package FinancingEvaluationSystem;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.text.DecimalFormat;

public class FinancingEvaluationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Check if you have a job
        boolean hasJob = false;
        boolean validInput = false;

        while (!validInput){
            System.out.println("Do you have a job? (yes or no): ");
            String response = scanner.nextLine().trim();

            if (response.equalsIgnoreCase("yes")){
                hasJob = true;
                validInput = true;
            }
            else if (response.equalsIgnoreCase("no")){
                validInput = true;
            }
            else {
                System.out.println("Invalid input. Please answer with 'yes' or 'no'.");
            }
        }
        // Check if you have a company
        validInput = false;
        boolean EIN = false;

        while (!validInput){
            System.out.println("Do you own a company? (yes or no): ");
            String response = scanner.nextLine().trim();

            if (response.equalsIgnoreCase("yes")){
                EIN = true;
                validInput = true;
            }
            else if (response.equalsIgnoreCase("no")){
                validInput = true;
            }
            else {
                System.out.println("Invalid input. Please answer with 'yes' or 'no'.");
            }
        }
        // Check credit score
        double creditScore = 0;
        boolean validCreditScore = false;

        while (!validCreditScore) {
            System.out.println("Enter your credit score: ");
            try {
                creditScore = Double.parseDouble(scanner.nextLine().trim());
                if (creditScore < 0) {
                    throw new IllegalArgumentException("Credit score cannot be negative.");
                }
                validCreditScore = true;
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid credit score (a number).");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Value loan
        double loan = 0;
        boolean validLoan = false;

        while (!validLoan){
            System.out.println("Enter the loan amount you wish to acquire: ");
            try {
                loan = Double.parseDouble(scanner.nextLine().trim());
                if (loan <= 0){
                    throw new IllegalArgumentException("Loan amount must be greater than zero.");
                }
                validLoan = true;
            }
            catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid loan amount (a number).");
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        // Entry $
        double entry = 0;
        boolean validEntry = false;

        while (!validEntry) {
            System.out.println("Enter the down payment, either as a percentage or absolute value: ");
            String entryInput = scanner.nextLine().trim();

            try {
                if (entryInput.endsWith("%")) {
                    double percentage = Double.parseDouble(entryInput.replace("%", "").trim());
                    if (percentage < 0 || percentage > 100) {
                        throw new IllegalArgumentException("Percentage must be between 0 and 100.");
                    }
                    entry = loan * (percentage / 100);
                } else {
                    entry = Double.parseDouble(entryInput.replace(".", "").replace(",", "."));
                    if (entry < 0) {
                        throw new IllegalArgumentException("Down payment must be a positive value.");
                    }
                }
                if (entry > loan) {
                    throw new IllegalArgumentException("Down payment cannot exceed the loan amount.");
                }
                validEntry = true;
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid down payment (a number or percentage).");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        double surplus = loan - entry;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedEntry = currencyFormatter.format(entry);
        System.out.println("The entry is from: " + formattedEntry);

        // Check if you accept entry
        validInput = false;
        boolean acceptEntry = false;

        while (!validInput){
            System.out.println("Do you accept the entry fee? (yes or no): ");
            String response = scanner.nextLine().trim();

            if (response.equalsIgnoreCase("yes")){
                acceptEntry = true;
                validInput = true;
            }
            else if (response.equalsIgnoreCase("no")){
                validInput = true;
            }
            else {
                System.out.println("Invalid input. Please answer with 'yes' or 'no'.");
            }
        }

        // Monthly
        int months = 0;
        boolean validMonths = false;

        while (!validMonths){
            System.out.println("Enter the number of months for financing: ");
            String monthsInput = scanner.nextLine().trim();

            try {
                months = Integer.parseInt(monthsInput);

                if (months <= 0){
                    throw new IllegalArgumentException("The number of months must be a positive integer.");
                }
                validMonths = true;
            }
            catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid positive integer for the number of months.");
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        // Interest rate
        double interestRate = 0;
        boolean validInterestRate = false;

        while (!validInterestRate) {
            System.out.println("Enter the monthly interest rate (Ex: 1.8): ");
            String interestRateInput = scanner.nextLine().trim().replace(",", ".");

            try {
                interestRate = Double.parseDouble(interestRateInput);
                if (interestRate <= 0) {
                    throw new IllegalArgumentException("The interest rate must be a positive value.");
                }
                interestRate = interestRate / 100;
                validInterestRate = true;
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid positive number for the interest rate.");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        double installment = (surplus * Math.pow(1 + interestRate, months) * interestRate) / (Math.pow(1 + interestRate, months) - 1);
        double totalPago = installment * months;
        double financeEntry = totalPago + entry;
        NumberFormat currencyFormatter01 = NumberFormat.getCurrencyInstance(Locale.US);
        String downPaymentFinancing = currencyFormatter01.format(financeEntry);
        DecimalFormat decimalFormat = new DecimalFormat("#");
        System.out.println("The total amount paid, after " + decimalFormat.format(months) + " months will be : " + downPaymentFinancing);

        //Check accept interest
        boolean acceptInterest = false;
        validInput = false;

        while (!validInput){
            System.out.println("Do you accept this amount with interest? (yes or no): ");
            String response = scanner.nextLine().trim();

            if (response.equalsIgnoreCase("yes")){
                acceptInterest = true;
                validInput = true;
            }
            else if (response.equalsIgnoreCase("no")){
                validInput = true;
            }
            else {
                System.out.println("Invalid input. Please answer with 'yes' or 'no'.");
            }
        }

        double installments = totalPago / months;
        NumberFormat currencyFormatter02 = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedPlots = currencyFormatter02.format(installments);
        boolean canFinance = (hasJob || EIN) && acceptEntry && acceptInterest && creditScore >= 669;
        if (canFinance){
            System.out.println("Financing 'Approved!'");
            System.out.println("Entry will be: " + formattedEntry);
            System.out.println("With installments of " + formattedPlots + " for " + decimalFormat.format(months) + " months.");
        }else {
            System.out.println("Financing 'Disapproved!' ");
            if (!hasJob && !EIN){
                System.out.println("Reason: You have no job or company.");
            }
            if (creditScore <= 669){
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
}

