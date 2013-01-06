package com.ruslik.catalog.web.controller;

import com.ruslik.catalog.model.Abonent;
import com.ruslik.catalog.service.AbonentService;
import com.ruslik.catalog.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/abonent")
@SessionAttributes("abonent")
public class AbonentController {

    @Autowired
    private AbonentService abonentService;

    @Autowired
    private PhoneService phoneService;

    @RequestMapping({"", "/"})
    public String listAbonent(Model model) {
        model.addAttribute("abonent", new Abonent());
        model.addAttribute("abonentlist", abonentService.listAbonent());
        return "abonent_list";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addAbonent(@ModelAttribute("abonent") Abonent abonent) {
        abonentService.addUser(abonent);
        return "redirect:/abonent";
    }

    @RequestMapping("delete/{abonentId}")
    public String deleteAbonent(@PathVariable("abonentId") Long abonentId) {
        phoneService.deleteAbonentPhones(abonentId);
        abonentService.removeUser(abonentId);
        return "redirect:/abonent";
    }

    @RequestMapping("edit/{abonentId}")
    public String editAbonent(@PathVariable("abonentId") Long abonentId, @ModelAttribute("abonent") Abonent abonent) {
        //  phoneService.deleteAbonentPhones(abonentId);
        //  abonentService.removeUser(abonentId);
        abonent = abonentService.findById(abonentId);
        return "redirect:/abonent";
    }
}
