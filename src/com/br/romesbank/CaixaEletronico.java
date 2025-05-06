package com.br.romesbank;

import java.util.Scanner;

public class CaixaEletronico {

	public static void main(String[] args) {

		int opcaoConta, opcaoOperacao;
		boolean retornar;

		Scanner scanner = new Scanner(System.in);

		Poupanca conta1 = new Poupanca(2501, 10000, "Romes Miyazaki", "25020293", "Rua dos bobos, 0", scanner, 0.007);
		Corrente conta2 = new Corrente(2601, 5000, "Romes Miyazaki", "25020293", "Rua dos bobos,0", scanner, 2000);
		Investimentos conta3 = new Investimentos(2701, 3000, "Romes Miyazaki", "25020293", "Rua dos bobos,0", scanner,
				0.01);

		do {

			System.out.println("----------ROMES BANK----------");
			System.out.println("Seja bem vindo ao Romes Bank");

			System.out.println("------------------------------");

			System.out.println("Deseja entrar em qual conta? \n Digite a opção desejada: ");
			System.out.println("1. Conta Poupança");
			System.out.println("2. Conta Corrente");
			System.out.println("3. Conta de investimento");
			System.out.println("4. Sair");
			System.out.println("---------------------------");

			opcaoConta = scanner.nextInt();
			if (opcaoConta >= 1 && opcaoConta <= 3) {
				retornar = false; // enquanto
				do {
					switch (opcaoConta) {
					case 1 -> {
						conta1.menu();
					}
					case 2 -> {
						conta2.menu();
					}
					case 3 -> {
						conta3.menu();
					}
					case 4 -> {
						System.out.println("Obrigado por usar nosso banco! Desconectando...");
					}
					}

				} while (retornar = false);

			}
		} while (opcaoConta != 4);
	}
}
