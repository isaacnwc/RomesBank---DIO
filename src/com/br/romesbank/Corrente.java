package com.br.romesbank;

import java.util.Scanner;

public class Corrente extends ContaBancaria {

	private double limiteChequeEspecial;

	Corrente(int numeroConta, double saldo, String nome, String cpf, String endereco, Scanner scanner,
			double limiteChequeEspecial) {
		super(numeroConta, saldo, nome, cpf, endereco, scanner);
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	@Override
	public void sacar(double valor) {

		System.out.println("Valor para sacar: ");
		valor = scanner.nextDouble();

		if (valor <= 0) {
			System.out.println("Valor inválido para saque!");
			return;
		}

		if (getSaldo() + limiteChequeEspecial >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.printf("Saque de R$%.2f \n", valor);

			if (getSaldo() < 0) {
				System.out.println("Você usará o cheque especial");
				System.out.printf("Limite disponível: R$%.2f%n", limiteChequeEspecial + saldo);

			} else {
				System.out.println("Limite do cheque especial excedido");
				System.out.printf("Saldo: R$.2f | Limite: R$.2f\n", saldo, limiteChequeEspecial);
			}

		}
	}

@Override
public boolean menu() {

	int opcao;
	do {
		System.out.print("\n---------------CORRENTE-----------------");
		this.mostrarDados();
		System.out.println("\n\n1. Ver Saldo e limite");
		System.out.println("2. Sacar");
		System.out.println("3. Depositar");
		System.out.println("4. Retornar");
		System.out.println("Escolha a operação: ");

		opcao = scanner.nextInt();
		scanner.nextLine();

		switch (opcao) {
		case 1 -> {
			this.mostrarSaldo();
		}

		case 2 -> {
			this.sacar(0);

		}
		case 3 -> {
			this.depositar(0);
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


@Override
public void mostrarSaldo() {
	 super.mostrarSaldo();
     System.out.printf("Limite cheque especial: R$%.2f\n", limiteChequeEspecial);
     System.out.printf("Disponível para saque: R$%.2f\n", 
                     getSaldo() + limiteChequeEspecial);
}
}