package za.co.rida.messaging.orders.entity;

import javax.json.bind.annotation.JsonbPropertyOrder;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@JsonbPropertyOrder(value = {"orderNumber", "item", "itemPrice", "customerName", "orderDate"})
public class PurchaseOrderMessage {

    private final Long orderNumber;
    private final String item;
    private final BigDecimal itemPrice;
    private final String customerName;
    private final Date orderDate;

    public PurchaseOrderMessage(Long orderNumber, String item, BigDecimal itemPrice, String customerName, Date orderDate) {
        Objects.requireNonNull(orderNumber);
        Objects.requireNonNull(item);
        Objects.requireNonNull(itemPrice);
        Objects.requireNonNull(customerName);
        Objects.requireNonNull(orderDate);

        this.orderNumber = orderNumber;
        this.item = item;
        this.itemPrice = itemPrice;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public String getItem() {
        return item;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Date getOrderDate() {
        return (Date) orderDate.clone();
    }
}
