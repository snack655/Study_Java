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
                    default: {
                        System.out.println(command[0]);
                        break;
                    }
                }
            } catch (IOException e) { }
        }
    } // run

    public void authReceive(String authResult) {
        if (Objects.equals(authResult, "success")) {
            MultiChatClient.isLOGIN = true;
        } else {
            System.out.println("인증에 실패하였습니다. 다시 입력해주세요!");
            MultiChatClient.isLOGIN = false;
        }
        MultiChatClient.isLOADING = false;
    }
} // ClientReceiver
