package kr.hs.dgsw.network.test01.n2318.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

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
                System.out.println(in.readUTF());
            } catch (IOException e) { }
        }
    } // run
} // ClientReceiver
