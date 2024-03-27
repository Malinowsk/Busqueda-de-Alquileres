package com.example.microservicio_alquileres.dto;

import com.example.microservicio_alquileres.entity.Rent;
import jakarta.persistence.Column;
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
    private String email;
    private String phone_number;
    private String titulo;
    private String descripcion;
    private String tipo_de_propiedad;
    private int pers_min;
    private int pers_max;
    private int habitaciones;
    private int banios;
    private String periodo;
    private String moneda;

    public DTORequestRent(String name, String email, String phone_number, String titulo, String descripcion, String tipo_de_propiedad,String periodo,String moneda, int pers_min, int pers_max, int habitaciones, int banios) {
        this.name = name;
        this.titulo = titulo;
        this.phone_number = phone_number;
        this.email = email;
        this.descripcion = descripcion;
        this.tipo_de_propiedad = tipo_de_propiedad;
        this.periodo = periodo;
        this.moneda = moneda;
        this.pers_min = pers_min;
        this.pers_max = pers_max;
        this.habitaciones = habitaciones;
        this.banios = banios;
    }

    public DTORequestRent(Rent dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.titulo = dto.getTitulo();
        this.phone_number = dto.getPhone_number();
        this.email = dto.getEmail();
        this.descripcion = dto.getDescripcion();
        this.tipo_de_propiedad = dto.getTipo_de_propiedad();
        this.periodo = dto.getPeriodo();
        this.moneda = dto.getMoneda();
        this.pers_min = dto.getPers_min();
        this.pers_max = dto.getPers_max();
        this.habitaciones = dto.getHabitaciones();
        this.banios = dto.getBanios();
    }
}
