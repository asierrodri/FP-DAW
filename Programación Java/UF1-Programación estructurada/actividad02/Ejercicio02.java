/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author asier
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        // Declaramos todas las variables fuera del Do/While para que el valor no vuelva a cero cada vez que re repite el bucle.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String  [][] asignaturas = {{"M01","8","5","10"},{"M02","3","8","9"},{"M03","9","7","6"},{"M04","10","4","9"}};
        //String [] materia = {"M01","M02","M03","M04"}; Si los valores pudiesen ser numeros y no Strings, hacer este array me parecía más sencillo para desarrollar el programa.
        int opcion_numero = 0;
        int asignatura_numero = 0;
        int valor_numero = 0;
        double  nueva_nota = 0;
        double  num_min;
        int x;
        int y;
        boolean continua;

        //Mostramos los valores iniciales del array
        System.out.println("Los valores del array bidimensional son:");
        for (x = 0; x < asignaturas.length; x++){
            //System.out.print(materia[x] + " ");
            for (y = 0; y < asignaturas[x].length; y++){
                //He visto que el 'ln' lo que hace es un salto de linea por lo que así se puede dibujar la matriz
                System.out.print(asignaturas[x][y] + " ");
            }
            System.out.println();
        }
        
        do{
            System.out.println("\n");
            System.out.println(" Indica la opción del siguiente menu de opciones:");
            System.out.println("1. Mostrar el nombre de todas las asignaturas.");
            System.out.println("2. Modificar el nombre de una asignatura.");
            System.out.println("3. Modificar la puntuación de una asignatura.");
            System.out.println("4. Mostrar la puntuación menor de cada una de las asignaturas.");
            //System.out.println("5. Mostrar todos los valores.");
            System.out.println("0. Salir.");
            
            try{
                continua = false;
                String opcion = br.readLine();
                opcion_numero = Integer.parseInt(opcion);
                //Solo podemos elegir las opciones entre 0 y 4.
                if (opcion_numero < 0 || opcion_numero > 4){
                    System.out.println("El valor " + opcion_numero + " no es una opción.\n");
                }
          
                //Cada una de las 5 opciones disponibles hace una cosa diferente.
                switch (opcion_numero){
                    case 1 -> {
                        y = 0;
                        for (x = 0; x < asignaturas.length; x++){
                            System.out.print(asignaturas[x][y] + " ");
                        }
                    }
                        
                    case 2 -> {
                    //He metido en otro Do/While este bloque para que solo pueda elegir entre las asignaturas 1 y 4.
                        do{
                            System.out.println("Indica el número de asignatura entre (1 y 4) de la que quieres cambiar el nombre.");
                            try{
                                continua = false;
                                String  seleccionar_asignatura = br.readLine();
                                asignatura_numero = Integer.parseInt(seleccionar_asignatura);
                                
                                if (asignatura_numero < 1 || asignatura_numero > 4){
                                    System.out.println("El valor " + asignatura_numero + " no es una opción.\n");
                                    continua = true;
                                }
                                
                            }catch(NumberFormatException e){
                                System.out.println("No has indicado un valor numérico.\n");
                                continua = true;
                            }
                        //Si no hay fallos continua = false y por lo tanto se sale del bucle.
                        }while(continua);
                        //Como en la actividad anterior no quería empezar en el número 0 aunque me haya tenido que complicar
                        System.out.println("Indica el nuevo nombre de la asignatura " + asignaturas[asignatura_numero - 1][0]);
                        String  nombre_asignatura = br.readLine();
                        asignaturas[asignatura_numero - 1][0] = nombre_asignatura;
                        //Guardamos el nuevo nombre y lo muestra
                        System.out.println("El nuevo nombre de la asignatura es " + nombre_asignatura);
                    }
                        
                    case 3 -> {
                        //Lo mismo que el anterior Do/While pero para que no pueda meter letras y numeros negativos.
                        do{
                            System.out.println("Indica el número de asignatura entre (1 y 4) de la que quieres cambiar un valor.");
                            try{
                                continua = false;
                                String  seleccionar_asignatura = br.readLine();
                                asignatura_numero = Integer.parseInt(seleccionar_asignatura);
                                
                                if (asignatura_numero < 1 || asignatura_numero > 4){
                                    System.out.println("El valor " + asignatura_numero + " no es una opción.\n");
                                    continua = true;
                                }
                                
                            }catch(NumberFormatException e){
                                System.out.println("No has indicado un valor numérico.\n");
                                continua = true;
                            }
                        }while(continua);
                        
                        do{
                            System.out.println("Indica el número de puntuación entre (1 y 3) que quieres cambiar de la asignatura " + asignaturas[asignatura_numero - 1][0]);
                            try{
                                continua = false;
                                String  seleccionar_valor = br.readLine();
                                valor_numero = Integer.parseInt(seleccionar_valor);
                                
                                if (valor_numero < 1 || valor_numero > 3){
                                    System.out.println("El valor " + asignatura_numero + " no es una opción.\n");
                                    continua = true;
                                }
                                
                            }catch(NumberFormatException e){
                                System.out.println("No has indicado un valor numérico.\n");
                                continua = true;
                            }
                        }while(continua);
                        //Indica la puntuacion en esa posición antes de poder cambiarlo
                        System.out.println("El valor actual de la puntuación " + valor_numero + " de la asignatura " + asignaturas[asignatura_numero - 1][0] + " es: " + asignaturas[asignatura_numero - 1][valor_numero]);
                        do{
                            System.out.println("Indica el nuevo valor (entre 0 y 10)");
                            try{
                                continua = false;
                                //Lo pasamos a double ya que puede tener decimales y poder comprobar que el número esté entre 0 y 10
                                String  valor_asignatura = br.readLine();
                                nueva_nota = Double.parseDouble(valor_asignatura);
                            
                                if (nueva_nota < 0 || nueva_nota > 10){
                                    System.out.println("El valor " + nueva_nota + " no es una opción.\n");
                                    continua = true;
                                }
                            }catch(NumberFormatException e){
                                System.out.println("No has indicado un valor numérico.\n");
                                continua = true;
                            }                            
                        }while (continua);
                        //Lo volvemos a pasar a String para poder meterlo en el array
                        String valor_asignatura = String.valueOf(nueva_nota);
                        asignaturas[asignatura_numero - 1][valor_numero] = valor_asignatura;
                        //Muestra los nuevos valores de la asignatura
                        System.out.print("Los valores de " + asignaturas[asignatura_numero - 1][0] + " son: ");
                        for (y = 1; y < asignaturas[asignatura_numero -1].length; y++){
                            System.out.print(asignaturas[asignatura_numero - 1][y] + " | ");
                        }
                    }
                    //Muestra los valores más pequeños de cada asignatura y lo hemos pasado a double para poder hacer las comprobaciones
                    case 4 -> {
                    //Como no puede haber una nota mayor a diez, ponemos ahí el límite y si la primera nota es menor a 10 lo guarda en la variable
                    //Así sucesivamente hasta terminar de recorrer la primera posicion, después se reinicia a 10 otra vez para hacerlo de nuevo con la siguiente asignatura
                        for (x = 0; x < asignaturas.length; x++){
                            num_min = 10;
                            for (y = 1; y < asignaturas[x].length; y++){
                                double nuevo_numero = Double.parseDouble(asignaturas[x][y]);
                                if (nuevo_numero < num_min){
                                    num_min = nuevo_numero;
                                }
                            }
                            System.out.println("El valor menor de " + asignaturas[x][0] + " es: " + num_min);
                        }
                    }
                    //Aunque no lo pide en el ejercicio lo he estado utilizando para comprobar a medida que iba desarrollando el código        
                    /*case 5 -> {
                        System.out.println("Los valores del array bidimensional son:");
                        for (x = 0; x < asignaturas.length; x++){
                            for (y = 0; y < asignaturas[x].length; y++){
                                System.out.print(asignaturas[x][y] + " ");
                            }           
                            System.out.println();
                        } 
                    }*/
                    
                    case 0 -> {
                        System.out.println("¡Gracias por tu colaboración!");
                        return;
                    }
                }
            }catch(NumberFormatException e){
                System.out.println("No has indicado un valor numérico.\n");
                continua = true;
            }
        }while (continua || opcion_numero != 0);
    }
}
    

