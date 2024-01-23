package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    public AboutController(){
    }
    @GetMapping("/about")
    public String showAbout() {
        return "about";
    }
}
