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
        precioMinimo = precioMax*2;
        
        
    }
    
    public ArrayList<Cromosoma> randomIndividuos(ArrayList<Tour> tours,int nLugares){
        ArrayList<Tour> temp = new ArrayList<Tour>();
        ArrayList<Cromosoma> crom = new ArrayList<Cromosoma>();
        Cromosoma aux = new Cromosoma();
        int random;
        for (int i = 0; i < nLugares; i++) {
            temp=new ArrayList<Tour>();
            for (int j = 0; j < nLugares; j++) {
                random = (int) (Math.random() * maxTours);

                
                
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
        double part = this.precioMax/8;
        
        
        
        fitness= (precioMax - precioPaquete)/10;
        
        if(precioPaquete == this.precioMax){
            fitness= fitness +600;
            
        }else if(precioPaquete >= part*7 && precioPaquete<this.precioMax){
            fitness= fitness +520;
        }
        else if(precioPaquete >= part*6 && precioPaquete<this.precioMax){
            fitness= fitness +220;
        }
        else if(precioPaquete <= part*5){
            fitness= fitness - precioPaquete;
        }
        
        /*
        else if(precioPaquete < this.precioMax) {
            fitness= fitness + 100;
            
        }
        else if(precioPaquete < this.precioMax/2){
            fitness = fitness-170;
        }

        else{
            fitness = fitness-70;
        }*/
        
        
        String tourName;
        int cont;
        for (int i = 0; i < tours.size(); i++) {
            cont =0;
            tourName = tours.get(i).getTourName();
            
            for (int j = 0; j < tours.size(); j++) {
                if(tourName.equals(tours.get(j).getTourName()) && i!=j){
                    fitness = fitness-250;
                    
                    
                }
                
            }
            
        }
        
       

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
    
    public ArrayList<Cromosoma> crossover(ArrayList<Cromosoma> croms){

         double ram;
         ArrayList<Tour> padre = (ArrayList<Tour>) croms.get(0).getCromosoma().clone();
         ArrayList<Tour> madre = (ArrayList<Tour>) croms.get(0).getCromosoma().clone();

         ArrayList<Tour> hijo1 = new ArrayList<Tour>();
         ArrayList<Tour> hijo2 = new ArrayList<Tour>();

         Cromosoma aux1 = new Cromosoma();
         Cromosoma aux2 = new Cromosoma();
         ArrayList<Cromosoma> children = new ArrayList<Cromosoma>();
 
         for (int j = 0; j < padre.size(); j++) {
             ram=Math.random();
             if(ram<0.5){
                hijo1.add(j,padre.get(j));

                hijo2.add(j,madre.get(j));

            }
            else{
                 
                hijo1.add(j,madre.get(j));

                hijo2.add(j,padre.get(j));

                
            }

         }
         aux1.setCromosoma(hijo1);
         aux2.setCromosoma(hijo2);
         
         children.add(aux1);
         children.add(aux2);

         
         return children;

     }
    
    public void mutation(ArrayList<Cromosoma> children,ArrayList<Tour> tours) {
        ArrayList <Tour> m  = new ArrayList <Tour>();
        double random;
        int random2;
        for(int i=0; i< children.size();i++){
            m = children.get(i).getCromosoma();
   
            for(int j=0;j< m.size(); j++){
                 random =  Math.random() ; 
                 if(random<0.5){
                     random2 = (int) (Math.random() * maxTours);

                     Tour temp = tours.get(random2);
                     if(!temp.tourName.equals(m.get(j).tourName)){
                         m.set(j, temp);
                         
                     }
                     
                     
                 }
            }

            
            children.get(i).setCromosoma(m);
            
            
            
            
        }
        
    }
    
    
}
