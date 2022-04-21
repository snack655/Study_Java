package kr.hs.dgsw.java.dept23.d0421;

import java.util.Date;

public interface DateStudy {

	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		
		MyDate date1 = new MyDate();
		System.out.println(date1);
		System.out.println(date1.getYear1());
		
		Object object = new Object();
	}
}
