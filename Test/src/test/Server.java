package test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Server {
	
	public static final int port = 54332; 

	public static void main(String[] args) {
		System.out.println("Server is starting....");
		Server server = new Server();	
		server.init();
	}
	
	public void init() {
		try {
			ServerSocket socket = new ServerSocket(port);
			
			while(true) {
				Socket client = socket.accept();
				System.out.println("connection is successful");
				new HandlerThread(client);	
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class HandlerThread implements Runnable {
		
		private Socket socket;
		
		public HandlerThread(Socket client) {
			this.socket = client;
			new Thread(this).start();
		}
		
		@Override
		public void run() {
			try {
				System.out.println("receiving messages....");
				//accept
				DataInputStream input = new DataInputStream(socket.getInputStream());
				String clientInputStr = input.readUTF();
				System.out.println("client is sending: " + clientInputStr);
				
				//reply
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());
				System.out.println("please input:°°\t");
				String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
				
				output.writeUTF(s);
				output.flush();
//				output.close();
//				input.close();
				
			} catch (IOException e) {
				System.out.println("øÕªß∂À“Ï≥£:" + e.getMessage());
			}		
		} 
	}
}
