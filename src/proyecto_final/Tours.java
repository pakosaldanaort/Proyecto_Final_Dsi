/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author francisco_saldana
 */
public class Tours implements Serializable{
    private static final long serialVersionUID = 8799656478674716638L;
    public ArrayList<Tour> tours =  new ArrayList<Tour>();

    public ArrayList<Tour> getTours() {
        return tours;
    }

    
    public void setTour(Tour tour){
        tours.add(tour);
    }

    @Override
    public String toString() {
        String toursList="";
        for (Tour temp : this.tours) {
            toursList +=temp.toString()+", ";
        }
        
        return toursList;
    }
    
    
    
    
}
