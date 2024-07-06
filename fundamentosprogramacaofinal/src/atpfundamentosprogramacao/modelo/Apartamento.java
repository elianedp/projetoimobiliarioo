package atpfundamentosprogramacao.modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private int numeroVagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (getTaxaJurosAnual() / 100) / 12;
        int numeroParcelas = getPrazoFinanciamento() * 12;
        return (getValorImovel() * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -numeroParcelas));
    }

    @Override
    public void mostrarDadosFinanciamento() {
        System.out.printf("Valor do imóvel: R$ %.2f%n", getValorImovel());
        System.out.printf("Prazo do financiamento: %d anos%n", getPrazoFinanciamento());
        System.out.printf("Taxa de juros anual: %.2f%%%n", getTaxaJurosAnual());
        System.out.printf("Número de vagas na garagem: %d%n", numeroVagasGaragem);
        System.out.printf("Número do andar: %d%n", numeroAndar);
    }

    @Override
    public String toString() {
        return String.format("Apartamento,%f,%d,%f,%f,%d,%d", getValorImovel(), getPrazoFinanciamento(), getTaxaJurosAnual(), getTaxaDesconto(), numeroVagasGaragem, numeroAndar);
    }

    public int getNumeroVagasGaragem() {
        return numeroVagasGaragem;
    }

    public void setNumeroVagasGaragem(int numeroVagasGaragem) {
        this.numeroVagasGaragem = numeroVagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    public void setNumeroAndar(int numeroAndar) {
        this.numeroAndar = numeroAndar;
    }
}
