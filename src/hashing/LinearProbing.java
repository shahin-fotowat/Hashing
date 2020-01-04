package hashing;
import java.util.ArrayList;

public class LinearProbing {
	private String[] hashTable;
	private int numOfCellsUsedInHashTable;

	//Constructor
	LinearProbing(){
		hashTable = new String[13];
		numOfCellsUsedInHashTable = 0;
	}

	//Hash Function to be used on Keys
	public int asciiHashFunction(String text, final int TABLE_SIZE) {
		char ch[];
		ch = text.toCharArray();
		int sum = 0;
		for (int i = 0; i < text.length(); i++) {
			sum += ch[i];
		}
		System.out.println("\nIndex from Hash function: " + sum % TABLE_SIZE);
		return sum % TABLE_SIZE;
	}
	
	//Returns LoadFactor of HashTable
	public double getLoadFactor() {
		double loadFactor = numOfCellsUsedInHashTable * 1.0 / hashTable.length;
		return loadFactor;
	}
	
	//Insert key in HashTable
	public void insertKey(String value) {
		double loadFactor = getLoadFactor();
		if (loadFactor >= 0.75) {	// we need to rehash in new table doubling the size
			System.out.println("Load factor of this HashTable has exceeded 0.75, hence we need to Rehash!\n");
			rehashKeys(value);
		} else {
			System.out.println("Inserting \"" + value + "\" in HashTable...");
			int index = asciiHashFunction(value, hashTable.length);
			for (int i = index; i < index + hashTable.length; i++) {
				int newIndex = i % hashTable.length;
				if (hashTable[newIndex] == null) { //If index is blank, then insert there
					hashTable[newIndex] = value;
					System.out.println("Index: " + newIndex + " is blank. Inserting there...");
					System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
					System.out.println("-------------------------------------------\n");
					break;
				}else {
					System.out.println("Index: " + newIndex + " is already occupied. Trying next empty cell...");
				}
			}//end of for loop
		}//end of if-else block
		numOfCellsUsedInHashTable++;
	}	
	
	//Creates a new HashTable and does ReHashing
	private void rehashKeys(String newStringToBeInserted) {
		numOfCellsUsedInHashTable = 0; //need to reset it as we are now dealing with fresh HashTable
		ArrayList<String> tempTable = new ArrayList<String>();
		for (String s : hashTable) { //loop through the HashTable and store all the keys in the temp ArrayList
			if (s != null)
				tempTable.add(s);
		}
		tempTable.add(newStringToBeInserted);
		hashTable = new String[hashTable.length * 2]; // make new table with double size
		for (String s : tempTable) { // push all old data into new table
			insertKey(s);
		}
	}
	
	//Search for a given key in hashTable
	public boolean searchKey(String stringToBeSearched) {
		int index = asciiHashFunction(stringToBeSearched, hashTable.length);
		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(stringToBeSearched)) {
				System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " found in HashTable at location: " + newIndex);
				return true;
			}
		}
		System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " not found in HashTable.");
		return false;
	}
	
	//Delete key from HashTable
	public void deleteKey(String stringToBeDeleted) {
		int index = asciiHashFunction(stringToBeDeleted, hashTable.length);
		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(stringToBeDeleted)) {
				hashTable[newIndex] = null;
				System.out.println("\n" + "\"" + stringToBeDeleted + "\"" + " has been found in HashTable." );
				System.out.println("\"" + stringToBeDeleted + "\"" + " has been deleted from HashTable !" );
				return;
			}
		}
		System.out.println("\nCould not find " + "\"" + stringToBeDeleted + "\"" + " in HashTable");
	}

	// Display the hash table
	public void displayHashTable() {
		if(hashTable == null) {
			System.out.println("\nHashTable does not exits !");
			return;
		} else {
			System.out.println("\n---------- HashTable ---------");
			for (int i = 0; i < hashTable.length; i++) {
				System.out.println("Index:" + i + ".   Key:" + hashTable[i]);
			}
		}
		System.out.println("\n");
	}
	
	//Deletes entire HashTable
	public void deleteHashTable() {
		System.out.println("Successfully deleted HashTable !");
		hashTable = null;
	}
	
}//end of class
