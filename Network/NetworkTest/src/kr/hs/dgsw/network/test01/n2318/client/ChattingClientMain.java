package kr.hs.dgsw.network.test01.n2318.client;

import java.net.Socket;

public class ChattingClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Socket sc = new Socket("127.0.0.1",5000);
			
			OutputThread om = new OutputThread(sc);
			om.start();
			
			InputThread im = new InputThread(sc);
			im.start();
		} catch(Exception e) {
			System.out.println("연결 종료");
			e.printStackTrace();
		}
	}

}