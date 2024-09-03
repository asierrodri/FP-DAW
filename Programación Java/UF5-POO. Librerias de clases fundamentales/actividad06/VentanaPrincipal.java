/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad06;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author asier
 */
public class VentanaPrincipal {

    /**
     * @param args the command line arguments
     */
    static HashMap<String, Empleado> empleados = new HashMap();

    public static void main(String[] args) throws IOException, ClassNotFoundException, ErrorLeerArchivo {
        Empleado empleadoA = new Empleado("Asier", "Rodriguez", 1200);
        Empleado empleadoB = new Empleado("Camila", "Bertolone", 2000);

        empleados.put("Asier", empleadoA);
        empleados.put("Camila", empleadoB);

        File archivo = new File("Empleados.txt");
        try {
            //ESCRIBIR EN EL ARCHIVO    
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(empleados);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Error al serializar");
        }

        // Iniciamos la ventana de bienvenida
        VentanaBienvenida ventana = new VentanaBienvenida();
        ventana.setVisible(true);
    }

}
