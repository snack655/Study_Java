package kr.hs.dgsw.java.dept23.d0414;

public class Sangbin extends Animal {

	public Sangbin(String name) {
		super(name);
	}
	
	@Override
	public void makeSound() {
		System.out.println("느금느금");
	}
	
	public static void main(String[] args) {
		Animal cat = new Sangbin("상빈학생");
		
		cat.move();
		cat.eat("느금");
		cat.makeSound();
	}
}