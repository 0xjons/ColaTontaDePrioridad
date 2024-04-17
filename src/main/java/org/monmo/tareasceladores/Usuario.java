/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.monmo.tareasceladores;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Usuario {

    private Integer id;
    private String nombre;
    private String email;
    private String username;
    private String pass;
    private Integer estatus;
    private Integer online;
    private Date fechaRegistro;
    private Date ultimaConexion;
    private List<Perfil> perfiles;
    
    private int tareasAsignadas; // Contador de tareas asignadas
    private static final int MAX_TAREAS = 3; // Límite de tareas por usuario
    
    
    public boolean puedeAsignarTarea() {
        return this.tareasAsignadas < MAX_TAREAS;
    }

    public void asignarTarea() {
        if (puedeAsignarTarea()) {
            this.tareasAsignadas++;
        }
    }

    public void tareaCompletada() {
        this.tareasAsignadas--;
    }

    public Usuario() {
        this.perfiles = new LinkedList<>();
    }

    public Usuario(String nombre, String email, String username, String password, Integer estatus, Integer online, Date fechaRegistro) {
        this.nombre = nombre;
        this.email = email;
        this.username = username;
        this.pass = password;
        this.estatus = estatus;
        this.online = online;
        this.fechaRegistro = fechaRegistro;
        this.ultimaConexion = new Date();
        this.perfiles = new LinkedList<>();
    }
    

    public void agregarPerfil(Perfil perfil) {
        if (perfiles == null) {
            perfiles = new LinkedList<>();
        }
        perfiles.add(perfil);
    }

    // Getters y setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String password) {
        this.pass = password;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }

    public Date getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", estatus=" + estatus +
                ", online=" + online +
                ", fechaRegistro=" + fechaRegistro +
                ", ultimaConexion=" + ultimaConexion +
                ", perfiles=" + perfiles +
                '}';
    }
}
