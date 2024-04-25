/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba3ra;

/**
 *
 * @author Usuario
 */
public class Juego {
   private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private boolean juegoTerminado;

    public Juego(int tamañoTablero, String nombreJugador1, String nombreJugador2) {
        this.tablero = new Tablero(tamañoTablero);
        this.jugador1 = new Jugador('X', nombreJugador1);
        this.jugador2 = new Jugador('O', nombreJugador2);
        this.juegoTerminado = false;
    }

    

    public void realizarTurno() {
        tablero.mostrarTablero();
        Jugador jugadorActual = tablero.getTurno() == 1 ? jugador1 : jugador2;
        System.out.println("Turno de " + jugadorActual.getNombre() + " (" + jugadorActual.getSimbolo() + ")");
        System.out.println("Elige una fila (0-" + (tablero.getTamaño() - 1) + "):");
        int fila = tablero.getScanner().nextInt();
        System.out.println("Elige una columna (0-" + (tablero.getTamaño() - 1) + "):");
        int columna = tablero.getScanner().nextInt();

        if (tablero.realizarMovimiento(fila, columna, jugadorActual.getSimbolo())) {
            if (tablero.comprobarVictoria(jugadorActual.getSimbolo())) {
                tablero.mostrarTablero();
                System.out.println("¡El jugador " + jugadorActual.getNombre() + " ha ganado!");
                juegoTerminado = true;
            } else if (tablero.tableroLleno()) {
                tablero.mostrarTablero();
                System.out.println("¡Empate! No hay ganador.");
                juegoTerminado = true;
            } else {
                tablero.cambiarTurno();
            }
        } else {
            System.out.println("Movimiento inválido. Intenta de nuevo.");
        }
    }

    public boolean getJuegoTerminado() {
        return juegoTerminado;
    } 
}
