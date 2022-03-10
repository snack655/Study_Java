package kr.hs.dgsw.java.first;

public class Cat {
	private String name;
	private int age;
	private Boolean hasTail;
	private double height;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public Boolean getHasTail() { return hasTail; }
	public void setHasTail(Boolean hasTail) { this.hasTail = hasTail; }
	public double getHeigt() { return height; }
	public void setHeigt(double height) { this.height = height; }
	
	public Cat(String name, int age, Boolean hasTail, Double height) {
		this.name = name;
		this.age = age;
		this.hasTail = hasTail;
		this.height = height;
	}
	
	public void getAll() {
		System.out.println(name + age + hasTail + height);
	}
}
