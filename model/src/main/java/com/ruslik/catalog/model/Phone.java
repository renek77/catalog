package com.ruslik.catalog.model;

import javax.persistence.*;

/**
 * @author Ruslan
 */
@Entity
@Table(name = "PHONES")
public class Phone extends ManagedEntity {

    @Column(name = "PHONE_NUMBER")
    private String number;

    @ManyToOne
    @JoinColumn(name = "OWNER")
    private Abonent owner;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Abonent getOwner() {
        return owner;
    }

    public void setOwner(Abonent owner) {
        this.owner = owner;
    }
}
