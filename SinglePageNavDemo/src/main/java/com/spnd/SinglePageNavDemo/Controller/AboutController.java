package com.spnd.SinglePageNavDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About");
        model.addAttribute("message","Learn more about our college. This school was founded in 1990 and has been providing quality education ever since.");
        model.addAttribute("mission", "Our mission is to provide a nurturing environment that fosters academic excellence, personal growth, and social responsibility.");
        return "dashboard";
    }
}
