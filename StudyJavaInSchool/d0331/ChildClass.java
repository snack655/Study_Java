package kr.hs.dgsw.java.dept23.d0331;

public class ChildClass extends AccessModifierStudy {
	public static void main(String[] args) {
		ChildClass study = new ChildClass();
		
		study.publicValue = 5;
		// study.privateValue = 5; 접근 불가능
		
		study.protectedValue = 3; 
		study.defaultValue = 2;
	}
}
