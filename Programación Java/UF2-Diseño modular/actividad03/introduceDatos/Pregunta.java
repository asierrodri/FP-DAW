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
//Esta clase pide un entero o un double.
public class Pregunta {

    // Pide un número entero que no puede tener decimales ni ser un carácter que no sea un entero.
    public static int pideEntero(String pregunta) {
        int numero;

        do {
            System.out.println(pregunta);
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

    // Pide un número decimal y no puede ser ningún otro carácter.
    public static double pideDouble(String pregunta) {
        double numero;

        do {
            System.out.println(pregunta);
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
