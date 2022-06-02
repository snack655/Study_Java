package kr.hs.dgsw.network.test01.n2318.server;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class MultiChatServer {
    HashMap clients;
    public static final String fileFolder = "/Users/choiminjae/NetworkTestServer";
    public static final String STANDARD = "::";
    DataOutputStream out;

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
                out = (DataOutputStream) clients.get(it.next());
                out.writeUTF(msg);
            } catch (IOException e) { }
        }
    }

    void auth(String name, String result) {
        out = (DataOutputStream) clients.get(name);
        try {
            out.writeUTF("[AUTH]"+STANDARD+result);
        } catch (IOException e) { }
    }

    void sendFileList(String name, String fileName, String fileSize, Boolean hasFile) {
        out = (DataOutputStream) clients.get(name);
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

    void sendFindDuplicateFileResult(String name, Boolean result) {
        out = (DataOutputStream) clients.get(name);
        try {
            if (result) {
                out.writeUTF("[DUPLICATE]");
            } else {
                out.writeUTF("[SUCCESS]");
            }
        } catch (IOException e) { }
    }

    void downFileResult(String name, Boolean result, String filePath) throws IOException {
        out = (DataOutputStream) clients.get(name);
        if (result) {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            out.writeUTF(
                    "[SEND_FILE]" +
                    MultiChatServer.STANDARD +
                    Files.size(file.toPath()) +
                    MultiChatServer.STANDARD +
                    file.getName()
            );
            byte[] bytes = new byte[1024];
            int readBit = 0;
            while((readBit = fis.read(bytes)) != -1) {
                out.write(bytes, 0, readBit);
            }
        } else {
            out.writeUTF("[DOWN_FAIL]");
        }
    }

    void sendFileUploadSuccess(String name) {
        out = (DataOutputStream) clients.get(name);
        try {
            out.writeUTF("파일 업로드에 성공하였습니다!");
        } catch (IOException e) { }
    }

    public static void main(String[] args) {
        new MultiChatServer().start();
    }
} // class
