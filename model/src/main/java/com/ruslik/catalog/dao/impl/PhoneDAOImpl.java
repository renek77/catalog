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

    public Phone getPhoneById(Long id) {
        //LOG.debug("selecting Phone by id =", id);
        System.out.println("phonedaoimpl is running, id = " + id);
        Phone phone = (Phone) getEm().createQuery("from Phone where id =:id ").setParameter("id", id).getSingleResult();
        System.out.println("result daoimpl is phone = " + phone.getNumber());
        return phone;
    }

    @Override
    public List<Phone> findByAbonentId(Long abonentId) {
        Query query = getEm().createQuery("from Phone where owner.id =:id ");
        return query.getResultList();
    }
}
