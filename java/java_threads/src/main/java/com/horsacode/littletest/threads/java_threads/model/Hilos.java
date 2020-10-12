package com.horsacode.littletest.threads.java_threads.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "threads", schema = "public")
public class Hilos {

    @Column(name = "nombreProyecto")
    private String nombreProyecto;

    @Column(name = "foliosSimultaneos")
    private Integer foliosSimultaneos;

    @Column(name = "hilosPorFolio")
    private Integer hilosPorFolio;

    @Id
    @Column(name = "idProyecto")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProyecto;

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Integer getFoliosSimultaneos() {
        return foliosSimultaneos;
    }

    public void setFoliosSimultaneos(Integer foliosSimultaneos) {
        this.foliosSimultaneos = foliosSimultaneos;
    }

    public Integer getHilosPorFolio() {
        return hilosPorFolio;
    }

    public void setHilosPorFolio(Integer hilosPorFolio) {
        this.hilosPorFolio = hilosPorFolio;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

}