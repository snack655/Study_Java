package kr.hs.dgsw.java.dept23.d0414;

import java.util.Scanner;

public class Student extends People {
	Student(String name, String gender, int age, long nationNumber) {
		super(name, gender, age, nationNumber);
	}

	int grade;
	int myClass;
	int number;
	
	String teacherName;
	
	public static void main(String[] args) {
		Student student = new Student("minjae", "man", 17, 1234123415);
		SetScanner setSc = new SetScanner();
		setSc.assignScanner();
		Scanner sc = setSc.getScanner();
		
		System.out.print("비밀번호를 설정해주세요 : ");
		student.setPw(sc.nextInt());
		
		String nameTag = student.hello();
		System.out.println(nameTag);
		setSc.closeScanner();
	}
}
