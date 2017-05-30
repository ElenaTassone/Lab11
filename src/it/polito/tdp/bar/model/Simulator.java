package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import it.polito.tdp.bar.model.Event.EventType;
import it.polito.tdp.bar.model.Tavolo.statoTavolo;


public class Simulator {
	
	Random rd = new Random(42) ;
	
	// Simulation parameters
	private List<Tavolo> tavoli = new ArrayList<Tavolo> ();
		//BANCONE
	 
	
	//World model
	private int tavoliLiberi=0;
	
	
	// Measures of Interest
	private int nTotClienti=0 ;
	private int nClientiSoddisfatti =0;
	private int nClientiInsoddisfatti =0;
	
	// Event queue
	PriorityQueue<Event> queue = new PriorityQueue<>() ;


	public void addTable(int numPosti, int id) {
		Tavolo temp = new Tavolo(id, numPosti);
		tavoli.add(temp) ;
		
	}
	public void addTavoli(List<Tavolo> tavoli) {
		this.tavoli = tavoli ;
		tavoliLiberi=tavoli.size() ;
		
		this.queue = new PriorityQueue<>() ;
		}
	

	public void addEventi(Gruppo g, long time) {
		queue.add(new Event(g,time,EventType.ARRIVO_GRUPPI_CLIENTI)) ;
		
	}
	
	public void run() {
		while(!queue.isEmpty()) {
			Event e = queue.remove() ;
			
			// process event
			switch(e.getType()) {
			case ARRIVO_GRUPPI_CLIENTI:
				Tavolo t = this.controllaTavoli(e.getGruppo()) ;
				
				this.nTotClienti+= e.getGruppo().getnAmici() ;
				if(t==null) {
					
					// non ho tavoli liberi o non ho posti sufficienti
					// devo controllare la tolleranza 
					if(this.controllaTolleranza(e.getGruppo())==true){
						// tolleranza ok, quindi aumento soddisfatti e clienti
						this.nClientiSoddisfatti+= e.getGruppo().getnAmici() ;
						
					}
					else{
						this.nClientiInsoddisfatti+= e.getGruppo().getnAmici();
					}
				}
				// HO TAVOLI LIBERI
				else {
					// fai sedere il gruppo
					
					// assegno il taavolo
					// e elimino il tavoo dalla lista di quelli liberi
					
					for(Tavolo t2 : tavoli){
						if(t2.getIdTavolo()==t.getIdTavolo()){
								t2.setStato(statoTavolo.OCCUPATO);
								e.getGruppo().setTavolo(t2);
								this.nClientiSoddisfatti+= e.getGruppo().getnAmici() ;
								break;
							}
						}
					
					// schedulo un evento in cui il gruppo se ne va
					queue.add(new Event(e.getGruppo(), e.getTime()+e.getGruppo().getDurata(), EventType.USCITA_GRUPPI_CLIENTI)) ;
					}
				
				break ;
			case USCITA_GRUPPI_CLIENTI:
				// lasciano il tavolo quindi lo riaggiungo
				//this.tavoliLiberi++ ;
				for(Tavolo t2 : tavoli){
					if(t2.getIdTavolo()==e.getGruppo().getTavolo().getIdTavolo()){
						t2.setStato(statoTavolo.LIBERO);
						break;
					}
				}
				
				
			}
		}
	}
	
	
	
	public boolean controllaTolleranza(Gruppo g ){
		float random = rd.nextFloat();
		if(random<=g.getTolleranza()) 
			return true ;
		else{
			return false ;
		}
		
	}
	
	private Tavolo controllaTavoli(Gruppo g) {
		Tavolo ritorno = null ;
		int tBest = 1000000000 ;
		// ho tavoli liberi e ci entrano e quindi torno il tavolo
		for(Tavolo t : tavoli){
			if(t.getStato().compareTo(statoTavolo.LIBERO)==0
					&& g.getnAmici()>=0.5*t.getnPosti()
					&& t.getnPosti()>=g.getnAmici()){
				if(t.getnPosti()<tBest ){
					tBest = t.getnPosti() ;
					ritorno = t;
					}
				}
			}
				return ritorno;
			
	}

		

	public int getnTotClienti() {
		return nTotClienti;
	}
	
	public int getnClientiSoddisfatti() {
		return nClientiSoddisfatti;
	}
	public int getnClientiInsoddisfatti() {
		return nClientiInsoddisfatti;
	}






	
	
	
	
	
}
