/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MColision;

import dispersion.*;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class EncadenamientoSeparado extends MColision {

    private MDispersion metodo;
    private int llave;
    private int n;
    private int[][] vector; //Cada posicion indica el numero de dispersion
    private int[][] arreglo;
    private ArrayList<Integer> numeros;
    private int tam;

    public EncadenamientoSeparado(MDispersion m, int n) {
        System.out.println("Encadeanimiento Separado");
        System.out.println("--------"+n);
        this.metodo = m;
        tam = 70;
        vector = new int[2][n];
        arreglo = new int[3][tam];
        for (int i = 0; i < n; i++) {
            vector[0][i] = i;
            vector[1][i] = -1;
        }
        for (int i = 0; i < tam; i++) {
            arreglo[0][i] = i;
            arreglo[1][i] = -1;
            arreglo[2][i] = -1;
        }
        numeros = new ArrayList();
    }

    @Override
    public void newNumber(int llave) {
        if (add(llave)) {
            System.out.println("Numero " + llave);
            int cod = metodo.getCode(llave, n); //Halla de codigo de dispersion
            int posx;
            if (vector[1][cod] == -1) { //Se ubica en el vector
                posx = getPos();
                arreglo[1][posx] = llave; //asignamos el numero de al arreglo
                vector[1][cod] = posx; //asignamos la posicion en la que se encuentra el codigo en el arreglo
            } else if (arreglo[2][vector[1][cod]] == -1) {
                posx = getPos();
                arreglo[2][vector[1][cod]] = posx;
                arreglo[1][posx] = llave;
            } else {
                int t = 0, posVal;
                posx = getPos();
                posVal = arreglo[2][vector[1][cod]];
                while (t != -1) {
                    t = arreglo[2][posVal];
                    if (t == -1) {
                        arreglo[2][posVal] = posx;
                        arreglo[1][posx] = llave;
                    }
                    posVal = arreglo[2][posVal];
                }

            }
        } else {
            System.out.println("La llaye existe");
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

    public int getPos() {
        int i = -1, x;
        for (i = 0; i < tam; i++) {
            if (arreglo[1][i] == -1) {
                return i;
            }
        }
        return i;
    }

    @Override
    public void mostrarMatrices() {
        System.out.println("Vector");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(vector[i][j] + "\t");
            }
            System.out.println("");
        }

        System.out.println("Matriz");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arreglo[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Cabezas de las listas");
        System.out.println("Posicion\tCabeza\tLista\n");
        int val, t = 0, tieneHijo, papa;
        String cadena = "";
        boolean entro = false;
        for (int j = 0; j < n; j++) {
            val = vector[1][j];
            if (val != -1) {
                entro = true;
                tieneHijo = arreglo[2][val];//Posicon que identifica si tiene hijos
                papa = arreglo[1][val];
                if (tieneHijo == -1) {//Esto significa que no tiene hijos
                    System.out.print(vector[0][j] + "       \t" + arreglo[0][vector[1][j]] + "     \t" + papa);
                } else { //Aqui tiene hijos
                    cadena += papa + "->";
                    while (tieneHijo != -1) {
                        papa = arreglo[1][tieneHijo]; //valor del hijo
                        cadena += papa + "->";
                        tieneHijo = arreglo[2][tieneHijo];
                    }
                    System.out.print(vector[0][j] + "       \t" + arreglo[0][vector[1][j]] + "     \t" + cadena.substring(0, cadena.length() - 2));
                }
            }
            if (entro) {
                System.out.println("");
                entro = false;
            }
            cadena = "";
        }

    }

    @Override
    public String matrizToString() {
        String matriz = "";
        System.out.println("Vector");
        matriz += "\n";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                matriz += vector[i][j] + "\t";
            }
            matriz += "\n";
        }
        matriz += "\n";
        System.out.println("Matriz");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < tam; j++) {
                matriz += arreglo[i][j] + "\t";
            }
            matriz += "\n";
        }

        matriz += "\nCabezas de las listas";
        matriz += "\nPosicion\tCabeza\tLista";
        matriz += "\n";
        int val, t = 0, tieneHijo, papa;
        String cadena = "";
        boolean entro = false;
        for (int j = 0; j < n; j++) {
            val = vector[1][j];
            if (val != -1) {
                entro = true;
                tieneHijo = arreglo[2][val];//Posicon que identifica si tiene hijos
                papa = arreglo[1][val];
                if (tieneHijo == -1) {//Esto significa que no tiene hijos
                    matriz += vector[0][j] + "       \t" + arreglo[0][vector[1][j]] + "     \t" + papa;
                } else { //Aqui tiene hijos
                    cadena += papa + "->";
                    while (tieneHijo != -1) {
                        papa = arreglo[1][tieneHijo]; //valor del hijo
                        cadena += papa + "->";
                        tieneHijo = arreglo[2][tieneHijo];
                    }

                    matriz += vector[0][j] + "       \t" + arreglo[0][vector[1][j]] + "     \t" + cadena.substring(0, cadena.length() - 2);
                }
            }
            if (entro) {
                matriz += "\n";
                entro = false;
            }
            cadena = "";
        }
        return matriz;
    }

    @Override
    public void setN(int n) {
        this.n = n;
    }

}
