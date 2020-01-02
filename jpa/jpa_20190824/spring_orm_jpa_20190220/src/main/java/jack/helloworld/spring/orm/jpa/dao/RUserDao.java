package jack.helloworld.spring.orm.jpa.dao;

import jack.helloworld.spring.orm.jpa.entity.remotedb.RUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-03-07
 */
@Repository
@Transactional
public class RUserDao {

    @PersistenceContext(unitName = "timesheetUnit")
    private EntityManager em;

    public void addUser(RUser rUser) {
        System.out.println("log - UserDao.em = " + em);
        em.persist(rUser);
    }
}
