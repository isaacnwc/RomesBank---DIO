package com.br.romesbank;

import java.util.Scanner;

public class Poupanca extends ContaBancaria {

	private double taxaJuros;

	public Poupanca(int numeroConta, double saldo, String nome, String cpf, String endereco, Scanner scanner,
			double taxaJuros) {

		super(numeroConta, saldo, nome, cpf, endereco, scanner);
		this.taxaJuros = taxaJuros;

	}

	@Override
	public boolean menu() {

		int opcao;
		do {
			System.out.print("---------------POUPANÇA-----------------");
			this.mostrarDados();
			System.out.println("\n\n1. Ver Saldo");
			System.out.println("2. Sacar");
			System.out.println("3. Depositar");
			System.out.println("4. Render Juros");
			System.out.println("5. Retornar");
			System.out.println("Escolha a operação: ");

			opcao = scanner.nextInt();

			switch (opcao) {
			case 1 -> {
				super.mostrarSaldo();
			}

			case 2 -> {
				super.sacar(0);

			}
			case 3 -> {
				super.depositar(0);
			}
			case 4 -> {
				this.renderJuros();
			}

			case 5 -> {
				System.out.println("Retornando...");
				return true;
			}
			}
		} while (opcao != 5);
		return false;
	}

	public void renderJuros() {

		double juros;
		juros = getSaldo() * taxaJuros;
		depositar(juros);
		System.out.printf("Juros de R$%.2f creditados na conta\n", juros);
	}

	@Override
	public void sacar(double valor) {
		if (valor <= 0) {
			System.out.println("Valor inválido para saque");
			return;

		}
		if (getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);

		} else {
			System.out.println("saldo insuficiente");
		}
	}

	public double getTaxaJuros() {
		return taxaJuros;
	}
}
