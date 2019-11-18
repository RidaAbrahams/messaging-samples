package za.co.rida.messaging.billing.entity;

import za.co.rida.messaging.audit.entity.SystemAudit;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "BILL")
@NamedQuery(name = Bill.FIND_ALL, query = "SELECT b FROM Bill b")
public class Bill {

    public static final String FIND_ALL = "billing.entity.Bill.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Column(name = "ORDER_NUMBER")
    private String orderNumber;
    @Column(name = "BILL_DETAIL")
    private String billDetail;
    @Column(name = "BILL_AMOUNT")
    private BigDecimal billAmount;
    @Column(name = "DUE_DATE")
    private Date dueDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getBillDetail() {
        return billDetail;
    }

    public void setBillDetail(String billDetail) {
        this.billDetail = billDetail;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", billDetail='" + billDetail + '\'' +
                ", billAmount=" + billAmount +
                ", dueDate=" + dueDate +
                '}';
    }
}
