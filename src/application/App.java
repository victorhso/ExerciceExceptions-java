package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Titular da conta: ");
			String name = sc.nextLine();
			System.out.print("Número da conta: ");
			int number = sc.nextInt();
			System.out.print("Saldo inicial: R$");
			double balance = sc.nextDouble();

			Account account = new Account(number, name, balance);

			System.out.print("Depositar? s/n: ");
			char c = sc.next().charAt(0);

			if (c == 's') {
				System.out.print("Valor a se depositar: R$");
				double amount = sc.nextDouble();
				account.deposit(amount);
				System.out.println("Novo saldo: R$" + String.format("%.2f", account.getBalance()));
			}
			
			System.out.print("Deseja realizar um saque? s/n: ");
			c = sc.next().charAt(0);
			System.out.println();

			if (c == 's') {
				System.out.print("Limite de saque: R$300,00");

				System.out.print("\nValor a se sacar: R$");
				double withdraw = sc.nextDouble();
				account.withdraw(withdraw);
				System.out.println("Novo saldo: R$" + String.format("%.2f", account.getBalance()));
			}
		} 
		catch (InputMismatchException e) {
			System.out.println("Número inválido!");
		} 
		catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		sc.close();
	}
}
