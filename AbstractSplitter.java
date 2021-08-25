package logic;

import java.io.File;

/**
 * Classe astratta padre di tutti i metodi di divisione.
 */
public abstract class AbstractSplitter implements Runnable {
	protected String path = "C:/Users/Lenovo/Desktop/Tutto/Università/Secondo Anno 19-20/Primo Semestre/Programmazione a Oggetti/Splitter/File Splittati/";
	protected String primo_carattere;
	protected File file;
	protected String nome_file;

	protected int dim_parti;
	protected int DIM_BUFFER = 4*1024;
	
	protected int dim, n_parti, dim_resto;
	
	protected int n_buffer_parti, dim_buffer_parti;
	protected int n_buffer_resto, dim_buffer_resto;
	
	protected Avanzamento avanz;
	Boolean zip;
	
	/**
	 * Il costruttore aggiorna i campi file e ne deriva il nome (nome_file) e prende la dimensione in byte (dim).
	 * @param f file da dividere.
	 */
	public AbstractSplitter(File f){
		file = f;
		nome_file = f.getName();
		dim = (int)f.length();
	}

	/**
	 * La funzione setDim calcolerà tutte le dimensioni utili alla divisione:
	 * 
	 * <p>n_parti = parti del file esattamente di dimensione n passata
	 * <p>dim_resto = dimensione del file che contiene il resto della divisione
	 *
	 * <p>n_buffer_parti = numero di buffer pieni necessari per le parti intere
	 * <p>dim_buffer_parti = dimensione del buffer resto per le parti intere
	 * 
	 * <p>n_buffer_resto = numero di buffer pieni necessari per la parte resto
	 * <p>dim_buffer_resto = dimensione del buffer resto per la parte resto
	 */
	
	public void setDim(){
		n_parti = dim/dim_parti;	//numero di file che saranno creati
		dim_resto = dim%dim_parti;	//dimensione di un eventuale file resto
		
		n_buffer_parti = dim_parti/DIM_BUFFER;	//numero di buffer pieni per una singola parte
		dim_buffer_parti = dim_parti%DIM_BUFFER;//dimensione di un eventuale buffer di resto per ogni parte
		
		n_buffer_resto = dim_resto/DIM_BUFFER;	//numero di buffer pieni per il file resto
		dim_buffer_resto = dim_resto%DIM_BUFFER;//dimensione di un eventuale buffer di resto per il file resto
				
		primo_carattere = "d"; //d per il primo file (che servirà per il merge) e un numero appartenente a [1,n_parti]
	}
	
	/**
	 * La funzione setAvanz passa alle classi la JProgressBar per l'avanzamento globale
	 * @param a avanzamento
	 */
	
	public void setAvanz(Avanzamento a){
		avanz = a;
	}
	
	public void setZip(boolean z){
		zip = z;
	}
}
