package com.stelvak.lil.learningspring.util;

import java.sql.Date;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.stelvak.lil.learningspring.data.GuestRepository;
import com.stelvak.lil.learningspring.data.Reservation;
import com.stelvak.lil.learningspring.data.ReservationRepository;
import com.stelvak.lil.learningspring.data.RoomRepository;

import lombok.var;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository,
            ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // printRepositoriesData();
        printReservationsByDate("2022-01-01");

    }

    private void printReservationsByDate(String date) {
        Iterable<Reservation> reservations = this.reservationRepository.findByDate(Date.valueOf(date));
        reservations.forEach(System.out::println);
    }

    private void printRepositoriesData(){
        var rooms = this.roomRepository.findAll();
        rooms.forEach(System.out::println);

        var guests = this.guestRepository.findAll();
        guests.forEach(System.out::println);

        var reservations = this.reservationRepository.findAll();
        reservations.forEach(System.out::println);
    }
}
