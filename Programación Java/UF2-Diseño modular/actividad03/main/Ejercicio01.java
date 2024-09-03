/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad03.main;

import static actividad03.introduceDatos.Pregunta.*;
import static actividad03.operaciones.OperacionesLinkia.convertirLinkiaCoins;
import static actividad03.operaciones.Valores.*;
import static actividad03.operaciones.aritmeticas.Operaciones.*;
import static actividad03.operaciones.geometricas.Operaciones.*;

/**
 *
 * @author asier
 */
public class Ejercicio01 {
// Clase principal.

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Tiene que elegir una de las 8 opciones o el 0 para salir y si pone cualquier otra cosa da un valor incorrecto y vuelve a pedirlo.
        int numero;
        do {
            System.out.println("Indica la opción del siguiente menú de opciones:\n");
            System.out.println("1- Convertir a LinkiaCoin");
            System.out.println("2- Muestra el valor de PI");
            System.out.println("3- Muestra el valor absoluto");
            System.out.println("4- Muestra un valor aleatorio");
            System.out.println("5- Muestra el logaritmo en base E");
            System.out.println("6- Muestra el resultado de elevar A a B");
            System.out.println("7- Muestra el Seno de un valor");
            System.out.println("8- Muestra el Coseno de un valor");
            System.out.println("0- Finalizar.\n");
            do {
                numero = pideEntero("Introduce una de las opciones");
                if (numero > 8 || numero < 0) {
                    System.out.println("Valor incorrecto.");
                }
            } while (numero > 8 || numero < 0);
            switch (numero) {
                case 1 -> {
                    convertirLinkiaCoins();
                    break;
                }
                case 2 -> {
                    muestraPI();
                    break;
                }
                case 3 -> {
                    muestraValorAbsoluto();
                    break;
                }
                case 4 -> {
                    muestraValorAleatorio();
                    break;
                }
                case 5 -> {
                    muestraLogaritmo(pideDouble("Indica el valor para mostrar su logaritmo en base e"));
                    break;
                }
                case 6 -> {
                    calculaPotencia(pideDouble("Indica el valor de A"), pideDouble("Indica el valor de B"));
                    break;
                }
                case 7 -> {
                    muestraSeno();
                    break;
                }
                case 8 -> {
                    muestraCoseno();
                    break;
                }
                case 0 -> {
                    System.out.println("Gracias por participar.");
                    break;
                }
            }
        } while (numero != 0);

    }

}
