package com.sl;

import org.springframework.stereotype.Component;

@Component
public class BankAccount {

	private double balance = 0;

	public void deposit(double amount) {		
		balance += amount;
		System.out.println("Deposited: $" + amount);
	}

	public double withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			
			System.out.println("Withdrawn: $" + amount);
			return amount;
			
		} else {
			System.out.println("Insufficient funds");
			return 0.0d;
		}
	}

	public double getBalance() {
		return balance;
	}

}