package week4;

import java.awt.*;
import javax.swing.*;


public class MotorcycleInventoryFrame extends JFrame {
	static final int WIDTH = 800, HEIGHT = 900;
	
	
	public MotorcycleInventoryFrame() {
		super("Motorcycle Inventory");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void display() {
		setVisible(true);
	}
}
