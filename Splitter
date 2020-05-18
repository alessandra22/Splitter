package logic;
import java.io.File;

/**
 * Classe che gestisce lo splitter: qui viene mandata la coda, i cui elementi sono gestiti dalle corrispettive classi di 
 * di divisione.
 */
public class Splitter {
	private File file;
	private String operazione;
	private int numero;
	private char ext;
	private Avanzamento avanzamento;
	
	private Coda coda;
	protected Thread[] jobs;
	
	/**
	 * Il costruttore inizializza la coda (privata) con quella passata per argomento
	 * 
	 * @param c, coda creata tramite GUI.
	 * @param a, avanzamento che gestisce la JProgressBar 
	 */
	
	public Splitter(Coda c, Avanzamento a){
		coda = c;	
		avanzamento = a;
	}
	
	/**
	 * La funzione start() inizializza un array di Thread, dalla dimensione della coda, ossia degli elementi da splittare. 
	 * <p>Dopodiché scorre tramite un ciclo for la coda e, per ogni elemento, viene inizializzata la variabile elem, 
	 * (inizialmente di tipo AbstractSplitter, classe padre di tutte le classi di divisione) con la classe di divisione specificata
	 * nel campo operazione e l'estensione richiesta nel campo extra. 
	 * 
	 * <p>All'elemento appena creato viene passato l'oggetto Avanzamento. L'elemento è poi usato come parametro per la creazione di
	 * un Thread, da aggiungere all'array jobs creato al momento, e poi fatto partire.
	 * 
	 */
	
	public void start(){
		jobs = new Thread[coda.getSize()];
		for (int i=0 ; i<coda.getSize() ; i++){
			operazione = coda.getOpIndex(i);
			numero = coda.getInfoIndex(i);
			ext = coda.getExtraIndex(i);
			file = coda.getFileIndex(i);
			AbstractSplitter elem = null;
			
			if (operazione == "#parti")
				elem = new NPar(file, numero);
			else
				switch(ext){
					case 'd': 
						elem = new NBytes(file, numero);
						break;
					case 'z': 
						elem = new Zip(file, numero);
						break;
				}
			elem.setAvanz(avanzamento);
			jobs[i] = new Thread(elem);
			jobs[i].start();
		}
	}
}
