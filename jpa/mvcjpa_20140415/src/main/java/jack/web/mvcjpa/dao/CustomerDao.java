package jack.web.mvcjpa.dao;

import jack.web.mvcjpa.entities.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("customerDao")
public class CustomerDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Integer save(Customer customer) {
        em.persist(customer);
        return customer.getId();
    }

}
