package ru.vorobev.lesson_04.patterns.behavioral.chain_of_responsibility;

public class Main {
	
	public static void main(String[] args) {
		
		// Let's prepare a chain like below
		//      bank->paypal->bitcoin
		//
		// First priority bank
		//      If bank can't pay then paypal
		//      If paypal can't pay then bit coin
		
		Account bank = new Bank(100);          // Bank with balance 100
		Account paypal = new Paypal(200);      // Paypal with balance 200
		Account bitcoin = new Bitcoin(300);    // Bitcoin with balance 300
		
		bank.setNext(paypal);
		paypal.setNext(bitcoin);

		// Let's try to pay using the first priority i.e. bank
		bank.pay(259);

		// Output will be
		// ==============
		// Cannot pay using Bank. Proceeding ..
		// Cannot pay using Paypal. Proceeding ..:
		// Cannot pay using Bitcoin. Proceeding ..
		// Paid 259 using Bitcoin!
	}
}
