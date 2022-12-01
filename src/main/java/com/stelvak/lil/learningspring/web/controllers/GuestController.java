package com.stelvak.lil.learningspring.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stelvak.lil.learningspring.business.DTOs.GuestDTO;
import com.stelvak.lil.learningspring.business.services.GuestService;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllGuests(Model model) {
        List<GuestDTO> guests = this.guestService.getAllGuestInfo();
        model.addAttribute("guests", guests);
        return "guest";
    }
}
