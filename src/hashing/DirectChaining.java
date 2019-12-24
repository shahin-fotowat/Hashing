package hashing;
import java.util.LinkedList;

public class DirectChaining {
	LinkedList<String>[] hashTable;
	int maximumChainSize = 5;
	
	DirectChaining() {
		hashTable = new LinkedList[13];
	}//end of method

	// HashFunction to be used on Keys
	public int simpleASCIIHashFunction(String text, final int TABLE_SIZE) {
		char ch[];
		ch = text.toCharArray(); //Convert the string text to an array of characters
		int sum = 0;
		for (int i = 0; i < text.length(); i++) {
			sum += ch[i];		 //Add the ASCII values of the characters
		}
		// System.out.println("Index from hashfunction: " + sum % TABLE_SIZE);
		return sum % TABLE_SIZE;
	}// end of method

	//Insert Key in HashTable
	public void insertKeyInHashTable(String value) {
		int hashIndex = simpleASCIIHashFunction(value, hashTable.length); //returns in which index we need to store this string
		if(hashTable[hashIndex] == null) {
			System.out.println("Index: " + hashIndex + " is empty. Creating a new LinkedList there...");
			hashTable[hashIndex] = new LinkedList<String>(); 
			hashTable[hashIndex].add(value);
			System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + hashIndex);
			System.out.println("-------------------------------------------\n");
		} else {
			System.out.println("\nIndex: " + hashIndex + " is having sufficient space. Inserting there...");
			hashTable[hashIndex].add(value);
			System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + hashIndex);
			System.out.println("-------------------------------------------\n");
		}
	}//end of method

	//Search for a given key in hashTable
	public boolean searchKeyInHashTable(String query) {
		int hashIndex = simpleASCIIHashFunction(query, hashTable.length);
		if (hashTable[hashIndex] != null && hashTable[hashIndex].contains(query)) {
			System.out.println("\n" + "\"" + query + "\"" + " found in HashTable at location: " + hashIndex);
			return true;
		}else {
			System.out.println("\n" + "\"" + query + "\"" + " not found in HashTable.");
			return false;
		}
	}//end of method

	//Delete key from HashTable
	public void deleteKeyFromHashTable(String query) {
		int hashIndex = simpleASCIIHashFunction(query, hashTable.length);
		if (hashTable[hashIndex] != null && hashTable[hashIndex].contains(query)) {
			System.out.println("\n" + "\"" + query + "\"" + " has been found in HashTable." );
			hashTable[hashIndex].remove(query);
			System.out.println("\"" + query + "\"" + " has been deleted from HashTable !" );
		} else {
			System.out.println("\nCould not find " + "\"" + query + "\"" + " in HashTable");
		}
	}//end of method
		
	// display the hash table
	public void displayHashTable() {
		if(hashTable == null) {
			System.out.println("\nHashTable does not exits !");
			return;
		} else {
			System.out.println("\n---------- HashTable ---------");
			for (int i = 0; i < hashTable.length; i++) {
				if(i < 0) {
					System.out.println("Index: " + i + ",  key: " + hashTable[i]);
					
				} else {
					System.out.println("Index: " + i + ", key: " + hashTable[i]);
				}
			}
		}
	} //end of method
	
	// Deletes entire HashTable
	public void deleteHashTable() {
		hashTable = null;
		System.out.println("Successfully deleted HashTable !");
	}// end of method
	
}//end of class
