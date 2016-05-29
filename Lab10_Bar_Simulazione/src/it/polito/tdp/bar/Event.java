package it.polito.tdp.bar;

public class Event implements Comparable<Event>{
	
	private int time;
	private int nPersone;
	private int durata;
	private float tolleranza;
	private Movimento tipoEvento;
	public Event(int time, int nPersone,int durata,  float tolleranza, Movimento tipoEvento) {
		super();
		this.time = time;
		this.nPersone = nPersone;
		this.tolleranza = tolleranza;
		this.tipoEvento=tipoEvento;
		this.durata=durata;
		
	}
	
	public enum Movimento {
		ARRIVO, PARTENZA
	};
	
	
	public Movimento getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(Movimento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getnPersone() {
		return nPersone;
	}
	public void setnPersone(int nPersone) {
		this.nPersone = nPersone;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public float getTolleranza() {
		return tolleranza;
	}
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + durata;
		result = prime * result + nPersone;
		result = prime * result + time;
		long temp;
		temp = Double.doubleToLongBits(tolleranza);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (durata != other.durata)
			return false;
		if (nPersone != other.nPersone)
			return false;
		if (time != other.time)
			return false;
		if (Double.doubleToLongBits(tolleranza) != Double.doubleToLongBits(other.tolleranza))
			return false;
		return true;
	}
	@Override
	public int compareTo(Event arg0) {
		
		return this.time-arg0.time;
	}
	
	
	
	
	
	

}
