package kr.hs.dgsw.java.dept23.d0421;

public class AdultCard extends Card {
	
	public AdultCard(int money) {
		super(money);
	}

	@Override
	public String getType() {
		return "성인";
	}
	
}
