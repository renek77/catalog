package com.ruslik.catalog.model.impl;

import com.ruslik.catalog.model.AbonentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ruslan
 */
@Repository
public class AbonentDAOImpl extends CommonDAOImpl implements AbonentDAO {

    private static final Logger LOG = LoggerFactory.getLogger(AbonentDAOImpl.class);

    public List<Abonent> listAbonent() {
        return getEm().createQuery("from Abonent").getResultList();
    }
}
