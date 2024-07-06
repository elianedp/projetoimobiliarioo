package atpfundamentosprogramacao.modelo;

import java.io.Serializable;
import atpfundamentosprogramacao.excecoes.DescontoMaiorDoQueJurosException;

public abstract class Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;
    private double taxaDesconto;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public double getTaxaDesconto() {
        return taxaDesconto;
    }

    public void setTaxaDesconto(double taxaDesconto) throws DescontoMaiorDoQueJurosException {
        if (taxaDesconto > taxaJurosAnual) {
            throw new DescontoMaiorDoQueJurosException("O valor do desconto não pode ser maior que a taxa de juros.");
        }
        this.taxaDesconto = taxaDesconto;
    }

    public abstract double calcularPagamentoMensal();

    public abstract void mostrarDadosFinanciamento();

    @Override
    public String toString() {
        return String.format("%f,%d,%f,%f", valorImovel, prazoFinanciamento, taxaJurosAnual, taxaDesconto);
    }
}
