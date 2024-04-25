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
public class Tablero {

    private char[][] tablero;
    private int tamaño;
    private int turno;
    private Scanner scanner;

    public Tablero(int tamaño) {
        this.tamaño = tamaño;
        this.tablero = new char[tamaño][tamaño];
        inicializarTablero();
        this.turno = 1;
        this.scanner = new Scanner(System.in);
    }

    private void inicializarTablero() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public void mostrarTablero() {
        System.out.println("  0 1 2");
        System.out.println(" -------");
        for (int i = 0; i < tamaño; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < tamaño; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean realizarMovimiento(int fila, int columna, char jugador) {
        if (fila >= 0 && fila < tamaño && columna >= 0 && columna < tamaño && tablero[fila][columna] == ' ') {
            tablero[fila][columna] = jugador;
            return true;
        } else {
            return false;
        }
    }

    public boolean comprobarVictoria(char jugador) {
        // Comprobar filas
        for (int i = 0; i < tamaño; i++) {
            boolean filaCompleta = true;
            for (int j = 0; j < tamaño; j++) {
                if (tablero[i][j] != jugador) {
                    filaCompleta = false;
                }
            }
            if (filaCompleta) {
                return true;
            }
        }
        // Comprobar columnas
        for (int i = 0; i < tamaño; i++) {
            boolean columnaCompleta = true;
            for (int j = 0; j < tamaño; j++) {
                if (tablero[j][i] != jugador) {
                    columnaCompleta = false;
                }
            }
            if (columnaCompleta) {
                return true;
            }
        }
        // Comprobar diagonales
        for (int i = 0; i < tamaño - 2; i++) {
            for (int j = 0; j < tamaño - 2; j++) {
                if (tablero[i][j] != ' ' && tablero[i][j] == tablero[i + 1][j + 1] && tablero[i][j] == tablero[i + 2][j + 2]) {
                    return true;
                }
            }
        }
        // Comprobar diagonales inversas
        for (int i = 2; i < tamaño; i++) {
            for (int j = 0; j < tamaño - 2; j++) {
                if (tablero[i][j] != ' ' && tablero[i][j] == tablero[i - 1][j + 1] && tablero[i][j] == tablero[i - 2][j + 2]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean tableroLleno() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void cambiarTurno() {
        turno = (turno % 2) + 1; // Alternar entre jugador 1 y jugador 2
    }

    public int getTamaño() {
        return tamaño;
    }

    public int getTurno() {
        return turno;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
