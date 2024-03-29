package com.ruslik.catalog.web.controller;

import com.ruslik.catalog.model.Abonent;
import com.ruslik.catalog.service.AbonentService;
import com.ruslik.catalog.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

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
    public String editAbonent(@PathVariable("abonentId") Long abonentId, Model model) {
        model.addAttribute("abonent", abonentService.findById(abonentId));
        return "abonent_edit";
    }

    /* @RequestMapping("update/{abonentId}")
public String updateAbonent(@ModelAttribute("abonent") Abonent abonent) {
    //abonentService.refresh(abonent);
    abonent.setFirstName("pupkin");
    abonentService.persist(abonent);
    return "redirect:/abonent";
}    */
    /*@RequestMapping("update/{abonentId}/{abonentfirstName}")
    public String updateAbonent(@PathVariable("abonentId") Long id, @PathVariable("abonentfirstName") String firstName) {
        //abonentService.refresh(abonent);
        Abonent abonent;
        abonent = abonentService.findById(id);
        abonent.setFirstName(firstName);
        // abonentService.persist(abonent);
        return "redirect:/";
    }
          */
    @RequestMapping("update/{abonentId}/{abonentfirstName}")
    public String processSubmit(
            @ModelAttribute("abonent") Abonent abonent,
            BindingResult result, SessionStatus status) {
        abonentService.storeAbonent(abonent);
        status.setComplete();
        //form success
        return "redirect:/";
    }
}

