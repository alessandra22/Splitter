package logic;
import java.io.File;
import java.util.Vector;

/**
 * La classe Coda è una gestione di un Vector di oggetti Elemento, che sta alla base della JTable e della divisione.
 */
public class Coda extends Elemento{
	public Vector <Elemento> coda;
	
	/**
	 * Il costruttore inizializza un Vector di oggetti Elemento.
	 */
	public Coda(){
		coda = new Vector<Elemento>();
	}
	
	/**
	 * La funzione addFiles riceve un array di File e li aggiunge alla coda.
	 * @param f array di file che proviene dal JFileChooser.
	 */
	public void addFiles(File[] f){
		if(f!=null){
			for(int i=0 ; i<f.length ; i++){
				Elemento e = new Elemento();
				e.setFile(f[i]);
				coda.add(e);
			}
		}
		else 
			System.out.println("Nessun file selezionato");
	}
	
	/**
	 * Funzione che restituisce l'elemento all'indice i.
	 * @param i indice.
	 * @return elemento.
	 */
	
	public Elemento getElementoIndex(int i){
		if (coda.size()>0)
			return coda.get(i);
		else
			return null;
	}
	/**
	 * Funzione che restituisce la dimensione della coda.
	 * @return dimensione della coda.
	 */
	public int getSize(){
		return coda.size();
	}
	
	/**
	 * Funzione che restituisce il nome del file all'indice i.
	 * @param i indice.
	 * @return nome del file.
	 */
	
	public String getNameFile(int i){
		return coda.get(i).getFile().getName();
	}
	
	/**
	 * Funzione che restituisce il file all'indice i.
	 * @param i indice.
	 * @return file.
	 */
	
	public File getFileIndex(int i){
		return coda.get(i).getFile();
	}
	
	/**
	 * Funzione che restituisce il numero opportuno per la divisione del file all'indice i.
	 * @param i indice.
	 * @return numero.
	 */
	
	public int getInfoIndex(int i){
		return coda.get(i).getInfo();
	}
	
	/**
	 * Funzione che restituisce l'operazione richiesta per la divisione del file all'indice i.
	 * @param i indice.
	 * @return operazione.
	 */
	
	public String getOpIndex(int i){
		return coda.get(i).getOp();
	}
	
	/**
	 * Funzione che restituisce l'estensione richiesta per la divisione del file all'indice i.
	 * @param i indice.
	 * @return d per default, z per compressione.
	 */
	
	public char getExtraIndex(int i){
		return coda.get(i).getExtra();
	}
	
	/**
	 * Funzione che imposta l'elemento all'indice i.
	 * @param i indice.
	 * @param f file.
	 * @param op operazione.
	 * @param n numero.
	 * @param ex estensione.
	 */
	
	public void setElementoIndex(int i, File f, String op, int n, char ex){
		Elemento e = new Elemento(f,op,n,ex);
		coda.set(i, e);
	}
	
	/**
	 * Funzione rimuove l'elemento all'indice i.
	 * @param i indice.
	 */
	
	public void deleteIndex(int i){
		coda.remove(i);
	}
}
