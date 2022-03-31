package kr.hs.dgsw.java.dept23.d0331;

public class OtherClass {
	public static void main(String[] args) {
		AccessModifierStudy study = new AccessModifierStudy();
		
		study.publicValue = 5;
		// study.privateValue = 5; private은 다른 클래스에서 접근이 가능하다.
		study.protectedValue = 3; 
		study.defaultValue = 2;
	}

}
