package com.ruslik.catalog.dao.impl;

import com.ruslik.catalog.dao.AbonentDAO;
import com.ruslik.catalog.model.Abonent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ruslan
 */
@Repository("abonentDAO")
public class AbonentDAOImpl extends CommonDAOImpl implements AbonentDAO {

    private static final Logger LOG = LoggerFactory.getLogger(AbonentDAOImpl.class);

    public List<Abonent> listAbonent() {
        return getEm().createQuery("from Abonent").getResultList();
    }


    public void storeAbonent(Abonent abonent) {
        //update --
        Abonent merged = this.getEm().merge(abonent);
        this.getEm().flush();
        abonent.setId(merged.getId());
    }

}
