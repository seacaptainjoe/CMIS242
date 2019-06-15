/*
* File: MotorcycleInventoryApplication.java
* Author: Joe Held
* Date: 06/14/2019
* Purpose: Contains main method to take inputs from the fields in MotorCycleInventoryFrame
* 			and saves them as variables that are then printed in the text area at the 
* 			bottom of the program window. 
*/

package week4;

import javax.swing.JOptionPane;

public class MotorcycleInventoryApplication extends MotorcycleInventoryFrame {
	// Variables to store input from fields in MotorcycleInventoryFrame 
	public int inventoryNumber = 1;
	public String serialNumber; 
	public boolean maintenanceNeeded;
	public String ownerName;
	public double price;
	public int serviceHours;
	public String type;
	
	// Default text for text output area
	public void setText() {
	textIndexNumber.setText(String.valueOf(inventoryNumber));	
	inventoryOutputPane.setText("\n\n   Inventory #   " + "Serial Number \t\t" + "Maintenance Needed? \t"
			+ "Current Owner \t\t" + "Price \t\t" + "Service Hours \t\t"
			+ "Type\n"
			+ " -------------------------------------------------------------------------------------------------------------------------------------------------\n");
	}
	
	// Method that runs when the Add to Inventory button is clicked
	@Override
	public void addToInventory() {
		
		// Gets input from text fields and drop down boxes
		serialNumber = textSerialNumber.getText();
		if (boxMaintenanceNeeded.getSelectedItem().toString().equals("YES")) {
			maintenanceNeeded = true;
		}
		if (boxMaintenanceNeeded.getSelectedItem().toString().equals("NO")) {
			maintenanceNeeded = false;
		}
		ownerName = textOwnerName.getText();
		try {
			price = Double.parseDouble(textPrice.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Price must be a number!");
			return;
		}
		try {
			serviceHours = Integer.parseInt(textServiceHours.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,  "Service Hours must be a number!");
			return;
		}
		type = boxType.getSelectedItem().toString();
		inventoryOutputPane.append("\n" + "\t" + inventoryNumber + "\t " 
						+ serialNumber + "\t\t\t" + maintenanceNeeded + "\t\t\t"
						+ ownerName + "\t\t\t" + "$" + price + "\t\t" + serviceHours + "\t\t\t" 
						+ type);
		// Incremends inventory record number value
		inventoryNumber += 1;
		
		// Runs method to clear input fields for the next record
		clearTextFields();
	}
	
	// Method to clear the inputfields
	public void clearTextFields() {
		textIndexNumber.setText(String.valueOf(inventoryNumber));
		textSerialNumber.setText("");
		boxMaintenanceNeeded.setSelectedIndex(0);
		textOwnerName.setText("");
		textPrice.setText("");
		textServiceHours.setText("");
		boxType.setSelectedIndex(0);
	}
	
	// Method runs when Clear Inventory button is clicked.
	@Override
	public void clearInventory () {
		// Confirmation popup box prompts user if they're sure they want to clear all records from inventory
		int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear the Inventory?", "Confirmation", JOptionPane.YES_NO_OPTION);
		if (input == 0) {
			setText();
			inventoryNumber = 1;
			clearTextFields();
		}
		else {
			return;
		}
	}
	
	// Main method, instantiates the class, populates the default text, turns on the GUI
	public static void main(String[] args) {
		MotorcycleInventoryApplication program = new MotorcycleInventoryApplication();
		program.setText();
		program.display();		
		
	}

}
