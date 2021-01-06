
public class Item {
	
	private String name;
	private int ID;
	private String category;
	private double profit=0;
	
	//default constructor
	public Item() {
		
	}
	
	//constructor according to item text file data.
	public Item(String name, int ID,String category) {
		this.name=name;
		this.ID=ID;
		this.category=category;
	}

	
	//GETTERS and SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", ID=" + ID + ", category=" + category + ", profit=" + profit + "]";
	}


}
