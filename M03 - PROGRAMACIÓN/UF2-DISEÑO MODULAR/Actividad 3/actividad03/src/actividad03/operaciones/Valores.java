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
public class Valores {
    public static double muestraPI() {
        double numPi = Math.PI;
        return numPi;
    }
    public static double muestraValorAbsoluto() {
        double decim = Math.abs(pideDouble());
        return decim;
    }
    public static int muestraValorAleatorio() {
        int aleatorio = (int) (Math.random()*pideEntero());
        return aleatorio;
    }
  
}
