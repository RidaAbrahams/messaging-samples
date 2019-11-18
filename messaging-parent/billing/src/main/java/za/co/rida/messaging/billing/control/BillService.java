package za.co.rida.messaging.billing.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BillService {

    @PersistenceContext
    private EntityManager entityManager;

    public void createBill()
}
