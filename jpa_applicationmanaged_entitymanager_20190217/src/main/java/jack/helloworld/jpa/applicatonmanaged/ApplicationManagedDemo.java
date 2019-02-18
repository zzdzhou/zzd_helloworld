package jack.helloworld.jpa.applicatonmanaged;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-18
 */
public class ApplicationManagedDemo {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        String email = userDao.getUserEmail(3);
        System.out.printf("Hello World! Hello, %s", email);
    }

}
