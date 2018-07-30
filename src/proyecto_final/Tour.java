/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final;

import java.io.Serializable;

/**
 *
 * @author francisco_saldana
 */
public class Tour implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;
    
    public String tourName;
    public double price;
    public double duracion;

    public Tour(String tourName, double price, double duracion) {
        this.tourName = tourName;
        this.price = price;
        this.duracion = duracion;
    }

    public Tour() {
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Tour {" + "Nombre=" + tourName + ", Precio =" + price + ", Duracion=" + duracion + '}';
    }
    
    
    
}
