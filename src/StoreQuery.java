

public class StoreQuery {
	
	FileIO fileIO = new FileIO();
	
	//default constructor
	public StoreQuery() {

	}
	
	/**
	 * Query 1
	 * Gets annual sale object and find the most profitable item over annual sale.
	 * @param annual sale.
	 * @return most profitable item for whole year from all stores.
	 */
	public Item mostProfitableItemOfYear(AnnualSale annualSale) {
		
		//define all items total profit value
		for (ItemTransaction itemTransaction : annualSale.getItemTransactionArray()) {
			double itemProfit = 0;
			for (int i = 0; i < 4; i++) { //for each store
				for (int j = 0; j < 12; j++) { 	//for each month
					itemProfit+=itemTransaction.getTransactionsArray()[i][j].calculateProfitForTransaction();
				}
				itemTransaction.getItem().setProfit(itemProfit);
			}
		}
		
		double maxProfit=0;
		Item maxProfitableItem = new Item();
		//maxSearch
		for (ItemTransaction itemTransaction : annualSale.getItemTransactionArray()) {
			if (maxProfit < itemTransaction.getItem().getProfit()) {
				maxProfit = itemTransaction.getItem().getProfit();
				maxProfitableItem = itemTransaction.getItem();
			}
		}
		
		
		System.out.printf("Query 1 --> Most profitable item for the whole year: %s\n",maxProfitableItem.getName());
		return maxProfitableItem;
	}
	
	/**
	 * Query 2
	 * Gets annual sale, find and produce output of most profitable category for whole year.
	 * @param annualSale
	 * @return name of category that most profitable for whole year.
	 */
	public String mostProfitableCategory(AnnualSale annualSale) {
		FileIO fileIO = new FileIO();
		String[] categoryArray = fileIO.readItemFileForCategories("HW1_Items.csv");
		double[] categoryProfits = new double[categoryArray.length];
		
		//define all items total profit value
		for (ItemTransaction itemTransaction : annualSale.getItemTransactionArray()) {
			double itemProfit = 0;
			for (int i = 0; i < 4; i++) { //for each store
				for (int j = 0; j < 12; j++) { //for each month
					itemProfit=itemTransaction.getTransactionsArray()[i][j].calculateProfitForTransaction();
				}
			}

			
			for (int i = 0; i < categoryProfits.length; i++) {
				if (categoryArray[i].equals(itemTransaction.getItem().getCategory())) {
					categoryProfits[i]+=itemProfit;
				}
			}
			
		}
		
		//maxSearch
		double maxProfit=0;
		int maxProfitIndex=-1;
		for (int i = 0; i < categoryProfits.length; i++) {
			if (categoryProfits[i]>maxProfit) {
				maxProfit=categoryProfits[i];
				maxProfitIndex=i;
			}
		}

		System.out.printf("Query 2 --> Most Profitable Category: %s\n",categoryArray[maxProfitIndex]);
		return categoryArray[maxProfitIndex];
	}
	
	/**
	 * Query 3
	 * Gets annual sale, find and produce output of least profitable item of year.
	 * @param annualSale
	 * @return Item object that is least profitable item for whole year.
	 */
	public Item leastProfitableItemOfYear(AnnualSale annualSale) {
		//define all items total profit value
		for (ItemTransaction itemTransaction : annualSale.getItemTransactionArray()) {
			double itemProfit = 0;
			for (int i = 0; i < 4; i++) { //for each store
				for (int j = 0; j < 12; j++) {  //for each month
					itemProfit+=itemTransaction.getTransactionsArray()[i][j].calculateProfitForTransaction();
				}
				itemTransaction.getItem().setProfit(itemProfit);
			}
		}
		
		double minProfit = annualSale.getItemTransactionArray()[0].getItem().getProfit();
		Item minProfitableItem = new Item();
		//minSearch
		for (ItemTransaction itemTransaction : annualSale.getItemTransactionArray()) {
			if (minProfit > itemTransaction.getItem().getProfit()) {
				minProfit = itemTransaction.getItem().getProfit();
				minProfitableItem = itemTransaction.getItem();
			}
		}
		
		System.out.printf("Query 3 --> Least profitable item for the whole year: %s\n",minProfitableItem.getName());
		return minProfitableItem;
	}
	
