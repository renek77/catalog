package com.ruslik.catalog.web;

import com.ruslik.catalog.service.impl.AbonentServiceImpl;

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

    public List getAbonent() {
        return this.getAbonentService().listAbonent();

    }
}