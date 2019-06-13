package week4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MouseKeyPanel extends JPanel {
	String coordinates, text;
	int x, y;
	public MouseKeyPanel() {
		coordinates = text = "";
		x = y = 0;
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				coordinates = "(" + x + "," + y + ")";
				text = "";
					repaint();
			}
		});
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if ((keyCode >= KeyEvent.VK_A && keyCode <= KeyEvent.VK_Z) || keyCode == KeyEvent.VK_SPACE)
					text += String.valueOf(e.getKeyChar());
				repaint();
			}
		});
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		g.setFont(new Font("Courier New", Font.PLAIN, 16));
		g.drawString(coordinates,  x,  y);
		g.setColor(Color.blue);
		g.setFont(new Font("Times New Roman", Font.BOLD, 20));
		g.drawString(text,  x,  y + 30);;
	}
}
