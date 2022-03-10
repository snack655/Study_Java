package kr.hs.dgsw.java.first;

public class Person {
	private int age = 0;
	private String name = "이름";
	
	public void Hello() {
		System.out.println("안녕 나는야 " + name);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
