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
public class Plegamiento extends MDispersion{

    public Plegamiento() {
        System.out.println("Metodo de Plegamiento");
    }

    @Override
    public int getCode(int llave, int n) {
        String b = Integer.toString(llave, 2);
        int num = b.length() / n; //Este es el numero de grupos
        int num1 = -1, num2 = -1;
        if (b.length() >= n) {
            num1 = Integer.parseInt(b.substring(b.length() - n, b.length()), 2);
            b = b.substring(0, b.length() - n);
        } else {
            return llave;
        }
        for (int i = 0; i <= num - 1; i++) {
            if (b.length() >= n) {
                num2 = Integer.parseInt(b.substring(b.length() - n, b.length()), 2);
                b = b.substring(0, b.length() - n);
                num1 = num1 ^ num2;
            } else {
                num2 = Integer.parseInt(b, 2);
                num1 = num1 ^ num2;
                break;
            }
        }
        return num1;
    }

}
