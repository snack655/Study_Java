package kr.hs.dgsw.java.dept23.d0428.abstractstudy;

public class Minus extends Calculator {

	@Override
	public int calculate() {
		return this.value1 - this.value2;
	}

	@Override
	public String getOperator() {
		return "-";
	}
	
	public static void main(String[] args) {
		Calculator minuser = new Minus();
		minuser.execute();
	}
}
