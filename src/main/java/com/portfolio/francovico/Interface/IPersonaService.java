/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.francovico.Interface;

import com.portfolio.francovico.Entity.Persona;
import java.util.List;

/**
 *
 * @author franc
 */
public interface IPersonaService {
    // Traer una lista de personas.
    public List<Persona> getPersona();
    
    // Guardar un objeto de tipo persona.
    public void savePersona(Persona persona);
    
    // Eliminar un objeto por ID.
    public void deletePersona(Long id);
    
    // Buscar una persona por ID.
    public Persona findPersona(Long id);
}
