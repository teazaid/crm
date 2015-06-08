package org.pnt.product.model;

import org.pnt.product.model.enumerate.PaymentMethod;
import org.pnt.product.model.enumerate.PaymentStatus;

import java.util.Date;

/**
 * Created by Alexander on 08.06.2015.
 */
public class Payment {
    private Long id;

    private Date createdAt;
    private Date executedAt;
    private Date updatedAt;

    private Person createdBy;
    private Person updatedBy;

    private Long amount;

    private PaymentStatus paymentStatus;
    private PaymentMethod paymentMethod;
}
