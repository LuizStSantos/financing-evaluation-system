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
Copiar código
Tem emprego? (sim ou não):
sim
Tem empresa? (sim ou não):
não
Tem o nome no Serasa ? (sim ou não):
não
Digite o valor do empréstimo a ser adquirido:
12.000
Digite a % da entrada ou valor da entrada:
10%
A entrada é de: R$ 1.200,00
Você aceita o valor da entrada? (sim ou não):
sim
Digite o número de meses para o financiamento:
12
Digite a taxa de juros mensal (Ex: 1.8):
10
O valor total pago, após 12 meses, será de: R$ 14.596,80
Aceita esse valor com Juros? (sim ou não):
sim
Financiamento 'Aprovado!'
A entrada será de: R$ 1.200,00
Com parcelas de R$ 1.100,00 por 12 meses.
```

4. **Créditos**
- Autor: Luiz St. Santos
- Data: 30 de Setembro de 2024
- GitHub: LuizStSantos

5. **Licença**

Este projeto está licenciado sob a [MIT License](https://opensource.org/license/mit).

Esse `README.md` fornece uma boa documentação do seu projeto, ajudando outros desenvolvedores ou colaboradores a entender e utilizar o sistema.
