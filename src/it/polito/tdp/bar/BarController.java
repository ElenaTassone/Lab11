package it.polito.tdp.bar;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Gruppo;
import it.polito.tdp.bar.model.Simulator;
import it.polito.tdp.bar.model.Tavolo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {
	Simulator simulator  ;
	List<Tavolo> tavoli;
	long time = 0 ; 
	int idtavolo=0;
	Random rn = new Random(42);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSimula;

    @FXML
    private TextArea txtResult;

    @FXML
    void doSimula(ActionEvent event) {
    	simulator = new Simulator() ; 
    	tavoli= new ArrayList<Tavolo> ();
    	
//    	for(int i=0 ; i<2 ;  i++){
//    		idtavolo++;
//    		Tavolo t = new Tavolo(idtavolo,10);
//    		tavoli.add(t) ;
//    	}
//    	for(int i=0 ; i<4 ;  i++){
//    		idtavolo++;
//    		Tavolo t = new Tavolo(idtavolo,8);
//    		tavoli.add(t) ;
//    	}
//    	for(int i=0 ; i<4 ;  i++){
//    		idtavolo++;
//    		Tavolo t = new Tavolo(idtavolo,6);
//    		tavoli.add(t) ;
//    	}
//    	for(int i=0 ; i<5 ;  i++){
//    		idtavolo++;
//    		Tavolo t = new Tavolo(idtavolo,4);
//    		tavoli.add(t) ;
//    	}
//    	simulator.addTable(numPosti, id);
    	idtavolo++;

    	simulator.addTable(10, idtavolo++);
    	simulator.addTable(10,idtavolo++);

    	simulator.addTable(8,idtavolo++);
    	simulator.addTable(8,idtavolo++);
    	simulator.addTable(8,idtavolo++);
    	simulator.addTable(8,idtavolo++);

    	simulator.addTable(6,idtavolo++);
    	simulator.addTable(6,idtavolo++);
    	simulator.addTable(6,idtavolo++);
    	simulator.addTable(6,idtavolo++);

    	simulator.addTable(4,idtavolo++);
    	simulator.addTable(4,idtavolo++);
    	simulator.addTable(4,idtavolo++);
    	simulator.addTable(4,idtavolo++);
    	simulator.addTable(4,idtavolo++);

    	//simulator.addTavoli(tavoli);
    	long lastTimeOfArrival = 0;
    	
    	for (int i = 0 ; i <2000; i++){
    		time = lastTimeOfArrival + 1 + rn.nextInt(9);
    		int n = 1 + rn.nextInt(9);
    		Gruppo g = new Gruppo (n, rn.nextFloat());
    		simulator.addEventi(g, time);
    	}
    	simulator.run();
    	txtResult.setText("Statistica: tot clienti"+simulator.getnTotClienti()+", \n tot soddisfatti "
    			+simulator.getnClientiSoddisfatti()+"\n tot insoddisfatti"+simulator.getnClientiInsoddisfatti()) ;
	
    	
    }

    @FXML
    void initialize() {
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Bar.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";

    }



	public void setSimulator(Simulator s) {
	this.simulator= s ;
		
	}

}
