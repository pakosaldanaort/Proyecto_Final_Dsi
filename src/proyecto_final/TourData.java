/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author francisco_saldana
 */
public class TourData {
    private final SimpleStringProperty nombre;
    private final SimpleDoubleProperty precio;
    private final SimpleStringProperty duracion;

    public TourData(String nombre, double precio, int horas,int minutos) {
        this.nombre = new SimpleStringProperty(nombre);
        this.precio = new SimpleDoubleProperty(precio);
        this.duracion = new SimpleStringProperty(horas+ " horas "+minutos+" minutos");
    }

    public String getNombre() {
        return nombre.get();
    }

    public double getPrecio() {
        return precio.get();
    }

    public String getDuracion() {
        return duracion.get();
    }

    
    
   
    
    
    
}
