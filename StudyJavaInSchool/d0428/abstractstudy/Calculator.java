package kr.hs.dgsw.java.dept23.d0428.abstractstudy;

import java.util.Scanner;

public abstract class Calculator {
	protected final Scanner scanner;
	
	protected int value1;
	
	protected int value2;

	public Calculator() {
		this.scanner = new Scanner(System.in);
	}
	
	public void execute() {
		
		while(true) {
			// 두 정수를 입력 받는다.
			this.inputValues();
			if(isExitCondition()) {
				break;
			}
			
			// 결과를 출력한다.
			int result = this.calculate();
			
			// 계산을 수행한다.
			this.showResult(result);
		}
		
		this.scanner.close();
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void inputValues() {
		System.out.println("두 정수를 입력하세요.");
		this.value1 = this.scanner.nextInt();
		this.value2 = this.scanner.nextInt();
	}
	
	public abstract int calculate();
	
	public void showResult(int result) {
		System.out.printf("%d %s %d = %d\n", value1, getOperator(), value2, result);
	}
	
	public boolean isExitCondition() {
		return (value1 == 0 && value2 == 0);
	}
	
	public abstract String getOperator();
	
}
