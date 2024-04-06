package mortgagecalculator;

import java.util.Scanner;
// agora preciso fazer o tratamento de erros
public class Main {
	public static void main (String[] args) {
		final int MONTHSYEAR = 12;
		final byte PERCENT = 100;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Principal: ");
		int principal = scanner.nextInt(); // 100000
		
		System.out.print("Annual Interest Rate: ");
		float annualInterestRate = scanner.nextFloat(); // 0,06 / 12
		float monthlyInterestRate = annualInterestRate / PERCENT / MONTHSYEAR;
		
		System.out.print("Period (Years): "); //1
		int period = scanner.nextInt(); // 15 * 12
		int n = period * MONTHSYEAR; // 12
		
		double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, n)) / (Math.pow(1 + monthlyInterestRate, n) - 1);
		
		String mortgageResult = String.format("%.2f", mortgage);
		System.out.print("Mortgage: " + mortgageResult);
		scanner.close();
	}
}
