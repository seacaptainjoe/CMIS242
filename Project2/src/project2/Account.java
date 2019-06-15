package project2;

import javax.swing.JOptionPane;

// Account class declaration
public class Account {

	// Double type variable to be used by all account subclass instances.
	private double accountBalance;
	
	// Default Account class constructor
	public Account() {
	}
	
	// Sets account balance
	public void setBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	// Gets account balance
	public double getBalance() {
		return this.accountBalance;
	}
	
	
	public class checkingAccount extends Account {
		public checkingAccount() {
			
		}
		
	}
	
	public class savingsAccount extends Account {
		public savingsAccount() {
			
		}
	}
	
	public void withdraw(double withdrawalAmount) throws InsufficientFundsException{
		if (this.accountBalance < withdrawalAmount) {
			throw new InsufficientFundsException();
		}
		
		this.accountBalance = this.accountBalance - withdrawalAmount;
	}
	
	public void deposit(double depositAmount) {
		this.accountBalance = this.accountBalance + depositAmount;
	}
	
	public void transfer(double transferAmount) {
		this.accountBalance = this.accountBalance + transferAmount;
	}
	
	public void transferFrom(double transferAmount) throws InsufficientFundsException {
		if (transferAmount > this.accountBalance) {
			throw new InsufficientFundsException();
		}
		this.accountBalance = this.accountBalance - transferAmount;
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		Project2ATMgui program = new Project2ATMgui();
		program.display();

	}

}
