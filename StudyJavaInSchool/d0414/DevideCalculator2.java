package kr.hs.dgsw.java.dept23.d0414;

import java.util.Scanner;

public class DevideCalculator2 extends PlusCalculator {
	
	DevideCalculator2(String oper) {
		super(oper);
	}
	 
	public int calculate() {
		return this.value1 / this.value2;
	}
	
	/*
	public void showResult(int result) {
		System.out.printf("%d - %d = %d", this.value1, this.value2, calculate());
	}
	*/
	
	public static void main(String[] args) {
		DevideCalculator2 calculator = new DevideCalculator2("/");
		calculator.execute();
	}
}
