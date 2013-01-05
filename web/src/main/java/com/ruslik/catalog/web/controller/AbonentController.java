package com.ruslik.catalog.web.controller;

import com.ruslik.catalog.model.Abonent;
import com.ruslik.catalog.service.AbonentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class AbonentController {

    @Autowired
    private AbonentService abonentService;
    private Abonent abonent;

    @RequestMapping("/Abonent/index")
    public String listAbonent(Map<String, Object> map) {
        map.put("Abonent", new Abonent());
        map.put("Abonentlist", abonentService.listAbonent());
        return "abonent_list";
    }

    @RequestMapping(value = "/Abonent/add", method = RequestMethod.POST)
    public String addAbonent(@ModelAttribute("Abonent") Abonent abonent, BindingResult result) {
        abonentService.addUser(abonent);
        return "redirect:/Abonent/index";
    }

    @RequestMapping("/Abonent/delete/{idAbonent}")
    public String deleteAbonent(@PathVariable("idAbonent") Long idAbonent) {
        abonentService.removeUser(idAbonent);
        return "redirect:/Abonent/index";
    }
}
