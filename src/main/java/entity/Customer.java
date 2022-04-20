package entity;

import javax.persistence.*;

@NamedQueries(
        {
                @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
                @NamedQuery(name = "Customer.customerFindById", query = "SELECT c FROM Customer c WHERE c.id=:id"),
                @NamedQuery(name = "Customer.findByCustomerName", query = "SELECT c FROM Customer c WHERE c.customerName=:customerName"),
                @NamedQuery(name = "Customer.customerFindByPhoneNumber", query = "SELECT c FROM Customer c WHERE c.phoneNumber=:phoneNumber"),
                @NamedQuery(name = "Customer.updateCustomerName", query = "UPDATE Customer SET customerName=:customerName WHERE id=:id"),
                @NamedQuery(name = "Customer.updatePhoneNumber", query = "UPDATE Customer SET phoneNumber=:phoneNumber WHERE id=:id")

        }
)

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    private String customerName;

    private String phoneNumber;

    @ManyToOne


    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
    }

    public Customer(String customerName, String phoneNumber) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", bank=" + bank +
                '}';
    }
}
