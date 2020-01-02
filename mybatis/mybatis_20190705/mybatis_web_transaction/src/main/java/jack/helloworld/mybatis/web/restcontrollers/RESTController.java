package jack.helloworld.mybatis.web.restcontrollers;

import jack.helloworld.mybatis.web.dao.LicenseDao;
import jack.helloworld.mybatis.web.dao.OrganizationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/*
1. 每个servlet request 都在不同的线程中处理
2. 只要 Application 不重启，SqlSessionTemplate对象 是singleton的，被所有线程和 DAOs共享，SqlSessionTemplate对象是线程安全的

3. SqlSessionTemplate 管理 mysql session 的生命周期，
    它根据 spring 事务的边界，传播 mysql session，可以跨越多个 DAO，这保证的多个dao中的sql在同一个事务中执行

4. 另外，SqlSessionTemplate 也负责将 MyBatis 的异常翻译成 Spring 中的 DataAccessExceptions。
 */
@RestController
@RequestMapping("/rest")
public class RESTController {

    @Autowired
    private LicenseDao licenseDao;

    @Autowired
    private OrganizationDao organizationDao;


    @GetMapping("/test")
    @Transactional
    public void testTransaction() {
        System.out.println(Thread.currentThread().getName());
        licenseDao.getLicense("08dbe05-606e-4dad-9d33-90ef10e334f9");
        organizationDao.getOrganization("08dbe05-606e-4dad-9d33-90ef10e334f9");
    }

    @GetMapping("/test/no")
//    @Transactional
    public void testWithoutTransaction() {
        System.out.println(Thread.currentThread().getName());
        licenseDao.getLicense1("08dbe05-606e-4dad-9d33-90ef10e334f9");
        organizationDao.getOrganization1("08dbe05-606e-4dad-9d33-90ef10e334f9");
    }

    @GetMapping("/rollback")
    @Transactional
    public void testTransactionRollback() {
        System.out.println(Thread.currentThread().getName());
        try {
            licenseDao.getLicense("08dbe05-606e-4dad-9d33-90ef10e334f9");
            String s = null;
            s.toString();
            organizationDao.getOrganization("08dbe05-606e-4dad-9d33-90ef10e334f9");

            for (int i = 1; i <= 5; i++) {

            }
        } catch (Exception e) {
            System.out.println("catch exception");
            e.printStackTrace();
        }
        System.out.println("outside of try block");
    }

    @GetMapping("/thread")
    public void requestThread() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("requestThread - start");
        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("requestThread - end");
    }

}
