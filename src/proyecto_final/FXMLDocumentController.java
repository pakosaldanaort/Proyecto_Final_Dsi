/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author francisco_saldana
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private AnchorPane hijoPrincipal;
    @FXML
    private AnchorPane paneInicio;
    
    @FXML
    private AnchorPane addTour;
    @FXML
    private TextField tourName;
    @FXML
    private TextField tourDuration;
    @FXML
    private TextField tourPrice;
    
    
    private Tours tours =  new Tours();
    
    @FXML
    private AnchorPane generatePaquete;
    @FXML
    private TextField presupuesto;
    @FXML
    private TextField nLugares;
    @FXML
    private TextField nDias;
    
    
    @FXML
    private void addTour() throws IOException {
        Tour tour;
        String nombre;
        double duracion,precio;
        
        nombre = this.tourName.getText();
        duracion = Double.parseDouble(this.tourDuration.getText());
        precio = Double.parseDouble(this.tourPrice.getText());
        tour = new Tour(nombre,precio,duracion);
        this.tours.setTour(tour); 
        guardar();
        for (Node aux : addTour.getChildren()) {
            if (aux instanceof TextField) {
                ((TextField)aux).setText("");
            }
            
        }        
    }
    
    
    @FXML 
    private void guardar() throws FileNotFoundException, IOException {
      FileOutputStream a =  new FileOutputStream("media.obj");
      ObjectOutputStream salida=new ObjectOutputStream(a);
      salida.writeObject(this.tours);
      salida.close();
      a.close();
    }
    
    @FXML
    private void cancel(){
        AnchorPane temp;
        for (Node aux : hijoPrincipal.getChildren()) {
            
            if (aux instanceof AnchorPane) {
                temp = (AnchorPane) aux;
                if(temp.getId().equals("paneInicio")){
                    temp.setVisible(true);
                }else{
                    temp.setVisible(false);
                }
                
            }
            
        }
    }
    
    @FXML
    private void optionAddTour(){
        
        AnchorPane temp;
        for (Node aux : hijoPrincipal.getChildren()) {
            
            if (aux instanceof AnchorPane) {
                temp = (AnchorPane) aux;
                if(temp.getId().equals("addTour")){
                    temp.setVisible(true);
                }else{
                    temp.setVisible(false);
                }
                
            }
            
        }
    }
    
    @FXML
    private void optionGeneratePaquete(){
        
        AnchorPane temp;
        for (Node aux : hijoPrincipal.getChildren()) {
            
            if (aux instanceof AnchorPane) {
                temp = (AnchorPane) aux;
                if(temp.getId().equals("generatePaquete")){
                    temp.setVisible(true);
                }else{
                    temp.setVisible(false);
                }
                
            }
            
        }
    }
    
    @FXML
    private void generatePaquete(){
        double costoMax;
        int lugares,dias;
        costoMax = Double.parseDouble(presupuesto.getText());
        lugares = Integer.parseInt(nLugares.getText());
        dias = Integer.parseInt(nDias.getText());
        for (Node aux : generatePaquete.getChildren()) {
            if (aux instanceof TextField) {
                ((TextField)aux).setText("");
            }
            
        }
        AlgoritmoGenetico a = new AlgoritmoGenetico(tours.getTours().size(),lugares,dias,costoMax);
        ArrayList<Cromosoma> b = new ArrayList<Cromosoma> ();
        b = a.randomIndividuos(tours.getTours(), lugares);
        
        for (Cromosoma t : b) {
            
            t.setFitness(a.setFitness(t));
            
        }
        
        a.Bubblesort(b);
        int i=2;
        do{
            b = a.seleccion(b, 2);
            
            
        }while(i!=400);
        
        
        
    }
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FileInputStream a = new FileInputStream("media.obj");
            ObjectInputStream entrada=new ObjectInputStream(a);
            this.tours = (Tours) entrada.readObject();
            System.out.println(tours);
            a.close();
            entrada.close();
           
        } catch (FileNotFoundException ex) {
            System.out.println("No se Encontro Archivo");
        } catch (IOException ex) {
            
        } catch (ClassNotFoundException ex) {
            
        }
    }    
    
}
