package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread implements Runnable{
	
	private Socket socket;
	
	
	
	private int clientNum;
	
	public ServerThread(Socket socket, int clientNum) {
		this.socket = socket;
		this.clientNum = clientNum;
	}
	
	

	@Override
	public void run() {
		System.out.println("Client " + clientNum + " has connected to the server");
		BufferedReader in_socket;
		try {
			in_socket = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			while(true) {
				ArrayList<PrintWriter> temp = ServerMain.getPrintWriters();
				if(in_socket.ready()) {
					String msg = in_socket.readLine();
					for(PrintWriter p : temp) {
						p.println(msg);
					}
				}
				
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
			
	}

}
