package com.dormitoryservice.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {
    @GetMapping("/service")
    public String service() {
        return "service";
    }
    @GetMapping("/entry")
    public String home() {
        return "home";
    }
}