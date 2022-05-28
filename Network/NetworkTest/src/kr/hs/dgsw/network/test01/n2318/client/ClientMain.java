package kr.hs.dgsw.network.test01.n2318.client;

import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 5000);

            OutputThread outputThread = new OutputThread(socket);
            outputThread.start();

            InputThread inputThread = new InputThread(socket);
            inputThread.start();
        } catch (Exception e) {
            System.out.println("연결 종료");
            e.printStackTrace();
        }
    }
}
