package week4;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

class SketchPanel extends JPanel {
	private Point start, end;
	public SketchPanel() {
		start = new Point(0, 0);
		end = new Point (0, 0);
		SketchListener skListener = new SketchListener();
		addMouseListener(skListener);
		addMouseMotionListener(skListener);
	}
	
	protected void paintComponent(Graphics g) {
		g.drawLine(start.x,  start.y,  end.x,  end.y);
		start.setLocation(end);
	}
	
	class SketchListener implements MouseListener, MouseMotionListener {
		public void mousePressed(MouseEvent e) {
			start = e.getPoint();
		}
		
		public void mouseDragged(MouseEvent e) {
			//int r = ran.nextInt(101);
			end = e.getPoint();
			repaint();
		}
		
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseMoved(MouseEvent e) {}
	}
}
