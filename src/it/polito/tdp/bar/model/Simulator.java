package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.bar.model.Event.EventType;


public class Simulator {

	// Simulation parameters
	private List<Tavolo> tavoli;
		//BANCONE
//	private int INTERVALLO_DI_ARRIVO ; 
	 
	
	//World model
	private int tavoliLiberi=0;
	
	
	// Measures of Interest
	private int nTotClienti=0 ;
	private int nClientiSoddisfatti =0;
	private int nClientiInsoddisfatti =0;
	
	// Event queue
	PriorityQueue<Event> queue ;

	public void addTavoli(List<Tavolo> tavoli) {
		this.tavoli = tavoli ;
		tavoliLiberi=tavoli.size() ;
		
		this.queue = new PriorityQueue<>() ;
		}
	

	public void addEventi(Gruppo g, int time) {
		queue.add(new Event(g,time,EventType.ARRIVO_GRUPPI_CLIENTI)) ;
		
	}
	
	public void run() {
		while(!queue.isEmpty()) {
			Event e = queue.poll() ;
			
			// process event
			switch(e.getType()) {
			case ARRIVO_GRUPPI_CLIENTI:
				Tavolo t = this.controllaTavoli(e.getGruppo()) ;
				
				this.nTotClienti+= e.getGruppo().getnAmici() ;
				if(t==null) {
					
					// non ho tavoli liberi o non ho posti sufficienti
					// devo controllare la tolleranza 
					if(this.controllaTolleranza(e.getGruppo())){
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
					e.getGruppo().setTavolo(t);
					// e elimino il tavoo dalla lista di quelli liberi
					this.tavoliLiberi-- ;
					this.tavoli.remove(t) ;
					this.nClientiSoddisfatti+= e.getGruppo().getnAmici() ;
					
					// schedulo un evento in cui il gruppo se ne va
					queue.add(new Event(e.getGruppo(), e.getTime()+e.getGruppo().getDurata(), EventType.USCITA_GRUPPI_CLIENTI)) ;
					}
				break ;
			case USCITA_GRUPPI_CLIENTI:
				// lasciano il tavolo quindi lo riaggiungo
				this.tavoliLiberi++ ;
				tavoli.add(e.getGruppo().getTavolo()) ;
				
			}
		}
	}
	
	
	
	public boolean controllaTolleranza(Gruppo g ){
		float random = (float) Math.random() ;
		if(random<=g.getTolleranza() && g.getTolleranza()!= 0)
			return true ;
		else{
			return false ;
		}
		
	}
	
	private Tavolo controllaTavoli(Gruppo g) {
		//nohn ho tavoli libeir
		if(this.tavoliLiberi==0 )
			return null;
		// ho tavoli liberi e ci entrano e quindi torno il tavolo
		for(Tavolo t : tavoli){
			if(t.getnPosti()>=g.getnAmici()){
				g.setTavolo(t);
				tavoli.remove(t);
				return t;
			}
		}
		return null ;
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
