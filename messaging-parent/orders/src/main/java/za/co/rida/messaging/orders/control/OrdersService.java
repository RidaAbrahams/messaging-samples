package za.co.rida.messaging.orders.control;

import za.co.rida.messaging.orders.entity.PurchaseOrderMessage;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.math.BigDecimal;
import java.util.Date;

@Stateless
public class OrdersService {

    @Inject
    @JMSConnectionFactory("java:/ConnectionFactory")
    private JMSContext context;

    @Resource(mappedName = "java:/jms/queue/orders_to_billing")
    private Queue queue;

    public void placePurchaseOrder() {
        System.out.println("Placing order...");
        TextMessage textMessage = context.createTextMessage(generatePurchaseOrder());
        JMSProducer producer = context.createProducer();
        producer.send(queue, textMessage);
        System.out.println("Order placed successfully.");
    }

    private String generatePurchaseOrder() {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(
                new PurchaseOrderMessage(
                        10968L,
                        "PS4",
                        new BigDecimal("5999.99"),
                        "Rida Abrahams",
                        new Date()));
    }

}
