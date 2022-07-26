/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.francovico.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @Autor Franco Vico - Backend para Argentina Programa
 */

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String intervalo;
    private String nombreexperiencia;
    private String descripcionexperiencia;

    public Experiencia() {
    }

    public Experiencia(String nombreexperiencia, String intervalo, String descripcionexperiencia) {
        this.nombreexperiencia = nombreexperiencia;
        this.intervalo = intervalo;
        this.descripcionexperiencia = descripcionexperiencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreexperiencia() {
        return nombreexperiencia;
    }

    public void setNombreexperiencia(String nombreexperiencia) {
        this.nombreexperiencia = nombreexperiencia;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }
    
    public String getDescripcionexperiencia() {
        return descripcionexperiencia;
    }

    public void setDescripcionexperiencia(String descripcionexperiencia) {
        this.descripcionexperiencia = descripcionexperiencia;
    }
  
}
