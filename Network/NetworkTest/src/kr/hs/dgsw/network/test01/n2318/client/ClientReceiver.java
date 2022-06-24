package kr.hs.dgsw.network.test01.n2318.client;

import java.io.DataInputStream;
import java.io.FileOutputStream;
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
                    case "[SEND_FILE]": {
                        downloadFile(command[1], command[2]);
                        break;
                    }
                    case "[DOWN_FAIL]": {
                        MultiChatClient.IS_SUCCESS_FILE_DOWNLOAD = false;
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

    private void downloadFile(String fileSize, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(MultiChatClient.CLIENT_FOLDER_PATH + "/" + fileName);
        byte[] bytes = new byte[1024];
        int readBit = 0;
        while((readBit = in.read(bytes)) != -1) {
            // bytes에 저장된 데이터 전송
            fos.write(bytes, 0, readBit);
        }
        fos.close();
        MultiChatClient.IS_SUCCESS_FILE_DOWNLOAD = true;
    }
} // ClientReceiver
