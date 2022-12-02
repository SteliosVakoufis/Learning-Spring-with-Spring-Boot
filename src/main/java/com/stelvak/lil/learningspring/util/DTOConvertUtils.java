package com.stelvak.lil.learningspring.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.stelvak.lil.learningspring.business.DTOs.GuestDTO;
import com.stelvak.lil.learningspring.business.DTOs.RoomDTO;
import com.stelvak.lil.learningspring.data.Guest;
import com.stelvak.lil.learningspring.data.Room;

@Component
public class DTOConvertUtils {
    public Guest convertGuestDTOtoGuest(GuestDTO guestDTO){
        var guest = new Guest();
        guest.setFirstName(guestDTO.getFirstName());
        guest.setLastName(guestDTO.getLastName());
        guest.setEmail(guestDTO.getEmail());
        guest.setAddress(guestDTO.getAddress());
        guest.setCountry(guestDTO.getCountry());
        guest.setState(guestDTO.getState());
        guest.setPhone(guestDTO.getPhone());

        return guest;
    }

    public List<GuestDTO> convertAllGuestToGuestDTO(Iterable<Guest> guests){
        var result = new ArrayList<GuestDTO>();
        guests.forEach(item -> {
                var guestDTO = new GuestDTO();
                guestDTO.setFirstName(item.getFirstName());
                guestDTO.setLastName(item.getLastName());
                guestDTO.setEmail(item.getEmail());
                guestDTO.setPhone(item.getPhone());

                result.add(guestDTO);
            });
        return result.stream()
            .sorted(Comparator.comparing(GuestDTO::getLastName))
            .collect(Collectors.toList());
    }

    public List<RoomDTO> convertAllRoomToRoomDTO(Iterable<Room> rooms) {
        var result = new ArrayList<RoomDTO>();
        rooms.forEach(item -> 
            result.add(new RoomDTO(
                item.getName(), item.getRoomNumber(), item.getBedInfo()
            ))
        );
        return result;
    }
}
