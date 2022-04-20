public class Main {

    public static void main(String[] args) {

        InputOutput io = new InputOutput();

        JPADaoImpl dao = new JPADaoImpl();

        BankCustomerController bCController = new BankCustomerController(dao, io);

        bCController.runProgram();

    }
}
