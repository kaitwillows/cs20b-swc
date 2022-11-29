
/**
 *
 */
public class Fish {
	//Instant fields.
	private int age;
	private String name;
	
	/**
	 * Constructor that takes no parameter.
	 */
	public Fish(){
		name = "Fish.";
		age = 1;
	}
	
	/**
	 * Constructor.
	 */
	public Fish(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	
	
	/**
	 *overwrite this method in sub-class
	 */
	public void greeting(){
		System.out.println("Hi, I am " + name + ". I can swim.");
	}
	
	/**
	 * overwrite default toString method.
	 * Print out this fish's name and age.
	 */
	public String toString(){
		return "Name: " + name + " Age: " + age;
	}
	
	/**
	 * Main method for demoing and testing purposes
	 * @param args
	 */
	public static void main(String[] args){
		//Uncomment the code when use.
		/*
		Fish fish = new ClassName(); //use the name of the class that you create to replace ClassName.
		fish.greeting();
		fish.someMethod();  //use the method that you write to replace someMethod.
		*/
	}
} //The end of Fish.java