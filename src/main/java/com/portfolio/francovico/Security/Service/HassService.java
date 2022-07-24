/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.francovico.Security.Service;

import com.portfolio.francovico.Entity.Hass;
import com.portfolio.francovico.Repository.IHassRepository;
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
public class HassService {
    @Autowired
    IHassRepository rHass;
    
    // Busca todo y devuelve una lista completa de Experiencias.
    public List<Hass> list(){
        return rHass.findAll();
    }
    
    public Optional<Hass> getOne(int id){
        return rHass.findById(id);
    }
    
    //El Optional es porque puede estar o no.
    public Optional<Hass> getBynombrehass(String nombrehass){
        return rHass.findBynombrehass(nombrehass);
    }
    
    public void save(Hass hass){
        rHass.save(hass);
    }
    
    public void delete(int id){
        rHass.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHass.existsById(id);
    }
    
    public boolean existsBynombrehass(String nombrehass){
        return rHass.existsBynombrehass(nombrehass);
    }
}