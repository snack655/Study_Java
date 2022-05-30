package kr.hs.dgsw.network.test01.n2318.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class ServerReceiver extends Thread {
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    File file;
    String name = "";

    public static final String ID = "admin";
    public static final String PASSWORD = "1234";

    MultiChatServer multiChatServer = new MultiChatServer();

    ServerReceiver(Socket socket) {
        this.socket = socket;
        file = new File(MultiChatServer.fileFolder);

        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {}
    }

    public void run() {
        try {
            setServer();
            while(in != null) {
                sortOutCommand();
            }
        } catch (IOException e) {
            // Ignore
        } finally {
            shutDownClient();
            printServerSize();
        }   // try
    } // run

    /**
     * 명령어를 구분하여 각각 올바른 함수를 실행시킵니다.
     * @throws IOException
     */
    private void sortOutCommand() throws IOException {
        String[] commandDiv = in.readUTF().split(MultiChatServer.STANDARD);
        switch (commandDiv[0]) {
            case "[AUTH]": {
                authReceive(commandDiv[1], commandDiv[2]);
                break;
            }
            case "[LIST]": {
                sendFileList();
                break;
            }
            default: {
                multiChatServer.sendToAll(commandDiv[0]);
                break;
            }
        }
    } // sortOutCommand

    /**
     * Auth 인증을 처리하는 함수입니다.
     * @param id
     * @param pw
     */
    private void authReceive(String id, String pw) {
        if (Objects.equals(id, ID) && Objects.equals(pw, PASSWORD)) {
            multiChatServer.auth(name, "success");
            System.out.println(name + "님이 인증에 성공하셨습니다.");
            return;
        }
        multiChatServer.auth(name, "fail");
        System.out.println(name + "님이 인증에 실패하셨습니다.");
    } // authReceive

    /**
     * 파일 리스트를 가공하여 메인으로 전송합니다.
     * 이때 숨긴 파일은 전송하지 않습니다.
     * @throws IOException
     */
    private void sendFileList() throws IOException {
        File[] fileArr = file.listFiles();

        // 숨긴 파일은 전송하지 않기 위해
        List<File> processedFileList = new ArrayList<>();
        for (int i = 0; i < fileArr.length; i++) {
            char[] fileName = fileArr[i].getName().toCharArray();
            if (fileName[0] == '.') {
                continue;
            }
            processedFileList.add(fileArr[i]);
        }

        if (processedFileList.isEmpty()) {
            System.out.println(processedFileList);
            multiChatServer.sendFileList(name, null, null, false);
            return;
        }

        for (File file: processedFileList) {
            String fileSize = Files.size(file.toPath()) / 1024 + "KB";
            multiChatServer.sendFileList(name, file.getName(), fileSize, true);
        }
    }

    /**
     * 서버 초기 세팅 함수
     * @throws IOException
     */
    private void setServer() throws IOException {
        name = in.readUTF();
        multiChatServer.sendToAll("#" + name + "님이 들어오셨습니다.");
        multiChatServer.clients.put(name, out);
        System.out.println("현재 서버접속자 수는 " + multiChatServer.clients.size() + "입니다.");
    }

    /**
     * 서버 접속자 수를 출력하는 함수
     */
    private void printServerSize() {
        System.out.println("현재 서버접속자 수는 " + multiChatServer.clients.size() + "입니다.");
    }

    /**
     * 클라이언트의 종료에 대응하는 함수
     */
    private void shutDownClient() {
        multiChatServer.sendToAll("#" + name + "님이 나가셨습니다.");
        multiChatServer.clients.remove(name);
        System.out.println("["+socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
    }
} // Receiver Thread
