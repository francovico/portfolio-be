/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.francovico.Controller;

import com.portfolio.francovico.Entity.Hass;
import com.portfolio.francovico.Security.Controller.Mensaje;
import com.portfolio.francovico.Security.Service.HassService;
import com.portfolio.francovico.dto.dtoHass;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Autor Franco Vico - Backend para Argentina Programa
 */

@RestController
@RequestMapping("hass")
@CrossOrigin(origins ="https://portfolio-fe-francovico.herokuapp.com")
public class HassController {
    @Autowired
    HassService HassService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Hass>> list(){
        List<Hass> list = HassService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hass> getById(@PathVariable("id") int id){
        if(!HassService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Hass hass = HassService.getOne(id).get();
        return new ResponseEntity(hass, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!HassService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        HassService.delete(id);
        return new ResponseEntity(new Mensaje("Hard and soft skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHass dtohass){
        if(StringUtils.isBlank(dtohass.getNombrehass()))
            return new ResponseEntity (new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(HassService.existsBynombrehass(dtohass.getNombrehass()))
            return new ResponseEntity (new Mensaje("Ese Hard and soft skill no existe"), HttpStatus.BAD_REQUEST);
        Hass hass = new Hass(dtohass.getNombrehass(), dtohass.getPuntuacionhass());
        HassService.save(hass);
        
        return new ResponseEntity(new Mensaje("Hard and soft skill agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHass dtohass){
        if(!HassService.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        if(HassService.existsBynombrehass(dtohass.getNombrehass()) && HassService.getBynombrehass(dtohass.getNombrehass()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese Hard and soft skill ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtohass.getNombrehass()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Hass hass = HassService.getOne(id).get();
        hass.setNombrehass(dtohass.getNombrehass());
        hass.setPuntuacionhass(dtohass.getPuntuacionhass());
        
        HassService.save(hass);
        return new ResponseEntity(new Mensaje("Hard and soft skills actualizado"), HttpStatus.OK);
    }
    
}
