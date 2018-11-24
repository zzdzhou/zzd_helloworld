package jack.jpa.springdatajpa.dao;

import jack.jpa.springdatajpa.entities.Customer;
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
