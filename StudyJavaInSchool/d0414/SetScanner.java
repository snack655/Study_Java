package kr.hs.dgsw.java.dept23.d0414;

import java.util.Scanner;

public class SetScanner {
	private Scanner sc;
	
	public void assignScanner() {
		this.sc = new Scanner(System.in);
	}
	
	public Scanner getScanner() {
		return sc;
	}
	
	public void closeScanner() {
		this.sc.close();
	}
}
