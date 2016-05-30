package it.polito.tdp.bar;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.TreeMap;




public class Model {
	
	
	Queue<Event> coda = new PriorityQueue<Event>();
	List<Tavolo> tavoli =  new LinkedList<Tavolo>();
	int numerotavoli=0;
	int numeroSoddisfatti=0;
	int numeroInsoddisfatti=0;
	int numeroBancone=0;
	static String result="";

	public String creaTavoli(int nPosti) {
		
		String sTavoli="";
		this.numerotavoli++;
		Tavolo tavolo = new Tavolo(nPosti,this.numerotavoli,true);
		sTavoli="aggiunto il tavolo n.:  "+ this.numerotavoli +" di "+nPosti + "  posti"+"\n";
		tavoli.add(tavolo);
		return sTavoli;
		
	}
	
	
	

	public String simula() {
		coda.clear();
		int lineaTempo=0;
		this.numeroBancone=0;
		this.numeroInsoddisfatti=0;
		this.numeroSoddisfatti=0;
		// creazione 2000 Eventi a=0rrivo
		for(int conta=0;conta<2000;conta++){
		// random
			Random random = new Random();
			int randomTime = random.nextInt(9)+1;
			//System.out.println(randomTime);
			Random random1 = new Random();
			int randomGruppo= random1.nextInt(9)+1;
			//System.out.println(randomGruppo);
			Random random3 = new Random();
			int randomDurata = random3.nextInt(60)+60;
			//System.out.println(randomDurata);
			Random random4 = new Random();
			float randomTolleranza = (random4.nextFloat());
			//System.out.println(randomTolleranza);
			lineaTempo=randomTime+lineaTempo;
		// creazione eventi di arrivo e partenza
			coda.add(new Event(lineaTempo,randomGruppo,randomDurata,randomTolleranza,Event.Movimento.ARRIVO));
			
	     }
		//	esame degli eventi
			//System.out.println(tavoli.toString());
		
	 		
			while (!coda.isEmpty()) {
			passo();
		}
			
			result=result+" Numero Clienti Soddisfatti : "+this.numeroSoddisfatti+"\n";
			result=result+" Numero Clienti Insoddisfatti : "+this.numeroInsoddisfatti+"\n";
			result=result+" Numero Clienti al bancone : "+this.numeroBancone+"\n";

	
		return result;
	}


	private void passo() {
		
		Event e = coda.remove();
		switch (e.getTipoEvento()) {
		case ARRIVO:
			boolean li=false;
			Collections.sort(tavoli);
			for(Tavolo tt: tavoli){
				if(li==false){
				if(tt.isLibero()){
					if(tt.getnPosti()>=e.getnPersone()){
						if(e.getnPersone()>=tt.getnPosti()/2){
							this.numeroSoddisfatti++;
							tt.setLibero(false);
							coda.add(new Event(e.getTime()+e.getDurata(),e.getnPersone(),tt.getId(),0,Event.Movimento.PARTENZA));
							result=result+"un gruppo di :"+e.getnPersone()+"  è messo al tavolo " + tt.getId()+" al tempo "+e.getTime()+"\n";
						li=true;}}}}}
			
			if(e.getTolleranza()<=0.9 && li==false){
					this.numeroSoddisfatti++;
					this.numeroBancone++;
					li=true;
					result=result+"un gruppo di :"+e.getnPersone()+"  è messo al bancone " +" al tempo "+e.getTime()+"\n";
					coda.add(new Event(e.getTime()+e.getDurata(),e.getnPersone(),0,0,Event.Movimento.PARTENZA));
				}
				
				
						if(!li){this.numeroInsoddisfatti++;
				result=result+"un gruppo di :"+e.getnPersone()+"  lascia il locale per mancanza posti " +" al tempo "+e.getTime()+"\n";
				}
				break;
				case PARTENZA:
					if(e.getDurata()==0){result=result+"un gruppo di :"+e.getnPersone()+"  lascia il locale dopo consumazione al bancone " +" al tempo "+e.getTime()+"\n";}
			for(Tavolo ta:tavoli){
				if(ta.getId()==e.getDurata()){
					ta.setLibero(true);
					result=result+"un gruppo di :"+e.getnPersone()+"  lascia il locale dopo consumazione al tavolo " +" al tempo "+e.getTime()+"\n";
				}
				
			}
			
			break;
		default:
			break;
	
		}

	}

}
