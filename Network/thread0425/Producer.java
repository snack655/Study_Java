package kr.hs.dgsw.network.thread0425;

public class Producer extends Thread {
	
	private CakePlate cake;
	
	public Producer(CakePlate cake) {
		this.cake = cake;
	}
	
	public void run() {
		for (int i = 0; i < 50; i++) {
			cake.makeBread();
		}
	}
}
