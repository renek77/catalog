package com.ruslik.catalog.service;

import com.ruslik.catalog.model.Phone;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ruslan
 * Date: 10.05.12
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
public interface PhoneService {

    void addPhone(Phone phone);

    Phone getPhoneById(Long id);

    void removePhone(Long id);

    List<Phone> listPhone();
}
