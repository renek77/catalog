package com.ruslik.catalog.service;

import com.ruslik.catalog.model.Abonent;

import java.util.List;

public interface AbonentService {

    void addUser(Abonent Abonent);

    void removeUser(Long id);

    List<Abonent> listAbonent();

}
