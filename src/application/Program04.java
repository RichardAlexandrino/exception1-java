/* Write a program to read data from a bank account and then
 * perform a withdraw from this bank account, showing the new
 * balance. A withdraw cannot occur or if there is no balance
 * in the account, or if the amount of the withdraw is greater
 * than the limit of account withdraw. */

package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account04;
import model.exceptions.DomainException03;

public class Program04 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		Account04 account = new Account04(number, holder, balance, withdrawLimit);
		
		System.out.println();
		
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		
		try {
			account.withdraw(amount);
			System.out.println(account);
		}
		catch (DomainException03 e){
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
		
	}

}
