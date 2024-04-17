/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.monmo.tareasceladores.queue;

/**
 *
 * @author 0xjons
 */
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import org.monmo.tareasceladores.Tarea;
import org.monmo.tareasceladores.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SistemaDeTareas {

    private static final Logger logger = LoggerFactory.getLogger(SistemaDeTareas.class);

    private static final int MAX_PRIORIDAD = 9;
    private static final int MAX_REINTENTOS = 3;

    private PriorityQueue<Tarea> colaDeTareas;
    private Queue<Tarea> tareasEnEspera;
    private List<Usuario> usuarios;
    private int indexUsuarioActual = 0;  // Para la asignación round-robin
    private Map<Usuario, Integer> estadisticasDeAsignacion;

    public SistemaDeTareas(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        this.colaDeTareas = new PriorityQueue<>(Comparator.comparingInt(Tarea::getPrioridad).reversed());
        this.tareasEnEspera = new LinkedList<>();
        this.estadisticasDeAsignacion = new HashMap<>();
        for (Usuario usuario : usuarios) {
            estadisticasDeAsignacion.put(usuario, 0);
        }
    }

    public void agregarTarea(Tarea tarea) {
        colaDeTareas.offer(tarea);
        logger.info("Tarea agregada con ID {} y prioridad inicial {}", tarea.getTareaId(), tarea.getPrioridad());
    }

    public void ajustarPrioridades() {
        List<Tarea> tareasTemporales = new ArrayList<>();
        LocalDateTime ahora = LocalDateTime.now();
        while (!colaDeTareas.isEmpty()) {
            Tarea tarea = colaDeTareas.poll();
            long minutosDesdeCreacion = ChronoUnit.MINUTES.between(tarea.getCreadaEn(), ahora);
            if (minutosDesdeCreacion > 30 && tarea.getPrioridad() < MAX_PRIORIDAD) {
                int nuevaPrioridad = Math.min(tarea.getPrioridad() + 1, MAX_PRIORIDAD);
                tarea.setPrioridad(nuevaPrioridad);
                logger.debug("Prioridad incrementada para tarea ID {} a {}", tarea.getTareaId(), nuevaPrioridad);
            }
            tareasTemporales.add(tarea);
        }
        colaDeTareas.addAll(tareasTemporales);
        logger.info("Prioridades ajustadas para todas las tareas en cola.");
    }

    public void procesarTareas() {
        logger.info("Comenzando procesamiento de tareas...");
        ajustarPrioridades();
        while (!colaDeTareas.isEmpty()) {
            Tarea tareaActual = colaDeTareas.poll();
            if (!asignarTarea(tareaActual)) {
                tareasEnEspera.add(tareaActual);
                logger.info("Tarea ID {} puesta en espera.", tareaActual.getTareaId());
            }
        }
        if (!tareasEnEspera.isEmpty()) {
            reintentoAsignarTareas();
        }
        logger.info("Procesamiento de tareas completado.");
    }

    private boolean asignarTarea(Tarea tarea) {
        int intentos = 0;
        while (intentos < usuarios.size()) {
            Usuario usuario = usuarios.get(indexUsuarioActual);
            indexUsuarioActual = (indexUsuarioActual + 1) % usuarios.size();
            intentos++;

            if (usuario.getOnline() == 1 && usuario.puedeAsignarTarea()) {
                logger.info("Asignando tarea ID {} con prioridad {} a {}", tarea.getTareaId(), tarea.getPrioridad(), usuario.getNombre());
                usuario.asignarTarea();
                int conteo = estadisticasDeAsignacion.get(usuario) + 1;
                estadisticasDeAsignacion.put(usuario, conteo);
                return true;
            }
        }
        logger.warn("No se pudo asignar la tarea ID {} después de {} intentos.", tarea.getTareaId(), intentos);
        return false;
    }

    private void reintentoAsignarTareas() {
        logger.info("Reintentando asignar tareas en espera...");
        int sizeInicial = tareasEnEspera.size();
        for (int i = 0; i < sizeInicial; i++) {
            Tarea tarea = tareasEnEspera.poll();
            if (!asignarTarea(tarea)) {
                tareasEnEspera.add(tarea);
            }
        }
        logger.info("Reintento completado. Tareas aún en espera: {}", tareasEnEspera.size());
    }

    public void mostrarEstadisticas() {
        logger.info("Mostrando estadísticas de asignación de tareas...");
        for (Map.Entry<Usuario, Integer> entrada : estadisticasDeAsignacion.entrySet()) {
            logger.info("Usuario {} : {} tareas asignadas", entrada.getKey().getNombre(), entrada.getValue());
        }
        logger.info("Total de tareas aún en espera: {}", tareasEnEspera.size());
    }



}
