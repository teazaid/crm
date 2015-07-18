package org.pnt.product.model;

import org.pnt.product.listeners.UuidListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Alexander on 09.06.2015.
 */
@Entity
@EntityListeners(value = {UuidListener.class})
public class Visit implements Uuidable, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long uuid;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @ManyToOne(optional = false)
    private Subscription subscription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
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