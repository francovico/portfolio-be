/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.francovico.Controller;

import com.portfolio.francovico.Entity.About;
import com.portfolio.francovico.Security.Controller.Mensaje;
import com.portfolio.francovico.Security.Service.AboutService;
import com.portfolio.francovico.dto.dtoAbout;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
@RequestMapping("about")
@CrossOrigin(origins ="https://portfolio-fe-francovico.herokuapp.com")
@EnableWebSecurity

public class AboutController {
    @Autowired
    AboutService AboutService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<About>> list(){
        List<About> list = AboutService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<About> getById(@PathVariable("id") int id){
        if(!AboutService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        About about = AboutService.getOne(id).get();
        return new ResponseEntity(about, HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!AboutService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        AboutService.delete(id);
        return new ResponseEntity(new Mensaje("Datos eliminados"), HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAbout dtoabout){
        if(StringUtils.isBlank(dtoabout.getAbout()))
            return new ResponseEntity (new Mensaje("El texto es obligatorio"), HttpStatus.BAD_REQUEST);
        if(AboutService.existsByAbout(dtoabout.getAbout()))
            return new ResponseEntity (new Mensaje("El texto no puede ser igual"), HttpStatus.BAD_REQUEST);
        if(AboutService.existsByJob(dtoabout.getJob()))
            return new ResponseEntity (new Mensaje("El texto no puede ser igual"), HttpStatus.BAD_REQUEST);
        About about = new About(dtoabout.getAbout());
        AboutService.save(about);
        
        return new ResponseEntity(new Mensaje("El texto ha sido agregado"), HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAbout dtoabout){
        if(!AboutService.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        if(AboutService.existsByAbout(dtoabout.getAbout()) && AboutService.getByAbout(dtoabout.getAbout()).get().getId() != id)
            return new ResponseEntity(new Mensaje("El texto no puede ser igual"), HttpStatus.BAD_REQUEST);
        if(AboutService.existsByJob(dtoabout.getJob()) && AboutService.getByJob(dtoabout.getJob()).get().getId() != id)
            return new ResponseEntity(new Mensaje("El texto no puede ser igual"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoabout.getAbout()))
            return new ResponseEntity(new Mensaje("El texto es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoabout.getJob()))
            return new ResponseEntity(new Mensaje("El texto es obligatorio"), HttpStatus.BAD_REQUEST);
        
        About about = AboutService.getOne(id).get();
        about.setAbout(dtoabout.getAbout());
        about.setJob(dtoabout.getJob());
        
        AboutService.save(about);
        return new ResponseEntity(new Mensaje("About actualizado"), HttpStatus.OK);
    }
    
}
