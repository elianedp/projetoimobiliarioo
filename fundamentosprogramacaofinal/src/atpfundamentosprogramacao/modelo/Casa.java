package atpfundamentosprogramacao.modelo;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double tamanhoAreaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tamanhoAreaConstruida = tamanhoAreaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (getTaxaJurosAnual() / 100) / 12;
        int numeroParcelas = getPrazoFinanciamento() * 12;
        return (getValorImovel() * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -numeroParcelas)) + 80;
    }

    @Override
    public void mostrarDadosFinanciamento() {
        System.out.printf("Valor do imóvel: R$ %.2f%n", getValorImovel());
        System.out.printf("Prazo do financiamento: %d anos%n", getPrazoFinanciamento());
        System.out.printf("Taxa de juros anual: %.2f%%%n", getTaxaJurosAnual());
        System.out.printf("Tamanho da área construída: %.2f m²%n", tamanhoAreaConstruida);
        System.out.printf("Tamanho do terreno: %.2f m²%n", tamanhoTerreno);
    }

    @Override
    public String toString() {
        return String.format("Casa,%f,%d,%f,%f,%f,%f", getValorImovel(), getPrazoFinanciamento(), getTaxaJurosAnual(), getTaxaDesconto(), tamanhoAreaConstruida, tamanhoTerreno);
    }
}
