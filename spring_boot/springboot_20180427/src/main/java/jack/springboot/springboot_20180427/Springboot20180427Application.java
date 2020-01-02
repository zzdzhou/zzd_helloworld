package jack.springboot.springboot_20180427;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("jack.springboot.springboot_20180427.entities")
public class Springboot20180427Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot20180427Application.class, args);
//        System.out.println(Springboot20180427Application.class.getClassLoader().getResource("").getPath());
    }

}
