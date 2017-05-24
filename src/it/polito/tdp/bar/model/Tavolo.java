package it.polito.tdp.bar.model;

public class Tavolo {

	public enum statoTavolo { LIBERO, OCCUPATO } ;
	
	private int nPosti ;
	private statoTavolo stato;
	
	
	public Tavolo(int nPosti) {
		super();
		this.nPosti = nPosti;
		this.stato = statoTavolo.LIBERO ; 
	}


	public int getnPosti() {
		return nPosti;
	}


	public void setnPosti(int nPosti) {
		this.nPosti = nPosti;
	}


	public statoTavolo getStato() {
		return stato;
	}


	public void setStato(statoTavolo stato) {
		this.stato = stato;
	}


	@Override
	public String toString() {
		return "Tavolo [nPosti=" + nPosti + ", stato=" + stato + "]";
	} 
	
	
	


}
