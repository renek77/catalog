package com.ruslik.catalog.service.impl;

import com.ruslik.catalog.dao.PhoneDAO;
import com.ruslik.catalog.model.Phone;
import com.ruslik.catalog.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Ruslan
 */
@Service("phoneService")
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneDAO phoneDAO;

    @Transactional
    public void addPhone(Phone phone) {
        phoneDAO.persist(phone);
    }

    @Transactional
    public Phone getPhoneById(Long id) {
        return phoneDAO.find(Phone.class, id);
    }

    @Transactional
    public void removePhone(Long id) {
        phoneDAO.remove(Phone.class, id);
    }

    @Transactional(readOnly = true)
    public List<Phone> listPhone() {
        return phoneDAO.listAllPhones();
    }

    @Override
    public List<Phone> getAbonentPhones(Long abonentId) {
        return phoneDAO.findByAbonentId(abonentId);
    }
}
