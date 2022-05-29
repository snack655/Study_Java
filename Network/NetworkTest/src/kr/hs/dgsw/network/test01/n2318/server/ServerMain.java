package kr.hs.dgsw.network.test01.n2318.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerMain {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4000);
            System.out.println(getTime() + " 서버가 열렸습니다.");

            while (true) {
                System.out.println(getTime() + "연결 요청을 기다립니다.");
                serverSocket.setSoTimeout(10 * 1000);
                Socket socket = serverSocket.accept();

                System.out.println("Client IP : " + socket.getInetAddress() + ": 접속하였습니다.");

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF("[Notice] Test Message1 from Server.");
                System.out.println("데이터 전송 완료");

                dos.close();
                socket.close();

//                ClientAccept clientAccept = new ClientAccept(socket);
//                Thread clientThread = new ClientThread(socket.getInetAddress().toString(), clientAccept);
//                clientThread.start();
            }
        } catch (SocketTimeoutException e){
            System.out.println("지정된 시간동안 접속요청이 없어서 서버를 종료합니다.");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }

}
