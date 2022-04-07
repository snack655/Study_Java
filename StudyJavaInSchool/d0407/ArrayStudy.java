package kr.hs.dgsw.java.dept23.d0407;

public class ArrayStudy {
	
	public String[] studyArray() {
		int array2[];
		String[] names = new String[5];
		
		int[] array1 = new int[10];
		int[] values = { 1, 2, 3, 4, 5 };
		
		// colors 라는 문자열 타입의 배열을 선언하고, 값을 초기화 해 보자.
		String[] colors = { "yello", "red", "blue", "green", "gray" };
		
		String[] colors2 = colors;
		colors2[2] = "파랑";
		
		ArrayCopy arrayCopy = new ArrayCopy();
		String[] colors3 = arrayCopy.copy(colors);
		colors3[3] = "green";
		System.out.println(colors[3]);
		
		return colors;
	}
	
	public void printColors(String[] colors) {
		// TODO colors에 들어있는 값을 인덱스 - 값 형식으로 모두 출력해 보세요.
		// 0 - 파랑
		// 1 - 노랑
//		for(int i = 0; i < colors.length; i++) {
//			System.out.printf("%d - %s\n", i, colors[i]);
//		}
		
		for (String color: colors) {
			System.out.println(color);
		} // 단점 : i 값을 가지고 있지 않다..
	}
	
	public void printLastValue(String[] values) {
		int length = values.length;
		System.out.println("lastValue : " + values[length - 1]);
	}
	
	public static void main(String[] args) {
		ArrayStudy arrStudy = new ArrayStudy();
		String[] colors = arrStudy.studyArray();
		arrStudy.printLastValue(colors);
		arrStudy.printColors(colors);
	}

}
