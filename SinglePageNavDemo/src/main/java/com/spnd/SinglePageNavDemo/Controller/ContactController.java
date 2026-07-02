package com.spnd.SinglePageNavDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("title", "Contact");
        model.addAttribute("message","Email Us at school@school.edu");
        model.addAttribute("phone","Call Us at 123-456-7890");
        return "dashboard";
    }
}
