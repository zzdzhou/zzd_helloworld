package jack.jpa.dao;

import jack.jpa.entity.Orders;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("orderDao")
public class OrderDao {

/*    @PersistenceUnit
    private EntityManagerFactory emf;*/

    @PersistenceContext/*(unitName = "OrderDB")*/
    private EntityManager em;

/*    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }*/

    public List<Orders> getOrdersByCustomerId(long customerId) {
//        List<Orders> orders = new ArrayList<Orders>();

        List<Orders> orders = em.createQuery("select o from Orders o where o.customer = :customerId")
            .setParameter("customerId", customerId)
            .getResultList();
        return orders;
    }

    @Transactional
    public long saveOneOrder(Orders o) {
        System.out.println("em = " + em);
        em.persist(o);
        return o.getId();
    }
}
