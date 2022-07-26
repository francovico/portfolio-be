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
public class dtoAbout {
    @NotBlank
    private String about;

    public dtoAbout() {
    }

    public dtoAbout(String about) {
        this.about = about;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
    
}