/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad04.pideDatos;

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
    // Se le pasa un valor máximo y un valor mínimo para que no se pueda introducir un valor fuera de ese rango..
    public static int pideValorMinMax(int valorMin, int valorMax) {
        int valor = 0;

        do {
            valor = pideEntero("Introduce un valor entre " + valorMin + " y " + valorMax);
            if (valor < valorMin || valor > valorMax) {
                System.out.println("Valor incorrecto.");
            }
        } while (valor < valorMin || valor > valorMax);
        return valor;
    }

}
