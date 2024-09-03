/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad05.ejercicio01.cuentaCorriente;

import java.util.Scanner;

/**
 *
 * @author asier
 */
public class Utilidades {

    private static Scanner sc = new Scanner(System.in);

    public static int pedirEntero(String pregunta) {
        int num;

        do {
            System.out.println(pregunta);
            String entrada = sc.nextLine();
            try {
                num = Integer.parseInt(entrada);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: debes introducir un número entero válido.");
            }
        } while (true);
        return num;
    }

    public static double pedirDecimal(String pregunta) {
        double num;

        do {
            System.out.println(pregunta);
            String entrada = sc.nextLine();
            try {
                num = Double.parseDouble(entrada);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: debes introducir un número decimal válido.");
            }
        } while (true);
        return num;
    }
}
