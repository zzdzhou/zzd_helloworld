package jack.helloworld.jpa.applicatonmanaged;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-18
 */
public class UserDao {

/*    @PersistenceUnit(unitName = "mmalUnit")
    private EntityManagerFactory emf;*/

    private static EntityManager em;

    private EntityManager getEntityManager() {
        //return (em == null)? emf.createEntityManager(): this.em;
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("mmalUnit");
            em = emf.createEntityManager();
        }
        return this.em;
    }

    public String getUserEmail(Integer userId) {
        return (String) getEntityManager().createQuery("SELECT u.email FROM EUser u WHERE u.id = :id")
                .setParameter("id", userId)
                .getSingleResult();
    }

}
