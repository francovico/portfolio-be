/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.francovico.Security.Service;

import com.portfolio.francovico.Entity.About;
import com.portfolio.francovico.Repository.IAboutRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.stereotype.Service;

/**
 *
 * @Autor Franco Vico - Backend para Argentina Programa
 */

@Service
@Transactional
public class AboutService {
    @Autowired
    IAboutRepository rAbout;
    
    public List<About> list(){
        return rAbout.findAll();
    }
    
    public Optional<About> getOne(int id){
        return rAbout.findById(id);
    }
    
    //El Optional es porque puede estar o no.
    public Optional<About> getByAbout(String about){
        return rAbout.findByAbout(about);
    }
    
    public Optional<About> getByJob(String job){
        return rAbout.findByJob(job);
    }    
    
    public void save(About about){
        rAbout.save(about);
    }   
    
    public void delete(int id){
        rAbout.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rAbout.existsById(id);
    }
    
    public boolean existsByAbout(String about){
        return rAbout.existsByAbout(about);
    }
    
    public boolean existsByJob(String job){
    return rAbout.existsByJob(job);
    }
    
}
