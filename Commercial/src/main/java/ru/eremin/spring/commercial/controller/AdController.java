package ru.eremin.spring.commercial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdController {
    @RequestMapping("/ad")
    public String ad(final Model model){

        return "hello";
    }



}
