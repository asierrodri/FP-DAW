/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad04;

import static actividad04.pideDatos.Pregunta.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author asier
 */
public class Archivos {
//Crea un uevo archivo.
    public static void crearArchivo(String rutaCarpeta, String separador) throws IOException {
        Scanner sc = new Scanner(System.in);

        FileWriter fw;
        try {
            System.out.println("Por favor introduce el nombre de un archivo:");
            String nombreArchivo = sc.nextLine();
            System.out.println("Introduce un texto: ");
            String textoArchivo = sc.nextLine();

            fw = new FileWriter(rutaCarpeta + separador + nombreArchivo);

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(textoArchivo);
            bw.flush();

            bw.close();

        } catch (IOException el) {
            System.out.println("Se ha producido un error al intentar escribir en el archivo");
            System.out.println("El error producido es el siguiente: " + el.getMessage());
        }
    }
//Muestra los archivos creados por consola.
    public static String[] listarArchivos(String rutaCarpeta, String separador) {
        File carpeta = new File(rutaCarpeta);

        //Obtenemos un array con los nombres de archivos y directorios
        String[] listado = carpeta.list();

        for (int i = 0; i < listado.length; i++) {
            System.out.println((i + 1) + "-" + listado[i]);
        }
        return listado;
    }
//Muestra el contenido del archivo seleccionado.
    public static void mostrarArchivos(String rutaCarpeta, String separador) throws IOException {
        String[] listado = listarArchivos(rutaCarpeta, separador);

        if (listado.length > 0) {

            int numeroArchivo = pideValorMinMax(1, listado.length);
            FileReader fr = new FileReader(rutaCarpeta + separador + listado[numeroArchivo - 1]); //Stream conectado al fichero a leer.
            BufferedReader br = new BufferedReader(fr); //Buffer que almacena datos del stream
            String linea = br.readLine(); //leemos los datos almacenados en el buffer
            System.out.println(linea);
            br.close();//cerramos el buffer

        } else {
            System.out.println("Carpeta vacía");
        }
    }
//Borra el archivo seleccionado.
    public static void borrarArchivos(String rutaCarpeta, String separador) {
        String[] listado = listarArchivos(rutaCarpeta, separador);

        if (listado.length > 0) {
            int numeroArchivo = pideValorMinMax(1, listado.length);
            File deleteFile = new File(rutaCarpeta + separador + listado[numeroArchivo - 1]); //Stream conectado al fichero a leer.
            deleteFile.delete();

        } else {
            System.out.println("Carpeta vacía");
        }
    }
//Cambia el nombre del archivo seleccionado.
    public static void renombrarArchivos(String rutaCarpeta, String separador) {
        String[] listado = listarArchivos(rutaCarpeta, separador);

        if (listado.length > 0) {
            int numeroArchivo = pideValorMinMax(1, listado.length);
            File renameFile = new File(rutaCarpeta + separador + listado[numeroArchivo - 1]); //Stream conectado al fichero a leer.

            Scanner sc = new Scanner(System.in);
            System.out.println("Por favor introduce el nuevo nombre del archivo:");
            String nombreArchivo = sc.nextLine();
            File newName = new File(rutaCarpeta + separador + nombreArchivo);
            renameFile.renameTo(newName);

            if (!newName.exists()) {
                System.out.println("Se ha producido un error al intentar renombrar el archivo");
            }

        } else {
            System.out.println("Carpeta vacía");
        }
    }
//Reemplaza el carácter elegido por otro. Del contenido del archivo elegido.
    public static void reemplazarCaracteres(String rutaCarpeta, String separador) throws IOException {

        String[] listado = listarArchivos(rutaCarpeta, separador);

        if (listado.length > 0) {
            int numeroArchivo = pideValorMinMax(1, listado.length);

            String rutaArchivo = listado[numeroArchivo - 1];
            File archivo = new File(rutaCarpeta + separador + rutaArchivo);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            try {
                String textFind, textReplace;
                do {
                    System.out.println("Indica el caracter a reemplazar. Solo un caracter");
                    textFind = br.readLine();
                } while (textFind.length() != 1);

                do {
                    System.out.println("Indica el nuevo caracter. Solo un caracter");
                    textReplace = br.readLine();
                } while (textReplace.length() != 1);

                RandomAccessFile raf = new RandomAccessFile(archivo, "rw");

                while (raf.getFilePointer() < raf.length()) {
                    Character chr = (char) raf.readByte();
                    if (chr.toString().compareTo(textFind) == 0) {
                        raf.seek(raf.getFilePointer() - 1);
                        raf.writeBytes(textReplace);
                    }
                }
                raf.close();

            } catch (IOException el) {
                System.out.println("Se ha producido un error al intentar escribir en el archivo");
                System.out.println("El error producido es el siguiente: " + el.getMessage());
            }

        } else {
            System.out.println("Carpeta vacía");
        }
    }
}
