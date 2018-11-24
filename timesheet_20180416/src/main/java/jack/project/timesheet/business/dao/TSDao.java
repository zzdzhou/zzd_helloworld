package jack.project.timesheet.business.dao;

import jack.project.timesheet.business.entities.TimeSheet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("tSDao")
public class TSDao {

    @PersistenceContext/*(unitName = "zhibernateUnit")*/
    private EntityManager em;

    @Transactional
    public Integer save(TimeSheet ts) {
        em.persist(ts);
        return ts.getId();
    }

    @Transactional(readOnly = true)
    public List<TimeSheet> getAll() {
        return em.createQuery("SELECT t FROM timesheet t ORDER BY t.id ASC")
                .getResultList();
    }

    @Transactional(readOnly = true)
    public TimeSheet getTimesheetById(Integer id) {
        List<TimeSheet> resultList = em.createQuery("SELECT t FROM timesheet t WHERE t.id = :id")
                .setParameter("id", id)
                .getResultList();
        return resultList.get(0);
    }

}
