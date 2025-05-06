package com.br.romesbank;

import java.util.Scanner;

public class ContaBancaria {

	private int numeroConta;
	protected double saldo;
	private String nome;
	private String cpf;
	private String endereco;
	protected Scanner scanner;

	ContaBancaria(int numeroConta, double saldo, String nome, String cpf, String endereco, Scanner scanner) {
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.scanner = scanner;
	}

	public void mostrarSaldo() {
		System.out.printf("\nSaldo atual: R$%.2f\n", saldo);
	}

	public void depositar(double valor) {

		System.out.println("Digite a quantia que deseja depositar: ");
		valor = scanner.nextDouble();
		scanner.nextLine();
		if (valor > 0) {
			System.out.printf("Voce depositou %.2f\n", valor);
			saldo += valor;
		} else {
			System.out.println("Não é possível depositar esse valor");
		}
	}

	public void sacar(double valor) {

		System.out.println("Digite a quantia para o saque:");
		valor = scanner.nextDouble();
		scanner.nextLine();
		if (valor > 0) {
			if (saldo >= valor) {
				saldo -= valor;
				System.out.printf("Você sacou R$ %.2f e seu saldo agora é de R$ %.2f", valor, saldo);
			} else {
				System.out.println("Seu saldo é menor que a quantia que deseja sacar");
			}
		} else {
			System.out.println("Não é possível sacar essa quantia");
		}
	}

	public void mostrarDados() {
		System.out.println("\n---Cliente---");

		System.out.print("| " + numeroConta);
		System.out.print(" | " + nome);
		System.out.print("| " + cpf);
		System.out.print("| " + endereco);
	}

	public boolean menu() {

		int opcao;
		do {
			System.out.print("\n---------------MENU-----------------");
			this.mostrarDados();
			System.out.println("\n\n1. Ver Saldo");
			System.out.println("2. Sacar");
			System.out.println("3. Depositar");
			System.out.println("4. Retornar");
			System.out.println("Escolha a operação: ");

			opcao = scanner.nextInt();

			switch (opcao) {
			case 1 -> {
				this.mostrarSaldo();
			}

			case 2 -> {
				sacar(0);

			}
			case 3 -> {
				depositar(0);
			}

			case 4 -> {
				System.out.println("Retornando...");
				return true;
			}
			default -> System.out.println("Opção inválida");
			}
		} while (opcao != 4);
		return false;
	}

	
	public void retornando() {
		System.out.println("Retornando...");
		
	}
	
	
	
	public void scannerClose() {
		if (scanner != null) {
			scanner.close();
		}
	}

	public int getNumeroConta() {
		return this.numeroConta;
	}

	public double getSaldo() {
		return this.saldo;
	}

	protected void setSaldo(double novoSaldo) {
		this.saldo = novoSaldo;
	}

	public String getNome() {

		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getEndereco() {
		return this.endereco;
	}

}
