package kr.hs.dgsw.network;


public class ThreadMain {

	public static void main(String[] args) {
		
		new Thread(() -> {
			for(int i = 0; i < 500; i++) {
				System.out.printf("t1 Thread: %d \n", i);
			}
		}, "t1").start();
		
		new Thread(() -> {
			for(int i = 0; i < 500; i++) {
				System.out.printf("t2 Thread: %d \n", i);
			}
		}, "t2").start();
		
		for (int i = 0; i < 500; i++) {
			System.out.printf("main Thread: %d \n", i);
		}
		
		
	}

}
