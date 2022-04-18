package kr.hs.dgsw.java.dept23.d0414;

public class KyeongTae extends Animal {

	public KyeongTae(String name) {
		super(name);
	}
	
	@Override
	public void makeSound() {
		System.out.println("살고 싶지 않아?");
	}
	
	public static void main(String[] args) {
		Animal cat = new KyeongTae("경태");
		
		cat.move();
		cat.eat("민성");
		cat.makeSound();
	}
}