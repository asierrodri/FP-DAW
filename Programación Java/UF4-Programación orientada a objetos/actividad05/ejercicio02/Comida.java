/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad05.ejercicio02;

/**
 *
 * @author asier
 */
public abstract class Comida implements Vendible {

    private static String tipo = "comida:";
    private String nombre;
    private double precio;

    public Comida(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        Comida.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return tipo + " " + nombre + " a " + precio + " euros";
    }   
}
