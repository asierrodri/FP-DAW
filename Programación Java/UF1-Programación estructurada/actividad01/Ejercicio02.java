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
        /*2.1. Para cada tipo de dato simple a�ade dentro de la funci�n main de Ejercicio02
        un comentario indicando el tipo de dato. A dem�s  para cada tipo de dato simple declara
        una variable de ese tipo, as�gnale un valor y muestra un mensaje que explique las
        caracter�sticas del tipo de dato y muestre el valor de la variable.*/
        //Tipo de dato de 8 bits de longitud que muestra dos posibles valores (true o false)
        boolean variableBool = true;
        System.out.println("La variable de tipo boolean muestra valores de true o false y ocupa 8 bits. Ejemplo: "+variableBool);
        //Tipo de dato entero de 8 bits de longitud
        byte variableByte = 5;
        System.out.println("La variable de tipo byte muestra n�meros enteros entre -128 y 127 y ocupa 8 bits. Ejemplo: "+variableByte);
        //Tipo de dato Unicode de 16 bits de longitud
        char variableChar = 'a';
        System.out.println("La variable de tipo char muestra car�cteres Unicode de 16 bits. Ejemplo: "+variableChar);
        //Tipo de dato entero de 16 bits de longitud
        short variableShort = 1200;
        System.out.println("La variable de tipo short muestra n�meros enteros entre -32.768 y 32.767 y ocupa 16 bits. Ejemplo: "+variableShort);
        //Tipo de dato entero de 32 bits de longitud
        int variableInt = 50000;
        System.out.println("La variable de tipo int muestra n�meros enteros entre -2^31 y 2^31 - 1 y ocupa 32 bits. Ejemplo: "+variableInt);
        //Tipo de dato entero de 64 bits de longitud
        long variableLong = 200000000;
        System.out.println("La variable de tipo long muestra n�meros enteros entre -2^63 y 2^63 - 1 y ocupa 64 bits. Ejemplo: "+variableLong);
        //Tipo de dato decimal de 32 bits de longitud
        float variableFloat = 5.8785F;
        System.out.println("La variable de tipo float muestra n�meros decimales con una precisi�n aproximada de 7 d�gitos y ocupa 32 bits. Ejemplo: "+variableFloat);
        //Tipo de dato decimal de 64 bits de longitud
        double variableDouble = 76.9730247230;
        System.out.println("La variable de tipo double muestra n�meros decimales con una precisi�n aproximada de 16 d�gitos y ocupa 64 bits. Ejemplo: "+variableDouble);
        
        /*2.2. Dentro de la clase de nombre Ejercicio02, a�ade un ejemplo de uso de cada uno de
        los operadores aritm�ticos,  relacionales, l�gicos, unitarios y de asignaci�n.Indicando con
        un comentario y con un mensaje por consola cual ser� el resultado de cada uno de ellos. */
        int A = 10;
        int B = 5;
        int result;
        
        System.out.println("Para este ejercicio vamos a trabajar con las variables A y B.");
        System.out.println("A = 10 y B = 5");
        
        System.out.println("--Operadores aritm�ticos binarios--");
        result = A + B;
        System.out.println("El resultado de sumar(+) A y B es: "+ (result));
        
        System.out.println("--Operadores aritm�ticos unitarios--");
        result = A;
        result++;
        System.out.println("El resultado de incrementar en 1(++) el valor de A es: "+ (result));
        
        System.out.println("--Operadores aritm�ticos de asignaci�n--");
        A *= 6;
        System.out.println("El resultado de asignarle a A su valor multiplicado por 6 es: "+ (A));
        
        System.out.println("--Operadores relacionales--");
        System.out.println("El resultado de comparar si B es menor a 15: "+ (B < 15));
        
        System.out.println("--Operadores l�gicos--");
        System.out.println("El resultado de true && false es: "+ (true && false));

    }
    
}
