package com.mott.pixelsquad.main;

import javax.swing.JFrame;

public class Game {

	private static final String NAME = "Team Pixel";

	private static final int INIT_WIDTH = 800;
	private static final int INIT_HEIGHT = INIT_WIDTH / 16 * 9;

	public static void main(String[] args) {

		new Game();

	}

	public Game() {

		// Initializing
		JFrame frame = new JFrame();
		frame.setSize(INIT_WIDTH, INIT_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle(NAME);
		frame.setVisible(true);

	}
}