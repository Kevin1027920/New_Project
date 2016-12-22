package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.*;

public class MyIoHandler extends IoHandlerAdapter{
	
	private final static Logger log = LoggerFactory.getLogger(MyIoHandler.class);

	private static String messages = null;

	@SuppressWarnings("deprecation")
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String str = message.toString();
		log.info("The message reveived is [" + str + "]");
		if (str.endsWith("quit")) {
			session.close(true);
			return;
		}
		messages = new BufferedReader(new InputStreamReader(System.in)).readLine();
		session.write(messages);
		
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("server session is created!");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("server session is opened!");
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("server session is closed!");
	}
	
	
	
}
