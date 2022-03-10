package kr.hs.dgsw.java.first;

class Hello3 {
	private int age;
	private String name;
	private Boolean isStudent;
	private int info;
	
	public Hello3(int age, String name, Boolean isStudent, int info) {
		this.age = age;
		this.name = name;
		this.isStudent = isStudent;
		this.info = info;
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
	public Boolean getIsStudent() {
		return isStudent;
	}
	public void setIsStudent(Boolean isStudent) {
		this.isStudent = isStudent;
	}
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {
		this.info = info;
	}
}


public class Hello2 {
	
	public static void main(String[] args) {
		Hello3 kt = new Hello3(17, "kt", false, 2213);
		
		System.out.println(kt.getName());
	}
}
