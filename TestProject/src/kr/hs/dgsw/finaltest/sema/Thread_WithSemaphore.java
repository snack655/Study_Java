package kr.hs.dgsw.finaltest.sema;
import java.util.concurrent.Semaphore;

public class Thread_WithSemaphore implements Runnable{
	private int i=0;
	// 여러명 넣고 싶을 때..
	private Semaphore sem = new Semaphore(1); // 1명으로 설정하였다.
	
	public void run() {
		while(i<500) {
			try {
				sem.acquire();	// �Ӱ豸�� ����
					for(int j=0;j<2000;j++);
					System.out.printf((Thread.currentThread()).getName() + " i = " + i);
					System.out.println();
					i++;
				sem.release();	// �Ӱ豸�� ����
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
