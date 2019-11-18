package za.co.rida.messaging.audit.entity;

import javax.persistence.*;

@Entity
@Table(name = "SYSTEM_AUDIT")
@NamedQuery(name = SystemAudit.FIND_ALL, query = "SELECT sa FROM SystemAudit sa")
public class SystemAudit {

    public static final String FIND_ALL = "audit.entity.SystemAudit.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "SOURCE_SYSTEM")
    private String sourceSystem;
    @Column(name = "AUDIT_MESSAGE")
    private String auditMessage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getAuditMessage() {
        return auditMessage;
    }

    public void setAuditMessage(String auditMessage) {
        this.auditMessage = auditMessage;
    }

    @Override
    public String toString() {
        return "SystemAudit{" +
                "id=" + id +
                ", sourceSystem='" + sourceSystem + '\'' +
                ", auditMessage='" + auditMessage + '\'' +
                '}';
    }
}
