/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.francovico.Security.Service;

import com.portfolio.francovico.Entity.Experiencia;
import com.portfolio.francovico.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franc
 */
@Service
@Transactional
public class ExperienciaService {
    @Autowired
    IExperienciaRepository rExperiencia;
    
    // Busca todo y devuelve una lista completa de Experiencias.
    public List<Experiencia> list(){
        return rExperiencia.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return rExperiencia.findById(id);
    }
    
    //El Optional es porque puede estar o no.
    public Optional<Experiencia> getBynombreexperiencia(String nombreexperiencia){
        return rExperiencia.findBynombreexperiencia(nombreexperiencia);
    }
    
    public void save(Experiencia experiencia){
        rExperiencia.save(experiencia);
    }
    
    public void delete(int id){
        rExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExperiencia.existsById(id);
    }
    
    public boolean existsBynombreexperiencia(String nombreexperiencia){
        return rExperiencia.existsBynombreexperiencia(nombreexperiencia);
    }
}
