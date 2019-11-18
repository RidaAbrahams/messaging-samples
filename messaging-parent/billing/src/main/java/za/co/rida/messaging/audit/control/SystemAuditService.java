package za.co.rida.messaging.audit.control;

import za.co.rida.messaging.audit.entity.SystemAudit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Objects;

@Stateless
public class SystemAuditService {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(SystemAudit systemAudit) {
        Objects.requireNonNull(systemAudit, "The systemAudit argument may not be null");
        System.out.println("Creating SystemAudit DB record...");
        entityManager.merge(systemAudit);
    }
}
