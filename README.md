# Financing Evaluation System

This project is a simple financing evaluation system that requests information about employment, company ownership, credit score status, loan amount, down payment, and calculates the financing based on the monthly interest rate and number of installments.

## Features

- Verification of financing eligibility based on:
    - Employment status or company ownership.
    - Credit score status.
    - Acceptance of the down payment amount and interest.
- Calculation of the total amount paid at the end of the financing.
- Calculation of monthly installments with compound interest.

## Requirements

- Java 8 or higher

## How to Use

1. **Clone the repository**:

    ```bash
    git clone https://github.com/LuizStSantos/financing-evaluation-system.git
    ```

2. **Compile and run**:
   Inside the project directory, compile and run the code with the following commands:

    ```bash
    cd financing-evaluation-system
    javac FinancingEvaluationSystem.java
    java FinancingEvaluationSystem
    ```

3. **Interact with the system**:

   The system will prompt for the following information:
    - Do you have a job? (yes or no)
    - Do you own a company? (yes or no)
    - Did your credit score drop from 670? (yes or no)
    - Enter the loan amount you wish to acquire.
    - Enter the down payment, either as a percentage or absolute value.
    - Enter the number of months for financing.
    - Enter the monthly interest rate.

   After providing all this information, the system will calculate your eligibility for financing and display the down payment, monthly installments, and total amount to be paid.

### Example of Use
```text
Do you have a job? (yes or no): 
Yes
Do you own a company? (yes or no): 
No
Did your credit score drop from 670? (yes or no): 
No
Enter the loan amount you wish to acquire: 
11,000
Enter the down payment, either as a percentage or absolute value: 
2,000 // Here it can be a value (e.g., 20%)
The down payment is: R$ 2,000.00
Do you accept the down payment amount? (yes or no): 
yes
Enter the number of months for financing: 
24
Enter the monthly interest rate (e.g., 1.8): 
5.8
The total amount paid after 24 months will be: R$ 18,893.90
Do you accept this amount with interest? (yes or no): 
Yes
Financing 'Approved!'
The down payment will be: R$ 2,000.00
With installments of R$ 703.91 for 24 months.
```

## Credits
- Author: Luiz Stormorwski dos Santos
- GitHub: [LuizStSantos](https://github.com/LuizStSantos).

## License

This project is licensed under the [MIT License](https://opensource.org/license/mit).
