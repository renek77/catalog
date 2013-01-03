package com.ruslik.catalog.model;

import com.ruslik.catalog.model.impl.Abonent;

import java.util.List;

public interface AbonentService {

    void addUser(Abonent Abonent);

    void removeUser(Long id);

    List<Abonent> listAbonent();

}
