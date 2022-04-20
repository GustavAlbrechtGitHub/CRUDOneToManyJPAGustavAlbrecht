package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries(
        {
                @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
                @NamedQuery(name = "Bank.findById", query = "SELECT b FROM Bank b WHERE b.id=:id"),
                @NamedQuery(name = "Bank.findByBankName", query = "SELECT b FROM Bank b WHERE b.bankName=:bankName"),
                @NamedQuery(name = "Bank.updateName", query = "UPDATE Bank SET bankName=:bankName WHERE id=:id"),

        }
)

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bankName;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "Bank")
    List<Customer> customerList = new ArrayList<>();

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void addCustomer(Customer customer){
        customerList.add(customer);
        customer.setBank(this);

    }

    public void removeCustomer(Customer customer){
        customerList.remove(customer);

        customer.setBank(null);

    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public Bank() {
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                '}';
    }
}

