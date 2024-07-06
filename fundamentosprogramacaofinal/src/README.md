# Sistema de Simulação de Financiamento de Imóveis

Este projeto simula financiamentos de imóveis, incluindo casas, apartamentos e terrenos, utilizando conceitos de Programação Orientada a Objetos em Java.

## Funcionalidades

- Entrada de dados do financiamento (valor do imóvel, prazo e taxa de juros)
- Cálculo do pagamento mensal e total do financiamento
- Salvamento dos dados dos financiamentos em um arquivo de texto
- Carregamento dos dados dos financiamentos a partir de um arquivo de texto
- Salvamento dos dados dos financiamentos em um arquivo serializado
- Carregamento dos dados dos financiamentos a partir de um arquivo serializado
- Tratamento de exceções específicas para o cálculo do financiamento

## Estrutura do Projeto

- `main/`
  - `Main.java`: Classe principal que executa o programa
- `modelo/`
  - `Financiamento.java`: Classe abstrata base para todos os tipos de financiamento
  - `Casa.java`: Classe para financiamento de casas
  - `Apartamento.java`: Classe para financiamento de apartamentos
  - `Terreno.java`: Classe para financiamento de terrenos
- `excecoes/`
  - `DescontoMaiorDoQueJurosException.java`: Exceção específica para tratar descontos maiores que os juros

## Como Compilar

Para compilar o projeto, navegue até o diretório raiz do projeto e execute o seguinte comando:

```bash
javac -d bin src/atpfundamentosprogramacao/main/Main.java