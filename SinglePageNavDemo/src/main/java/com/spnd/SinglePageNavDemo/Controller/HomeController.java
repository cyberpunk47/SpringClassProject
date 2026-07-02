package com.spnd.SinglePageNavDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Home");
        model.addAttribute("message","Welcome to college Portal Home Page");
        model.addAttribute("data3", "Data 3 from HomeController");
        return "dashboard";
    }
    
}
