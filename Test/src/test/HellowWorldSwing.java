package test;

import javax.swing.*;

public class HellowWorldSwing {
	
	private static void createAndShowGUI() {
		
		// ȷ��һ��Ư������۷��	
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		// ���������ô���
		JFrame frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 // ��� "Hello World" ��ǩ
		JLabel label = new JLabel("Hello World");
		frame.getContentPane().add(label);
		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(800, 600);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	createAndShowGUI();

		// ��ʾӦ�� GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}

}
