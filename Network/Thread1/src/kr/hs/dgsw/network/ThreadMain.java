package kr.hs.dgsw.network;

public class ThreadMain {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		
		t1.start();
		t2.start();
		
		for(int i = 0; i < 500; i++) {
			System.out.printf("main Thread: %d \n", i);
		}
	}
}