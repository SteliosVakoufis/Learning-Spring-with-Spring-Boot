package com.stelvak.lil.learningspring.business.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private String name;
    private String roomNumber;
    private String bedInfo;
}
