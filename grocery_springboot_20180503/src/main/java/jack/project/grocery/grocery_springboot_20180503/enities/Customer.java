package jack.project.grocery.grocery_springboot_20180503.enities;

import jack.project.grocery.grocery_springboot_20180503.enities.helpclass.CustomerTitle;
import jack.project.grocery.grocery_springboot_20180503.enities.helpclass.Gender;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String firstname;

    @Column(length = 30)
    private String lastname;

    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(length = 4)
    private CustomerTitle title;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(/*columnDefinition = "COMMENT 'Is email confirmed'"*/)
    private boolean confirmed;

    @Column(unique = true)
    private String phone;

    @Column(name = "registration_date")
    private Date registrationDate;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public CustomerTitle getTitle() {
        return title;
    }

    public void setTitle(CustomerTitle title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
