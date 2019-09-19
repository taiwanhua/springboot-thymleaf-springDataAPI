package com.example.fom.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class Errortest {
    @GetMapping("/aerror")
    public String avdd(){
       throw new RuntimeException();
    }
}
