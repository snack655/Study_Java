package kr.hs.dgsw.network.test01.n2318.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ServerReceiver extends Thread {
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    MultiChatServer multiChatServer = new MultiChatServer();

    ServerReceiver(Socket socket) {
        this.socket = socket;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {}
    }

    public void run() {
        String name = "";

        try {
            name = in.readUTF();
            multiChatServer.sendToAll("#" + name + "님이 들어오셨습니다.");

            multiChatServer.clients.put(name, out);
            System.out.println("현재 서버접속자 수는 " + multiChatServer.clients.size() + "입니다.");
            while(in != null) {
                multiChatServer.sendToAll(in.readUTF());
            }
        } catch (IOException e) {
            // Ignore
        } finally {
            multiChatServer.sendToAll("#" + name + "님이 나가셨습니다.");
            multiChatServer.clients.remove(name);
            System.out.println("["+socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
            System.out.println("현재 서버접속자 수는 " + multiChatServer.clients.size() + "입니다.");
        }   // try
    } // run
} // Receiver Thread
