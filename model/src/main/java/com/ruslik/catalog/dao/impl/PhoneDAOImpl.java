package com.ruslik.catalog.dao.impl;

import com.ruslik.catalog.dao.PhoneDAO;
import com.ruslik.catalog.model.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * @author Ruslan
 */

@Repository
public class PhoneDAOImpl extends CommonDAOImpl implements PhoneDAO {
    private static final Logger LOG = LoggerFactory.getLogger(PhoneDAOImpl.class);


    public List<Phone> listAllPhones() {
        return getEm().createQuery("from Phone").getResultList();
    }

    @Override
    public List<Phone> findByAbonentId(Long abonentId) {
        Query query = getEm()
                .createQuery("from Phone where owner.id =:abonentId")
                .setParameter("abonentId", abonentId);
        return query.getResultList();
    }
}
