import entity.Bank;
import entity.Customer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputOutput {

    static Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("""
                _______________________________________________
                              Employee Management
                _______________________________________________
                1. Add Bank
                2. Add Two Customers To One Bank
                3. Show All Banks And Customers
                4. Add New Customer To New Bank
                5. Add New Customer To Existing Bank
                6. Add Existing Customer To Existing Bank
                7. Delete Customer
                8. Delete Bank
                9. Find Customer By Id
                10. Find Bank By Id
                11. Update Bank Name
                12. Update Customer Name
                13. Show All Bank Clients
                14. Show All Clients Without Bank
                15. Show all banks without customer
                16. Show All Banks in Ascending Order
                17. Show All Customers in Ascending Order
                0. Exit

                Please choose: """);
    }

    public int getIntInput() {

        int input = 0;

        while (true) {
            try {
                input = sc.nextInt();
                return input;

            } catch (InputMismatchException e) {

                System.out.println("Endast numeriska värden tack");
            } finally {
                sc.nextLine();

            }

        }
    }


    public double getDoubleInput() {

        double input = 0;

        while (true) {
            try {
                input = sc.nextDouble();
                return input;

            } catch (InputMismatchException e) {
                System.out.print("Wrong input, please insert number : ");
            } finally {
                sc.nextLine();
            }

        }

    }

    public String getStringInput(){

        String input = sc.nextLine();

        return input;
    }

    public void printList(List list){
        list.forEach(System.out::println);

    }

    public Bank readBank(){

        Bank bank = new Bank();

        System.out.println("Please enter name of bank: ");

        bank.setBankName(getStringInput());

        return bank;

    }

    public void printBankAdded(){

        System.out.println("Bank has been added!");

    }

    public Customer readCustomer(){

        Customer customer = new Customer();

        System.out.println("Please enter customer name: ");

        customer.setCustomerName(getStringInput());

        System.out.println("Please enter customer phoneNumber: ");

        customer.setPhoneNumber(getStringInput());

        return customer;


    }

    public void printMessage(String message){
        System.out.println(message);

    }

    public void printCustomersBankAdded(){

        System.out.println("Bank and customers has been added!");

    }

    public void printCustomerAdded(){

        System.out.println("Customer has been added!");

    }

    public void printBankCustomerAdded(){

        System.out.println("Bank and Customer has been added! ");


    }

    public void printCustomerAddedExistingBank(){

        System.out.println("Customer has been added to the bank!");

    }



    public void printBankCustomerJoined(){

        System.out.println("Bank and Customer has been Joined! ");
    }

    public String returnBankName(){

        System.out.println("Please enter name of bank: ");

        String bankName = getStringInput();

        return bankName;

    }

    public String returnCustomerName(){

        System.out.println("Please enter name of customer: ");

        String customerName = getStringInput();

        return customerName;
    }

    public int returnCustomerId(){

        System.out.println("Please enter customer id:");

        int id = getIntInput();

        return id;
    }

    public int returnBankId(){

        System.out.println("Please enter bank id:");

        int id = getIntInput();

        return id;
    }

    public void printCustomerRemoved(){

        System.out.println("Customer has been removed!");
    }

    public void printBankRemoved(){

        System.out.println("Bank has been removed! ");
    }

    public void printBankUpdated(){

        System.out.println("Bank has been updated! ");

    }

    public void printCustomerUpdated(){

        System.out.println("Customer been updated! ");

    }

    public void ifClientsAreNull(List list){

        if (list.size() == 0){

            System.out.println("No clients to this bank");
        }

    }

}
