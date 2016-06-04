/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MColision;

import dispersion.MDispersion;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class DobleHash extends MColision {

    private MDispersion metodo;
    private int llave;
    private int n;
    private int[][] arreglo;
    private ArrayList<Integer> numeros;

    public DobleHash(MDispersion metodo, int n) {
        numeros = new ArrayList<>();
        System.out.println("Doble Hash");
        this.n = n;
        this.metodo = metodo;
        arreglo = new int[3][n];
        for (int i = 0; i < n; i++) {
            arreglo[0][i] = i; //Numero que indica el valor
            arreglo[1][i] = -1; //Posicion que almacena la llave 
            arreglo[2][i] = -1; //Posicion que guarda las referencias
        }

    }

    @Override
    public void newNumber(int num) {
        if (true) {
            int h = metodo.getCode(num, n);
            int fijo = 1 + (num % (n - 2));
            int val = arreglo[1][h];
            if (val == -1) {
                arreglo[1][h] = num;
            } else {
                while (val != -1) {
                    h = metodo.getCode((h + fijo), n);
                    val = arreglo[1][h];
                    if (val == -1) {
                        arreglo[1][h] = num;
                    }
                }
            }
        }
    }

    @Override
    public void mostrarMatrices() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arreglo[i][j] + "\t");
            }
            System.out.println("");
        }

    }

    @Override
    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String matrizToString() {
        String matriz = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                matriz += arreglo[i][j] + "\t";
            }
            matriz += "\n";
        }
        return matriz;
    }

    public void other(int num, int n) {
        int h = metodo.getCode(num, n);
        int fijo = 1 + (num % (n - 2));

        if (arreglo[1][h] == -1) {
            arreglo[1][h] = num;
        }
        while (arreglo[1][h] != -1) {
            if (arreglo[1][h] != h) {
                h = (h + fijo) % n;
            }
            if (arreglo[1][h] == -1) {
                arreglo[1][h] = h;
            }
        }
    }

    public boolean add(int num) {
        for (int i = 0; i < numeros.size(); i++) {
            if (num == numeros.get(i)) {
                return false;
            }
        }
        numeros.add(num);
        return true;
    }

}
