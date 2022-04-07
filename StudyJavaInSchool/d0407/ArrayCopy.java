package kr.hs.dgsw.java.dept23.d0407;

public class ArrayCopy {
	
	/**
	 * 주어진 src 배열을 복사해서 리턴한다.
	 * 
	 * @param src
	 * @return
	 */
	public String[] copy(String[] src) {
		String[] result = new String[src.length];
		
		for (int i = 0; i < src.length; i++) {
			result[i] = src[i];
		}
		
		return result;
	}

}
