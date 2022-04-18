package kr.hs.dgsw.java.dept23.d0414;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}
	
	@Override
	public void makeSound() {
		System.out.println("냐옹냐옹");
	}
	
	public static void main(String[] args) {
		Animal cat = new Cat("나비");
		
		cat.move();
		cat.eat("생선");
		cat.makeSound();
	}
}