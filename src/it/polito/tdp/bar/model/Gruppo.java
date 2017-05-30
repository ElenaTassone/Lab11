package it.polito.tdp.bar.model;

import java.util.Random;

public class Gruppo {

	private int nAmici ; 
	private long durata ;
	private float tolleranza ;
	private Tavolo  tavolo ; 
	
	
	public Gruppo(int nAmici, float t ) {
		super();
		this.nAmici = nAmici;
		this.durata = (long) (60 + Math.random() * 60);
		this.tolleranza = t;

	}

	public int getnAmici() {
		return nAmici;
	}

	public void setnAmici(int nAmici) {
		this.nAmici = nAmici;
	}

	//@Override
	//public String toString() {
	
	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo t) {
		this.tavolo = t;
	}

	public long getDurata() {
		return durata;
	}

	public float getTolleranza() {
		return tolleranza;
	}
	
}
