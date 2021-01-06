import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileIO {
	
	
	
	//default constructor
	public FileIO() {
		
	}
	
	/**
	 * Find number of lines of given csv file name.
	 * @param csvFileName
	 * @return number of lines
	 */
	public int numberOfLinesInText(String csvFileName) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(csvFileName));
			int lines = 0;
			while (reader.readLine() != null) lines++;
			reader.close();
			
			return lines;
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	/**
	 * Read item file lines and create item for each line of item csv file.
	 * @param csvFileName
	 * @return item array
	 */
	public Item[] readItemFile(String csvFileName) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(csvFileName));
			Item[] itemArray = new Item[numberOfLinesInText(csvFileName)];
			String line;
			
			for (int i = 0; i < itemArray.length; i++) {
				line=reader.readLine();
				String[] itemProperties = line.split(",");
				Item item = new Item(itemProperties[0],Integer.parseInt(itemProperties[1]),itemProperties[2]);
				itemArray[i]=item;
				
				
			}
			reader.close();
			
			return itemArray;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		

	}
	
	/**
	 * Read item files and define categories of items and store in array.
	 * @param csvFileName
	 * @return category name array
	 */
	public String[] readItemFileForCategories(String csvFileName) {
		
		Item[] itemArray = readItemFile(csvFileName);
		String[] categoryArray = new String[1];
		int categoryArrayIndex = 0;
		for (Item item : itemArray) {
			int key=1;
			for (String string : categoryArray) {
				if (item.getCategory().equals(string)) {
					key=0;
				}
			}
			if (key==1) {
				//add category to array
				categoryArray[categoryArrayIndex]=item.getCategory();
				categoryArrayIndex++;
				String[] tempCategoryArray = Arrays.copyOf(categoryArray, categoryArrayIndex+1);
				categoryArray=tempCategoryArray;
			}
		}
		
		//delete last increment size with element nulls
		String[] returnedCategoryArray = Arrays.copyOf(categoryArray, categoryArrayIndex);
		return returnedCategoryArray;
		
	}
	
	/**
	 * Read transaction file, define transactions and store in transaction array. 
	 * @param csvFileName
	 * @return transaction array
	 */
	public Transaction[] readTransactionFile(String csvFileName) {		

		try {
			BufferedReader reader = new BufferedReader(new FileReader(csvFileName));
			Transaction[] transactionArray = new Transaction[numberOfLinesInText(csvFileName)*12];
			String line=reader.readLine();
			int indexForAddTransaction = 0;
			
			while (line!=null) {
				String[] transactionData = line.split(",");
				for (int i = 1; i < transactionData.length; i+=3) {
					Transaction tempTransaction = new Transaction(Double.parseDouble(transactionData[i]),Double.parseDouble(transactionData[i+1])
							,Integer.parseInt(transactionData[i+2]));
					transactionArray[indexForAddTransaction]=tempTransaction;
					indexForAddTransaction++;
				}
				line=reader.readLine();
				
			}
			reader.close();
			
			return transactionArray;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}
	
	


}
