package kr.hs.dgsw.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("255.255.255.255");

        DatagramSocket ds = new DatagramSocket();


        String j = "북";
        DatagramPacket sendPacket = new DatagramPacket(j.getBytes(), j.getBytes().length, inetAddress, 9999);
        ds.send(sendPacket);

        System.out.println("상빈 학생");
    }
}
