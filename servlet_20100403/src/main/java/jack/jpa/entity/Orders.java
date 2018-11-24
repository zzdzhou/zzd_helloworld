package jack.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String product;

    private double quantity;

    private double amount;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = true)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Orders() {
    }

    public Orders(String product, double quantity, double amount) {
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
