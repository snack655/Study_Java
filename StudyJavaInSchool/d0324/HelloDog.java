package kr.hs.dgsw.java.dept23.d0324;

import java.util.Scanner;

class SetScanner {
	private Scanner sc;
	
	public void assignScanner() {
		this.sc = new Scanner(System.in);
	}
	
	public Scanner getScanner() {
		return sc;
	}
	
	public void closeScanner() {
		this.sc.close();
	}
}


public class HelloDog {
	private String dogName;
	
	public void sayHello() {
		System.out.println("Hello " + dogName);
	}
	
	public HelloDog(String name) {
		dogName = name;
		sayHello();
	}

	public static void main(String[] args) {
		SetScanner setScanner = new SetScanner();
		setScanner.assignScanner();
		Scanner sc = setScanner.getScanner();
		
		while(true) {
			System.out.println("강아지 이름을 입력하세요");
			String name = sc.nextLine();
			
			if ("quit".equals(name)) {
				setScanner.closeScanner();
				break;
			}
		
			HelloDog dog = new HelloDog(name);
		}
	}
}
