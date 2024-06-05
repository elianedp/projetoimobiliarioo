import modelo.Financiamento;
import util.InterfaceUsuario;

// Classe principal que executa o programa
public class Main {
    public static void main(String[] args) {
        // Cria uma instância da interface de usuário para receber os dados de entrada
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // Solicita os dados do financiamento ao usuário
        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.pedirTaxaJuros();

        // Cria uma instância de Financiamento com os dados fornecidos
        Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);

        // Exibe os dados do financiamento calculados
        financiamento.mostrarDadosFinanciamento();
    }
}