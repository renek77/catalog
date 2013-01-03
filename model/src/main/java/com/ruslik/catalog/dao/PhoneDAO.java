package com.ruslik.catalog.dao;

import com.ruslik.catalog.model.Phone;

import java.util.List;

/**
 * @author Ruslan
 */
public interface PhoneDAO extends CommonDAO {

    List<Phone> listPhone();

    Phone getPhoneById(Long id);
}
