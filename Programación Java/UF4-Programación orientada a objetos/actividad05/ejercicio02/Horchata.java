/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad05.ejercicio02;

/**
 *
 * @author asier
 */
public class Horchata extends Comida {

    private int cantidad;
    private double porcentajeChufa;

    public Horchata(String nombre, double precio, int cantidad, double porcentajeChufa) {
        super(nombre, precio);
        this.cantidad = cantidad;
        this.porcentajeChufa = porcentajeChufa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPorcentajeChufa() {
        return porcentajeChufa;
    }

    public void setPorcentajeChufa(double porcentajeChufa) {
        this.porcentajeChufa = porcentajeChufa;
    }
    
    @Override
    public String toString() {
        return super.toString() + " con " + porcentajeChufa + "% de chufa";
    }
}
