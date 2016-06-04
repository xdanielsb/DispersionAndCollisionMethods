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
public class PruebaCuadratico extends MColision {

    private MDispersion metodo;
    private int llave;
    private int n;
    private int[][] arreglo;
    private ArrayList<Integer> numeros;

    public PruebaCuadratico(MDispersion metodo, int n) {
        numeros = new ArrayList<>();
        this.metodo = metodo;
        System.out.println("Prueba Cuadratica");
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
        if (true) {
            int pruebas = (n + 1) / 2;
            int count = 1;
            int h = metodo.getCode(num, n);;
            int k = h;

            int val = arreglo[1][h];
            if (val == -1) {
                arreglo[1][h] = num;
            } else {
                while (val != -1 && count < pruebas) {
                    h = (k + count * count) % n;
                    count++;
                    val = arreglo[1][h];
                    if (arreglo[1][h] == -1) {
                        arreglo[1][h] = num;
                    }
                }
            }

            if (count == pruebas) {
                //HACER EL RE-HAes cambiar el n segun la cantidad 
                //de datos e insertar todos los datos nuevamente, lo cual no 
                //es necesario porque se puede verificar
                //antes de llamar el metodo cuando se lean los numero ****************************************SH que 
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

}
