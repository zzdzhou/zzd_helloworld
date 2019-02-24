package jack.helloworld.jpa.dao;

import jack.helloworld.jpa.entity.EUser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-24
 */
@Repository
public class UserDao {

    @PersistenceContext
    private static EntityManager em;

    public String getUserEmail(Integer userId) {
        return (String) em.createQuery("SELECT u.email FROM EUser u WHERE u.id = :id")
                .setParameter("id", userId)
                .getSingleResult();
    }

    public String getEmail(Integer userId) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<EUser> criteria = builder.createQuery(EUser.class);
        Root<EUser> root = criteria.from(EUser.class);
        TypedQuery<EUser> query = em.createQuery(criteria.select(root)
                .where(builder.equal(root.<Integer> get("id"), userId)));
        try {
            return query.getSingleResult().getEmail();
        } catch (NoResultException e) {
            return null;
        }
    }

}
