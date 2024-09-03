/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad03.operaciones;

import static actividad03.introduceDatos.Pregunta.pideDouble;

/**
 *
 * @author asier
 */
//Convierte el valor pedido en LinkiaCoins.
public class OperacionesLinkia {

    //Multiplica el número x1.5.
    public static void convertirLinkiaCoins() {
        double numero = pideDouble("Introduce un valor con decimales para convertirlo a LinkiaCoins");
        double coins = numero * 1.5;
        System.out.println("El valor " + numero + " son " + coins + " LinkiaCoins");
    }

}
