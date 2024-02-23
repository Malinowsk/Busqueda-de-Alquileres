package com.example.microservicio_alquileres.controller;

import com.example.microservicio_alquileres.dto.DTOResponseRent;
import com.example.microservicio_alquileres.dto.DTORequestRent;
import com.example.microservicio_alquileres.entity.Rent;

import com.example.microservicio_alquileres.service.RentService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("api/alquileres")
public class RentalsController {

    private final RentService rentalsService;

    public RentalsController(RentService rentalsService) {
        this.rentalsService = rentalsService;
    }

    ///////////////////////////////////////////////// ABM //////////////////////////////////////////////////////////////////////////

    @GetMapping("")
    public List<DTOResponseRent> findAll(){
        return this.rentalsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserByID(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(rentalsService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. No existe el Alquiler con el ID: "+id);
        }
    }


    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody @Validated DTORequestRent request){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(rentalsService.save(request));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrió un error, revise los datos ingresados.");
        }
    }



    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteRent(@PathVariable Long id){
        try{
            this.rentalsService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Se elimino correctamente el alquiler con el id: " + id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. No se pudo eliminar el alquiler con id: " + id);
        }
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<?> editUser(@PathVariable Long id){
        try {
            Rent rent = rentalsService.update(id);
            DTOResponseRent response = new DTOResponseRent(rent);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el alquiler con el ID: "+id);
        }
    }*/

}