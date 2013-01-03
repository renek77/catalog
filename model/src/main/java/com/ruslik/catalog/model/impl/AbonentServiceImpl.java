package com.ruslik.catalog.model.impl;

import com.ruslik.catalog.model.AbonentDAO;
import com.ruslik.catalog.model.AbonentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Ruslan
 */
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
}
