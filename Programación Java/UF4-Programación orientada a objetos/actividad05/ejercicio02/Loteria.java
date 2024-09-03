/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad05.ejercicio02;

/**
 *
 * @author asier
 */
public class Loteria extends Comida {

    private double precio;
    private String numero;

    public Loteria(String numero, double precio) {
        super(numero, precio);
        this.precio = precio;
        this.numero = numero;
    }


    @Override
    public double getPrecio() {
        return precio;
    }


    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "numero: " + numero + ", precio: " + precio;
    }
}
