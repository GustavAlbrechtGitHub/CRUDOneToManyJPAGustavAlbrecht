import entity.Bank;
import entity.Customer;

public class BankCustomerController {

    JPADaoImpl dao;

    InputOutput io;

    public BankCustomerController(JPADaoImpl dao, InputOutput io) {
        this.dao = dao;
        this.io = io;
    }

    public void addBankController(){

        Bank bank = io.readBank();

        dao.addBank(bank);

        io.printBankAdded();

    }

    public void addTwoCustomersAndBankController(){

        Bank bank = io.readBank();

        Customer customer1 = io.readCustomer();

        Customer customer2 = io.readCustomer();



        dao.addTwoCustomersAndBank(customer1, customer2, bank);

        io.printBankCustomerAdded();

    }

    public void addNewBanktoNewCustomerController(){

        Bank bank = io.readBank();

        Customer customer = io.readCustomer();

        dao.addNewBanktoNewCustomer(customer, bank);

        io.printMessage("Bank and customers has been added!");
    }

    public void addNewCustomerToExistingBankController(){

        String bankName = io.returnBankName();

        Customer customer = io.readCustomer();

        dao.addNewCustomerToExistingBank(bankName, customer);

        io.printCustomerAddedExistingBank();

    }

    public void addExistingCustomerToExistingBankController(){

        String bankName = io.returnBankName();

        String customerName = io.returnCustomerName();

        dao.addExistingCustomerToExistingBank(bankName, customerName);

        io.printBankCustomerJoined();

    }

    public void showAllBanksAndCustomersController(){

        io.printList(dao.showAllBanks());

        io.printList(dao.showAllCustomers());

    }

    public void removeBankController(){

        String bankName = io.returnBankName();

        dao.removeBankByName(bankName);

        io.printBankRemoved();

    }

    public void removeCustomerController(){

        String customerName = io.returnCustomerName();

        dao.removeCustomerByName(customerName);

        io.printCustomerRemoved();

    }

    public void findBankByIdController(){

        int id = io.returnBankId();

        io.printList(dao.findBankById(id));

    }

    public void findCustomerByIdController(){

        int id = io.returnCustomerId();

        io.printList(dao.findCustomerById(id));

    }

    public void updateBankNameController(){

        int id = io.returnBankId();

        String bankName = io.returnBankName();

        dao.updateBankName(bankName, id);

        io.printBankUpdated();

    }

    public void updateCustomerNameController(){

        int id = io.returnCustomerId();

        String customerName = io.returnCustomerName();

        dao.updateCustomerName(customerName, id);

        io.printCustomerUpdated();

    }

    public void showAllBankClientsController(){

        String bankName = io.returnBankName();

        io.printList(dao.showAllBankClients(bankName));

        io.ifClientsAreNull(dao.showAllBankClients(bankName));

    }

    public void showAllCustomersWithoutBankController(){

        io.printList(dao.showAllCustomersWithoutBank());

    }

    public void showAllBanksWithoutCustomerController(){

        io.printList(dao.showAllBanksWithoutCustomer());
    }

    public void showAllBanksAscOrdController(){

        io.printList(dao.showAllBanksAscOrd());

    }

    public void showAllCustomersAscOrdController(){

        io.printList(dao.showAllCustomersAscOrd());

    }

    public void runProgram() {

        boolean loop = true;


        while (loop) {

            io.menu();

            String choice = io.getStringInput();


            switch (choice) {

                case "1" -> addBankController();
                case "2" -> addTwoCustomersAndBankController();
                case "3" -> showAllBanksAndCustomersController();
                case "4" -> addNewBanktoNewCustomerController();
                case "5" -> addNewCustomerToExistingBankController();
                case "6" -> addExistingCustomerToExistingBankController();
                case "7" -> removeCustomerController();
                case "8" -> removeBankController();
                case "9" -> findCustomerByIdController();
                case "10" -> findBankByIdController();
                case "11" -> updateBankNameController();
                case "12" -> updateCustomerNameController();
                case "13" -> showAllBankClientsController();
                case "14"-> showAllCustomersWithoutBankController();
                case "15" -> showAllBanksWithoutCustomerController();
                case "16" -> showAllCustomersAscOrdController();
                case "17" -> showAllBanksAscOrdController();
                case "0" ->  loop = false;
                default -> System.out.println("Wrong input, please choose 1-9");
            }
        }
    }
}
