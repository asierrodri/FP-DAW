/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad03.operaciones;

import static actividad03.introduceDatos.Pregunta.pideDouble;
import static actividad03.introduceDatos.Pregunta.pideEntero;

/**
 *
 * @author asier
 */
//Muestra los valores de PI, valor absoluto yun valor aleatorio.
public class Valores {

    //Muestra el n�mero PI.
    public static void muestraPI() {
        double numPi = Math.PI;
        System.out.println("El n�mero PI es: " + numPi);
    }

    //Muestra el valor absoluto del n�mero pedido.
    public static void muestraValorAbsoluto() {
        double decim = (pideDouble("Introduce un n�mero para mostrar su valor absoluto"));
        double abs = Math.abs(decim);
        System.out.println("El valor absoluto de " + decim + " es: " + abs);
    }

    //Muestra un valor aleatorio entre cero y el n�mero pedido.
    public static void muestraValorAleatorio() {
        int maximo = pideEntero("Introduce un valor m�ximo del n�mero aleatorio");
        int aleatorio = (int) (Math.random() * maximo);
        System.out.println("El valor aleatorio con un m�ximo de " + maximo + " es: " + aleatorio);
    }

}
