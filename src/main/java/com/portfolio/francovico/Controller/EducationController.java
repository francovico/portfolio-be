/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.francovico.Controller;

import com.portfolio.francovico.Entity.Education;
import com.portfolio.francovico.Security.Controller.Mensaje;
import com.portfolio.francovico.Security.Service.EducationService;
import com.portfolio.francovico.dto.dtoEducation;
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
 * @author franc
 */

@RestController
@RequestMapping("education")
@CrossOrigin(origins ="http://localhost:4200")

public class EducationController {
    @Autowired
    EducationService EducationService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Education>> list(){
        List<Education> list = EducationService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!EducationService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Education education = EducationService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!EducationService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        EducationService.delete(id);
        return new ResponseEntity(new Mensaje("Education eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducation dtoeducation){
        if(StringUtils.isBlank(dtoeducation.getInstitucion()))
            return new ResponseEntity (new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(EducationService.existsByinstitucion(dtoeducation.getInstitucion()))
            return new ResponseEntity (new Mensaje("Esa education ya existe"), HttpStatus.BAD_REQUEST);
        Education education = new Education(dtoeducation.getInstitucion(), dtoeducation.getIntervalo(), dtoeducation.getDescripcion());
        EducationService.save(education);
        
        return new ResponseEntity(new Mensaje("Education agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducation dtoeducation){
        if(!EducationService.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        if(EducationService.existsByinstitucion(dtoeducation.getInstitucion()) && EducationService.getByinstitucion(dtoeducation.getInstitucion()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa education ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoeducation.getInstitucion()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Education education = EducationService.getOne(id).get();
        education.setInstitucion(dtoeducation.getInstitucion());
        education.setIntervalo(dtoeducation.getIntervalo());
        education.setDescripcion(dtoeducation.getDescripcion());
        
        EducationService.save(education);
        return new ResponseEntity(new Mensaje("Education actualizada"), HttpStatus.OK);
    }

}
