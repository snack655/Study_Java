package kr.hs.dgsw.network.thread0425;

public class Consumer extends Thread {
	
	private CakePlate cake;
	
	public Consumer(CakePlate cake) {
		this.cake = cake;
	}
	
	public void run() {
		for (int i = 0; i < 50; i++) {
			cake.eatBread();
		}
	}
}
