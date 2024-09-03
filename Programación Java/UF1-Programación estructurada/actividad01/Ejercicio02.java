/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad01;

/**
 *
 * @author asier
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*2.1. Para cada tipo de dato simple añade dentro de la función main de Ejercicio02
        un comentario indicando el tipo de dato. A demás  para cada tipo de dato simple declara
        una variable de ese tipo, asígnale un valor y muestra un mensaje que explique las
        características del tipo de dato y muestre el valor de la variable.*/
        //Tipo de dato de 8 bits de longitud que muestra dos posibles valores (true o false)
        boolean variableBool = true;
        System.out.println("La variable de tipo boolean muestra valores de true o false y ocupa 8 bits. Ejemplo: "+variableBool);
        //Tipo de dato entero de 8 bits de longitud
        byte variableByte = 5;
        System.out.println("La variable de tipo byte muestra números enteros entre -128 y 127 y ocupa 8 bits. Ejemplo: "+variableByte);
        //Tipo de dato Unicode de 16 bits de longitud
        char variableChar = 'a';
        System.out.println("La variable de tipo char muestra carácteres Unicode de 16 bits. Ejemplo: "+variableChar);
        //Tipo de dato entero de 16 bits de longitud
        short variableShort = 1200;
        System.out.println("La variable de tipo short muestra números enteros entre -32.768 y 32.767 y ocupa 16 bits. Ejemplo: "+variableShort);
        //Tipo de dato entero de 32 bits de longitud
        int variableInt = 50000;
        System.out.println("La variable de tipo int muestra números enteros entre -2^31 y 2^31 - 1 y ocupa 32 bits. Ejemplo: "+variableInt);
        //Tipo de dato entero de 64 bits de longitud
        long variableLong = 200000000;
        System.out.println("La variable de tipo long muestra números enteros entre -2^63 y 2^63 - 1 y ocupa 64 bits. Ejemplo: "+variableLong);
        //Tipo de dato decimal de 32 bits de longitud
        float variableFloat = 5.8785F;
        System.out.println("La variable de tipo float muestra números decimales con una precisión aproximada de 7 dígitos y ocupa 32 bits. Ejemplo: "+variableFloat);
        //Tipo de dato decimal de 64 bits de longitud
        double variableDouble = 76.9730247230;
        System.out.println("La variable de tipo double muestra números decimales con una precisión aproximada de 16 dígitos y ocupa 64 bits. Ejemplo: "+variableDouble);
        
        /*2.2. Dentro de la clase de nombre Ejercicio02, añade un ejemplo de uso de cada uno de
        los operadores aritméticos,  relacionales, lógicos, unitarios y de asignación.Indicando con
        un comentario y con un mensaje por consola cual será el resultado de cada uno de ellos. */
        int A = 10;
        int B = 5;
        int result;
        
        System.out.println("Para este ejercicio vamos a trabajar con las variables A y B.");
        System.out.println("A = 10 y B = 5");
        
        System.out.println("--Operadores aritméticos binarios--");
        result = A + B;
        System.out.println("El resultado de sumar(+) A y B es: "+ (result));
        
        System.out.println("--Operadores aritméticos unitarios--");
        result = A;
        result++;
        System.out.println("El resultado de incrementar en 1(++) el valor de A es: "+ (result));
        
        System.out.println("--Operadores aritméticos de asignación--");
        A *= 6;
        System.out.println("El resultado de asignarle a A su valor multiplicado por 6 es: "+ (A));
        
        System.out.println("--Operadores relacionales--");
        System.out.println("El resultado de comparar si B es menor a 15: "+ (B < 15));
        
        System.out.println("--Operadores lógicos--");
        System.out.println("El resultado de true && false es: "+ (true && false));

    }
    
}
