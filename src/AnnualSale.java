
public class AnnualSale {
	
	private ItemTransaction[] itemTransactionArray = new ItemTransaction[32];
	
	public AnnualSale() {
		defineItemTransactionArray();
	}
	

	
	/**
	 * Define item transaction array that is field of annual sale with fileIO methods. 
	 */
	public void defineItemTransactionArray() {
		FileIO fileIO = new FileIO();
		Item[] itemArray = fileIO.readItemFile("HW1_Items.csv");
		int itemTransactionArrayIndex=0;
		
		for (Item item : itemArray) {
			ItemTransaction itemTransaction = new ItemTransaction(item);
			itemTransactionArray[itemTransactionArrayIndex]=itemTransaction;
			itemTransactionArrayIndex++;
		}
	}
	

	//GETTERS AND SETTERS
	public AnnualSale(ItemTransaction[] itemTransaction) {
		this.itemTransactionArray=itemTransaction;
	}

	public ItemTransaction[] getItemTransactionArray() {
		return itemTransactionArray;
	}

	public void setItemTransactionArray(ItemTransaction[] itemTransactionArray) {
		this.itemTransactionArray = itemTransactionArray;
	}

	
	
}
