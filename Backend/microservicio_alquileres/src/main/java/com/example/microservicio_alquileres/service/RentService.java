package com.example.microservicio_alquileres.service;

import com.example.microservicio_alquileres.exception.NotFoundException;

import com.example.microservicio_alquileres.dto.DTORequestRent;
import com.example.microservicio_alquileres.dto.DTOResponseRent;
import com.example.microservicio_alquileres.entity.Rent;
import com.example.microservicio_alquileres.repository.RentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {

    private final RentRepository rentRepository;

    public RentService(RentRepository rentRepository ) {
        this.rentRepository = rentRepository;
    }

    @Transactional
    public List<DTOResponseRent> findAll(){
        return this.rentRepository.findAll().stream().map( DTOResponseRent::new ).toList();
    }

    @Transactional
    public DTOResponseRent findById( Long id ){
        return this.rentRepository.findById( id )
                .map( DTOResponseRent::new )
                .orElseThrow( () -> new NotFoundException("rent", id));
    }


    @Transactional
    public DTOResponseRent save(DTORequestRent request){

        Rent rent = new Rent(request);
        Rent result = this.rentRepository.save(rent);
        return new DTOResponseRent(result);

    }


    @Transactional
    public void delete(Long id) {
        this.rentRepository.delete(this.rentRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No se pudo eliminar alquiler con ID:" + id)));
    }

    @Transactional
    public Rent update(Long id, DTORequestRent request) {
        Rent rent = this.rentRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No se encontro alquiler con ID: " + id));

        rent.setName(request.getName());
        rent.setPhone_number(request.getPhone_number());
        rent.setEmail(request.getEmail());

        return this.rentRepository.save(rent);
    }
}
