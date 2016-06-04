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
public class EncademanientoLineal extends MColision {

    private MDispersion metodo;
    private int llave;
    private int n;
    private int[][] arreglo;
    private ArrayList<Integer> numeros;
    private int tam;

    public EncademanientoLineal(MDispersion metodo, int n) {
        numeros = new ArrayList<>();
        this.metodo = metodo;
        System.out.println("Encadeanimiento Lineal " + n);
        this.n = n;

        arreglo = new int[3][n];
        for (int i = 0; i < n; i++) {
            arreglo[0][i] = i; //Numero que indica el valor
            arreglo[1][i] = -1; //Posicion que almacena la llave 
            arreglo[2][i] = -1; //Posicion que guarda las referencias
        }

    }

    @Override
    public void newNumber(int num) {
        if (add(num)) {
            int cod = metodo.getCode(num, n);
            if (arreglo[1][cod] == -1) {
                arreglo[1][cod] = num;
            } else if (arreglo[2][cod] == -1) {
                int x = getPos();
                arreglo[2][cod] = x;
                arreglo[1][x] = num;
            } else {
                int referencia = arreglo[2][cod]; //Referencia al nuevo valor
                int val = 1; //Indica si/no hay valor
                while (val != -1) {
                    val = arreglo[1][referencia]; //Llave que se encuentra en esa posicion
                    if (val == -1) {
                        arreglo[1][referencia] = num;
                        arreglo[2][cod] = referencia;
                    } else {
                        int posx = getPos();
                        referencia = posx;
                        val = arreglo[1][referencia]; ///Corregir esta parte
                    }
                }
            }
        }
    }

    public int getPos() {
        int i = -1, x;
        for (i = n - 1; i >= 0; i--) {
            if (arreglo[1][i] == -1) {
                return i;
            }
        }
        return i;
    }

    @Override
    public void mostrarMatrices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
