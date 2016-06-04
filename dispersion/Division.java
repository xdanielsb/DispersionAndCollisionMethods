/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispersion;

/**
 *
 * @author Daniel
 */
public class Division extends MDispersion{

    public Division() {
        System.out.println("Metodo de Division");
    }

    /*Metodo de division 
       La idea de este metodo es dividir por un numero primo
     */
    @Override
    public int getCode(int llave, int n) {
        return llave % n;
    }
}
