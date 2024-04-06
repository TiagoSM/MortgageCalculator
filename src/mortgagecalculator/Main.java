package mortgagecalculator;

import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		int principal, period, n;
		float annualInterestRate, monthlyInterestRate;
		final int MONTHSYEAR = 12;
		final byte PERCENT = 100;
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.print("Principal: ");
			principal = scanner.nextInt(); // 100000
			if (principal < 1000 || principal > 1000000) {
				System.out.println("Enter a number between $1000 and $1000000!");
			}
		}while(principal < 1000 || principal > 1000000);
		
		do {
			System.out.print("Annual Interest Rate: ");
			annualInterestRate = scanner.nextFloat(); // 0,06 / 12
			monthlyInterestRate = annualInterestRate / PERCENT / MONTHSYEAR;
			if (monthlyInterestRate <= 0 || monthlyInterestRate > 30) {
				System.out.println("Enter a number greater than 0 and less or equal to 30!");
			}
		} while(monthlyInterestRate <= 0 || monthlyInterestRate > 30);
		
		
		do {
			System.out.print("Period (Years): "); //1
			period = scanner.nextInt(); // 15 * 12
			n = period * MONTHSYEAR; // 12]
			if (period < 1 || period > 30) {
				System.out.println("Enter a number greater than 1 and less or equal to 30!");
			}
		} while(period < 1 || period > 30);
		
		double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, n)) / (Math.pow(1 + monthlyInterestRate, n) - 1);
		
		String mortgageResult = String.format("%.2f", mortgage);
		System.out.print("Mortgage: " + mortgageResult);
		scanner.close();
	}
}
