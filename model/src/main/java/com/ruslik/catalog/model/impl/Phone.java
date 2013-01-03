package com.ruslik.catalog.model.impl;

import javax.persistence.*;

/**
 * @author Ruslan
 */
@Entity
@Table(name = "PHONES")
public class Phone extends ManagedEntity {

    @Column(name = "PHONE_NUMBER")
    private String phone_number;

    @ManyToOne
    @JoinColumn(name = "OWNER")
    private Abonent owner;

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
