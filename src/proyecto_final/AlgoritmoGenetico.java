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
public class AlgoritmoGenetico {
    
    
    int maxTours,nLugares,diasPaquete;
    double precioMax,precioMinimo;

    
    
    
    
    public AlgoritmoGenetico(int maxTours,int nLugares, int diasPaquete,double precioMax){
        
        this.maxTours = maxTours;
        this.nLugares = nLugares;
        this.diasPaquete = diasPaquete;
        this.precioMax = precioMax;
        precioMinimo = precioMax;
        
        
    }
    
    public ArrayList<Cromosoma> randomIndividuos(ArrayList<Tour> tours,int nLugares){
        ArrayList<Tour> temp = new ArrayList<Tour>();
        ArrayList<Cromosoma> crom = new ArrayList<Cromosoma>();
        Cromosoma aux = new Cromosoma();
        int random;
        for (int i = 0; i < nLugares; i++) {
            temp=new ArrayList<Tour>();
            for (int j = 0; j < nLugares; j++) {
                random = (int) (Math.random() * maxTours-1);
                
                
                temp.add(tours.get(random));
                
                
            }
            aux = new Cromosoma();
            aux.setCromosoma(temp);
            crom.add(aux);
            
            
            
        }
        
        
        return crom;
    }
    
    public double setFitness(Cromosoma crom){
        double fitness=0,precioPaquete=0;
        
        ArrayList <Tour> tours = (ArrayList <Tour>) crom.getCromosoma().clone();
       
        
        for(Tour temp : tours){
            precioPaquete+= temp.getPrice();
            
        }
        
        precioPaquete = precioPaquete / tours.size();
        
        if(precioPaquete == this.precioMax){
            fitness= fitness + 50;
            if(precioPaquete < this.precioMinimo){
                this.precioMinimo = precioPaquete;
                fitness+= 30;
            }
        }
        else if(precioPaquete < this.precioMax) {
            fitness= fitness + 100;
            if(precioPaquete < this.precioMinimo){
                this.precioMinimo = precioPaquete;
                fitness+= 30;
            }
        }
        else if(precioPaquete < this.precioMax/2){
            fitness = fitness-70;
        }
        else{
            fitness = fitness-30;
        }
        String tourName;
        int cont;
        for (int i = 0; i < tours.size(); i++) {
            cont =0;
            tourName = tours.get(i).getTourName();
            
            for (int j = 0; j < tours.size(); j++) {
                if(tourName.equals(tours.get(j).getTourName()) && i!=j){
                    fitness = fitness-25;
                    
                    
                }
                
            }
            
        }
        
       
        System.out.println(fitness);
        return fitness;
    }
    
    public void Bubblesort(ArrayList<Cromosoma> crom){
        Cromosoma buffer;
        int i,j;
        for(i = 0; i < crom.size(); i++)
            {
            for(j = 0; j < i; j++)
            {
                if(crom.get(i).getFitness() < crom.get(j).getFitness())
                {
                    buffer = crom.get(j);
                    crom.set(j, crom.get(i));
                    crom.set(i, buffer) ;
                }
            }
        }
    }
    
    public ArrayList<Cromosoma> seleccion(ArrayList<Cromosoma> croms, int n){
        int index =0,cont=0;
        ArrayList<Cromosoma> aux =  new ArrayList<Cromosoma>();
        
        for (int i = 0; i < n; i++) {
            aux.add(croms.get(croms.size()-1));
            croms.remove(croms.size()-1);
            
        }
        
        
        /*double maxFitness= croms.get(0).getFitness();
        double currentFitness=0;
        for(int i=0; i < croms.size(); i++){
            currentFitness =  croms.get(i).getFitness();
            if(currentFitness > maxFitness){
                maxFitness = currentFitness;
                index = i;
            }
        }*/
        return aux;
        
    }
    
    
}
