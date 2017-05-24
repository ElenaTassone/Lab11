package it.polito.tdp.bar.model;

public class Gruppo {

	private int nAmici ; 
	private int durata ;
	private float tolleranza ;
	private Tavolo  tavolo ; 
	
	public Gruppo(int nAmici ) {
		super();
		this.nAmici = nAmici;
		this.durata = (int) (60+Math.random()*61) ;
		this.tolleranza = (float) Math.random() ;
			if(tolleranza>0.90)
				tolleranza = (float) 0.90 ; 
		
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

	public int getDurata() {
		return durata;
	}

	public float getTolleranza() {
		return tolleranza;
	}
	
}
