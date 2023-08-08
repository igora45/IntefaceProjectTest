package application;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import model.ContractService;
import model.PaypalService;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Contract> contracts = new ArrayList<>();

        System.out.println("How many contracts you have ?: ");
        int con = sc.nextInt();
        for(int i = 1; i <= con; i++){
            System.out.println("Entry the contract value: ");
            System.out.print("Number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Name of the company: ");
            String company = sc.nextLine();
            System.out.print("Date (dd/MM/yyyy): ");
            LocalDate date = LocalDate.parse(sc.next(), fmt);
            System.out.print("Value: ");
            double value = sc.nextDouble();

            System.out.print("Number of Installments: ");
            int n = sc.nextInt();
            ContractService cs = new ContractService(new PaypalService());
            Contract contract = new Contract(number, date, value, company, cs);
            cs.processContract(contract, n);
            contracts.add(contract);
        }

        System.out.println();

        for(Contract contract : contracts){
            System.out.println("Company: " + contract.getCompany());

            System.out.println("Installments: ");
            for(Installment installment : contract.getInstallments()){
                System.out.println(installment);
            }
            System.out.println();
        }


    }
}