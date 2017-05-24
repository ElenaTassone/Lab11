package it.polito.tdp.bar.model;



public class Event implements Comparable<Event> {
	
	public enum EventType { 
		ARRIVO_GRUPPI_CLIENTI , // un gruppo di clienti arriva ed ha bisogno di un tavolo
		USCITA_GRUPPI_CLIENTI   // un gruppo di clienti va viua, soddisfatto o meno 
	}
	
	private Gruppo gruppo ;
	private int time ; //intervallo in cui si verifica l'evento (1-10)
	private EventType type ;

	

	public Event(Gruppo g, int time, EventType type) {
		super();
		this.gruppo = g ;
		this.time = time;
		this.type = type;
		
	}
	
//	
//	public Event(int time, int num_persone, int durata, int tolleranza) {
//		super();
//		this.time = time;
//		this.num_persone = num_persone;
//		this.durata = durata;
//		this.tolleranza = tolleranza;
//	}
//	
//	@Override
//	public String toString() {
//		return "Event [time=" + time + ", num_persone=" + num_persone + ", durata=" + durata + ", tolleranza="
//				+ tolleranza + "]";
//	}

	public Gruppo getGruppo() {
		return gruppo;
	}

	

	@Override
	public int compareTo(Event altro) {
		return this.time-altro.time;
	};
	public EventType getType() {
		return type;
	}


	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	

}
