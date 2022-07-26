/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.francovico.Repository;

import com.portfolio.francovico.Entity.About;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @Autor Franco Vico - Backend para Argentina Programa
 */
@Repository
public interface IAboutRepository extends JpaRepository<About, Integer>{
    public Optional<About> findByAbout(String about);
    public Optional<About> findByJob(String job);
    public boolean existsByAbout(String about);
    public boolean existsByJob(String job);
}