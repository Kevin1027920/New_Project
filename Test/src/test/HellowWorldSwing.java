package test;

import javax.swing.*;

public class HellowWorldSwing {
	
	private static void createAndShowGUI() {
		
		// 确保一个漂亮的外观风格	
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		// 创建及设置窗口
		JFrame frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 // 添加 "Hello World" 标签
		JLabel label = new JLabel("Hello World");
		frame.getContentPane().add(label);
		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(800, 600);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	createAndShowGUI();

		// 显示应用 GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}

}
