package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private static Double withdrawLimit = 300.0;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(Double amount) {
		this.balance += amount;
	}

	public void withdraw(Double amount) {
		if (amount > withdrawLimit) {
			throw new DomainException("Limite de saque maior do que o permitido.");
		}

		if (amount > getBalance()) {
			throw new DomainException("Saldo insuficiente");
		}
		this.balance -= amount;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nTitular: " + holder);
		sb.append("\nNúmero da conta: " + number);
		sb.append("\nSaldo: R$" + String.format("%.2f", getBalance()));
		return sb.toString();
	}

}
