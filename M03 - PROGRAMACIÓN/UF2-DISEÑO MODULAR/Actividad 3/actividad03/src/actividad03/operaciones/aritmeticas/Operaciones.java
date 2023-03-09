/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad03.operaciones.aritmeticas;

import static actividad03.introduceDatos.Pregunta.pideDouble;

/**
 *
 * @author asier
 */
public class Operaciones {
    public static double muestraLogaritmo() {
        double logE = Math.log(pideDouble());
        return logE;
    }
    public static double calculaPotencia() {
        double pot = Math.pow(pideDouble(), pideDouble());
        return pot;
    }
    
}
