package kr.hs.dgsw.java.dept23.d0421;

public class Animal {
	
	public String getName() {
		return "";
	}
	
	public String getSound() {
		return "";
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	public static void main(String[] args) {
		Animal animal = new Animal();
		System.out.println(animal.toString());
		
		Pig pig = new Pig();
		Duck duck = new Duck();
		System.out.println(pig.toString());
		System.out.println(duck.toString());
	}

}
