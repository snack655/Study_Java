package kr.hs.dgsw.network.test01.n2318.client;

import java.net.ConnectException;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class MultiChatClient {
    public static void main(String[] args) {
        String id;
        String pw;
        String nickName;
        Scanner sc = new Scanner(System.in);
        System.out.print("닉네임을 입력해주세요 : ");
        nickName = sc.nextLine();

        try {
            String serverIp = "127.0.0.1";
            // 소켓을 생성하여 연결을 요청한다.
            Socket socket = new Socket(serverIp, 3000);
            System.out.println("서버에 연결되었습니다.");
            while(true) {
                System.out.print("ID : ");
                id = sc.nextLine();
                System.out.print("PW : ");
                pw = sc.nextLine();
                if (Objects.equals(id, "admin") && Objects.equals(pw, "1234"))
                    break;
                System.out.println("ID 또는 PW가 틀렸습니다.");
            }
            System.out.println("FTP 서버에 연결되었습니다.");
            System.out.println("메시지 혹은 명령어를 입력해주세요");
            Thread sender = new Thread(new ClientSender(socket, nickName));
            Thread receiver = new Thread(new ClientReceiver(socket));

            sender.start();
            receiver.start();
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (Exception e) {}
    } // main
} // class
