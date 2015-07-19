package org.pnt.product.model;

import org.pnt.product.listeners.UuidListener;
import org.pnt.product.model.enumerate.SubscriptionType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Alexander on 08.06.2015.
 */
@Entity
@EntityListeners(value = {UuidListener.class})
public class Subscription implements Uuidable, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long uuid;

    private Long amount;

    @Enumerated
    private SubscriptionType subscriptionType;

    @OneToMany(mappedBy = "subscription")
    private Collection<Payment> payments;

    @OneToOne
    private Person trainee;

    @OneToOne
    private Person trainer;

    @OneToMany(mappedBy = "subscription")
    private Collection<Visit> visits;

    @ManyToOne
    private Promo promo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    public Subscription() {
        visits = new HashSet<Visit>();
        payments = new HashSet<Payment>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getTrainee() {
        return trainee;
    }

    public void setTrainee(Person trainee) {
        this.trainee = trainee;
    }

    public Collection<Payment> getPayments() {
        return payments;
    }

    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }

    public void setPayments(Collection<Payment> payments) {
        this.payments = payments;
    }

    public Person getTrainer() {
        return trainer;
    }

    public void setTrainer(Person trainer) {
        this.trainer = trainer;
    }

    public Collection<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Collection<Visit> visits) {
        this.visits = visits;
    }

    public Promo getPromo() {
        return promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        //TODO implementation is expected
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        //TODO implementation is expected
        return super.equals(obj);
    }

    @Override
    public String toString() {
        //TODO implementation is expected
        return super.toString();
    }
}