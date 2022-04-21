package kr.hs.dgsw.java.dept23.d0421;

public class Card {
	
	int money;
	
	public Card(int money) {
		this.money = money;
	}
	
	public String getType() {
		return "";
	}
	
	public Boolean canPaiable(int fee) {
		if(money >= fee) {
			return true;
		} else {
			return false;
		}
	}
	
	public void payment(int fee) {
		money -= fee;
	}
}
