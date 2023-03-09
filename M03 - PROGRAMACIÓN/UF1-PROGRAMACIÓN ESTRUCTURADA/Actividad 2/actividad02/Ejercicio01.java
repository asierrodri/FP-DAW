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
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        // Declaramos todas las variables fuera del Do/While para que el valor no vuelva a cero cada vez que re repite el bucle.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double  [] recipientes;
        recipientes = new double[5];
        int i;
        int opcion_numero = 0;
        int recipiente_numero = 0;
        double comprobar_cantidad = 0;
        boolean continua;
        do{
            System.out.println("Menu de opciones:\n");
            System.out.println("1- Añadir refresco a un recipiente.");
            System.out.println("2- Quitar refresco de un recipiente.");
            System.out.println("3- Calcular el total de refresco.");
            System.out.println("0- Finalizar.\n");
            System.out.println("Introduzca la operación a realizar del siguiente menú de opciones: ");
            //Me ha costado entender como funciona el try/catch y solo lo he usado por si no meten un valor numérico.
            try{
                continua = false;
                String opcion = br.readLine();
                opcion_numero = Integer.parseInt(opcion);
                //Solo podemos elegir las opciones entre 0 y 3.
                if (opcion_numero < 0 || opcion_numero > 3){
                    System.out.println("El valor " + opcion_numero + " no es una opción.\n");
                }
                //Cada una de las 4 opciones disponibles hace una cosa diferente.
                switch (opcion_numero){
                    case 1 -> {
                        //He metido en otro Do/While este bloque para que solo pueda elegir entre el recipiente 1 y 5.
                        do{
                            System.out.println("Introduce el número de recipiente entre 1 y 5, por favor.");
                            try{
                                continua = false;
                                String  seleccionar_recipiente = br.readLine();
                                recipiente_numero = Integer.parseInt(seleccionar_recipiente);
                                
                                if (recipiente_numero < 1 || recipiente_numero > 5){
                                    System.out.println("El valor " + recipiente_numero + " no es una opción.\n");
                                    continua = true;
                                }
                                
                            }catch(NumberFormatException e){
                                System.out.println("No has indicado un valor numérico.\n");
                                continua = true;
                            }
                            //Si no hay fallos continua = false y por lo tanto se sale del bucle.
                        }while(continua);
                        //Lo mismo que el anterior Do/While pero para que no pueda meter letras y numeros negativos.
                        do{
                            System.out.println("Introduce la cantidad a ingresar en el recipiente " + recipiente_numero + ", por favor.");
                            try{
                                continua = false;
                                String  cantidad_recipiente = br.readLine();
                                comprobar_cantidad = Double.parseDouble(cantidad_recipiente);
                                
                                if (comprobar_cantidad < 0){
                                    System.out.println("La cantidad no puede ser negativa.\n");
                                    continua = true;
                                }
                                
                            }catch(NumberFormatException e){
                                System.out.println("No has indicado un valor numérico.\n");
                                continua = true;
                            }
                            
                        }while(continua);
                        //Cuando meta un valor correcto podremos sumar la cantidad introducida a lo que hay en el recipiente indicado, porque si lo hacemos antes la cantidad se queda guardada.
                        /*Como el array empieza siempre en cero pero yo no queria que hubiera un recipiente para el usuario con el numero 0, le he tenido que restar 1 al recipiente indicado para
                        que se posicione en el recipiente correcto.*/
                        recipientes[recipiente_numero - 1] += comprobar_cantidad;
                        
                        System.out.println("---El estado actual de los recipientes es---:");
                        for (i = 0; i < recipientes.length; i++){
                            System.out.println("En el recipiente " + (i + 1) + " hay " + recipientes[i] + " litros");
                        }
                        System.out.println("\n\n");
                    }
                                         
                    case 2 -> {
                        //Es lo mismo que el primer caso, exceptuando una comprobacion más que indico más adelante y que luego se le resta en vez de sumarle.
                        do{
                            System.out.println("Introduce el número de recipiente entre 1 y 5, por favor.");
                            try{
                                continua = false;
                                String  seleccionar_recipiente = br.readLine();
                                recipiente_numero = Integer.parseInt(seleccionar_recipiente);
                                
                                if (recipiente_numero < 1 || recipiente_numero > 5){
                                    System.out.println("El valor " + recipiente_numero + " no es una opción.\n");
                                    continua = true;
                                }
                                
                            }catch(NumberFormatException e){
                                System.out.println("No has indicado un valor numérico.\n");
                                continua = true;
                            }
                        }while(continua);
                        
                        do{
                            System.out.println("Introduce la cantidad a retirar del recipiente " + recipiente_numero + ", por favor.");
                            try{
                                continua = false;
                                String  cantidad_recipiente = br.readLine();
                                comprobar_cantidad = Double.parseDouble(cantidad_recipiente);
                                
                                if (comprobar_cantidad < 0){
                                    System.out.println("La cantidad no puede ser negativa.\n");
                                    continua = true;
                                }
                                //Hay que comprobar que si le quitamos la cantidad indicada el recipiente no quede en numero negativo.
                                if (recipientes[recipiente_numero - 1] - comprobar_cantidad < 0){
                                    System.out.println("La cantidad del recipiente no puede quedar en negativo.\n");
                                    continua = true;
                                }
                                
                            }catch(NumberFormatException e){
                                System.out.println("No has indicado un valor numérico.\n");
                                continua = true;
                            }
                            
                        }while(continua);
                        //Le quitamos la cantidad introducida.
                        recipientes[recipiente_numero - 1] -= comprobar_cantidad;
                        
                        System.out.println("---El estado actual de los recipientes es---:");                        
                        for (i = 0; i < recipientes.length; i++){
                            System.out.println("En el recipiente " + (i + 1) + " hay " + recipientes[i] + " litros");
                        }
                        System.out.println("\n\n");
                    }
                    case 3 -> {
                        System.out.println("---El estado actual de los recipientes es---:");
                        for (i = 0; i < recipientes.length; i++){
                            System.out.println("En el recipiente " + (i + 1) + " hay " + recipientes[i] + " litros");
                        }
                        //Esta había sido mi primera opcion antes de ver la clase online de los arrays.
                        /*System.out.println("En el recipiente 2 hay " + recipientes[1] + " litros");
                        System.out.println("En el recipiente 3 hay " + recipientes[2] + " litros");
                        System.out.println("En el recipiente 4 hay " + recipientes[3] + " litros");
                        System.out.println("En el recipiente 5 hay " + recipientes[4] + " litros");*/
                        System.out.println("\n\n");
                    }
                    case 0 -> {
                        System.out.println("¡Gracias por tu colaboración!");
                        return;
                    }
                }
                //Mostramos lo que hay en los recipientes.
                //Acabamos el programa, de ahí el return.
                            }catch(NumberFormatException e){
                    System.out.println("No has indicado un valor numérico.\n");
                    continua = true;
            }
        //Hasta que no introduzca la opción 0 el programa se seguirá ejecutando.    
        }while(continua || opcion_numero != 0);
    }
    
}
