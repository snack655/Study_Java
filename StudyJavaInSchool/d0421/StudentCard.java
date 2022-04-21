package kr.hs.dgsw.java.dept23.d0421;

public class StudentCard extends Card {
	
	public StudentCard(int money) {
		super(money);
	}

	@Override
	public String getType() {
		return "학생";
	}
	
}
