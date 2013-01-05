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
@RequestMapping(value = "/phone")
@SessionAttributes({"phone", "abonentId"})
public class PhoneController {

    @Resource
    private PhoneService phoneService;

    @Resource
    private AbonentService abonentService;

    @RequestMapping("{abonentId}")
    public String listPhones(@PathVariable("abonentId") Long abonentId, Model model) {
        Abonent abonent = abonentService.findById(abonentId);
        Phone phone = new Phone();
        phone.setOwner(abonent);
        model.addAttribute("abonentId", abonentId);
        model.addAttribute("phone", phone);
        model.addAttribute("phoneList", phoneService.listPhone());
        return "phone";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addPhone(@ModelAttribute("phone") Phone phone, BindingResult result) {
        phoneService.addPhone(phone);
        return "redirect:/phone/{abonentId}";
    }

    @RequestMapping("delete/{phoneId}")
    public String deletePhone(@PathVariable("phoneId") Long phoneId) {
        phoneService.removePhone(phoneId);
        return "redirect:/phone/{abonentId}";
    }
}
