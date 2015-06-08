package org.pnt.product.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alexander on 08.06.2015.
 */
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String firstName;
    private String lastName;
    private String middleName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
