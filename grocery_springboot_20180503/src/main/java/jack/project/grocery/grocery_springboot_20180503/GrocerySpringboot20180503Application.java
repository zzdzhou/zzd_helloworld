package jack.project.grocery.grocery_springboot_20180503;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("jack.project.grocery.grocery_springboot_20180503.enities")
public class GrocerySpringboot20180503Application {

    public static void main(String[] args) {
        SpringApplication.run(GrocerySpringboot20180503Application.class, args);
    }

}
