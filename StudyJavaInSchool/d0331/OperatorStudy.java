package kr.hs.dgsw.java.dept23.d0331;

public class OperatorStudy {
	
	public void studyArithmeticOperators() {
		int value;
		
		value = 3 + 4;
		value = 3 - 4;
		value = 3 * 4;
		value = 3 / 4;
		value = 3 % 4;
		
		value += 3;
		value -= 3;
		value *= 3;
		value /= 3;
		value %= 3;
		
		int value1 = ++value;
		value1 = value--;
	}
	
	public void studyComparisionOperators() {
		boolean flag;
		
		flag = 3 > 4;
		flag = 3 < 4;
		// 등등...
	}
	
	public void studyLogicalOperators() {
		int value;
		
		value = 3 & 2;
		// 0 0 1 1
		// 0 0 1 0 &
		// ---------
		// 0 0 1 0 -> 2
		
		value = 3 | 2;
		// 0 0 1 1 -> 3
		
		value = 3 ^ 2;
		// XOR 계산
		
		value = ~3;
		// not
		
		value = 12424 << 1;
		// * 2를 하는 효과 반대면 / 2
		
		byte value1 = -128;
		byte result = (byte)(value1 >> 1);
		// 결과 -> -64
		// 빈자리에 0이 들어오는 것이 아니라 가장 앞의 값이 들어오는 것!
		// -> 부호를 유지하기 위해
		// 1000 0000 >> 1
		// 0100 0000 (X) -> 64
		// 1100 0000 (O) -> -64
	
		System.out.println(result);
		
		
	}
	
	public static void main(String[] args) {
		OperatorStudy study = new OperatorStudy();
		study.studyLogicalOperators();
		
		int a = 40;
		int b = 23;
		
		int max;
		if(a > b) {
			max = a;
		} else {
			max = b;
		}
		
		// 더욱 간편한 삼항연산자!
		max = (a > b) ? a : b;
		
		
		
	}

}
