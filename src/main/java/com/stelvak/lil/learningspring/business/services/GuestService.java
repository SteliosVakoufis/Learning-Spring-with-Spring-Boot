package com.stelvak.lil.learningspring.business.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.stelvak.lil.learningspring.business.DTOs.GuestDTO;
import com.stelvak.lil.learningspring.data.GuestRepository;

import lombok.var;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<GuestDTO> getAllGuestInfo() {
        var result = new ArrayList<GuestDTO>();
        guestRepository.findAll()
            .forEach(item -> {
                var guestDTO = new GuestDTO();
                guestDTO.setFirstName(item.getFirstName());
                guestDTO.setLastName(item.getLastName());
                guestDTO.setEmailAddress(item.getEmail());
                guestDTO.setPhoneNumber(item.getPhone());

                result.add(guestDTO);
            });

        return result.stream()
            .sorted(Comparator.comparing(GuestDTO::getLastName))
            .collect(Collectors.toList());
    }
}
