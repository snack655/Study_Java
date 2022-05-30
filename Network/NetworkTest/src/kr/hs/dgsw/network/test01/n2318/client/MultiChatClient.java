package kr.hs.dgsw.network.test01.n2318.client;

import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class MultiChatClient {
    public static Boolean isLOGIN = false;
    public static Boolean isLOADING = false;
    public static final String STANDARD = "::";

    public static void main(String[] args) {
        String nickName;
        Scanner sc = new Scanner(System.in);
        System.out.print("닉네임을 입력해주세요 : ");
        nickName = sc.nextLine();

        try {
            String serverIp = "127.0.0.1";
            // 소켓을 생성하여 연결을 요청한다.
            Socket socket = new Socket(serverIp, 3000);
            System.out.println("서버에 연결되었습니다.");

            Thread sender = new Thread(new ClientSender(socket, nickName));
            Thread receiver = new Thread(new ClientReceiver(socket));

            sender.start();
            receiver.start();
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (Exception e) {}
    } // main
} // class
