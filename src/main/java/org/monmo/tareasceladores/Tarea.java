/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.monmo.tareasceladores;

import java.time.LocalDateTime;

public class Tarea {

    private Integer tareaId;
    private Usuario operador;
    private Usuario celador;
    private Integer especialidadId;
    private Integer dependenciaDesdeId;
    private Integer dependenciaHastaId;
    private Integer prioridad;
    private Boolean esAsignada;
    private Boolean esEmpezada;
    private Boolean esFinalizada;
    private LocalDateTime creadaEn;
    private LocalDateTime fechaAsign;
    private LocalDateTime fechaIni;
    private LocalDateTime fechaFin;

    // Constructor sin parámetros
    public Tarea() {
    }
    
    public Tarea(Integer tareaId, Integer prioridad, LocalDateTime creadaEn) {
    this.tareaId = tareaId;
    this.prioridad = prioridad;
    this.creadaEn = creadaEn;
    // Inicializa valores predeterminados o nulos para otros campos si es necesario
}


    // Constructor con parámetros
    public Tarea(Integer tareaId, Usuario operador, Usuario celador, Integer especialidadId,
                 Integer dependenciaDesdeId, Integer dependenciaHastaId, Integer prioridad,
                 Boolean esAsignada, Boolean esEmpezada, Boolean esFinalizada,
                 LocalDateTime creadaEn, LocalDateTime fechaAsign, LocalDateTime fechaIni,
                 LocalDateTime fechaFin) {
        this.tareaId = tareaId;
        this.operador = operador;
        this.celador = celador;
        this.especialidadId = especialidadId;
        this.dependenciaDesdeId = dependenciaDesdeId;
        this.dependenciaHastaId = dependenciaHastaId;
        this.prioridad = prioridad;
        this.esAsignada = esAsignada;
        this.esEmpezada = esEmpezada;
        this.esFinalizada = esFinalizada;
        this.creadaEn = creadaEn;
        this.fechaAsign = fechaAsign;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }


    // Getters y setters
    public Integer getTareaId() {
        return tareaId;
    }

    public void setTareaId(Integer tareaId) {
        this.tareaId = tareaId;
    }

    public Usuario getOperador() {
        return operador;
    }

    public void setOperador(Usuario operador) {
        this.operador = operador;
    }

    public Usuario getCelador() {
        return celador;
    }

    public void setCelador(Usuario celador) {
        this.celador = celador;
    }

    public Integer getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(Integer especialidadId) {
        this.especialidadId = especialidadId;
    }

    public Integer getDependenciaDesdeId() {
        return dependenciaDesdeId;
    }

    public void setDependenciaDesdeId(Integer dependenciaDesdeId) {
        this.dependenciaDesdeId = dependenciaDesdeId;
    }

    public Integer getDependenciaHastaId() {
        return dependenciaHastaId;
    }

    public void setDependenciaHastaId(Integer dependenciaHastaId) {
        this.dependenciaHastaId = dependenciaHastaId;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Boolean getEsAsignada() {
        return esAsignada;
    }

    public void setEsAsignada(Boolean esAsignada) {
        this.esAsignada = esAsignada;
    }

    public Boolean getEsEmpezada() {
        return esEmpezada;
    }

    public void setEsEmpezada(Boolean esEmpezada) {
        this.esEmpezada = esEmpezada;
    }

    public Boolean getEsFinalizada() {
        return esFinalizada;
    }

    public void setEsFinalizada(Boolean esFinalizada) {
        this.esFinalizada = esFinalizada;
    }

    public LocalDateTime getCreadaEn() {
        return creadaEn;
    }

    public void setCreadaEn(LocalDateTime creadaEn) {
        this.creadaEn = creadaEn;
    }

    public LocalDateTime getFechaAsign() {
        return fechaAsign;
    }

    public void setFechaAsign(LocalDateTime fechaAsign) {
        this.fechaAsign = fechaAsign;
    }

    public LocalDateTime getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDateTime fechaIni) {
        this.fechaIni = fechaIni;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "tareaId=" + tareaId +
                ", operador=" + operador +
                ", celador=" + celador +
                ", especialidadId=" + especialidadId +
                ", dependenciaDesdeId=" + dependenciaDesdeId +
                ", dependenciaHastaId=" + dependenciaHastaId +
                ", prioridad=" + prioridad +
                ", esAsignada=" + esAsignada +
                ", esEmpezada=" + esEmpezada +
                ", esFinalizada=" + esFinalizada +
                ", creadaEn=" + creadaEn +
                ", fechaAsign=" + fechaAsign +
                ", fechaIni=" + fechaIni +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
