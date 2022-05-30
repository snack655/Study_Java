package kr.hs.dgsw.network.test01.n2318.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class MultiChatServer {
    HashMap clients;
    public static final String fileFolder = "/Users/choiminjae/NetworkTestServer";
    public static final String STANDARD = "::";

    MultiChatServer() {
        clients = new HashMap();
        Collections.synchronizedMap(clients);
    }

    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(3000);
            System.out.println("서버가 시작되었습니다!");

            while(true) {
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress()
                            + ":"+socket.getPort()+"]"+"에서 접속하였습니다.");
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void sendToAll(String msg) {
        Iterator it = clients.keySet().iterator();

        while (it.hasNext()) {
            try {
                DataOutputStream out = (DataOutputStream) clients.get(it.next());
                out.writeUTF(msg);
            } catch (IOException e) { }
        }
    }

    void auth(String name, String result) {
        DataOutputStream out = (DataOutputStream) clients.get(name);
        try {
            out.writeUTF("[AUTH]"+STANDARD+result);
        } catch (IOException e) { }
    }

    void sendFileList(String name, String fileName, String fileSize, Boolean hasFile) {
        DataOutputStream out = (DataOutputStream) clients.get(name);
        try {
            if (hasFile) {
                out.writeUTF("[LIST]" +
                        STANDARD +
                        fileName +
                        STANDARD +
                        fileSize
                );
            } else {
                out.writeUTF("0개의 파일..");
            }
        } catch (IOException e) { }
    }

    public static void main(String[] args) {
        new MultiChatServer().start();
    }
} // class