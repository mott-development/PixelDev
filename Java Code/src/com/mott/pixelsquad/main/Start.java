package com.mott.pixelsquad.main;

import javax.swing.JFrame;

public class Start {
	//setup frame
	private Frame frame;
	private Game panel;
	
	//Initial variables
	private final int INIT_WIDTH = 1280;
	private final int INIT_HEIGHT = INIT_WIDTH / 16 * 9;
	
	public Start() {
		//Initializing
		frame = new Frame();
		panel = new Game();
		frame.setSize(INIT_WIDTH, INIT_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("");
		
		//Settings
		
		frame.add(panel);
	}
}
