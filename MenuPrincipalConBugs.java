package org.cuatrovientos.ed.listatareas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase para gestionar el listado de tareas
 */
public class MenuPrincipal {

    private String tema = "black";

    /**
     * Constructor para crear una nueva instancia con un tema en concreto
     * @param tema
     */
    public MenuPrincipal(String tema) {
        this.tema = tema;
    }

    /**
     * Constructor por defecto, pondremos el tema a White
     */
    public MenuPrincipal() {
        this.tema = "white";
    }

    /**
     * Método principal que lanza el menú.
     * @param args
     */
    public static void main(String[] args) {

        ArrayList<String> listaDeTareas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in); // Necesario para recoger una entrada por teclado en la consola
        int opcionElegidaUsuario;

        do {
            mostrarMenuPrincipal();
            while (!scanner.hasNextInt()) { // Validar entrada para evitar errores
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // Descartar la entrada no válida
            }
            opcionElegidaUsuario = scanner.nextInt();
            scanner.nextLine(); // Recoger la información del buffer

            switch (opcionElegidaUsuario) {
                case 1:
                    anadirTareas(listaDeTareas, scanner);
                    break;
                case 2:
                    listarTareas(listaDeTareas);
                    break;
                case 3:
                    listaDeTareas.clear(); // Limpiar la lista en lugar de asignarla a null
                    System.out.println("Lista de tareas borrada.");
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
        } while (opcionElegidaUsuario != 4); // Corregir condición de salida

        scanner.close();
    }

    /**
     * Lista las tareas almacenadas en la lista
     * @param listaDeTareas La lista completa de tareas
     */
    private static void listarTareas(ArrayList<String> listaDeTareas) {
        if (listaDeTareas.isEmpty()) {
            System.out.println("Lista de tareas vacía.");
        } else {
            for (int i = 0; i < listaDeTareas.size(); i++) {
                System.out.println("Tarea " + (i + 1) + ": " + listaDeTareas.get(i));
            }
        }
        System.out.print("Pulse Enter para continuar...");
        new Scanner(System.in).nextLine(); // Crear nuevo scanner para pausar la ejecución
    }

    /**
     * Añade una nueva tarea a la lista
     * @param listaDeTareas La lista completa de tareas
     * @param scanner Para recoger información desde teclado
     */
    private static void anadirTareas(ArrayList<String> listaDeTareas, Scanner scanner) {
        System.out.print("Introduce la descripción de la tarea: ");
        String descripcion = scanner.nextLine();
        if (!descripcion.trim().isEmpty()) { // Validar que la descripción no esté vacía
            listaDeTareas.add(descripcion);
            System.out.println("Tarea añadida correctamente.");
        } else {
            System.out.println("La descripción no puede estar vacía.");
        }
    }

    /**
     * Muestra el menú principal de nuestra lista de tareas
     */
    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Menú de Lista de Tareas ---");
        System.out.println("1. Agregar una tarea");
        System.out.println("2. Mostrar todas las tareas");
        System.out.println("3. Borrar lista de tareas");
        System.out.println("4. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}