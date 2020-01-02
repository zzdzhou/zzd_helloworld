package jack.javaee.springioc20181124;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2018-11-24
 */
public class SpringIoCDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        Customer customer = appContext.getBean(Customer.class);


    }
}
