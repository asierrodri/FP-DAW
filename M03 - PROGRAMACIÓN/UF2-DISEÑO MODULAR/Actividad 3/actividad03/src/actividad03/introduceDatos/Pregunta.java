/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad03.introduceDatos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author asier
 */
public class Pregunta {
    public static int pideEntero() {
       int  numero;
       
        do {
            System.out.println("Introduce un valor entero, por favor.");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                numero = Integer.parseInt(br.readLine());
                break;
            } catch (Exception e) {
               System.out.println("valor incorrecto.");
            }
        } while (true);
       
    return numero;
    }
    
    public static double pideDouble() {
       double  numero;
       
        do {
            System.out.println("Introduce un valor numérico con decimales, por favor.");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                numero = Double.parseDouble(br.readLine());
                break;
            } catch (Exception e) {
               System.out.println("valor incorrecto.");
            }
        } while (true);
       
    return numero;
    }
}
