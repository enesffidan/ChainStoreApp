
public class ItemTransaction {
	
	private Item item;
	private Transaction[][] transactionsArray = new Transaction[4][12]; //[storeID][month] hold transactions
	
	
	public ItemTransaction(Item item) {
		this.item=item;
		defineTransactionsArray();
	}
	
	
	/**
	 * Read transaction files for each store and define transaction array for item transaction.
	 */
	public void defineTransactionsArray() {
		FileIO fileIO = new FileIO();
		Transaction[] FirstStoreTransactions = fileIO.readTransactionFile("HW1_Transactions_Store1.csv");
		Transaction[] SecondStoreTransactions = fileIO.readTransactionFile("HW1_Transactions_Store2.csv");
		Transaction[] ThirdStoreTransactions = fileIO.readTransactionFile("HW1_Transactions_Store3.csv");
		Transaction[] FourthStoreTransactions = fileIO.readTransactionFile("HW1_Transactions_Store4.csv");
		
		for (int i = 0; i < 12; i++) {
			transactionsArray[0][i]=FirstStoreTransactions[((item.getID()-1)*12)+i]; //correct place according to csv file 
			transactionsArray[1][i]=SecondStoreTransactions[((item.getID()-1)*12)+i];
			transactionsArray[2][i]=ThirdStoreTransactions[((item.getID()-1)*12)+i];
			transactionsArray[3][i]=FourthStoreTransactions[((item.getID()-1)*12)+i];
		}
	}
	


	//GETTERS AND SETTERS
	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	public Transaction[][] getTransactionsArray() {
		return transactionsArray;
	}


	public void setTransactionsArray(Transaction[][] transactionsArray) {
		this.transactionsArray = transactionsArray;
	}
	
	

	
	
	

}
