
public class ChainStoreApp {

	
	public static void main(String[] args) {
			
		AnnualSale annualSale = new AnnualSale();
		StoreQuery storeQuery = new StoreQuery();
		
		//#Query 1 
		storeQuery.mostProfitableItemOfYear(annualSale);
		
		//#Query 2
		storeQuery.mostProfitableCategory(annualSale);
		
		//#Query 3
		storeQuery.leastProfitableItemOfYear(annualSale);
		
		//#Query 4
		storeQuery.leastProfitableCategory(annualSale);
		
		//#Query 5
		storeQuery.mostProfitableItemForSingleSale(annualSale);
		
		//#Query 6
		storeQuery.bestSellingItemOfYear(annualSale);
		
		//#Query 7
		storeQuery.mostProfitableStore(annualSale);

	}
}
