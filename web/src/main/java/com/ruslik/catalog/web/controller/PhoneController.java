package com.ruslik.catalog.web.controller;

import com.ruslik.catalog.model.Abonent;
import com.ruslik.catalog.model.Phone;
import com.ruslik.catalog.service.AbonentService;
import com.ruslik.catalog.service.PhoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/abonent/{abonentId}/phones")
@SessionAttributes({"phone"})
public class PhoneController {

    @Resource
    private PhoneService phoneService;

    @Resource
    private AbonentService abonentService;

    @RequestMapping(method = RequestMethod.GET)
    public String listPhones(@PathVariable("abonentId") Long abonentId, Model model) {
        Abonent abonent = abonentService.findById(abonentId);
        Phone phone = new Phone();
        phone.setOwner(abonent);
        model.addAttribute("phone", phone);
        model.addAttribute("phoneList", phoneService.getAbonentPhones(abonentId));
        return "phone";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addPhone(@ModelAttribute("phone") Phone phone, BindingResult result) {
        phoneService.addPhone(phone);
        return "redirect:/abonent/{abonentId}/phones";
    }

    @RequestMapping(value = "delete/{phoneId}", method = RequestMethod.GET)
    public String deletePhone(@PathVariable("phoneId") Long phoneId) {
        phoneService.removePhone(phoneId);
        return "redirect:/abonent/{abonentId}/phones";
    }
}
