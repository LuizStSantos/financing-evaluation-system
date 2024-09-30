# Sistema de Avaliação de Financiamento

Este projeto é um sistema simples de avaliação de financiamento, que solicita informações sobre emprego, empresa, nome no Serasa, valor do empréstimo, entrada, e calcula o financiamento com base na taxa de juros mensal e número de parcelas.

## Funcionalidades

- Verificação de possibilidade de financiamento com base em:
  - Situação de emprego ou posse de empresa.
  - Status do nome no Serasa.
  - Aceitação do valor da entrada e juros.
- Cálculo do valor total pago ao final do financiamento.
- Cálculo de parcelas mensais com juros compostos.

## Requisitos

- Java 8 ou superior
- Maven ou Gradle (opcional, se estiver usando gerenciamento de dependências)

## Como usar

1. **Clonar o repositório**:

```bash
git clone git@github.com:LuizStSantos/sistema-de-avaliacao-de-financiamento.git
```
2. **Compilar e rodar**:
Dentro do diretório do projeto, compile e rode o código com os seguintes comandos:

```bash
cd sistema-de-avaliacao-de-financiamento
javac Main.java
java Main
```

3. **Interagir com o sistema**:

O sistema irá solicitar as seguintes informações:
Se você possui emprego (sim ou não).
Se você possui uma empresa (sim ou não).
Se o seu nome está no Serasa (sim ou não).
O valor do empréstimo que você deseja adquirir.
O valor da entrada, em porcentagem ou valor absoluto.
A quantidade de meses para o financiamento.
A taxa de juros mensal.
Após fornecer todas essas informações, o sistema irá calcular se você é elegível para o financiamento e exibirá os valores de entrada, parcelas mensais e o total a ser pago.

Exemplo de Uso
```text
Tem emprego? (sim ou não): 
Sim
Tem empresa? (sim ou não): 
Não
Tem o nome no Serasa ? (sim ou não): 
Não
Digite o valor do empréstimo a ser adquirido: 
11.000
Digite a % da entrada ou valor da entrada: 
2.000 // Aqui pode ser valor (Ex: 20%)
A entrada e de: R$ 2.000,00
Você aceita o valor da entrada? (sim ou não): 
sim
Digite o número de meses para o financiamento: 
24
Digite a taxa de juros mensal (Ex: 1.8): 
5.8
O valor total pago, após 24 meses será de : R$ 18.893,90
Aceita esse valor com Juros? (sim ou não): 
Sim
Financiamento 'Aprovado!'
A entrada será de: R$ 2.000,00
Com parcelas de R$ 703,91 por 24 meses.
```

## Créditos
- Autor: Luiz Stormorwski dos Santos
- Data: 30 de Setembro de 2024
- GitHub: LuizStSantos

## Licença

Este projeto está licenciado sob a [MIT License](https://opensource.org/license/mit).
