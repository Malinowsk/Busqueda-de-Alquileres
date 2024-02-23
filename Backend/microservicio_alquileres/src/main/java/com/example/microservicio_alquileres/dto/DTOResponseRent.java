package com.example.microservicio_alquileres.dto;

import com.example.microservicio_alquileres.entity.Rent;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DTOResponseRent {
    private Long id;
    private String name;
    private String surname;
    private String phone_number;
    private String email;
    //private List<Authority> authorities;


    public DTOResponseRent(Rent u) {
        this.id = u.getId();
        this.name = u.getName();
        this.surname = u.getSurname();
        this.phone_number = u.getPhone_number();
        this.email = u.getEmail();
        //this.authorities = u.getAuthorities();
    }
}
