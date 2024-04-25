/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba3ra;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Prueba3ra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido a la suite de juegos!");

        System.out.println("¿Cuántos juegos deseas jugar?");
        int numJuegos = scanner.nextInt();
        scanner.nextLine(); // Consumir el carácter de nueva línea restante

        Juego[] juegos = new Juego[numJuegos];

        for (int i = 0; i < numJuegos; i++) {
            System.out.println("Configuración del Juego " + (i + 1));
            int tamañoTablero = elegirTamañoTablero(scanner);
            System.out.println("Introduce el nombre del Jugador 1 para este juego:");
            String nombreJugador1 = scanner.nextLine();
            System.out.println("Introduce el nombre del Jugador 2 para este juego:");
            String nombreJugador2 = scanner.nextLine();
            juegos[i] = new Juego(tamañoTablero, nombreJugador1, nombreJugador2);
        }

        // Jugar todos los juegos simultáneamente
        boolean juegosActivos = true;
        while (juegosActivos) {
            juegosActivos = false;
            for (Juego juego : juegos) {
                if (!juego.getJuegoTerminado()) {
                    juegosActivos = true;
                    juego.realizarTurno();
                }
            }
        }
        System.out.println("¡Todos los juegos han terminado!");
    }
    public static int elegirTamañoTablero(Scanner scanner) {
        int tamaño;
        do {
            System.out.println("Elige el tamaño del tablero (mínimo 3):");
            tamaño = scanner.nextInt();
            scanner.nextLine(); // Consumir el carácter de nueva línea restante
        } while (tamaño < 3);
        return tamaño;
    }

}
