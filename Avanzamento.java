package logic;
import javax.swing.JProgressBar;

/**
 * La classe avanzamento gestisce la JProgressBar dell'avanzamento globale
 */
public class Avanzamento extends JProgressBar{
	private int nElementi;
	
	/**
	 * Il costruttore prende il numero degli elementi e richiama la funzione per inizializzare la barra.
	 * @param n numero elementi.
	 */
	public Avanzamento(int n){
		nElementi = n;
		setInizio();
	}
	
	/**
	 * L'inizializzazione della barra consiste nel mettere il valore iniziale a 0 e il valore massimo al numero di elementi.
	 */
	public void setInizio(){
		setVoid();
		setMaximum(nElementi);
	}
	
	/**
	 * La funzione incrementa aumenta di uno il valore della barra.
	 */
	public void incrementa(){
		int v = getValue();
		setValue(v+1);
	}
	
	/**
	 * La funzione svuota la progress bar.
	 */
	
	public void setVoid(){
		setValue(0);
		this.repaint();
	}
}
