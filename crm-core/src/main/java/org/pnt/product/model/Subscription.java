package org.pnt.product.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Alexander on 08.06.2015.
 */
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Person trainee;
    @ManyToOne
    private Person trainer;

    @OneToMany
    private Collection<Visit> visits;

    @ManyToOne
    private Promo promo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

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
}
