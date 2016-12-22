package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class ClientHandler extends IoHandlerAdapter {
	
	private static String messages = null;
	
	private static long timeBeforeSending = 0;
	
	private static long timeAfterSending = 0;
	
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("client session is opened!");
		messages = new BufferedReader(new InputStreamReader(System.in)).readLine();
		timeBeforeSending = System.nanoTime();
		session.write(messages);
		
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		System.out.println("client has received " + message);
		messages = new BufferedReader(new InputStreamReader(System.in)).readLine();
		timeBeforeSending = System.nanoTime();
		session.write(messages);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("client session is created!");
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("client session is closed!");
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		timeAfterSending = System.nanoTime();
		System.out.println("client message has sent out, the time is " + (timeAfterSending - timeBeforeSending) + "ns");
	}
	
	
	
	
}
