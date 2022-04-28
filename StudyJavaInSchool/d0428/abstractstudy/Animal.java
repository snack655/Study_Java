package kr.hs.dgsw.java.dept23.d0428.abstractstudy;

public abstract class Animal {
	
	public abstract String getName();
	
	public abstract String makeSound();
	
	public void move() {
		System.out.printf("%s 이(가) %s 소리를 내며 달려갑니다.", getName(), makeSound());
	}
	
	public static void main(String[] args) {
		// 추상 클래스로는 객체를 만들 수 없다..
		//Animal animal = new Animal();
		
		Horse horse = new Horse();
		horse.move();
	}

}
