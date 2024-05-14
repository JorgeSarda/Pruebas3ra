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
class JuegoAdivinarNumero extends Juego {
    @Override
    void jugar() {
        int numeroAdivinar = (int) (Math.random() * 10);
        Scanner scanner = new Scanner(System.in);
        boolean adivinado = false;

        System.out.println("Intenta adivinar el número:");

        
            int intento = scanner.nextInt();

            if (intento == numeroAdivinar) {
                System.out.println("¡Has adivinado el número!");
                adivinado = true;
            } else {
                jugar();
            }
        
    }
}
