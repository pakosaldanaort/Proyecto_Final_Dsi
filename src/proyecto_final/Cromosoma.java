/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final;

import java.util.ArrayList;

/**
 *
 * @author francisco_saldana
 */
public class Cromosoma {
    public ArrayList<Tour> cromosoma =  new ArrayList<Tour>();
    public double fitness;
    public int size;


    public Cromosoma(double fitness, int size) {
        this.fitness = fitness;
        this.size = size;

    }
    
    public Cromosoma(ArrayList<Tour> cromosoma){
        
    }

    public Cromosoma() {
    }

    public ArrayList<Tour> getCromosoma() {
        return cromosoma;
    }

    public void setCromosoma(ArrayList<Tour> cromosoma) {
        this.cromosoma = cromosoma;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

   

    @Override
    public String toString() {
        
        String toursList="[";
        for (Tour temp : this.cromosoma) {
            toursList +=temp.toString()+", ";
        }
        toursList+= " Fitness: "+fitness+"]";
        
        return toursList;
        
        
    }
    
    
    
}
