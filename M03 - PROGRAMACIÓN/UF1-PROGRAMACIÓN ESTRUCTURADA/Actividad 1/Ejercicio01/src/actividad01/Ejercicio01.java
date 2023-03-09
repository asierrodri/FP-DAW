/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author asier
 */
public class Ejercicio01 {
    public static void main(String[] args) throws IOException {
        int manzanas_tienda;
        int manzanas_queremos_comprar;
        double precio_manzana;
        double dinero_pagado;

        manzanas_tienda = 20;
        manzanas_queremos_comprar = 2;
        precio_manzana = 0.40;

        System.out.println("En la tienda tenemos " + manzanas_tienda + " manzanas");
        System.out.println("Vamos a comprar " + manzanas_queremos_comprar + " manzanas");
        // modificamos el contenido de las variables numericas para representar la
        // compra de manzanas
        dinero_pagado = precio_manzana * manzanas_queremos_comprar;
        manzanas_tienda = manzanas_tienda - manzanas_queremos_comprar;

        // mostramos por consola el valor de las variables numericas. De forma implícita
        // se convierte de de numero a string.
        System.out.println("Nos han costado:" + dinero_pagado);
        System.out.println("En la tienda quedan " + manzanas_tienda + " manzanas");

        System.out.println("Quantas mazanas más quieres comprar?");
        // Declaramos una variable compleja de nombre "br" y de tipo "BufferedReader".
        // Las variables del tipo "BufferedReader" contienen funciones para leer datos
        // por consola
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // utilizamos la función "readLine" de la variable "br" para leer un dato por
        // consola. Guardamos el número introducido en la variable "valor_escrito"
        String valor_escrito = br.readLine();

        /*
         * Convertimos mediante una conversion explicita la variable "valor_escrito" a
         * un valor entero para poder operar con él y lo almacenamos en la variable
         */
        manzanas_queremos_comprar = Integer.parseInt(valor_escrito);

        System.out.println("Vamos a comprar " + manzanas_queremos_comprar + " manzanas");
        // modificamos el contenido de las variables numericas para representar la
        // compra de manzanas
        dinero_pagado = precio_manzana * manzanas_queremos_comprar;
        manzanas_tienda = manzanas_tienda - manzanas_queremos_comprar;
        // mostramos por consola el valor de las variables numericas. De forma implícita
        // se convierte de de numero a string.
        System.out.println("Nos han costado:" + dinero_pagado);
        System.out.println("En la tienda quedan " + manzanas_tienda + " manzanas");

        int mangos_tienda = 30;
        int mangos_queremos_comprar;
        double precio_mangos = 2;  
        
        // 1.2.1. Un mensaje indicando que quedan 30 mangos a 2? la unidad.
        System.out.println("En la tienda tenemos " + mangos_tienda + " mangos a " + precio_mangos + "? la unidad");
        // 1.2.1. Un mensaje indicando que quedan 30 mangos a 2? la unidad.
        System.out.println("¿Cuántos mangos quieres comprar?");
        
        // 1.2.3. El código que reciba del usuario el número de mangos que quiere comprar y muestre el coste total con decimales.
        br = new BufferedReader(new InputStreamReader(System.in));
        
        valor_escrito = br.readLine();
        
        mangos_queremos_comprar = Integer.parseInt(valor_escrito);
        
        // 1.2.4. Un mensaje indicando el total de mangos que quedan en la tienda. 
        System.out.println("Vamos a comprar " + mangos_queremos_comprar + " mangos");
        
        dinero_pagado = precio_mangos * mangos_queremos_comprar;
        mangos_tienda -= mangos_queremos_comprar;
        
        System.out.println("Nos han costado: " + dinero_pagado + "?");
        System.out.println("En la tienda quedan " + mangos_tienda + " mangos");
    }
    
}
