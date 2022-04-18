package kr.hs.dgsw.java.dept23.d0414;

public class People {
	protected String name;
	protected String gender;
	protected int age;
	
	private long nationNumber;
	private int password;
	
	People(String name, String gender, int age, long nationNumber) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.nationNumber = nationNumber;
	}
	
	public String hello() {
		System.out.println("Hello my name is " + name);
		return mkNameTag();
	}
	
	private String mkNameTag() {
		return "Name : " + name  +"\nGender : " + gender + "\nAge : " + age;
	}
	
	public void setNationNumber(long nN) {
		this.nationNumber = nN;
	}
	
	public void setPw(int pw) {
		this.password = pw;
	}
	
}
