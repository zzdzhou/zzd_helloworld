package jack.jpa.springdatajpa.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "customer_since")
    private Date customerSince;

    public Customer() {
    }

    public Customer(String name, Date customerSince) {
        this.name = name;
        this.customerSince = customerSince;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCustomerSince() {
        return customerSince;
    }

    public void setCustomerSince(Date customerSince) {
        this.customerSince = customerSince;
    }
}
