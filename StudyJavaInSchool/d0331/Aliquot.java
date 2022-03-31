package kr.hs.dgsw.java.dept23.d0331;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Aliquot {

private Scanner sc;
	
	public void setSc() {
		sc = new Scanner(System.in);
	}
	public Scanner getSc() { return sc; }
	public void closeSc() {
		sc.close();
	}
	
	public String findAliquots(int value) {
		int sqrt = (int) Math.sqrt(value);
		ArrayList<Integer> arr = new ArrayList<>();

		for(int i = 1; i <= sqrt; i++){
		   if(value % i == 0){
		    arr.add(i);
		        if(value / i != i) {
		            arr.add(value / i);
		        }
		    }
		}
		arr.sort(Comparator.naturalOrder());
		return arr.toString();
	}
	
	public static void main(String[] args) {
		Aliquot aliquot = new Aliquot();
		aliquot.setSc();
		Scanner sc = aliquot.getSc();
		int value = sc.nextInt();
		System.out.println(aliquot.findAliquots(value));
	}

}
