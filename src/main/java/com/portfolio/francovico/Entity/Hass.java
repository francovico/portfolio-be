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
public class Hass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombrehass;
    private String puntuacionhass;

    public Hass() {
    }

    public Hass(String nombrehass, String puntuacionhass) {
        this.nombrehass = nombrehass;
        this.puntuacionhass = puntuacionhass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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