package jack.helloworld.spring.orm.jpa.dao;

import jack.helloworld.spring.orm.jpa.entity.EUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
 * Created on 2019-02-21
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserDao {

    @PersistenceContext(unitName = "mmalUnit")
    private EntityManager em;

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

    public void addUser(EUser eUser) {
        em.persist(eUser);
    }



}


