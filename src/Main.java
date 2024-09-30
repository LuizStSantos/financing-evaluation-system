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
        System.out.println("Digite o valor do 'bem' a ser adquirido: ");
        double bem = scanner.nextDouble();
        System.out.println("Digite a % da entrada ou valor da entrada: ");
        String entradaInput = scanner.next();
        double entrada;

        if (entradaInput.endsWith("%")){
            double porcentagem = Double.parseDouble(entradaInput.replace("%", "")) /100;
            entrada = bem * porcentagem;
        }else {
            entrada = Double.parseDouble(entradaInput.replace(".", "").replace(",", "."));
        }
        double sobra = bem - entrada;
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String entradaFormatada = formatador.format(entrada);
        String sobraFormatada = formatador.format(sobra);
        System.out.println("A entrada e de: " + entradaFormatada);
        System.out.println("Você aceita o valor da entrada? (sim ou não): ");
        boolean aceitaEntrada = SimNao(scanner.next());
        System.out.println("Digite a taxa de juros mensal (Ex: 1.8): ");
        String taxaJurosInput = scanner.next().replace(',', '.');
        double taxaJuros = Double.parseDouble(taxaJurosInput) / 100;
        System.out.println("Digite o número de meses para o financiamento: ");
        double meses = scanner.nextDouble();
        double saldoFinanciado = bem - entrada;
        double montante = saldoFinanciado * Math.pow(1 + taxaJuros, meses);
        NumberFormat formatado2 = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String montanteFormatado = formatado2.format(montante);
        DecimalFormat decimalFormat = new DecimalFormat("#");
        System.out.println("O valor total a ser pago, após " + decimalFormat.format(meses) + " meses, será: " + montanteFormatado);
        System.out.println("Aceita esse valor com Juros? (sim ou não): ");
        boolean aceitaJuros = SimNao(scanner.next());
        double parcelas = montante / meses;
        String parcelasFormatadas = formatador.format(parcelas).replace("R$", "$");
        boolean podeFinanciar = (temEmprego || temEmpresa) && aceitaEntrada && aceitaJuros && !temSerasa;
        if (podeFinanciar){
            System.out.println("Financiamento 'Aprovado!'");
            System.out.println("A entrada será de: " + entradaFormatada);
            System.out.println("Com parcelas de " + parcelasFormatadas + " por " + decimalFormat.format(meses) + " meses");
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
