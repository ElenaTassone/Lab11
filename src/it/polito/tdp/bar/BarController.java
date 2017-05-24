package it.polito.tdp.bar;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
	int time = 0 ; 

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
    	for(int i=0 ; i<2 ;  i++){
    		Tavolo t = new Tavolo(10);
    		tavoli.add(t) ;
    	}
    	for(int i=0 ; i<4 ;  i++){
    		Tavolo t = new Tavolo(8);
    		tavoli.add(t) ;
    	}
    	for(int i=0 ; i<4 ;  i++){
    		Tavolo t = new Tavolo(6);
    		tavoli.add(t) ;
    	}
    	for(int i=0 ; i<5 ;  i++){
    		Tavolo t = new Tavolo(4);
    		tavoli.add(t) ;
    	}
    	simulator.addTavoli(tavoli);
    	
    	for (int i = 0 ; i <2000; i++){
    		time = time + (int) (1+Math.random()*10);
    		int n = (int) (1+Math.random()*10);
    		Gruppo g = new Gruppo (n);
    		simulator.addEventi(g, time);
    	}
    	simulator.run();
    	txtResult.setText("Statistica: tot clienti"+simulator.getnTotClienti()+", tot soddisfatti "
    			+simulator.getnClientiSoddisfatti()+" tot insoddisfatti"+simulator.getnClientiInsoddisfatti()) ;
	
    	
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
