package kr.hs.dgsw.java.dept23.d0414;

public class Child extends Parent {
	
	private int age;
	
	public void showAge() {
		System.out.println(age);
	}
	
	public static void main(String[] args) {
		Child child = new Child();
		System.out.println(child.age);
		System.out.println("name : " + child.name);
		child.sayHello();
		// int weight = child.weight;
		
		Parent parent = new Child();	// 자식이 더 크기 때문에 가능하다.
		Parent realParent = new Parent();
		//Child child1 = new Parent();
		
		parent.sayHello();
		//parent.showAge();
		
		System.out.println(parent + " " + parent.getClass());
		System.out.println(realParent + " " + realParent.getClass());
		
		Child child1 = (Child)parent;
		//Child child2 = (Child)realParent; // class cast exception 
		System.out.println(child1 + " " + child1.getClass());
		//System.out.println(child2 + " " + child2.getClass());
	}
}
