package kr.hs.dgsw.network.test01.n2318.client;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";
            System.out.println("서버에 연결 중 입니다. 서버 IP : " + serverIp);

            // 소켓을 생성하여 연결을 요청
            Socket socket = new Socket(serverIp, 4000);

            // 소켓의 입력스트림을 얻는다
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            System.out.println("서버로부터 받은 메시지 : " + dis.readUTF());
            System.out.println("연결을 종료합니다.");

            // 스트림과 소켓을 닫는다
            dis.close();
            socket.close();
            System.out.println("연결이 종료되었습니다.");
//            OutputThread outputThread = new OutputThread(socket);
//            outputThread.start();
//
//            InputThread inputThread = new InputThread(socket);
//            inputThread.start();
        } catch (Exception e) {
            System.out.println("연결 종료");
            e.printStackTrace();
        }
    }
}
