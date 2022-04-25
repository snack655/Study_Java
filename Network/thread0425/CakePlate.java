package kr.hs.dgsw.network.thread0425;

public class CakePlate {
	private int breadCount = 0;
	
	public CakePlate() {}
	
	// 재빵사가 빵을 만듦 (생산자)
	public synchronized void makeBread() {
		if (breadCount >= 10) {
			try {
				System.out.println("빵이 남는다.");
				wait();	// 대기
			} catch(InterruptedException ire) {}
		}
		
		breadCount++;
		System.out.println("빵을 1개 더 만듦 총: " +
		breadCount + "개");
		this.notifyAll();	// 대기해제
 	}
	
	// 빵을 먹음 (소비자)
	public synchronized void eatBread() {
		if (breadCount <= 0) {
			try {
				System.out.println("빵이 없소용..ㅠㅠ");
				wait();	// 대기
			} catch(InterruptedException ire) {}
		}
		
		breadCount--;
		System.out.println("빵을 1개를 먹음 총: " +
		breadCount + "개");
		this.notify();	// 대기해제
 	}
}
