package kr.hs.dgsw.network.test01.n2318.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("서버가 열렸습니다.");


            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client IP : " + socket.getInetAddress() + ": 접속하였습니다.");

                ClientAccept clientAccept = new ClientAccept(socket);
                Thread clientThread = new ClientThread(socket.getInetAddress().toString(), clientAccept);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert serverSocket != null;
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
