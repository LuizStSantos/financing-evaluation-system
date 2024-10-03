/*
* Author: Luiz Stormorwski dos Santos
 * Description: System for evaluating financing, considering input,
 * interest, number of installments, job, company and status on Serasa.
 * GitHub: https://github.com/LuizStSantos/sistema-de-avaliacao-de-financiamento
 */

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you have a job? (yes or no): ");
        boolean temEmprego = SimNao(scanner.nextLine());
        System.out.println("Do you own a company? (yes or no): ");
        boolean temEmpresa = SimNao(scanner.nextLine());
        System.out.println("Is your name with Serasa? (yes or no): ");
        boolean temSerasa = SimNao(scanner.nextLine());
        System.out.println("Enter the loan amount you wish to acquire: ");
        double emprestimo = scanner.nextDouble();
        System.out.println("Enter the down payment, either as a percentage or absolute value: ");
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
        System.out.println("Do you accept the entry fee? (yes or no): ");
        boolean aceitaEntrada = SimNao(scanner.next());
        System.out.println("Enter the number of months for financing: ");
        double meses = scanner.nextDouble();
        System.out.println("Enter the monthly interest rate (Ex: 1.8): ");
        String taxaJurosInput = scanner.next().replace(',', '.');
        double taxaJuros = Double.parseDouble(taxaJurosInput) / 100;
        double parcela = (sobra * Math.pow(1 + taxaJuros, meses) * taxaJuros) / (Math.pow(1 + taxaJuros, meses) - 1);
        double totalPago = parcela * meses;
        double entradaFinanciamento = totalPago + entrada;
        NumberFormat formatado2 = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String totalEntradaFinanciamento = formatado2.format(entradaFinanciamento);
        DecimalFormat decimalFormat = new DecimalFormat("#");
        System.out.println("The total amount paid, after " + decimalFormat.format(meses) + " months will be : " + totalEntradaFinanciamento );
        System.out.println("Do you accept this amount with interest? (yes or no): ");
        boolean aceitaJuros = SimNao(scanner.next());
        double parcelas = totalPago / meses;
        NumberFormat formatador3 = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String parcelasFormatadas = formatador.format(parcelas);
        boolean podeFinanciar = (temEmprego || temEmpresa) && aceitaEntrada && aceitaJuros && !temSerasa;
        if (podeFinanciar){
            System.out.println("Financing 'Approved!'");
            System.out.println("Entry will be: " + entradaFormatada);
            System.out.println("With installments of " + parcelasFormatadas + " for " + decimalFormat.format(meses) + " months.");
        }else {
            System.out.println("Financing 'Disapproved!' ");
            if (!temEmprego && !temEmpresa){
                System.out.println("Reason: You have no job or company.");
            }
            if (temSerasa){
                System.out.println("Reason: Your name is on Serasa.");
            }
            if (!aceitaEntrada){
                System.out.println("Reason: You did not accept the entry value.");
            }
            if (!aceitaJuros){
                System.out.println("Reason: You did not accept the amount with interest.");
            }
        }
        scanner.close();
    }
    public static boolean SimNao(String resposta){
        return resposta.equalsIgnoreCase("Sim");
    }
}
