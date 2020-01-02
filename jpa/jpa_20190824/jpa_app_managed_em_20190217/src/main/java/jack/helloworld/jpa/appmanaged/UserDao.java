package jack.helloworld.jpa.appmanaged;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-18
 */
public class UserDao {

    private EntityManagerFactory emf;
    private static EntityManager em;

    private EntityManager getEntityManager() {
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("mmalUnit");
            em = emf.createEntityManager();
        }
        return em;
    }

    String getEmail1(Integer userId) {
        return (String) getEntityManager().createQuery("SELECT u.email FROM EUser u WHERE u.id = :id")
                .setParameter("id", userId)
                .getSingleResult();
    }

    String getEmail2(Integer userId) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<EUser> criteria = builder.createQuery(EUser.class);
        Root<EUser> root = criteria.from(EUser.class);
        TypedQuery<EUser> query = getEntityManager().createQuery(criteria.select(root)
                .where(builder.equal(root.<Integer> get("id"), userId)));
        try {
            return query.getSingleResult().getEmail();
        } catch (NoResultException e) {
            return null;
        }
    }

}
