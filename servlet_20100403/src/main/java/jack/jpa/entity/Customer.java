package jack.jpa.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String email;

    @Column(name = "registration_date")
    private Date registrationDate;

    @OneToMany(mappedBy = "customer")
    private Set<Orders> orders;

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Set<Orders> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

}
