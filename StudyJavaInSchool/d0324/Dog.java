package kr.hs.dgsw.java.dept23.d0324;

import java.util.Iterator;

public class Dog {
	
	// private final String name;
	// final을 붙이면 해당 변수는 상수 취급을 받고 값을 1번만 할당할 수 있다.
	// 그리고 선언 후 생성자에서 초기화하지 않을 시 오류가 발생한다.
	private String name;
	private String gender;
	private int age;
	
	public Dog() {
		this("몰루?");	// this에 매개변수를 넣음으로서 나 자신의 생성자를 호출할 수 있다.
		System.out.println("aaa");	// this 호출 이전에 다른 코드를 작성하는 것은 허용하지 않는다.
	}
	
	
	public Dog(String name) {
		this.name = name;
	}
	
	public Dog(String name, int age) {
		System.out.println(name + "생성됨");
		this.name = name;
		this.age = age;
	}

//	public Dog(String gender) {
//		this.name = "몰라";
//		this.gender = gender;
//		
//		// 두 변수의 타입이 같기 때문에 컴파일러가 판단하지 못해 오류가 난다.
//	}

	public void sayHello() {
		System.out.println("Hello " + this.name);
	}
	
	private String getName() { return name; }
	private void setName(String name) { this.name = name; }
	private int getAge() { return age; }
	private void setAge(int age) { this.age = age; }

	public static void main(String[] args) {
		System.out.println("count : " + args.length);
		
		for (int i = 0; i < args.length; i++) {
			Dog dog = new Dog(args[i]);
			dog.sayHello();
		}
				
//		Dog puppy = new Dog("puppy", 3);
//		Dog happy = new Dog("happy", 2);
//		Dog poppy = new Dog("poppy", 1);
//		
//		System.out.println(puppy.getName());
//		System.out.println(puppy.getAge());
//		puppy.setName("puppy2");
//		puppy.setAge(4);
//		System.out.println(puppy.getName());
//		System.out.println(puppy.getAge());
	}

}
