package kr.hs.dgsw.java.dept23.d0407;

import java.util.Scanner;

public class Student {
	String[] student = {"정은서","강성훈","고용빈","기준","김민성","류지훈","박병관","박성한","박지건","박현우","손원","안찬","우상범","윤병훈","윤서준", "이승민", "이지호","최민재","한상빈"};
	
	public String findStudent(int idx) {
		try {
			return idx+"번 : " + student[idx - 1];
		} catch(ArrayIndexOutOfBoundsException e) {
			return "없는 번호입니다.";
		}
	}
	
	public static void main(String[] args) {
		SetScanner setSc = new SetScanner();
		setSc.assignScanner();
		Scanner sc = setSc.getScanner();
		Student student = new Student();
		
		System.out.print("번호를 입력하세요 : ");
		int idx = sc.nextInt();
		System.out.println(student.findStudent(idx));
		
		setSc.closeScanner();
	}

}

class SetScanner {
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
