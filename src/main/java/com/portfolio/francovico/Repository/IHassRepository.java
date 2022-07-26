/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.francovico.Repository;

import com.portfolio.francovico.Entity.Hass;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @Autor Franco Vico - Backend para Argentina Programa
 */

@Repository
public interface IHassRepository extends JpaRepository<Hass, Integer>{
    public Optional<Hass> findBynombrehass(String nombrehass);
    public boolean existsBynombrehass(String nombrehass);
}
