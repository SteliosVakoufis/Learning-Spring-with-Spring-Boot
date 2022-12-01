package com.stelvak.lil.learningspring.business.DTOs;

import lombok.Data;

@Data
public class GuestDTO {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
}
