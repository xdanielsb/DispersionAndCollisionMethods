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
public class Transformacion extends MDispersion {

    public Transformacion() {
        System.out.println("Metodo de transformacion");
    }

    @Override
    public int getCode(int llave, int n) {
        String b = Integer.toString(llave, n);  // llave en base n como string
        String s = "";  //solucion
        for (int i = 0; i < b.length(); i++) {
            int a = Integer.parseInt(("" + b.charAt(i)), n); //cada digito aparte como decimal
            s = s + Integer.toString(a, 2); //el anterior decimal a binario y se suma
        }
        int a = Integer.parseInt(s, 2);  //binario a decimal
        return a;
    }

}
