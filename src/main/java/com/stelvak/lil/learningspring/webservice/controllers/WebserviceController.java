package com.stelvak.lil.learningspring.webservice.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stelvak.lil.learningspring.business.DTOs.GuestDTO;
import com.stelvak.lil.learningspring.business.DTOs.RoomDTO;
import com.stelvak.lil.learningspring.business.DTOs.RoomReservationDTO;
import com.stelvak.lil.learningspring.business.services.ReservationService;
import com.stelvak.lil.learningspring.data.Guest;
import com.stelvak.lil.learningspring.util.DateUtils;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<RoomReservationDTO> getReservations(@RequestParam(value = "date", required = false) String dateString){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @RequestMapping(path = "/rooms", method = RequestMethod.GET)
    public List<RoomDTO> getAllRooms(){
        return this.reservationService.getAllRoomsInfo();
    }

    @RequestMapping(path = "/guests", method = RequestMethod.GET)
    public List<GuestDTO> getAllGuests(){
        return this.reservationService.getAllGuestInfo();
    }

    @RequestMapping(path = "/guests", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Guest insertGuest(@RequestBody GuestDTO guestDTO){
        return this.reservationService.insertGuest(guestDTO);
    }
}
