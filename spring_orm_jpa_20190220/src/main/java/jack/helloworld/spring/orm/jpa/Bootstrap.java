package jack.helloworld.spring.orm.jpa;

import jack.helloworld.spring.orm.jpa.context.AppConfig;
import jack.helloworld.spring.orm.jpa.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-21
 */
@Component
public class Bootstrap {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserDao myService = ctx.getBean(UserDao.class);

    }

}


