package com.br.romesbank;

import java.util.Scanner;

public class Investimentos extends ContaBancaria {

	private double taxaRendimento; // mensal

	public Investimentos(int numeroConta, double saldo, String nome, String cpf, String endereco, Scanner scanner,
			double taxaRendimento) {
		super(numeroConta, saldo, nome, cpf, endereco, scanner);
		this.taxaRendimento = taxaRendimento;

	}

	public double simularRendimentos() {
		int meses;
		System.out.printf("Taxa de %.2f% ao mês", taxaRendimento);
		System.out.println("\nDeseja simular quantos meses?");
		meses = scanner.nextInt();
		scanner.nextLine();
		if (meses <= 0) {
			System.out.println("Não é possível simular esse período");
			
		}

		double saldoSimulado = getSaldo() * Math.pow(1 + taxaRendimento, meses); // formula juros ocmpostos
		System.out.printf("Simulação considerando %d meses\n", meses);
		System.out.printf("Saldo futuro: %.2f\n", saldoSimulado);
		System.out.printf("Rendimento de R$%.2f", saldoSimulado - getSaldo());
		
		return saldoSimulado;

		

	}
	
	
	public double aplicarRendimentos() {
	
	    System.out.print("Informe quantos meses deseja aplicar: ");
	    int meses = scanner.nextInt();
	    scanner.nextLine(); 
	    
	
	    if (meses <= 0) {
	        System.out.println("Período inválido! Deve ser maior que zero.");
	        return getSaldo();
	    }
	    

	    double saldoAtual = getSaldo();
	    double saldoComRendimento = saldoAtual * Math.pow(1 + taxaRendimento, meses);
	    double rendimento = saldoComRendimento - saldoAtual;
	    
	    setSaldo(saldoComRendimento);
	    
	    System.out.printf("\nTaxa aplicada: %.2f%% ao mês%n", taxaRendimento * 100);
	    System.out.printf("Período: %d meses%n", meses);
	    System.out.printf("Rendimento aplicado: R$%.2f \n", rendimento);
	    System.out.printf("Novo saldo: R$%.2f \n", getSaldo());
	    
	    return getSaldo();
	}
	
	@Override
	public boolean menu() {
		
		int opcao;
		do {
			System.out.print("\n---------------INVESTIMENTOS-----------------");
			this.mostrarDados();
			System.out.println("\n\n1. Ver saldo");
			System.out.println("2. Sacar");
			System.out.println("3. Depositar");
			System.out.println("4. Simular rendimentos");
			System.out.println("5. Aplicar rendimentos");
			System.out.println("6. Retornar");
			System.out.println("Escolha a operação: ");

			opcao = scanner.nextInt();

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
				this.simularRendimentos();
			}
			case 5->{
				this.aplicarRendimentos();
			}
			case 6 -> {
				this.retornando();
				return true;
			}
			
			default -> System.out.println("Opção inválida");
			}
		} while (opcao != 6);
		return false;
		
		
	}

	
 @Override
    public void mostrarSaldo() {
       super.mostrarSaldo();
        System.out.printf("Taxa de rendimento: %.2f%% ao mês%n", taxaRendimento * 100);
        
    }	public double getTaxaRendimento() {
		return taxaRendimento;
	}

}
