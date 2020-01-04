package hashing;

public class LinearProbingMain {
	public static void main(String[] args) {
		
		LinearProbing linearProbing = new LinearProbing();

		linearProbing.insertKey("The");
		linearProbing.insertKey("quick");
		linearProbing.insertKey("brown");
		linearProbing.insertKey("fox");
		linearProbing.insertKey("over");
		linearProbing.insertKey("lazy");
		linearProbing.displayHashTable();
		
		linearProbing.insertKey("fox"); //use for showing collision
		linearProbing.displayHashTable();
				
		
		linearProbing.insertKey("fox");
		linearProbing.displayHashTable();
		
		linearProbing.insertKey("fox");
		linearProbing.displayHashTable();
		
		linearProbing.insertKey("fox");
		linearProbing.displayHashTable();
		
		linearProbing.insertKey("fox");
		linearProbing.displayHashTable();
		
		
		linearProbing.searchKey("jump");
		linearProbing.searchKey("brown");
		
		
		linearProbing.deleteKey("jump");
		linearProbing.deleteKey("quick");
		linearProbing.displayHashTable();
		
		
		linearProbing.deleteHashTable();
		linearProbing.displayHashTable();	
	}

}//end of class
