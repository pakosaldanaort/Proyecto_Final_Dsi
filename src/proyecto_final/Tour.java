/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author francisco_saldana
 */
public class Tour implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;
    
    public String tourName;
    public double price;
    public int horas;
    public int minutos;
    
    
    public Tour(String tourName, double price, int horas,int minutos) {
        this.tourName = tourName;
        this.price = price;
        this.horas = horas;
        this.minutos = minutos;


       
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

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    
    @Override
    public String toString() {
        return "Tour {" + "Nombre=" + tourName + ", Precio =" + price + ", Duracion= " + horas + " horas "+minutos+" minutos}";
    }
    
    
    
}
