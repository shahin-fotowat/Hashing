package hashing;
import java.util.LinkedList;

public class DirectChaining {
	LinkedList<String>[] hashTable;
	int maximumChainSize = 5;
	
	// Constructor
	DirectChaining() {
		hashTable = new LinkedList[13];
	}

	// HashFunction to be used on Keys
	public int asciiHashFunction(String text, final int TABLE_SIZE) {
		char ch[];
		ch = text.toCharArray(); //Convert the string text to an array of characters
		int sum = 0;
		for (int i = 0; i < text.length(); i++) {
			sum += ch[i];		 //Add the ASCII values of the characters
		}
		System.out.println("\nIndex from Hash function: " + sum % TABLE_SIZE);
		return sum % TABLE_SIZE;
	}

	//Insert Key in HashTable
	public void insertKey(String value) {
		int hashIndex = asciiHashFunction(value, hashTable.length); //returns in which index we need to store this string
		if(hashTable[hashIndex] == null) {
			System.out.println("Index: " + hashIndex + " is empty. Creating a new LinkedList there ...");
			hashTable[hashIndex] = new LinkedList<String>(); //Creating a linked list at the specified index
			hashTable[hashIndex].add(value);
			System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + hashIndex);
		} else {
			System.out.println("\nIndex: " + hashIndex + " already contains a linked list. Inserting there ...");
			hashTable[hashIndex].add(value);
			System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + hashIndex);
		}
	}

	//Search for a given key in hashTable
	public boolean searchKey(String query) {
		int hashIndex = asciiHashFunction(query, hashTable.length);
		if (hashTable[hashIndex] != null && hashTable[hashIndex].contains(query)) {
			System.out.println("\n" + "\"" + query + "\"" + " found in HashTable at location: " + hashIndex);
			return true;
		} else {
			System.out.println("\n" + "\"" + query + "\"" + " not found in HashTable.");
			return false;
		}
	}

	//Delete key from HashTable
	public void deleteKey(String query) {
		int hashIndex = asciiHashFunction(query, hashTable.length);
		if (hashTable[hashIndex] != null && hashTable[hashIndex].contains(query)) {
			System.out.println("\n" + "\"" + query + "\"" + " has been found in HashTable." );
			hashTable[hashIndex].remove(query);
			System.out.println("\"" + query + "\"" + " has been deleted from HashTable !" );
		} else {
			System.out.println("\nCould not find " + "\"" + query + "\"" + " in HashTable");
		}
	}
		
	// display the hash table
	public void displayHashTable() {
		if(hashTable == null) {
			System.out.println("\nHashTable does not exits!");
			return;
		} else {
			System.out.println("\n---------- HashTable ---------");
			for (int i = 0; i < hashTable.length; i++) {
				if(i < 10) {
					System.out.println("Index: " + i + ",  key: " + hashTable[i]);
					
				} else {
					System.out.println("Index: " + i + ", key: " + hashTable[i]);
				}
			}
		}
	} 
	
	// Deletes the entire Hash Table
	public void deleteHashTable() {
		hashTable = null;
		System.out.println("\nSuccessfully deleted HashTable!");
	}
	
}//end of class
