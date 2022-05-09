import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        try {
            Socket sc = new Socket("10.80.162.244", 5000);
            Scanner scan = new Scanner(System.in);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        OutputStream os = null;
                        try {
                            os = sc.getOutputStream();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        PrintWriter pw = new PrintWriter(os, true);
                        pw.println(scan.nextLine());
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        InputStream is = null;
                        try {
                            is = sc.getInputStream();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));

                        try {
                            System.out.println(br.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }).start();


        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}

