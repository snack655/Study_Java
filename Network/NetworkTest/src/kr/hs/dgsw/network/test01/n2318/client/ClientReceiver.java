package kr.hs.dgsw.network.test01.n2318.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

class ClientReceiver extends Thread {
    Socket socket;
    DataInputStream in;

    ClientReceiver(Socket socket) {
        this.socket = socket;
        try {
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {}
    }

    @Override
    public void run() {
        while (in != null) {
            try {
                String[] command = in.readUTF().split(MultiChatClient.STANDARD);
                switch (command[0]) {
                    case "[AUTH]": {
                        authReceive(command[1]);
                        break;
                    }
                    case "[LIST]": {
                        listReceive(command[1], command[2]);
                        break;
                    }
                    case "[DUPLICATE]": {
                        findDuplicateFile();
                        break;
                    }
                    case "[SUCCESS]": {
                        notDuplicateFile();
                        break;
                    }
                    default: {
                        System.out.println(command[0]);
                        break;
                    }
                }
            } catch (IOException e) { }
        }
    } // run

    private void authReceive(String authResult) {
        if (Objects.equals(authResult, "success")) {
            MultiChatClient.IS_LOGIN = true;
        } else {
            System.out.println("인증에 실패하였습니다. 다시 입력해주세요!");
            MultiChatClient.IS_LOGIN = false;
        }
        MultiChatClient.IS_LOADING = false;
    }

    private void findDuplicateFile() {
        MultiChatClient.IS_DUPLICATE = true;
        MultiChatClient.IS_DUPLICATE_WAIT = false;
    }

    private void notDuplicateFile() {
        MultiChatClient.IS_DUPLICATE = false;
        MultiChatClient.IS_DUPLICATE_WAIT = false;
    }

    private void listReceive(String fileName, String fileSize) {
        System.out.println("파일명 : " + fileName + "    사이즈 : " + fileSize);
    }
} // ClientReceiver
