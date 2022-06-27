package kr.hs.dgsw.web;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;


public class RootHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        // Initialize Response Body
        OutputStream respBody = exchange.getResponseBody();

        try {
            // Write Response Body
            StringBuilder sb = new StringBuilder();
            sb.append("<!DOCTYPE html>");
            sb.append("<html>");
            sb.append("   <head>");
            sb.append("       <meta charset=\"UTF-8\">");
            sb.append("       <meta name=\"author\" content=\"Dochi\">");
            sb.append("       <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            sb.append("       <title>Example</title>");
            sb.append("   </head>");
            sb.append("   <body>");
            sb.append("       <h5>류지훈</h5>");
            sb.append("       <span>소속 : 일간베스트</span></br>");
            sb.append("       <span>나이 : ㅇㅇ</span></br>");
            sb.append("       <span>성별 : ㅇㅇ</span></br>");
            sb.append("       <span>직업 : 호감고닉</span></br>");
            sb.append("       <span>전공 : 분탕충</span></br>");
            sb.append("   </body>");
            sb.append("</html>");

            // Encoding to UTF-8
            ByteBuffer bb = Charset.forName("UTF-8").encode(sb.toString());
            int contentLength = bb.limit();
            byte[] content = new byte[contentLength];
            bb.get(content, 0, contentLength);

            // Set Response Headers
            Headers headers = exchange.getResponseHeaders();
            headers.add("Content-Type", "text/html;charset=UTF-8");
            headers.add("Content-Length", String.valueOf(contentLength));

            // Send Response Headers
            exchange.sendResponseHeaders(200, contentLength);

            respBody.write(content);

            // Close Stream
            // 반드시, Response Header를 보낸 후에 닫아야함
            respBody.close();

        } catch (IOException e) {
            e.printStackTrace();

            if (respBody != null) {
                respBody.close();
            }
        } finally {
            exchange.close();
        }
    }
}
