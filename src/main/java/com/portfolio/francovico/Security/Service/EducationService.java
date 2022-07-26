/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.francovico.Security.Service;

import com.portfolio.francovico.Entity.Education;
import com.portfolio.francovico.Repository.IEducationRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @Autor Franco Vico - Backend para Argentina Programa
 */
@Service
@Transactional
public class EducationService {
    @Autowired
    IEducationRepository rEducation;
    
    // Busca todo y devuelve una lista completa de Experiencias.
    public List<Education> list(){
        return rEducation.findAll();
    }
    
    public Optional<Education> getOne(int id){
        return rEducation.findById(id);
    }
    
    //El Optional es porque puede estar o no.
    public Optional<Education> getByinstitucion(String institucion){
        return rEducation.findByinstitucion(institucion);
    }
    
    public void save(Education education){
        rEducation.save(education);
    }
    
    public void delete(int id){
        rEducation.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEducation.existsById(id);
    }
    
    public boolean existsByinstitucion(String institucion){
        return rEducation.existsByinstitucion(institucion);
    }
}
