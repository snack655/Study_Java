package kr.hs.dgsw.network.test01.n2318.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class ClientSender extends Thread {
    Socket socket;
    DataOutputStream out;
    String name;

    ClientSender(Socket socket, String name) {
        this.socket = socket;
        try {
            out = new DataOutputStream(socket.getOutputStream());
            this.name = name;
        } catch (Exception e) {}
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            if (out != null) {
                out.writeUTF(name);
            }
            while (out != null) {
                out.writeUTF("["+name+"]"+scanner.nextLine());
            }
        } catch (IOException e) {}
    } // run()
} // ClientSender
