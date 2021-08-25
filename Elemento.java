package logic;
import java.io.File;

/**
 * Classe di elementi, ossia un oggetto con campi file, operazione, informazioni e estensione
 */
public class Elemento {
	private File file;
	private String operazione;
	private int info;
	private char extra;
	
	/**
	 * Il costruttore senza parametri imposta tutti i campi a 0 o null.
	 */
	public Elemento(){
		file = null;
		operazione = null;
		info = 0;
		extra = 'd';
	}
	
	/**
	 * Il costruttore con i parametri crea un elemento con i campi passati
	 * @param f file
	 * @param op operazione
	 * @param inf informazioni
	 * @param ex estensione
	 */
	public Elemento(File f, String op, int inf, char ex){
		file = f;
		operazione = op;
		info = inf;
		extra = ex;
	}
	
	/**
	 * Imposta il file dell'elemento selezionato
	 * @param f file
	 */
	
	public void setFile(File f){
		file = f;
	}
	
	/**
	 * Imposta l'operazione dell'elemento selezionato
	 * @param s operazione
	 */
	
	public void setOp(String s){
		operazione = s;
	}
	
	/**
	 * Imposta il numero per la divisione dell'elemento selezionato
	 * @param n numero
	 */
	
	public void setInfo(int n){
		info = n;
	}
	
	/**
	 * Imposta l'estensione futura file dell'elemento selezionato
	 * @param ex estensione
	 */
	
	public void setExtra(char ex){
		extra = ex;
	}
	
	/**
	 * Ritorna il file dell'elemento
	 * @return file
	 */
	
	public File getFile(){
		return file;
	}
	
	/**
	 * Ritorna l'operazione sul file dell'elemento
	 * @return operazione
	 */
	
	public String getOp(){
		return operazione;
	}
	
	/**
	 * Ritorna l'informazione sul file dell'elemento
	 * @return informazione
	 */
	
	public int getInfo(){
		return info;
	}
	
	/**
	 * Ritorna la futura estensione dell'elemento
	 * @return estensione
	 */
	
	public char getExtra(){
		return extra;
	}
}
