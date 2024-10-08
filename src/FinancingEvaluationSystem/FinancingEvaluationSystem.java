package FinancingEvaluationSystem;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.text.DecimalFormat;

public class FinancingEvaluationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you have a job? (yes or no): ");
        boolean HaveAJob = YesNo(scanner.nextLine());
        System.out.println("Do you own a company? (yes or no): ");
        boolean EIN = YesNo(scanner.nextLine());
        System.out.println("Did your credit score drop from 670? (yes or no): ");
        boolean creditScore = YesNo(scanner.nextLine());
        System.out.println("Enter the loan amount you wish to acquire: ");
        double loan = scanner.nextDouble();
        System.out.println("Enter the down payment, either as a percentage or absolute value: ");
        String entryInput = scanner.next();
        double entry;
        if (entryInput.endsWith("%")){
            double percentage = Double.parseDouble(entryInput.replace("%", "")) /100;
            entry = loan * percentage;
        }else {
            entry = Double.parseDouble(entryInput.replace(".", "").replace(",", "."));
        }
        double surplus = loan - entry;
        NumberFormat currencyFormatter00 = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedInput00 = currencyFormatter00.format(entry);
        System.out.println("The entry is from: " + formattedInput00);
        System.out.println("Do you accept the entry fee? (yes or no): ");
        boolean acceptEntry = YesNo(scanner.next());
        System.out.println("Enter the number of months for financing: ");
        double months = scanner.nextDouble();
        System.out.println("Enter the monthly interest rate (Ex: 1.8): ");
        String interestRateInput = scanner.next().replace(',', '.');
        double interestRate = Double.parseDouble(interestRateInput) / 100;
        double installment = (surplus * Math.pow(1 + interestRate, months) * interestRate) / (Math.pow(1 + interestRate, months) - 1);
        double totalPago = installment * months;
        double financeEntry = totalPago + entry;
        NumberFormat currencyFormatter01 = NumberFormat.getCurrencyInstance(Locale.US);
        String downPaymentFinancing = currencyFormatter01.format(financeEntry);
        DecimalFormat decimalFormat = new DecimalFormat("#");
        System.out.println("The total amount paid, after " + decimalFormat.format(months) + " months will be : " + downPaymentFinancing);
        System.out.println("Do you accept this amount with interest? (yes or no): ");
        boolean acceptInterest = YesNo(scanner.next());
        double installments = totalPago / months;
        NumberFormat currencyFormatter02 = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedPlots = currencyFormatter02.format(installments);
        boolean canFinance = (HaveAJob || EIN) && acceptEntry && acceptInterest && !creditScore;
        if (canFinance){
            System.out.println("Financing 'Approved!'");
            System.out.println("Entry will be: " + formattedInput00);
            System.out.println("With installments of " + formattedPlots + " for " + decimalFormat.format(months) + " months.");
        }else {
            System.out.println("Financing 'Disapproved!' ");
            if (!HaveAJob && !EIN){
                System.out.println("Reason: You have no job or company.");
            }
            if (creditScore){
                System.out.println("Reason: Your credit score.");
            }
            if (!acceptEntry){
                System.out.println("Reason: You did not accept the entry value.");
            }
            if (!acceptInterest){
                System.out.println("Reason: You did not accept the amount with interest.");
            }
        }
        scanner.close();
    }
    public static boolean YesNo(String response){
        return response.equalsIgnoreCase("Yes");
    }
}

