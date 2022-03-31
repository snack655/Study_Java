package kr.hs.dgsw.java.dept23.d0331;

import java.util.Scanner;

public class Sum {
	private Scanner sc;
	
	public void setSc() {
		sc = new Scanner(System.in);
	}
	public Scanner getSc() { return sc; }
	public void closeSc() {
		sc.close();
	}
	
	public int addOneToN(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
	
	public int addAToB(int a, int b) {
		int sum = 0;
		for(int i = a; i <= b; i++) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		Sum sum = new Sum();
		sum.setSc();
		Scanner sc = sum.getSc();
		int n = sc.nextInt();
		System.out.println(sum.addOneToN(n));
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(sum.addAToB(a, b));
		
		sum.closeSc();

	}

}
