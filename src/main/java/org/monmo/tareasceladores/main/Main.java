/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.monmo.tareasceladores.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.monmo.tareasceladores.entities.Tarea;
import org.monmo.tareasceladores.entities.Usuario;
import org.monmo.tareasceladores.queue.SistemaDeTareas;

/**
 *
 * @author 0xjons
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>(Arrays.asList(
                new Usuario("Usuario1", "email1@example.com", "user1", "password1", 1, 1, new Date()),
                new Usuario("Usuario2", "email2@example.com", "user2", "password2", 1, 0, new Date()),
                new Usuario("Usuario3", "email3@example.com", "user3", "password3", 1, 0, new Date()), // Inicialmente offline
                new Usuario("Usuario4", "email4@example.com", "user4", "password4", 1, 0, new Date()), // Inicialmente offline
                new Usuario("Usuario5", "email5@example.com", "user5", "password5", 1, 0, new Date()), // Inicialmente offline
                new Usuario("Usuario6", "email6@example.com", "user6", "password6", 1, 1, new Date()),
                new Usuario("Usuario7", "email7@example.com", "user7", "password7", 1, 1, new Date()),
                new Usuario("Usuario8", "email8@example.com", "user8", "password8", 1, 1, new Date())
        ));

        SistemaDeTareas sistema = new SistemaDeTareas(usuarios);
        Random rand = new Random();
        // Agregamos una cantidad significativa de tareas para asegurar que la cola de espera se utilice
        for (int i = 1; i <= 20; i++) {
            sistema.agregarTarea(new Tarea(i, rand.nextInt(10) + 1, LocalDateTime.now()));  // Prioridades entre 1 y 10
        }

        // Primer procesamiento de tareas
        sistema.procesarTareas();
        sistema.mostrarEstadisticas();  // Mostrar estadísticas después del primer procesamiento

        // Cambiar el estado de algunos usuarios a online y procesar tareas nuevamente
        usuarios.get(2).setOnline(1);  // Usuario3 ahora está online
        usuarios.get(3).setOnline(1);  // Usuario4 ahora está online
        usuarios.get(4).setOnline(1);  // Usuario5 ahora está online

        System.out.println("\nDespués de cambiar el estado de algunos usuarios a online:");
        sistema.procesarTareas();  // Segundo procesamiento para reasignar tareas en espera
        sistema.mostrarEstadisticas();  // Mostrar estadísticas finales
    }
}
