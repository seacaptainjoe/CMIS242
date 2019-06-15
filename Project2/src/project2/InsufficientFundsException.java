package project2;

import javax.swing.JOptionPane;

public class InsufficientFundsException extends Exception{
	
	public InsufficientFundsException() {
		JOptionPane.showMessageDialog(null, "Your account has insufficient funds for this action!");
	}
}
