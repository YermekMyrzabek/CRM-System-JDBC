package com.company;

import com.company.controllers.AnalyzedDataController;
import com.company.controllers.TransactionController;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MyApplication {
    private final TransactionController controller1;
    private final AnalyzedDataController controller2;
    private final Scanner scanner;

    public MyApplication(TransactionController controller1,AnalyzedDataController controller2 ) {
        this.controller1 = controller1;
        this.controller2=controller2;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all transactions");
            System.out.println("2. Get transactions by id");
            System.out.println("3. Get profitability");
            System.out.println("4. Get top age group");
            System.out.println("5. Get top item for date interval");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-5): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllTransactionsMenu();
                } else if (option == 2) {
                    getTransactionByIdMenu();
                } else if (option == 3) {
                    getProfitabilityMenu();
                }else if (option == 4) {
                    getTopAgeGroupMenu();}
                else if (option == 5) {
                    getTopItemMenu();}
                else {
                    break;
                }
            } catch (InputMismatchException _) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    private void getTopItemMenu() {
        System.out.println("Enter from what date to what in format YYYY/MM/DD:");
        System.out.println("From:");
        String from_date= scanner.next();
        System.out.println("To:");
        String to_date= scanner.next();
        int item_id = controller2.getFavoriteItem(from_date,to_date);
        System.out.println("Popular item id is "+item_id );


    }

    public void getAllTransactionsMenu() {
        String response = controller1.getAllTransactions();
        System.out.println(response);
    }

    public void getTransactionByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller1.getTransaction(id);
        System.out.println(response);
    }

    public void getProfitabilityMenu() {
        int AmountOfProfitability=controller1.getProfitability();
        System.out.println(AmountOfProfitability);
    }

    public void getTopAgeGroupMenu() {
        String AgeGroup=controller2.getTopAgeGroup();
        System.out.println(AgeGroup);
    }



}
