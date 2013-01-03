package com.ruslik.catalog.service.impl;

import com.ruslik.catalog.dao.PhoneDAO;
import com.ruslik.catalog.model.Phone;
import com.ruslik.catalog.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Ruslan
 */
@Component
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneDAO PhoneDAO;

    @Transactional
    public void addPhone(Phone phone) {
        PhoneDAO.persist(phone);
    }

    @Transactional
    public Phone getPhoneById(Long id) {
        System.out.println("PhoneService is running.... id = " + id);
        return PhoneDAO.getPhoneById(id);
    }

    @Transactional
    public void removePhone(Long id) {
        PhoneDAO.remove(Phone.class, id);
    }

    @Transactional(readOnly = true)
    public List<Phone> listPhone() {
        return PhoneDAO.listPhone();
    }
}
