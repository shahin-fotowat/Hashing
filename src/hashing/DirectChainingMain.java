package hashing;

public class DirectChainingMain {

	public static void main(String[] args) {

		DirectChaining directChaining = new DirectChaining();

		directChaining.insertKey("The");
		directChaining.insertKey("quick");
		directChaining.insertKey("brown");
		directChaining.insertKey("fox");
		directChaining.insertKey("over");
		directChaining.insertKey("lazy");
		directChaining.displayHashTable();

		directChaining.insertKey("fox"); // used for showing collision
		directChaining.displayHashTable();

		directChaining.insertKey("fox"); 
		directChaining.displayHashTable();
		
		directChaining.insertKey("fox"); 
		directChaining.displayHashTable();
		
		directChaining.insertKey("fox"); 
		directChaining.displayHashTable();
		
		directChaining.insertKey("fox"); 
		directChaining.displayHashTable();
		  
		directChaining.insertKey("fox"); 
		directChaining.displayHashTable();
		  
		directChaining.insertKey("fox"); 
		directChaining.displayHashTable();
		 
		directChaining.insertKey("fox"); 
		directChaining.displayHashTable();
		 
		directChaining.searchKey("jump");
		directChaining.searchKey("brown");
		 
		directChaining.deleteKey("jump");
		directChaining.deleteKey("quick");
		directChaining.displayHashTable();
		 
		directChaining.deleteHashTable(); 
		directChaining.displayHashTable();

	}// end of method

}// end of class
