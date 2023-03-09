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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
            
            numero = pideEntero();
            if (numero > 8 || numero < 0){
                System.out.println("Valor incorrecto.");
            }
            
            switch (numero) {
                case 1 -> {
                    System.out.println(convertirLinkiaCoins());
                }
                case 2 -> {
                    System.out.println(muestraPI());
                }
                case 3 -> {
                    System.out.println(muestraValorAbsoluto());
                }                
                case 4 -> {
                    System.out.println(muestraValorAleatorio());
                }                
                case 5 -> {
                    System.out.println(muestraLogaritmo());
                }                
                case 6 -> {
                    System.out.println(calculaPotencia());
                }                
                case 7 -> {
                    System.out.println(muestraSeno());
                }                
                case 8 -> {
                    System.out.println(muestraCoseno());
                }                
                case 0 -> {
                    System.out.println("Gracias por participar.");
                }                
            }
        }while (numero != 0);
        
    }
    
}
