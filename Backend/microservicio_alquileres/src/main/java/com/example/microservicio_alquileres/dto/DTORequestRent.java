package com.example.microservicio_alquileres.dto;

import com.example.microservicio_alquileres.entity.Rent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DTORequestRent {

    @Min(value = 0, message = "ID must be greater than 0")
    @NotNull(message = "ID cannot be null")
    private Long id;
    private String name;
    private String surname;
    private String phone_number;
    private String email;
    private List<String> authorities;
    private String password;

    public DTORequestRent(String name, String surname, String phone_number, String email, List<Long> accounts, List<String> authorities, String password) {
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
        this.email = email;
        this.authorities = authorities;
        this.password = password;
    }

    public DTORequestRent(Rent dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.surname = dto.getSurname();
        this.phone_number = dto.getPhone_number();
        this.email = dto.getEmail();
        this.authorities = new ArrayList<>();
        //for (Authority auth : dto.getAuthorities()) {
        //    this.authorities.add(auth.getName());
        //}
        this.password = dto.getPassword();
    }
}
