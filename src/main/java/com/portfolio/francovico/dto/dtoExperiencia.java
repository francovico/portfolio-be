/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.francovico.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @Autor Franco Vico - Backend para Argentina Programa
 */
public class dtoExperiencia {
    @NotBlank
    private String nombreexperiencia;
    private String intervalo;
    private String descripcionexperiencia;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreexperiencia, String intervalo, String descripcionexperiencia) {
        this.nombreexperiencia = nombreexperiencia;
        this.intervalo = intervalo;
        this.descripcionexperiencia = descripcionexperiencia;
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
