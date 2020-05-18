package logic;
import java.io.File;

/**
 * La classe NPar è una classe figlia di NBytes. In particolare si sfrutta la divisione a partire dal numero di bytes per parte
 * calcolando questo numero a partire dal numero di parti: per dividere il file in n parti, ogni parte avrà dimensione pari alla
 * divisione intera fra dimensione totale e n. Potrebbe esserci un resto dato dal modulo tra la dimensione totale e n. 
 */
public class NPar extends NBytes{
	
	/**
	 * Il costruttore richiama il costruttore di NBytes, passando come dimensione delle parti la dim totale del file e 
	 * il numero delle parti richieste.
	 * @param f file
	 * @param n dim/n_parti
	 */
	public NPar(File f, int n){
		super(f, ((int)f.length())/n);
	}
	
	/**
	 * Il metodo di divisione, una volta modificata la dimensione delle parti, è analoga a quella di NBytes. 
	 */
	
	public void run(){
		super.run();
	}
}
