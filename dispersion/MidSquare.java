/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispersion;

/**
 *
 * @author DanielSantos
 */
public class MidSquare extends MDispersion {

    public MidSquare() {
        System.out.println("Metodo de MidSquare");
    }

    /*Metodo de MidSquare
        La idea de este metodo es tomar la llave original, elevarla al cuadrado
        pasarla a binario seguido de esto hallar la posicion del bit mas significativo
        "el uno mas a la izquierda" y aplicar la formula para coger el codigo de dispersion
        
        int posBit; //el uno mas a la izquierda
        int n; //numero de bits del codigo de dispersion
        int x= posBit-n/2 //Este me va a dar la posicion en donde debo hallar la posicion desde donde 
        hallare mi codigo
        ahora de derecha a izquierda cuento x  posiciones y desde ahi va a empezar mi codigo de dispersion
        desde la posicion x hasta la posicion x +n va  a ser mi codigo de dispersion
     */
    @Override
    public int getCode(int llave, int n) {
        int llaveAux = llave * llave;  // se eleva llave al cuadrado
        int l = llaveAux;
        int c = 0;
        int aux;
        int MASC = 0x80000000;   //mascara de 32 bits para comparar
        int s = 0;              //valor a retornar
        while ((l & MASC) != MASC) {   //contar el numero de creos despues de la cifra mas significatica de la llave^2 en binario
            l = l << 1;
            c++;
        }
        c = 32 - c;         //cifras de llave^2 en binario
        aux = (c - n) / 2;  //aplicar el metodo corriendo las cifras que sobran desde el menos significaivo
        llaveAux = llaveAux >> aux;
        for (int i = 0; i < n; i++) {  //binario a decimal las n cifras
            if (llaveAux % 2 != 0) {
                s = (int) (s + Math.pow(2, i));
            }
            llaveAux = llaveAux >> 1;
        }
        return s; //solucion
    }


}
