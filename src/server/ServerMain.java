package server;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMain {
	
	private int clientNum = 1;
	
	private static ArrayList<PrintWriter> allClients;
	
	
	public ServerMain() throws Exception{
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(2021);
		allClients = new ArrayList<PrintWriter>();
		while(true) {
			Socket ref = server.accept();
			ServerThread process = new ServerThread(ref, getClientNumber());
			Thread connec = new Thread(process);
			allClients.add(new PrintWriter(new OutputStreamWriter(ref.getOutputStream()), true));
			connec.start();
		}
	}
	
	public int getClientNumber() {
		return clientNum++;
	}
	
	public static ArrayList<PrintWriter> getPrintWriters() {
		return allClients;
	}
	
	
	public static void main(String[] args) {
		try {
			new ServerMain();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
