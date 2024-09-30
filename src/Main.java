/*
 * Autor: Luiz Stormorwski dos Santos
 * Data: 30 de Setembro de 2024
 * Descrição: Sistema para avaliação de financiamento, considerando entrada,
 *            juros, número de parcelas, emprego, empresa e status no Serasa.
 * GitHub: https://github.com/LuizStSantos/sistema-de-avaliacao-de-financiamento
 */

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tem emprego? (sim ou não): ");
        boolean temEmprego = SimNao(scanner.nextLine());
        System.out.println("Tem empresa? (sim ou não): ");
        boolean temEmpresa = SimNao(scanner.nextLine());
        System.out.println("Tem o nome no Serasa ? (sim ou não): ");
        boolean temSerasa = SimNao(scanner.nextLine());
        System.out.println("Digite o valor do empréstimo a ser adquirido: ");
        double emprestimo = scanner.nextDouble();
        System.out.println("Digite a % da entrada ou valor da entrada: ");
        String entradaInput = scanner.next();
        double entrada;
        if (entradaInput.endsWith("%")){
            double porcentagem = Double.parseDouble(entradaInput.replace("%", "")) /100;
            entrada = emprestimo * porcentagem;
        }else {
            entrada = Double.parseDouble(entradaInput.replace(".", "").replace(",", "."));
        }
        double sobra = emprestimo - entrada;
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String entradaFormatada = formatador.format(entrada);
        System.out.println("A entrada e de: " + entradaFormatada);
        System.out.println("Você aceita o valor da entrada? (sim ou não): ");
        boolean aceitaEntrada = SimNao(scanner.next());
        System.out.println("Digite o número de meses para o financiamento: ");
        double meses = scanner.nextDouble();
        System.out.println("Digite a taxa de juros mensal (Ex: 1.8): ");
        String taxaJurosInput = scanner.next().replace(',', '.');
        double taxaJuros = Double.parseDouble(taxaJurosInput) / 100;
        double parcela = (sobra * Math.pow(1 + taxaJuros, meses) * taxaJuros) / (Math.pow(1 + taxaJuros, meses) - 1);
        double totalPago = parcela * meses;
        double entradaFinanciamento = totalPago + entrada;
        NumberFormat formatado2 = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String totalEntradaFinanciamento = formatado2.format(entradaFinanciamento);
        DecimalFormat decimalFormat = new DecimalFormat("#");
        System.out.println("O valor total pago, após " + decimalFormat.format(meses) + " meses será de : " + totalEntradaFinanciamento );
        System.out.println("Aceita esse valor com Juros? (sim ou não): ");
        boolean aceitaJuros = SimNao(scanner.next());
        double parcelas = totalPago / meses;
        NumberFormat formatador3 = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String parcelasFormatadas = formatador.format(parcelas);
        boolean podeFinanciar = (temEmprego || temEmpresa) && aceitaEntrada && aceitaJuros && !temSerasa;
        if (podeFinanciar){
            System.out.println("Financiamento 'Aprovado!'");
            System.out.println("A entrada será de: " + entradaFormatada);
            System.out.println("Com parcelas de " + parcelasFormatadas + " por " + decimalFormat.format(meses) + " meses.");
        }else {
            System.out.println("Financiamento 'Reprovado!' ");
            if (!temEmprego && !temEmpresa){
                System.out.println("Motivo: Você não tem emprego nem empresa.");
            }
            if (temSerasa){
                System.out.println("Motivo: Seu nome está no Serasa.");
            }
            if (!aceitaEntrada){
                System.out.println("Motivo: Você não aceitou o valor da entrada.");
            }
            if (!aceitaJuros){
                System.out.println("Motivo: Você não aceitou o valor com juros.");
            }
        }
        scanner.close();
    }
    public static boolean SimNao(String resposta){
        return resposta.equalsIgnoreCase("Sim");
    }
}
