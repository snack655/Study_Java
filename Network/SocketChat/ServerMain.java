import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(3000);

            Socket sc = ss.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    InputStream is = null;
                    try {
                        is = sc.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String msg = br.readLine();
                        System.out.println(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    OutputStream os = null;
                    try {
                        os = sc.getOutputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    PrintWriter pw = new PrintWriter(os, true);

                    Scanner scan = new Scanner(System.in);
                    pw.println(scan.next());
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

