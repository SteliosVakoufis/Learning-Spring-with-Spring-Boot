package com.stelvak.lil.learningspring.business.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String country;
    private String state;
    private String phone;
}
