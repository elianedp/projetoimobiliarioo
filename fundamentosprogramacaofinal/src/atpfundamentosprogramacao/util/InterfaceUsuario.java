package atpfundamentosprogramacao.util;

import java.util.Scanner;

public class InterfaceUsuario {
    public static double pedirValorImovel(Scanner scanner) {
        double valorImovel;
        do {
            System.out.print("Digite o valor do imóvel: ");
            valorImovel = Double.parseDouble(scanner.nextLine().replace(",", "."));
            if (valorImovel <= 0) {
                System.out.println("Valor do imóvel deve ser positivo.");
            }
        } while (valorImovel <= 0);
        return valorImovel;
    }

    public static int pedirPrazoFinanciamento(Scanner scanner) {
        int prazoFinanciamento;
        do {
            System.out.print("Digite o prazo do financiamento (em anos): ");
            prazoFinanciamento = Integer.parseInt(scanner.nextLine());
            if (prazoFinanciamento <= 0) {
                System.out.println("Prazo de financiamento deve ser positivo.");
            }
        } while (prazoFinanciamento <= 0);
        return prazoFinanciamento;
    }

    public static double pedirTaxaJurosAnual(Scanner scanner) {
        double taxaJurosAnual;
        do {
            System.out.print("Digite a taxa de juros anual: ");
            taxaJurosAnual = Double.parseDouble(scanner.nextLine().replace(",", "."));
            if (taxaJurosAnual <= 0) {
                System.out.println("Taxa de juros deve ser positiva.");
            }
        } while (taxaJurosAnual <= 0);
        return taxaJurosAnual;
    }
}

