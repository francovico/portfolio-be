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
public class dtoHass {
    @NotBlank
    private String nombrehass;
    private String puntuacionhass;

    public dtoHass() {
    }

    public dtoHass(String nombrehass, String puntuacionhass) {
        this.nombrehass = nombrehass;
        this.puntuacionhass = puntuacionhass;
    }

    public String getNombrehass() {
        return nombrehass;
    }

    public void setNombrehass(String nombrehass) {
        this.nombrehass = nombrehass;
    }

    public String getPuntuacionhass() {
        return puntuacionhass;
    }

    public void setPuntuacionhass(String puntuacionhass) {
        this.puntuacionhass = puntuacionhass;
    }
    
}
