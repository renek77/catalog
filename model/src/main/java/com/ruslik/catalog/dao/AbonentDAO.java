package com.ruslik.catalog.dao;

import com.ruslik.catalog.model.Abonent;

import java.util.List;

public interface AbonentDAO extends CommonDAO {
    List<Abonent> listAbonent();

    public void storeAbonent(Abonent abonent);
}
