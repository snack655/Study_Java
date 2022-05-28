package kr.hs.dgsw.network.test01.n2318.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientAccept {
	public Socket sc = null;

	private OutputStream os = null;
	private PrintWriter pw = null;
	private BufferedReader br = null;
	
	public ClientAccept(Socket sc) {
		this.sc = sc;
		
		try {
			this.os = sc.getOutputStream();
			this.pw = new PrintWriter(this.os, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		InputStream is = null;
		try {
			is = sc.getInputStream();
		} catch (IOException e) { }
		this.br = new BufferedReader(new InputStreamReader(is));
	}
	
	public void sendMessage(String msg) {
		pw.println(msg);
	}
	
	public String readMessage() throws IOException {
		return br.readLine();
	}
}
