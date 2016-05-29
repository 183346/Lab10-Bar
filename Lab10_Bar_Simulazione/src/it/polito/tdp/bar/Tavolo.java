package it.polito.tdp.bar;

public class Tavolo implements Comparable<Tavolo>{
	
	private int nPosti;
	private int id;
	boolean libero;
	
	
	public Tavolo(int nPosti, int id, boolean libero) {
		super();
		this.nPosti = nPosti;
		this.id = id;
		this.libero = true;
	}
	public int getnPosti() {
		return nPosti;
	}
	public void setnPosti(int nPosti) {
		this.nPosti = nPosti;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isLibero() {
		return libero;
	}
	public void setLibero(boolean libero) {
		this.libero = libero;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Tavolo other = (Tavolo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public int compareTo(Tavolo o) {
		
		return this.nPosti-o.nPosti;
	}
	@Override
	public String toString() {
		return "Tavolo [nPosti=" + nPosti + ", id=" + id + ", libero=" + libero + "]";
	}
	
	
	

}
