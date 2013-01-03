package com.ruslik.catalog.model;

import com.ruslik.catalog.model.impl.Phone;

import java.util.List;

/**
 * @author Ruslan
 */
public interface PhoneDAO extends CommonDAO {

    List<Phone> listPhone();

    Phone getPhoneById(Long id);
}
