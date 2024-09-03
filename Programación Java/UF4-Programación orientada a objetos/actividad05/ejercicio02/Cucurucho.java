/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad05.ejercicio02;

/**
 *
 * @author asier
 */
public class Cucurucho extends Comida {

    private SaborHelado[] sabores;
    private int numBolas;
    private double precio;

    public Cucurucho(String nombre, double precioBase, int numBolas) {
        super(nombre, precioBase);
        this.sabores = new SaborHelado[numBolas];
        this.numBolas = numBolas;
    }

    public void addBolaHelado(SaborHelado sabor, int posicion) {
        if (posicion >= 0 && posicion < numBolas) {
            sabores[posicion] = sabor;
        } else {
            System.out.println("La posición indicada no es válida.");
        }
    }

    @Override
    public double getPrecio() {
        double precioTotal = super.getPrecio();
        for (int i = 0; i < numBolas; i++) {
            if (sabores[i] != null) {
                precioTotal += sabores[i].getPrecio();
            }
        }
        return precioTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getNombre()).append("\n");
        for (int i = 0; i < numBolas; i++) {
            sb.append("Bola ").append(i + 1).append(": ");
            if (sabores[i] != null) {
                sb.append(sabores[i].toString());
            } else {
                sb.append("sin sabor");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
