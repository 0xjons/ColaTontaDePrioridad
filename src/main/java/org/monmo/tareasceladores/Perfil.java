/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.monmo.tareasceladores;

/**
 *
 * @author 0xjons
 */
public final class Perfil {

    private Integer id;
    private String nombre;
    private String info;

    public Perfil() {
        // Constructor vacío por defecto
    }

    public Perfil(Integer id) {
        this.id = id;
        this.nombre = "Nombre por defecto";
        this.info = "Info por defecto";
    }
    
    public Perfil(String perfil) {
        this.nombre = perfil;
        // Inicializar id y info con valores por defecto si es necesario
        this.id = null; // o un valor adecuado
        this.info = "Info por defecto";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Perfil [id=" + id + ", nombre=" + nombre + ", info=" + info + "]";
    }
}
