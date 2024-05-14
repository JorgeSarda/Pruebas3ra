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
        System.out.println("Bienvenido a los multiples juegos");

        System.out.println("¿Cuántos juegos deseas jugar?");
        int numJuegos = scanner.nextInt();
        scanner.nextLine(); 

        Juego[] juegos = new Juego[numJuegos];

        for (int i = 0; i < numJuegos; i++) {
            System.out.println("Tres en raya o Juego a adivinar (1 = Tres en raya, 2 = Juego a adivinar)");
            int decision = scanner.nextInt();
            scanner.nextLine();

            if (decision == 1) {
                juegos[i] = new Juego3EnRaya();
            } else if (decision == 2) {
                juegos[i] = new JuegoAdivinarNumero();
            } else {
                System.out.println("Opción no válida. Elige de nuevo.");
                i--;
            }
        }

            for (int i = 0; i < numJuegos; i++) {
            juegos[i].jugar();
        }

            System.out.println("Todos los juegos han terminado");
        }

        public static int elegirTamañoTablero(Scanner scanner) {
            int tamaño;
            do {
                System.out.println("Elige el tamaño del tablero (mínimo 3):");
                tamaño = scanner.nextInt();
                scanner.nextLine();
            } while (tamaño < 3);
            return tamaño;
        }
    
}
