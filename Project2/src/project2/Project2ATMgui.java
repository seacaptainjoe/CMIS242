/*
* File: Project2ATMgui.java
* Class: CMSC242 - Intermediate Programming, Summer 2019
* Author: Joe Held
* Date: 06/15/2019
* Purpose: GUI elements for the ATM machine program written for Week4, Project 2
*/

package week4;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Project2ATMgui extends JFrame{
	
	static final int WIDTH = 300, HEIGHT = 200;
	public double input;
	public double savingsBalance = 200;
	public double checkingBalance = 100;

	JButton buttonWithdraw = new JButton("Withdraw");
	JButton buttonDeposit = new JButton("Deposit");
	JButton buttonTransfer = new JButton("Transfer to");
	JButton buttonBalance = new JButton("Balance");
	
	JRadioButton radioChecking = new JRadioButton("Checking");
	JRadioButton radioSavings = new JRadioButton("Savings");
	
	JTextField textInOut = new JTextField("");
	
	JPanel panelButtons = new JPanel();
	//JPanel panelRadio = new JPanel();
	JPanel panelInOut = new JPanel();
	
	public Project2ATMgui () {
		super("ATM");
		setFrame(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setComponents();
	}
	
	public void display() {
		setVisible(true);
	}
	
	public void setFrame(int width, int height) {
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setComponents() {
		panelButtons.add(buttonWithdraw);
		panelButtons.add(buttonDeposit);
		panelButtons.add(buttonTransfer);
		panelButtons.add(buttonBalance);
		panelButtons.add(radioChecking);
		panelButtons.add(radioSavings);
		panelButtons.setLayout(new GridLayout(0, 2, 5, 5));
		
		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.add(radioChecking);
		radioButtons.add(radioSavings);
		radioChecking.setSelected(true);
		
		panelInOut.add(textInOut);
		textInOut.setColumns(20);
		panelInOut.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(panelButtons, BorderLayout.NORTH);
		add(panelInOut, BorderLayout.CENTER);
		
		buttonWithdraw.addActionListener(new withdrawalListener());
		buttonDeposit.addActionListener(new depositListener());
		buttonTransfer.addActionListener(new transferListener());
		buttonBalance.addActionListener(new balanceListener());
	}
	
	class withdrawalListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				input = Double.parseDouble(textInOut.getText());
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Please enter a whole number only!");
				clearTextInOut();
				return;
			}
			if (input % 20 != 0) {
				JOptionPane.showMessageDialog(null,  "You must enter withdrawal ammounts in $20 increments only!");
				clearTextInOut();
			}
			else {
				withdrawal();
			}
		}
		
	}
	class depositListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				input = Double.parseDouble(textInOut.getText());
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Please enter a whole number only!");
				clearTextInOut();
				return;
			}
			deposit();
			}
		}
	class transferListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				input = Double.parseDouble(textInOut.getText());
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Please enter a whole number only!");
				clearTextInOut();
				return;
			}
			transfer();
			}
		}
	class balanceListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			balance();
			}
		}
	
	public double getInput() {
		return Double.parseDouble(textInOut.getText());
		
	}
	public void withdrawal() {
	
	}
	public void deposit() {
		if (radioChecking.isSelected()) {
			checkingBalance = checkingBalance + getInput();
				JOptionPane.showMessageDialog(null, "$" + getInput() + " has been deposited into your Checking account.\n"
						+ "Your current Checking account balance is: $" + checkingBalance);
				clearTextInOut();
				return;
			}
		else if (radioSavings.isSelected()) {
			savingsBalance = savingsBalance + getInput();
				JOptionPane.showMessageDialog(null, "$" + getInput() + " has been deposited into your Savings account.\n"
						+ "Your current Savings Account balance is: $" + savingsBalance);
				clearTextInOut();
				return;
			}
		}
	public void transfer() {
		input = Double.parseDouble(textInOut.getText());
			if (radioChecking.isSelected()) {
			}
				if (input <= savingsBalance) {
					checkingBalance = checkingBalance + input;
					savingsBalance -= input;
					JOptionPane.showMessageDialog(null,  "You have successfully transfered $" + input + "\nfrom your Savings account to your Checking Account.");
				}
				else {
					insufficientFunds();
					clearTextInOut();
				}
		
			
		
		if (radioSavings.isSelected()) {
			if (input <= checkingBalance) {
				savingsBalance = savingsBalance + input;
				checkingBalance -= input;
				JOptionPane.showMessageDialog(null,  "You have successfully transfered $" + input + "\nfrom your Checking account to your Savings account.");
			}
			else {
				insufficientFunds();
				clearTextInOut();
			}
		}
	}
	public void balance() {
		clearTextInOut();
		if (radioChecking.isSelected()) {
			JOptionPane.showMessageDialog(null, "Your current Checking Account balance is: \n"
												+ "$" + checkingAccount.getBalance());
		}
		if (radioSavings.isSelected()) {
			JOptionPane.showMessageDialog(null,  "Your currentSavings Account balance is: \n"
												+ "$" + savingsBalance);
		}
	}
	
	public void clearTextInOut() {
		textInOut.setText("");
	}
	
	public void insufficientFunds() {
		JOptionPane.showMessageDialog(null, "You have insufficient funds to complete this action.");
	}
}
