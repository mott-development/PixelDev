package com.mott.pixelsquad.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

public class Game implements GLEventListener, KeyListener, WindowListener {

	private static final String NAME = "Team Pixel";

	private static final int INIT_WIDTH = 720;
	private static final int INIT_HEIGHT = INIT_WIDTH * 3 / 4;

	private static final int FPS = 50;

	public final GLCanvas canvas;
	public GLU glu;

	public HashMap<Integer, Boolean> keysPressed = new HashMap<Integer, Boolean>() {

		private static final long serialVersionUID = 1L;

		public Boolean get(Object key) {

			if (containsKey(key))
				return super.get(key);
			else
				return false;

		}

	};

	public static void main(String[] args) {

		new Game();

	}

	public Game() {

		GLProfile glp = GLProfile.getDefault();
		GLCapabilities caps = new GLCapabilities(glp);

		JFrame frame;

		FPSAnimator animator;

		canvas = new GLCanvas(caps);
		canvas.addGLEventListener(this);
		canvas.setFocusable(false);

		frame = new JFrame(NAME);
		frame.setSize(INIT_WIDTH, INIT_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.add(canvas);
		frame.addKeyListener(this);
		frame.addWindowListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		animator = new FPSAnimator(canvas, FPS);
		animator.start();

	}

	public void update() {

	}

	public void render(GL2 gl) {

		// Demonstration of key system and rendering
		if (keysPressed.get(KeyEvent.VK_SPACE)) {
			gl.glLoadIdentity();

			gl.glTranslated(0, 0, -3);

			gl.glBegin(GL.GL_TRIANGLES);

			gl.glColor3d(1, 1, 1);
			gl.glVertex3d(0, 1, 0);
			gl.glVertex3d(-1, -1, 0);
			gl.glVertex3d(1, -1, 0);

			gl.glEnd();
		}

	}

	@Override
	public void init(GLAutoDrawable drawable) {

		GL2 gl = drawable.getGL().getGL2();

		glu = new GLU();

		gl.glClearColor(0.5f, 0.5f, 0.5f, 1f);

		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glDepthFunc(GL.GL_LEQUAL);
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
		gl.glShadeModel(GL2.GL_SMOOTH);

	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
	}

	@Override
	public void display(GLAutoDrawable drawable) {

		GL2 gl = drawable.getGL().getGL2();

		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

		update();
		render(gl);

	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {

		GL2 gl = drawable.getGL().getGL2();

		if (height == 0)
			height = 1;
		double aspect = (double) width / height;

		gl.glViewport(0, 0, width, height);

		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(45, aspect, 0.01, 100);

		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();

	}

	@Override
	public void keyPressed(KeyEvent e) {

		keysPressed.put(e.getKeyCode(), true);

	}

	@Override
	public void keyReleased(KeyEvent e) {

		keysPressed.put(e.getKeyCode(), false);

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {

		for (int i : keysPressed.keySet())
			keysPressed.put(i, false);

	}

}