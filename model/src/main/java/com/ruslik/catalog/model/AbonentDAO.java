package com.ruslik.catalog.model;

import com.ruslik.catalog.model.impl.Abonent;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ruslan
 * Date: 10.05.12
 * Time: 9:59
 * To change this template use File | Settings | File Templates.
 */    //
public interface AbonentDAO extends CommonDAO {
    List<Abonent> listAbonent();
}
