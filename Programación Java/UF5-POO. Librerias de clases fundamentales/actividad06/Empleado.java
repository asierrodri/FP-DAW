/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad06;

import java.io.Serializable;

/**
 *
 * @author asier
 */
public class Empleado implements Serializable {
    private String nombre;
    private String apellido;
    private double sueldo;
    private transient String clave = "patata";
    
    public Empleado(String nombre, String apellido, double sueldo) {
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.sueldo = sueldo;
    }
    //getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApeliido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    @Override
    public String toString() {
        return "Empleado: " + "nombre = " + nombre + "apellido = " + apellido + "sueldo = " + sueldo;
    }
}
