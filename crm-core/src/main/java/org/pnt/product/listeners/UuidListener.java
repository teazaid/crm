package org.pnt.product.listeners;

import org.pnt.product.model.Uuidable;

import javax.persistence.PrePersist;
import java.util.UUID;

/**
 * Created by Alexander on 12.07.2015.
 */
public class UuidListener {
    public UuidListener() {
    }

    @PrePersist
    public void generateUuid(Uuidable uuidable) {
        uuidable.setUuid(UUID.randomUUID().getMostSignificantBits());
    }
}
