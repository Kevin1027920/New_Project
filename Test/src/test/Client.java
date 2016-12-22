package test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static final String IP = "localhost";
	public static final int PORT = 54332;

	public static void main(String[] args) {
		System.out.println("client is starting...");
		System.out.println("当接收到服务器端字符为 \"OK\" 的时候, 客户端将终止\n");
		
		Socket socket;
		try {
			socket = new Socket(IP, PORT);
			DataInputStream input = null;
			DataOutputStream output = null;
			while(true) {
				output = new DataOutputStream(socket.getOutputStream());
				String s = new BufferedReader(new InputStreamReader(System.in)).readLine();		
				output.writeUTF(s);
				output.flush();
			
				//if (socket.getInputStream().available() > 0) {				
					input = new DataInputStream(socket.getInputStream());
					System.out.println("server is sending: " + input.readUTF()); 
				//}
								
				if (s.equals("close")) {
					input.close();
					output.close();
					socket.close();	
				}

				
			}
			
		}  catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务端异常:" + e.getMessage()); 
		} 

	}
}
