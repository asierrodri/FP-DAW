/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad03.operaciones.aritmeticas;

/**
 *
 * @author asier
 */
//Hace operaciones aritméticas.
public class Operaciones {

    //Muestra el logaritmo en base e del número recibido.
    public static void muestraLogaritmo(double valor) {
        double logE = Math.log(valor);
        System.out.println("El logaritmo en base e de " + valor + " es: " + logE);
    }

    //Muestra la potencia de elevar el primer númnero al segundo.
    public static void calculaPotencia(double a, double b) {
        double pot = Math.pow(a, b);
        System.out.println("El resultado de elevar " + a + " a " + b + " es: " + pot);
    }

}
