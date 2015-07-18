package org.pnt.product.model;

import org.pnt.product.model.enumerate.DiscountType;
import org.pnt.product.model.enumerate.PromoType;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Alexander on 08.06.2015.
 */
@Entity
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    @Enumerated(EnumType.STRING)
    private PromoType type;

    private Long discountAmount;

    private Long usedAmount;

    @OneToMany(mappedBy = "promo")
    private Collection<Subscription> subscriptions;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Collection<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setAddSubscription(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    public void setSubscriptions(Collection<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public PromoType getType() {
        return type;
    }

    public void setType(PromoType type) {
        this.type = type;
    }

    public Promo() {
        subscriptions = new HashSet<Subscription>();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public Long getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Long getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(Long used) {
        this.usedAmount = used;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
}
