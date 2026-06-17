package com.example.demo01.controller;

import com.example.demo01.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
    public class ViewController {
        @GetMapping("/home")
        public String home(){
            return "home";
        }
        @PostMapping("/login")
        public String login(@ModelAttribute Student student){

            System.out.println(student);

            return "login";

        }

    }

