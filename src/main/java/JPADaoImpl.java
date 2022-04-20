import entity.Bank;
import entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JPADaoImpl {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public void addBank(Bank bank){
        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();
        em.persist(bank);
        em.getTransaction().commit();
        em.close();


    }

    public void addTwoCustomersAndBank(Customer customer1, Customer customer2, Bank bank){
        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();

        em.persist(bank);

        bank.addCustomer(customer1);

        bank.addCustomer(customer2);

        em.getTransaction().commit();
        em.close();


    }

    public List showAllBanks(){

    EntityManager em = emf.createEntityManager();

    List<Bank> bankList = em.createNamedQuery("Bank.findAll", Bank.class).getResultList();

    return bankList;

    }

    public List showAllCustomers(){

        EntityManager em = emf.createEntityManager();

        List<Customer> customerList = em.createNamedQuery("Customer.findAll", Customer.class).getResultList();

        return customerList;


    }


    public void addNewBanktoNewCustomer(Customer customer, Bank bank){

        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();

        em.persist(bank);

        bank.addCustomer(customer);

        em.getTransaction().commit();

        em.close();


    }

    public void addNewCustomerToExistingBank(String bankName, Customer customer){

        EntityManager em = emf.createEntityManager();


        Bank bank = em.createNamedQuery("Bank.findByBankName", Bank.class)
                .setParameter("bankName", bankName).getSingleResult();



        em.getTransaction().begin();


        bank.addCustomer(customer);

        em.getTransaction().commit();

        em.close();

    }

    public void addExistingCustomerToExistingBank(String bankName, String customerName){

        EntityManager em = emf.createEntityManager();

        Bank bank = em.createNamedQuery("Bank.findByBankName", Bank.class)
                .setParameter("bankName", bankName).getSingleResult();

        Customer customer = em.createNamedQuery("Customer.findByCustomerName", Customer.class)
                .setParameter("customerName", customerName).getSingleResult();


        em.getTransaction().begin();

        bank.addCustomer(customer);

        em.getTransaction().commit();

        em.close();

    }

    public void removeBankByName(String bankName){

        EntityManager em = emf.createEntityManager();

        Bank bank = em.createNamedQuery("Bank.findByBankName", Bank.class)
                .setParameter("bankName", bankName)
                .getSingleResult();

      //  List<Customer> customerList = bank.getCustomerList();

        em.getTransaction().begin();

        bank.getCustomerList().forEach(b -> b.setBank(null));

        em.remove(bank);

        em.getTransaction().commit();

        em.close();




    }

    public void removeCustomerByName(String customerName){

        EntityManager em = emf.createEntityManager();

        Customer customer = em.createNamedQuery("Customer.findByCustomerName", Customer.class)
                .setParameter("customerName", customerName)
                .getSingleResult();

        em.getTransaction().begin();

       // customer.getCustomerList().forEach(b -> b.setBank(null));

        em.remove(customer);

        em.getTransaction().commit();

        em.close();


    }

    public List findBankById(int id){
        EntityManager em = emf.createEntityManager();


        List<Bank> bankList = em.createNamedQuery("Bank.findById", Bank.class)
                .setParameter("id", id)
                .getResultList();

        em.close();

        return bankList;


    }

    public List findCustomerById(int id){
        EntityManager em = emf.createEntityManager();


        List<Customer> customerList = em.createNamedQuery("Customer.customerFindById", Customer.class)
                .setParameter("id", id)
                .getResultList();

        em.close();

        return customerList;

    }

    public void updateBankName(String bankName, int id){
        EntityManager em = emf.createEntityManager();


        Bank bank = em.find(Bank.class, id);

        em.getTransaction().begin();

        bank.setBankName(bankName);

        em.getTransaction().commit();
        em.close();

    }

    public void updateCustomerName(String customerName, int id){
        EntityManager em = emf.createEntityManager();


        Customer customer = em.find(Customer.class, id);

        em.getTransaction().begin();

        customer.setCustomerName(customerName);

        em.getTransaction().commit();
        em.close();

    }

    public List showAllBankClients(String bankName){

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List list = em.createQuery("SELECT c FROM Customer c WHERE c.bank.bankName=:bankName", Customer.class)
                .setParameter("bankName", bankName)
                .getResultList();

        em.getTransaction().commit();

        em.close();

        return list;

    }

   public List showAllCustomersWithoutBank(){

       EntityManager em = emf.createEntityManager();

       em.getTransaction().begin();

       List list = em.createQuery("SELECT c FROM Customer c WHERE c.bank is null", Customer.class)
               .getResultList();

       em.getTransaction().commit();

       em.close();

       return list;

   }

   public List showAllBanksWithoutCustomer(){
       EntityManager em = emf.createEntityManager();

       em.getTransaction().begin();


       List list = em.createQuery("SELECT b FROM Bank b WHERE b.customerList is empty", Bank.class)
               .getResultList();

       em.getTransaction().commit();

       em.close();

       return list;

   }

   public List showAllBanksAscOrd(){
       EntityManager em = emf.createEntityManager();

       List<Bank> bankList = em.createQuery("SELECT b FROM Bank b ORDER BY b.bankName ASC", Bank.class)
               .getResultList();


       return bankList;

   }

   public List showAllCustomersAscOrd(){

       EntityManager em = emf.createEntityManager();

       List<Customer> customerList = em.createQuery("SELECT c FROM Customer c ORDER BY c.customerName ASC", Customer.class)
               .getResultList();


       return customerList;

   }
}
