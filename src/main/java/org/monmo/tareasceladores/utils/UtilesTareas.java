/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.monmo.tareasceladores.utils;

import java.util.ArrayList;
import java.util.List;
import org.monmo.tareasceladores.entities.Usuario;

/**
 *
 * @author 0xjons
 */
public class UtilesTareas {

    private static final int MAX_TAREAS = 3; // Límite de tareas por usuario
    public static final int MAX_PRIORIDAD = 9;
    private static final int MAX_REINTENTOS = 3;

    public UtilesTareas() {
    }

    public static boolean puedeAsignarTarea(Usuario usuario) {
        return usuario.tareasAsignadas < MAX_TAREAS;
    }

    public static void asignarTarea(Usuario usuario) {
        if (puedeAsignarTarea(usuario)) {
            usuario.tareasAsignadas++;
        }
    }

    public void tareaCompletada(Usuario usuario) {
        usuario.tareasAsignadas--;
    }

    // Método para agregar la duración de una tarea específica a la lista correspondiente
    public void agregarTiempoTarea(String tipoEspecialidad, long duracion, Usuario usuario) {
        usuario.tiemposPorTipoDeEspecialidad.putIfAbsent(tipoEspecialidad, new ArrayList<>());
        usuario.tiemposPorTipoDeEspecialidad.get(tipoEspecialidad).add(duracion);
    }

    // Método para obtener el tiempo promedio de duración de las tareas de una especialidad específica
    public double obtenerPromedioTiempo(String tipoEspecialidad, Usuario usuario) {
        List<Long> tiempos = usuario.tiemposPorTipoDeEspecialidad.getOrDefault(tipoEspecialidad, new ArrayList<>());
        return tiempos.stream().mapToLong(Long::longValue).average().orElse(Double.NaN);
    }
}
