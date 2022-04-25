package kr.hs.dgsw.network.thread0425;

public class NetWorkSemaphore implements Runnable {
	
	private int i = 0;
	private NetWorkSemaphore sem = new NetWorkSemaphore(1);

	@Override
	public void run() {
		while (i < 500) {
			
		}
	}
	
}
