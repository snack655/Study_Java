package kr.hs.dgsw.java.dept23.d0421;

public class ElderCard extends Card {
	
	public ElderCard(int money) {
		super(money);
	}

	@Override
	public String getType() {
		return "어르신";
	}
	
}
