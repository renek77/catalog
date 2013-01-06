package com.ruslik.catalog.service.impl;

import com.ruslik.catalog.dao.AbonentDAO;
import com.ruslik.catalog.model.Abonent;
import com.ruslik.catalog.service.AbonentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AbonentServiceImpl implements AbonentService {

    @Autowired
    private AbonentDAO abonentDAO;

    @Transactional
    public void addUser(Abonent Abonent) {
        abonentDAO.persist(Abonent);
    }

    @Transactional
    public void removeUser(Long id) {
        abonentDAO.remove(Abonent.class, id);
    }

    @Transactional(readOnly = true)
    public List<Abonent> listAbonent() {
        return abonentDAO.listAbonent();
    }

    @Override
    public Abonent findById(Long id) {
        return abonentDAO.find(Abonent.class, id);
    }

    @Transactional
    public void persist(Object entity) {
        abonentDAO.persist(entity);
    }
}
