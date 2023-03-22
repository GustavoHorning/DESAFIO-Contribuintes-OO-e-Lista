package application;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many taxpayers will you enter?: ");
        int taxpayers = sc.nextInt();

        List<TaxPayer> list = new ArrayList<>();

        for (int i = 0; i < taxpayers; i++) {

            System.out.println();
            System.out.println("enter the data of the " + (i+1) + "° taxpayer: ");
            System.out.print("annual income with salary: ");
            double annualSalary = sc.nextDouble();

            System.out.print("Annual income from service provision: ");
            double annualServices = sc.nextDouble();

            System.out.print("Annual income with capital gain: ");
            double annualCapital = sc.nextDouble();

            System.out.print("Medical expenses: ");
            double medicalExpenses = sc.nextDouble();

            System.out.print("Educational expenses: ");
            double educationalExpenses = sc.nextDouble();
            System.out.println();

            TaxPayer taxPayer = new TaxPayer(annualSalary,annualServices,annualCapital,medicalExpenses,educationalExpenses);
            list.add(taxPayer);
        }

        for (int i = 0; i < taxpayers; i++) {
            System.out.println("summary of the " + (i+1) + "° contributor: ");
            System.out.printf("total gross tax: %.2f\n",list.get(i).grossTax());
            System.out.printf("Abatement: %.2f\n",list.get(i).taxRebate());
            System.out.printf("Tax due: %.2f\n",list.get(i).netTax());
            System.out.println();
        }


    }
}
