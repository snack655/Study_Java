package kr.hs.dgsw.network.thread0425;

public class CakeMain {
	public static void main(String[] args) {
		
		CakePlate cakePlate = new CakePlate();
		Producer t1 = new Producer(cakePlate);
		Consumer t2 = new Consumer(cakePlate);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException e) {}
		
		System.out.println("모든 과정 종료");
	}
}
