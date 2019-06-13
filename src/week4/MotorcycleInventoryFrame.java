package week4;

import java.awt.*;
import javax.swing.*;


public class MotorcycleInventoryFrame extends JFrame {
	static final int WIDTH = 800, HEIGHT = 900;
	
	
	public MotorcycleInventoryFrame() {
		super("Motorcycle Inventory");
		setFrame(WIDTH, HEIGHT);
		setComponents();
	}

	public void display() {
		setVisible(true);
	}
	
	private void setFrame(int width, int height) {
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setComponents() {
		JLabel labelSerialNumber = new JLabel("Serial Number", JLabel.CENTER);
		JLabel labelMaintenanceNeeded = new JLabel("Maintenance Needed?", JLabel.CENTER);
		JLabel labelOwnerName = new JLabel("Current Owner", JLabel.CENTER);
		JLabel labelPrice = new JLabel("Price", JLabel.CENTER);
		JLabel labelServiceHours = new JLabel("Service Hours", JLabel.CENTER);
		JLabel labelType = new JLabel("Type", JLabel.CENTER);
		
		JTextField textSerialNumber = new JTextField("");
		JTextField textMaintenanceNeeded = new JTextField("");
		JTextField textOwnerName = new JTextField("");
		JTextField textPrice = new JTextField("");
		JTextField textServiceHours = new JTextField("");
		JTextField textType = new JTextField("");
		
		JPanel text = new JPanel();
		text.setLayout(new BorderLayout());
		
		JPanel labelsPanel = new JPanel();
		labelsPanel.setLayout(new GridLayout(0, 6, 2, 5));
		labelsPanel.add(labelSerialNumber);
		labelsPanel.add(labelMaintenanceNeeded);
		labelsPanel.add(labelOwnerName);
		labelsPanel.add(labelPrice);
		labelsPanel.add(labelServiceHours);
		labelsPanel.add(labelType);
		labelsPanel.add(textSerialNumber);
		labelsPanel.add(textMaintenanceNeeded);
		labelsPanel.add(textOwnerName);
		labelsPanel.add(textPrice);
		labelsPanel.add(textServiceHours);
		labelsPanel.add(textType);
		
		text.add(labelsPanel, BorderLayout.NORTH);
				
		add(text, BorderLayout.NORTH);
	}
	
	
}
