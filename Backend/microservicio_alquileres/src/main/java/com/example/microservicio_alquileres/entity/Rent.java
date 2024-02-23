package com.example.microservicio_alquileres.entity;

import com.example.microservicio_alquileres.dto.DTORequestRent;
import com.example.microservicio_alquileres.dto.DTOResponseRent;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@NoArgsConstructor
@Data
public class Rent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_rent")
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phone_number;

    @Column
    private String titulo;

    @Column
    private String descripcion;

    @Column
    private String tipo_de_propiedad;

    @Column
    private int pers_min;

    @Column
    private int pers_max;

    @Column
    private int habitaciones;

    @Column
    private int banios;

    @Column
    private String periodo;

    @Column
    private String moneda;


    public Rent(String name, String phone_number, String email, String titulo, String descripcion, String tipo_de_propiedad, int pers_min, int pers_max, int habitaciones, int banios, String periodo, String moneda) {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo_de_propiedad = tipo_de_propiedad;
        this.pers_min = pers_min;
        this.pers_max = pers_max;
        this.habitaciones = habitaciones;
        this.banios = banios;
        this.periodo = periodo;
        this.moneda = moneda;
    }

    public Rent(DTORequestRent dto) {
        this.name = dto.getName();
        this.phone_number = dto.getPhone_number();
        this.email = dto.getEmail();

    }
    public Rent(DTOResponseRent dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.phone_number = dto.getPhone_number();
        this.email = dto.getEmail();
    }

}
