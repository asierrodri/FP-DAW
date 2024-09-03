/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad03.operaciones.geometricas;

import static actividad03.introduceDatos.Pregunta.pideDouble;

/**
 *
 * @author asier
 */
//Hace operaciones geométricas.
public class Operaciones {

    //Muestra el seno del número pedido.
    public static void muestraSeno() {
        double valor = pideDouble("Indica un valor para mostrar el seno");
        double seno = Math.sin(valor);
        System.out.println("El seno de " + valor + " es " + seno);
    }

    //Muestra el coseno del número pedido.
    public static void muestraCoseno() {
        double valor = pideDouble("Indica un valor para mostrar el coseno");
        double coseno = Math.cos(valor);
        System.out.println("El coseno de " + valor + " es " + coseno);
    }

}
