package com.ruslik.catalog.web;

import com.ruslik.catalog.model.PhoneService;
import com.ruslik.catalog.model.impl.Abonent;
import com.ruslik.catalog.model.impl.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@Controller
@SessionAttributes({"Abonent", "Phone"})
public class TopicController {

    @Autowired
    private PhoneService phoneService;

    @RequestMapping("/index")
    public String listPhones(Map<String, Object> map) {
        map.put("Phone", new Phone());
        map.put("PhoneList", phoneService.listPhone());
        return "/Phone";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPhone(@ModelAttribute("Phone") Phone phone, @ModelAttribute("Abonent") Abonent Abonent, BindingResult result) {
        Date currentDate = new Date();
//        phone.setDatecreation(currentDate);
//        phone.setCreator(Abonent);
        phoneService.addPhone(phone);
        return "redirect:/index";
    }

    @RequestMapping("/delete/{idPhone}")
    public String deletePhone(@PathVariable("idPhone") Long idPhone) {
        phoneService.removePhone(idPhone);
        return "redirect:/index";
    }
}
