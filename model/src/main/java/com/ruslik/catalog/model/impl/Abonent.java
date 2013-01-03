package com.ruslik.catalog.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Abonent extends ManagedEntity {

    @Column(name = "ABONENT_FIO")
    private String abonent_fio;

    @Column(name = "ABONENT_ADRESS")
    private String abonent_adress;

    public String getAbonent_fio() {
        return abonent_fio;
    }

    public void setAbonent_fio(String abonent_fio) {
        this.abonent_fio = abonent_fio;
    }

    public String getAbonent_adress() {
        return abonent_adress;
    }

    public void setAbonent_adress(String abonent_adress) {
        this.abonent_adress = abonent_adress;
    }

    @Override
    public String toString() {
        return "Abonent{" +
                "abonent_fio='" + abonent_fio + '\'' +
                ", abonent_adress='" + abonent_adress + '\'' +
                '}';
    }
}
