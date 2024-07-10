public class Creature {
	/*
	@author		Al Malik Mahdivika almalik.mahdivika@ucalgary.ca

	@version 1.1
	@since	 1.0
	*/

	/**
	@para args Handles command-line argument
	*/
	public static void main(String[] args) {
		Animal myAnimal = new Animal();
		String myType = myAnimal.animalType();
		System.out.println("This is a placeholder for Creature " + myType);
	}
}
class Animal {
	private String animalType = "dog";
	
	public String animalType() {
		return animalType;
	}
}