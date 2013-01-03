package com.ruslik.catalog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: ruslan
 * Date: 17.07.12
 * Time: 10:26
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MainController {

    @RequestMapping("/home")
    public String main() {
        return "redirect:/index";
    }
}
