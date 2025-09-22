package com.demo.SpringSecurityDemo.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/myCards")
    public  String getCardsDetails (Principal p) {
        return "Here are the card details from the DB "+p.getName();
    }

}
