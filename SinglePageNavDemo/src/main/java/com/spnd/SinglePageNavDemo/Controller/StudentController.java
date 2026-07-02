package com.spnd.SinglePageNavDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    
    @GetMapping("/student")
    public String student(Model model){
        model.addAttribute("title", "Student");
        model.addAttribute("Name","Name:- ABC");
        model.addAttribute("RollNo","Roll No:- 123");
        model.addAttribute("Branch","Branch:- CSE");
        model.addAttribute("Semester","Semester:- VII");
        model.addAttribute("CGPA","CGPA:- 8.8");
        model.addAttribute("unique","Student Controller Unique Data");
        return "dashboard";
    }
}
