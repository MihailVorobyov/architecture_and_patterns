package ru.vorobev.lesson_04.patterns.behavioral.chain_of_responsibility;

public abstract class Account {
	
	private static final String EOL = "\n";
	private Account successor;
	protected float balance;
	
	public void setNext(Account account) {
		this.successor = account;
	}
	
	public void pay(float amountToPay) {
		
		if (canPay(amountToPay)) {
			System.out.printf("Paid %s using %s" + EOL, amountToPay, this.getClass().getSimpleName());
		} else {
			System.out.printf("Cannot pay using %s. Proceeding .." + EOL, this.getClass().getSimpleName());
			if (successor == null) {
				throw new RuntimeException("None of the accounts have enough balance");
			}
			successor.pay(amountToPay);
		}
	}
	
	public boolean canPay(float amount) {
		return this.balance >= amount;
	}
}
