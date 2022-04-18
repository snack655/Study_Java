package kr.hs.dgsw.java.dept23.d0414;

public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}
	
	@Override
	public void makeSound() {
		System.out.println("멍멍");
	}
	
	public static void main(String[] args) {
		Animal dog = new Dog("경태");
		
		dog.move();
		dog.eat("개껌");
		dog.makeSound();
	}
}
