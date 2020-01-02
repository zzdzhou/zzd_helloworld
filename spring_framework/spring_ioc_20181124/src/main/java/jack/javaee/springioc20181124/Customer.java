package jack.javaee.springioc20181124;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2018-11-24
 */
public class Customer {

    private String name;

    private String email;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Customer: [name = %s, email = %s]", name, email);
    }
}


