package za.co.rida.messaging.billing.boundary;

import za.co.rida.messaging.audit.control.SystemAuditService;
import za.co.rida.messaging.audit.entity.SystemAudit;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.*;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/orders_to_billing")
})
public class OrderMessageConsumer implements MessageListener {

    @Inject
    private SystemAuditService systemAuditService;

    @Override
    public void onMessage(Message message) {

        TextMessage textMessage = (TextMessage) message;
        try {
            String auditMessage = "Received message: [" + textMessage.getText() + "]";
            System.out.println(auditMessage);
            SystemAudit systemAuditRecord = new SystemAudit();
            systemAuditRecord.setSourceSystem("orders");
            systemAuditRecord.setAuditMessage(auditMessage);
            systemAuditService.create(systemAuditRecord);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
