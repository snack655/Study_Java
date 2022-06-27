package kr.hs.dgsw.web;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaWebServerMain {
    private final String DEFAULT_HOSTNAME = "0.0.0.0";
    private final int DEFAULT_PORT = 8080;
    private final int DEFAULT_BACKLOG = 0;
    private HttpServer server = null;

    /**
     * 생성자
     */
    public JavaWebServerMain() throws IOException {
        createServer(DEFAULT_HOSTNAME, DEFAULT_PORT);
    }
    public JavaWebServerMain(int port) throws IOException {
        createServer(DEFAULT_HOSTNAME, port);
    }
    public JavaWebServerMain(String host, int port) throws IOException {
        createServer(host, port);
    }

    /**
     * 서버 생성
     */
    private void createServer(String host, int port) throws IOException {
        // HTTP Server 생성
        this.server = HttpServer.create(new InetSocketAddress(host, port), DEFAULT_BACKLOG);
        // HTTP Server Context 설정
        server.createContext("/", new RootHandler());
    }

    /**
     * 서버 실행
     */
    public void start() {
        server.start();
    }

    /**
     * 서버 중지
     */
    public void stop(int delay) {
        server.stop(delay);
    }

    public static void main(String[] args) {

        JavaWebServerMain httpServerManager = null;

        try {
            // 시작 로그
            System.out.println(
                    String.format(
                            "[%s][HTTP SERVER][START]",
                            new SimpleDateFormat("yyyy-MM-dd H:mm:ss").format(new Date())
                    )
            );

            // 서버 생성
            httpServerManager = new JavaWebServerMain("0.0.0.0", 3000);
            httpServerManager.start();
            // Shutdown Hook
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    // 종료 로그
                    System.out.println(
                            String.format(
                                    "[%s][HTTP SERVER][STOP]",
                                    new SimpleDateFormat("yyyy-MM-dd H:mm:ss").format(new Date())
                            )
                    );
                }
            }));

            // Enter를 입력하면 종료
            System.out.print("Please press 'Enter' to stop the server.");
            System.in.read();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 종료
            // 0초 대기후  종료
            httpServerManager.stop(0);
        }
    }
}
