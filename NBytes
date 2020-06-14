package logic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * La classe NBytes è la classe da cui deriva la classe Zip.
 * Essa permette di dividere un file dato il numero di bytes per parte.
 */
public class NBytes extends AbstractSplitter{
	File[] fileSplitted;
	
	/**
	 * Il costruttore richiama il costruttore padre, ossia di AbstractSplitter.
	 * <p>Inizializza poi l'array di file che saranno i risultati della divisione del file f, utile per la funzione zip.
	 * <p>Imposta il booleano zip a false, poiché i file risultati non dovranno essere compressi, quindi una volta finita la 
	 * divisione standard, è possibile incrementare la JProgressBar. 
	 * 
	 * @param f file da dividere.
	 * @param n dimensione di ogni parte.
	 */
	public NBytes(File f, int n){
		super(f);
		dim_parti = n;
		setDim();
		
		if(dim_resto == 0)
			fileSplitted = new File[n_parti];
		else
			fileSplitted = new File[n_parti + 1];
		setZip(false);
	}

	/**
	 * Vengono creati un FileInputStream e un FileOutputStream, inizialmente null, e un buffer.
	 * 
	 * <p>Il fis è collegato a file, da cui dovremo infatti leggere.
	 * <p>Poi un ciclicamente viene creato un nuovo file con lo schema: path + carattere + nome originale.
	 * <p>Il primo carattere sarà 'd' o 'z' per il primo file creato, poi 1,2,3...,n_parti.
	 * <p>I nuovi file sono poi inseriti nell'array fileSplitted[].
	 * Alla fine viene incrementata la barra di avanz.
	 * 
	 * <p>È aggiunta una stampa di "ho letto x bytes per nome_file" così da osservare come i thread siano concorrenti.
	 */
	
	@Override
	public void run() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] buffer;   
		
		try {
			fis = new FileInputStream(file);
			
			for (int i=0 ; i<n_parti; i++){
				File f = new File(path + primo_carattere + nome_file);
				buffer = new byte[DIM_BUFFER];
				fos = new FileOutputStream(path + primo_carattere + nome_file);
				
				for (int j=0 ; j<n_buffer_parti+1; j++){
					if (j==n_buffer_parti)
						buffer = new byte[dim_buffer_parti];
					int letto = fis.read(buffer, 0, buffer.length);
					System.out.println("Ho letto " + letto + " bytes per " + f.getName());
					fos.write(buffer, 0, buffer.length);
				}
				fileSplitted[i] = f;
				fos.close();
				primo_carattere = i+1 + "";
			}
			
			if (dim_resto != 0){
				File f = new File(path + primo_carattere + nome_file);
				buffer = new byte[DIM_BUFFER];
				fos = new FileOutputStream(path + primo_carattere + nome_file);
				
				for (int i=0 ; i<n_buffer_resto+1; i++){
					if (i==n_buffer_resto)
						buffer = new byte[dim_buffer_resto];
					int letto = fis.read(buffer, 0, buffer.length);
					System.out.println("Ho letto " + letto + " bytes per " + f.getName());
					fos.write(buffer, 0, buffer.length);
				}
				fileSplitted[n_parti] = f;
			}
			
		fis.close();
		fos.flush();
		fos.close();
		} catch (IOException e) {
				e.printStackTrace();
		}
		if(!zip){
			System.out.println("File " + nome_file + " finito!");
			super.avanz.incrementa();
		}
	}
}
