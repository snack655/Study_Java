package kr.hs.dgsw.java.dept23.d0421;

import java.util.Calendar;
import java.util.Date;

public class MyDate extends Date{
	public int getYear1() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(getTime());
		
		return calendar.get(Calendar.YEAR);
	}
}
