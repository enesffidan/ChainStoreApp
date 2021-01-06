
public class Transaction {
	
	private double purchasePrice;
	private double salePrice;
	private int numberOfSales;
	
	
	//constructor according to transaction text file data.
	public Transaction(double purchasePrice, double salePrice, int numberOfSales) {
		this.purchasePrice=purchasePrice;
		this.salePrice=salePrice;
		this.numberOfSales=numberOfSales;
	}

	
	/**
	 * Calculate profit according to transaction data.
	 * @return profit value
	 */
	public double calculateProfitForTransaction() {
		double profit = (salePrice-purchasePrice)*numberOfSales;
		return profit;
	}
	
	
	//GETTERS and SETTERS
	public double getPurchasePrice() {
		return purchasePrice;
	}


	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}


	public double getSalePrice() {
		return salePrice;
	}


	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}


	public int getNumberOfSales() {
		return numberOfSales;
	}


	public void setNumberOfSales(int numberOfSales) {
		this.numberOfSales = numberOfSales;
	}
	
	
	

}
