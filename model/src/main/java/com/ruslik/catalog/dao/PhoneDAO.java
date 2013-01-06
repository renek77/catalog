package com.ruslik.catalog.dao;

import com.ruslik.catalog.model.Phone;

import java.util.List;

public interface PhoneDAO extends CommonDAO {

    List<Phone> listAllPhones();

    List<Phone> findByAbonentId(Long abonentId);

}
