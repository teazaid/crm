package org.pnt.product.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.pnt.product.listeners.UuidListener;
import org.pnt.product.model.enumerate.PaymentMethod;
import org.pnt.product.model.enumerate.PaymentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Alexander on 08.06.2015.
 */
@Entity
@EntityListeners(value = {UuidListener.class})
public class Payment implements Uuidable, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long uuid;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date executedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne
    private Person createdBy;

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    @ManyToOne
    private Subscription subscription;

    private Long amount;

    @Enumerated
    private PaymentStatus paymentStatus;
    @Enumerated
    private PaymentMethod paymentMethod;

    public Payment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getExecutedAt() {
        return executedAt;
    }

    public void setExecutedAt(Date executedAt) {
        this.executedAt = executedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Person getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Person createdBy) {
        this.createdBy = createdBy;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(subscription)
                .append(createdAt)
                .append(executedAt)
                .append(updatedAt)
                .append(createdBy)
                .append(amount)
                .append(paymentStatus)
                .append(paymentMethod)
        .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        //TODO implementation is expected
        return super.equals(obj);
    }
}
