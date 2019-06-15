/*
* File: MotorcycleInventoryFrame.java
* Author: Joe Held
* Date: 06/14/2019
* Purpose: Contains all of the GUI elements that make up the program.  Includes several
* 			text input fields and drop down boxes to allow the user to input inventory
* 			records.  Also has two buttons that add the current record to the inventory output
* 			or clears all current records. 
*/

package week4;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MotorcycleInventoryFrame extends JFrame implements ActionListener {
	static final int WIDTH = 1200, HEIGHT = 900;
	
	// Values for the drop down selection boxes 
	static final String TYPES[] = {"Chopper", "Cruiser", "Dirt", "Dual Sport", "Enduro", "Motocross", "Naked", "Scooter", "Sport", "Supermoto", "Touring", "Trials"}; 
	static final String MAINTENANCE[] = {"YES", "NO"};
	
	// Input box labels
	JLabel labelIndexNumber = new JLabel("Inventory #", JLabel.CENTER);
	JLabel labelSerialNumber = new JLabel("Serial Number", JLabel.CENTER);
	JLabel labelMaintenanceNeeded = new JLabel("Maintenance Needed?", JLabel.CENTER);
	JLabel labelOwnerName = new JLabel("Current Owner", JLabel.CENTER);
	JLabel labelPrice = new JLabel("Price", JLabel.CENTER);
	JLabel labelServiceHours = new JLabel("Service Hours", JLabel.CENTER);
	JLabel labelType = new JLabel("Type", JLabel.CENTER);
	
	// Non editable inventory record number, increments automatically for each record entered
	JTextField textIndexNumber = new JTextField("##");

	// Input box fields
	JTextField textSerialNumber = new JTextField("");
	JComboBox boxMaintenanceNeeded = new JComboBox(MAINTENANCE);
	JTextField textOwnerName = new JTextField("");
	JTextField textPrice = new JTextField("");
	JTextField textServiceHours = new JTextField("");
	JComboBox boxType = new JComboBox(TYPES);
	
	// Action buttons 
	JButton buttonAddToInventory = new JButton("Add to Inventory");
	JButton buttonClearInventory = new JButton("Clear Inventory");
	
	// Lower text output pane
	JTextArea inventoryOutputPane = new JTextArea();
	
	JPanel topPanel = new JPanel();
	JPanel labelsPanel = new JPanel();
	
	// Method builds the GUI 
	public MotorcycleInventoryFrame() {
		super("Motorcycle Inventory");
		setFrame(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
				
		setComponents();
	}
	
	// Instantiates the GUI for the user
	public void display() {
		setVisible(true);
	}
	
	// Sets default frame options
	private void setFrame(int width, int height) {
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// Setups the GUI components define above and applies them to the GUI layout
	public void setComponents() {
		labelsPanel.add(labelIndexNumber);
		labelsPanel.add(labelSerialNumber);
		labelsPanel.add(labelMaintenanceNeeded);
		labelsPanel.add(labelOwnerName);
		labelsPanel.add(labelPrice);
		labelsPanel.add(labelServiceHours);
		labelsPanel.add(labelType);
		labelsPanel.add(textIndexNumber);
		labelsPanel.add(textSerialNumber);
		labelsPanel.add(boxMaintenanceNeeded);
		labelsPanel.add(textOwnerName);
		labelsPanel.add(textPrice);
		labelsPanel.add(textServiceHours);
		labelsPanel.add(boxType);
		
		topPanel.setLayout(new BorderLayout());
		topPanel.add(labelsPanel, BorderLayout.NORTH);
		labelsPanel.setLayout(new GridLayout(0, 7, 5, 5));
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonsPanel.add(buttonAddToInventory);
		buttonsPanel.add(buttonClearInventory);
		
		textIndexNumber.setEditable(false);
		topPanel.add(buttonsPanel, BorderLayout.CENTER);
		
		// Sets output pane options
		inventoryOutputPane.setEditable(false);
		inventoryOutputPane.setLineWrap(false);
		inventoryOutputPane.setText("\n\nInventory will be displayed here.");
		inventoryOutputPane.setFont(new Font("Courier New", Font.PLAIN,14));
		
		add(topPanel, BorderLayout.NORTH);
		add(new JScrollPane(inventoryOutputPane), BorderLayout.CENTER);
		
		// Action Listeners for each button
		buttonAddToInventory.addActionListener(this); 
		buttonClearInventory.addActionListener(this);
	}
	
	// Button method default constructors
	public void addToInventory() {
	}
	
	public void clearInventory() {
	}
	
	// Single action event runs appropriate method depending on which button was actioned
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==buttonAddToInventory) {
			addToInventory();
		}
		
		if (e.getSource()==buttonClearInventory) {
			clearInventory();
		}
	}
	
	
}
