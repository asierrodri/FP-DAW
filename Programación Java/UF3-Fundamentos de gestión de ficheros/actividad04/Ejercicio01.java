/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad04;

import static actividad04.Archivos.*;
import static actividad04.pideDatos.Pregunta.pideValorMinMax;
import java.io.File;
import java.io.IOException;

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
//Para indicar la ruta de las carpetas y archivos.
        String rutaProyecto = System.getProperty("user.dir");

        String separador = File.separator;

        String rutaCarpeta = rutaProyecto + separador + "archivos";

        File archivos = new File(rutaCarpeta);

        if (!archivos.exists()) {
            archivos.mkdir();
        }

        int opcion;
//El menú dentro del do/while para que siempre se muestre.
        do {
            System.out.println("\n------ Elige una opción del menú ------");
            System.out.println("1- Nuevo Archivo");
            System.out.println("2- Listar Archivos");
            System.out.println("3- Muestra un Archivo");
            System.out.println("4- Borrar un Archivo");
            System.out.println("5- Renombrar un archivo");
            System.out.println("6- Modificar un archivo");
            System.out.println("0- Salir");

            opcion = pideValorMinMax(0, 6);
//Para elegir cada una de las opciones del menú.
            switch (opcion) {
                case 1 -> {
                    crearArchivo(rutaCarpeta, separador);
                    break;
                }
                case 2 -> {
                    listarArchivos(rutaCarpeta, separador);
                    break;
                }
                case 3 -> {
                    mostrarArchivos(rutaCarpeta, separador);
                    break;
                }
                case 4 -> {
                    borrarArchivos(rutaCarpeta, separador);
                    break;
                }
                case 5 -> {
                    renombrarArchivos(rutaCarpeta, separador);
                    break;
                }
                case 6 -> {
                    reemplazarCaracteres(rutaCarpeta, separador);
                    break;
                }
                case 0 -> {
                    System.out.println("Gracias por participar.");
                    break;
                }
            }

        } while (opcion != 0);
    }
}
