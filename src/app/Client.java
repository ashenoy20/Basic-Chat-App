package app;

import java.net.Socket;

public class Client {
	public static Socket mySocket;
	

	
	public Client() throws Exception {
		
		Socket connection = new Socket("localhost", 2021);
		mySocket = connection;	
		
	}
	
	
}

