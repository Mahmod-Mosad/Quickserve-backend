package com.mahmoud.quickserve.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCont {
@GetMapping("hello")
public String hello(){
    return "Hello World";
}

}