	//#Query.4 Least profitable catagory for the whole year.
	/**
	 * Gets annual sale, find and produce output of least profitable category.
	 * @param annualSale
	 * @return
	 */
	public String leastProfitableCategory(AnnualSale annualSale) {
		FileIO fileIO = new FileIO();
		String[] categoryArray = fileIO.readItemFileForCategories("HW1_Items.csv");
		double[] categoryProfits = new double[categoryArray.length];
		//define all items total profit value
		for (ItemTransaction itemTransaction : annualSale.getItemTransactionArray()) {
			double itemProfit = 0;
			for (int i = 0; i < 4; i++) { //for each store
				for (int j = 0; j < 12; j++) { //for each month
					itemProfit=itemTransaction.getTransactionsArray()[i][j].calculateProfitForTransaction();

				}
			}

			
			for (int i = 0; i < categoryProfits.length; i++) {
				if (categoryArray[i].equals(itemTransaction.getItem().getCategory())) {
					categoryProfits[i]+=itemProfit;
				}
			}
			
		}
		
		//minSearch
		double minProfit = categoryProfits[0];
		int minProfitIndex=-1;
		for (int i = 0; i < categoryProfits.length; i++) {
			if (categoryProfits[i]<minProfit) {
				minProfit=categoryProfits[i];
				minProfitIndex=i;
			}
		}
		System.out.printf("Query 4 --> Least profitable category for the whole year: %s\n",categoryArray[minProfitIndex]);
		return categoryArray[minProfitIndex];
	}
	
	/**
	 * Query 5
	 * Gets annual sale, calculate item profits over transactions
	 * find most profitable item for single sale.
	 * @param annualSale
	 * @return most profitable item for single sale
	 */
	public Item	mostProfitableItemForSingleSale(AnnualSale annualSale) {
		Item maxProfitableItemForSingleSale = new Item();
		double maxProfit = 0;

		
		
		for (ItemTransaction itemTransaction : annualSale.getItemTransactionArray()) {
			//maxSearch for a single sale
			for (int i = 0; i < 4; i++) { //for each store
				for (int j = 0; j < 12; j++) { //for each month
					if (maxProfit < itemTransaction.getTransactionsArray()[i][j].calculateProfitForTransaction()) {
						
						maxProfit=itemTransaction.getTransactionsArray()[i][j].calculateProfitForTransaction();
						maxProfitableItemForSingleSale=itemTransaction.getItem();
					}
				}
				
			}
		}
		
		System.out.printf("Query 5 --> Most profitable item for single sale: %s\n",maxProfitableItemForSingleSale.getName());
		return maxProfitableItemForSingleSale;
	}

	/**
	 * Query 6
	 * Gets annual sale and find best selling items.
	 * @param annualSale
	 * @return top seller item.
	 */
	
	public Item bestSellingItemOfYear(AnnualSale annualSale) {
		
		int maxSellingCount = 0;
		Item bestSellingItem = null;
		for (ItemTransaction itemTransaction : annualSale.getItemTransactionArray()) {
			int totalNumberOfSalesOfItem = 0;
			for (int i = 0; i < 12; i++) {
				totalNumberOfSalesOfItem += itemTransaction.getTransactionsArray()[0][i].getNumberOfSales();
				totalNumberOfSalesOfItem += itemTransaction.getTransactionsArray()[1][i].getNumberOfSales();
				totalNumberOfSalesOfItem += itemTransaction.getTransactionsArray()[2][i].getNumberOfSales();
				totalNumberOfSalesOfItem += itemTransaction.getTransactionsArray()[3][i].getNumberOfSales();
			}
			if (maxSellingCount<totalNumberOfSalesOfItem) {
				maxSellingCount=totalNumberOfSalesOfItem;
				bestSellingItem=itemTransaction.getItem();
			}
		}
		
		
		System.out.printf("Query 6 --> Best Selling Item of Year: %s\n"
				,bestSellingItem.getName());
		return bestSellingItem;
	}
	
	/**
	 * Query 7
	 * Print most profitable store for each month to console.
	 * @param annualSale
	 */
	public void mostProfitableStore(AnnualSale annualSale) {
		System.out.println("Query 7 -->");
		String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		for (int i = 0; i < 12; i++) {
			double[] storeProfits = new double[4];
			for (ItemTransaction itemTransaction : annualSale.getItemTransactionArray()) {
				for (int j = 0; j < 4; j++) {
					storeProfits[j]+=itemTransaction.getTransactionsArray()[j][i].calculateProfitForTransaction();
				}
			}
			//maxSearch
			double maxProfitOfStores=storeProfits[0];
			int maxProfitableStoreIndex = 0;
			for (int j = 0; j < storeProfits.length; j++) {
				if (maxProfitOfStores<storeProfits[j]) {
					maxProfitableStoreIndex=j;
				}
			}
			
			System.out.printf("The most profitable store in %s: Store %s\n",months[i],maxProfitableStoreIndex+1); //increment one for index to ID
		}
		
		
	}
	
}
