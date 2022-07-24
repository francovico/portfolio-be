/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.francovico.Repository;

import com.portfolio.francovico.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author franc
 */

@Repository
public interface IEducationRepository extends JpaRepository<Education, Integer>{
    public Optional<Education> findByinstitucion(String institucion);
    public boolean existsByinstitucion(String institucion);
}
