/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad05.ejercicio02;

/**
 *
 * @author asier
 */
class SaborHelado {

    private String nombre;
    private double porcentajeGrasa;
    private String tipoEdulcorante;
    private double precio;

    public SaborHelado(String nombre, double porcentajeGrasa, String tipoEdulcorante, double precio) {
        this.nombre = nombre;
        this.porcentajeGrasa = porcentajeGrasa;
        this.tipoEdulcorante = tipoEdulcorante;
        this.precio = precio;
    }
    
    public double getPrecio() {
        return precio;
    }

    // getters y setters
    @Override
    public String toString() {
        return nombre + " (grasa: " + porcentajeGrasa + "%, edulcorante: " + tipoEdulcorante + ")";
    }
}
