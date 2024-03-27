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


    public DTOResponseRent(Rent dto) {
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
