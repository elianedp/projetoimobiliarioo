package atpfundamentosprogramacao.modelo;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (getTaxaJurosAnual() / 100) / 12;
        int numeroParcelas = getPrazoFinanciamento() * 12;
        double pagamentoMensal = (getValorImovel() * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -numeroParcelas));
        return pagamentoMensal * 1.02; // Acréscimo de 2%
    }

    @Override
    public void mostrarDadosFinanciamento() {
        System.out.printf("Valor do imóvel: R$ %.2f%n", getValorImovel());
        System.out.printf("Prazo do financiamento: %d anos%n", getPrazoFinanciamento());
        System.out.printf("Taxa de juros anual: %.2f%%%n", getTaxaJurosAnual());
        System.out.printf("Tipo de zona: %s%n", tipoZona);
    }

    @Override
    public String toString() {
        return String.format("Terreno,%f,%d,%f,%f,%s", getValorImovel(), getPrazoFinanciamento(), getTaxaJurosAnual(), getTaxaDesconto(), tipoZona);
    }

    public String getTipoZona() {
        return tipoZona;
    }

    public void setTipoZona(String tipoZona) {
        this.tipoZona = tipoZona;
    }
}
