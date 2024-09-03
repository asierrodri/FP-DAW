/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad05.ejercicio02;

import java.util.Scanner;

/**
 *
 * @author asier
 */
public class Heladeria {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comida[] pedido = new Comida[4];

        // El numero de loteria "119383939" de 3.5?
        pedido[0] = new Loteria("119383939", 3.5);

        // Una horchata de 250ml, 20kcal, 30% de chufa y 2.5?.
        pedido[1] = new Horchata("Horchata", 2.5, 250, 30);

        // Un cucurucho de galleta de 20kcal y precio 1?. 
        // El cucurucho tiene dos sabores: de vainilla y de chocolate.
        Cucurucho cucurucho1 = new Cucurucho("Cucurucho de galleta", 1, 2);
        cucurucho1.addBolaHelado(new SaborHelado("Vainilla", 15, "Azúcar", 1), 0);
        cucurucho1.addBolaHelado(new SaborHelado("Chocolate", 15, "Aspartamo", 1), 1);
        pedido[2] = cucurucho1;

        // Un cucurucho de galleta de chocolate de 25kcal y precio 1.5?. 
        // El cucurucho tiene dos sabores: de cookies y de fresa.
        Cucurucho cucurucho2 = new Cucurucho("Cucurucho de galleta de chocolate", 1.5, 2);
        cucurucho2.addBolaHelado(new SaborHelado("Cookies", 20, "Azúcar", 1.25), 0);
        cucurucho2.addBolaHelado(new SaborHelado("Fresa", 5, "Aspartamo", 1), 1);
        pedido[3] = cucurucho2;

        boolean salir = false;

        do {
            // Mostrar el pedido actual
            for (Comida comida : pedido) {
                System.out.println(comida.toString());
                System.out.println("--------------------------------------------------");
            }
            double precioTotalPedido = 0;
            for (int i = 0; i < pedido.length; i++) {
                precioTotalPedido += pedido[i].getPrecio();
            }

            System.out.println("Precio total del pedido: " + precioTotalPedido + " euros");

            // Preguntar al dependiente si desea sustituir un elemento del pedido
            System.out.println("\n¿Desea sustituir algún elemento del pedido por una horchata personalizada?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            int opcion = sc.nextInt();

            if (opcion == 1) {
                // Pedir los valores personalizados para la horchata
                System.out.println("\nIntroduzca los valores para la horchata personalizada:");
                System.out.print("Nombre: ");
                String nombre = sc.next();
                System.out.print("Precio: ");
                double precio = sc.nextDouble();
                System.out.print("Cantidad: ");
                int cantidad = sc.nextInt();
                System.out.print("Porcentaje de chufa: ");
                int porcentajeChufa = sc.nextInt();

                // Sustituir el elemento del pedido por la horchata personalizada
                pedido[1] = new Horchata(nombre, precio, cantidad, porcentajeChufa);
            } else if (opcion == 2) {
                salir = true;
            } else {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (!salir);
    }
}
