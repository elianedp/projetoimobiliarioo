package atpfundamentosprogramacao.main;

import atpfundamentosprogramacao.modelo.*;
import atpfundamentosprogramacao.excecoes.DescontoMaiorDoQueJurosException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Financiamento> financiamentos = new ArrayList<>();
        String fileName = "financiamentos.txt";
        String serializedFileName = "financiamentos.ser";

        try {
            // Adiciona um financiamento de casa
            System.out.print("Digite o valor do imóvel: ");
            double valorImovel = Double.parseDouble(scanner.nextLine().replace(",", "."));

            System.out.print("Digite o prazo do financiamento (em anos): ");
            int prazoFinanciamento = Integer.parseInt(scanner.nextLine());

            System.out.print("Digite a taxa de juros anual: ");
            double taxaJurosAnual = Double.parseDouble(scanner.nextLine().replace(",", "."));

            Casa casa = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, 100, 200);
            casa.setTaxaDesconto(0.5);
            financiamentos.add(casa);

            // Adiciona um financiamento de apartamento
            System.out.print("Digite o valor do apartamento: ");
            double valorApartamento = Double.parseDouble(scanner.nextLine().replace(",", "."));

            System.out.print("Digite o prazo do financiamento (em anos): ");
            int prazoApartamento = Integer.parseInt(scanner.nextLine());

            System.out.print("Digite a taxa de juros anual: ");
            double taxaApartamento = Double.parseDouble(scanner.nextLine().replace(",", "."));

            System.out.print("Digite o número de vagas na garagem: ");
            int vagasGaragem = Integer.parseInt(scanner.nextLine());

            System.out.print("Digite o número do andar: ");
            int numeroAndar = Integer.parseInt(scanner.nextLine());

            Apartamento apartamento = new Apartamento(valorApartamento, prazoApartamento, taxaApartamento, vagasGaragem, numeroAndar);
            financiamentos.add(apartamento);

            // Adiciona um financiamento de terreno
            System.out.print("Digite o valor do terreno: ");
            double valorTerreno = Double.parseDouble(scanner.nextLine().replace(",", "."));

            System.out.print("Digite o prazo do financiamento (em anos): ");
            int prazoTerreno = Integer.parseInt(scanner.nextLine());

            System.out.print("Digite a taxa de juros anual: ");
            double taxaTerreno = Double.parseDouble(scanner.nextLine().replace(",", "."));

            System.out.print("Digite o tipo de zona: ");
            String tipoZona = scanner.nextLine();

            Terreno terreno = new Terreno(valorTerreno, prazoTerreno, taxaTerreno, tipoZona);
            financiamentos.add(terreno);

            // Salvar dados em um arquivo de texto
            salvarDadosTexto(financiamentos, fileName);

            // Carregar dados do arquivo de texto
            List<Financiamento> financiamentosCarregados = carregarDadosTexto(fileName);
            System.out.println("Financiamentos carregados do arquivo de texto:");
            for (Financiamento f : financiamentosCarregados) {
                f.mostrarDadosFinanciamento();
            }

            // Salvar dados serializados
            salvarDadosSerializados(financiamentos, serializedFileName);

            // Carregar dados serializados
            List<Financiamento> financiamentosSerializados = carregarDadosSerializados(serializedFileName);
            System.out.println("\nFinanciamentos carregados do arquivo serializado:");
            for (Financiamento f : financiamentosSerializados) {
                f.mostrarDadosFinanciamento();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void salvarDadosTexto(List<Financiamento> financiamentos, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Financiamento f : financiamentos) {
                writer.write(f.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Financiamento> carregarDadosTexto(String fileName) {
        List<Financiamento> financiamentos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String tipo = parts[0];
                double valorImovel = Double.parseDouble(parts[1]);
                int prazoFinanciamento = Integer.parseInt(parts[2]);
                double taxaJurosAnual = Double.parseDouble(parts[3]);
                double taxaDesconto = Double.parseDouble(parts[4]);

                switch (tipo) {
                    case "Casa":
                        double tamanhoAreaConstruida = Double.parseDouble(parts[5]);
                        double tamanhoTerreno = Double.parseDouble(parts[6]);
                        Casa casa = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, tamanhoAreaConstruida, tamanhoTerreno);
                        casa.setTaxaDesconto(taxaDesconto);
                        financiamentos.add(casa);
                        break;
                    case "Apartamento":
                        int numeroVagasGaragem = Integer.parseInt(parts[5]);
                        int numeroAndar = Integer.parseInt(parts[6]);
                        Apartamento apartamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, numeroVagasGaragem, numeroAndar);
                        financiamentos.add(apartamento);
                        break;
                    case "Terreno":
                        String tipoZona = parts[5];
                        Terreno terreno = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, tipoZona);
                        financiamentos.add(terreno);
                        break;
                }
            }
        } catch (IOException | NumberFormatException | DescontoMaiorDoQueJurosException e) {
            e.printStackTrace();
        }
        return financiamentos;
    }

    private static void salvarDadosSerializados(List<Financiamento> financiamentos, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(financiamentos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Financiamento> carregarDadosSerializados(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Financiamento>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
