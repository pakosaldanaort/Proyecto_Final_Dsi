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
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TextField horas;
    @FXML
    private TextField minutos;
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
    private TableView<TourData> table;
    @FXML
    TableColumn <TourData, String> tNombre;
    @FXML
    TableColumn <TourData, Double> tPrecio;
    @FXML
    TableColumn <TourData, String> tDuracion;
    @FXML
    private TableView<TourData> table2;
    @FXML
    TableColumn <TourData, String> tNombre2;
    @FXML
    TableColumn <TourData, Double> tPrecio2;
    @FXML
    TableColumn <TourData, String> tDuracion2;
    @FXML
    Label costo;

   
    @FXML
    private AnchorPane verTours;
    
    @FXML
    private AnchorPane verToursR;
    
    private ObservableList<TourData> tourData;
    
    
    
    @FXML
    private void addTour() throws IOException {
        Tour tour;
        String nombre;
        double precio;
        int hours, mins;
        
        nombre = this.tourName.getText();
        hours = Integer.parseInt(this.horas.getText());
        mins = Integer.parseInt(this.minutos.getText());
        precio = Double.parseDouble(this.tourPrice.getText());
        tour = new Tour(nombre,precio,hours,mins);
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
    private void optionShowTours(){
        AnchorPane temp;
        for (Node aux : hijoPrincipal.getChildren()) {
            
            if (aux instanceof AnchorPane) {
                temp = (AnchorPane) aux;
                if(temp.getId().equals("verTours")){
                    temp.setVisible(true);
                }else{
                    temp.setVisible(false);
                }
                
            }
            
        }
        showTours();
    }
    
    @FXML
    private void optionShowToursR(ArrayList<Tour> t){
        AnchorPane temp;
        for (Node aux : hijoPrincipal.getChildren()) {
            
            if (aux instanceof AnchorPane) {
                temp = (AnchorPane) aux;
                if(temp.getId().equals("verToursR")){
                    temp.setVisible(true);
                }else{
                    temp.setVisible(false);
                }
                
            }
            
        }
        showToursR(t);
    }
    
    @FXML
    private void showTours(){
        tourData = FXCollections.observableArrayList();
        for(Tour temp: tours.getTours()){
            tourData.add(new TourData(temp.getTourName(),temp.getPrice(),temp.getHoras(),temp.getMinutos()));
        }
   
        tNombre.setCellValueFactory(
            new PropertyValueFactory<TourData,String>("nombre")
        );
        tPrecio.setCellValueFactory(
            new PropertyValueFactory<TourData,Double>("precio")
        );
        tDuracion.setCellValueFactory(
            new PropertyValueFactory<TourData,String>("duracion")
        );
        table.setItems(tourData);

    }
    @FXML
    private void showToursR(ArrayList<Tour> t){
        double costoT=0;
        tourData = FXCollections.observableArrayList();
        for(Tour temp: t){
            tourData.add(new TourData(temp.getTourName(),temp.getPrice(),temp.getHoras(),temp.getMinutos()));
            costoT+=temp.getPrice();
        }
   
        tNombre2.setCellValueFactory(
            new PropertyValueFactory<TourData,String>("nombre")
        );
        tPrecio2.setCellValueFactory(
            new PropertyValueFactory<TourData,Double>("precio")
        );
        tDuracion2.setCellValueFactory(
            new PropertyValueFactory<TourData,String>("duracion")
        );
        table2.setItems(tourData);
        costo.setText(""+costoT);

    }
    
    @FXML
    public ObservableList<TourData> getPersonData() {
        return tourData;
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
        ArrayList <Cromosoma> ch ;
        
        for (Cromosoma t : b) {
            
            t.setFitness(a.setFitness(t));
            
        }
        
        a.Bubblesort(b);
        int i = 0,cont =0,numMax;
        double maxFitness = b.get(b.size()-1).getFitness();
        numMax = 70;
        do{
            System.out.println(b);
            b = a.seleccion(b, 2);
            ch = a.crossover(b);
            a.mutation(ch, tours.getTours());
            for (Cromosoma aux : ch) {
                double d = a.setFitness(aux);

                aux.setFitness(d);


                b.add(aux);

            }
            a.Bubblesort(b);
            if(maxFitness < b.get(b.size()-1).getFitness()  ){

                maxFitness = b.get(b.size()-1).getFitness();
                cont =0;

            }
            if(maxFitness == b.get(b.size()-1).getFitness()){

                cont++;
                if(cont>numMax){

                    break;
                }

            }
            i++;
            
        }while(i!=2000);
        System.out.println(i);
        Date f = new Date();
        f.setHours(1);
        f.setMinutes(40);
        f.setSeconds(0);
        Date h =this.sumarRestarHorasFecha(f, 23, 50);
        
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        hourFormat.format(h);
        System.out.println(hourFormat.format(h));
        this.optionShowToursR(b.get(b.size()-1).getCromosoma());
        
        
        
    }
    @FXML
    public Date sumarRestarHorasFecha(Date fecha, int horas,int minutos){
	
 
	
      Calendar calendar = Calendar.getInstance();
	
      calendar.setTime(fecha); // Configuramos la fecha que se recibe
	
      calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<0
	
      calendar.add(Calendar.MINUTE, minutos);
	
      return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas
	
 
	
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
