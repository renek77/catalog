package com.ruslik.catalog.web;

import com.ruslik.catalog.model.impl.AbonentServiceImpl;

import java.util.List;


public class ShowAbonentBean {


    public ShowAbonentBean() {
    }

    private AbonentServiceImpl abonentService;


    public void setAbonent(AbonentServiceImpl abonentService) {
        this.abonentService = abonentService;
    }

    public AbonentServiceImpl getAbonentService() {
        return abonentService;
    }

    public List getRooms() {
        return this.getAbonentService().listAbonent();

    }
}