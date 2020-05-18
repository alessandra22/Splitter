package logic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

/**
 * Classe che riunisce i file divisi. Estende la classe Zip, così da servirsi della funzione unzip.
 */
public class Merger extends Zip{
	File primoFile;
	String parte1, parte2;
	String nomeFile;
	boolean zip;
	Vector <File> filesDaUnire;
	
	/**
	 * Il costruttore deve utilizzare prima quello della classe padre, inizializza poi il file primoFile a f.
	 * <p>Inizializza poi una stringa s col nome del percorso assoluto del file; questa viene poi divisa tra path e nome del file, 
	 * così da non avere più il primoCarattere. L'unione tra le due stringhe trovate darà infatti il nome originale del file.
	 * 
	 * <p>Inizialmente lo zip è disattivato e il primo file viene unito al Vector di files da unire.
	 * @param f primo file da unire.
	 */
	
	public Merger(File f){
		super(f,1);
		primoFile = f;
		
		String s = primoFile.getAbsolutePath();
		int pos = s.lastIndexOf(primoFile.getName());
		parte1 = s.substring(0, pos);
		parte2 = s.substring(pos+1);
		nomeFile = parte1+parte2;
		
		zip = false;
		filesDaUnire = new Vector<File>();
		filesDaUnire.add(primoFile);
	}
	
	/**
	 * La funzione cercaFile inizializza zip grazie al primo carattere del nome di primoFile.
	 * 
	 * <p>Ciclicamente poi cerca un file formato dalle due stringhe ricavate, con al posto del primo carattere precedentemente 
	 * cancellato, i numeri a partire da 1. Se il file esiste, viene aggiunto al Vector di file da unire.
	 * <p>Il ciclo si ferma quando il file non viene trovato.
	 */
	
	public void cercaFile(){		
		if (primoFile.getName().startsWith("z")){
			zip = true;
		}
		for (int i=1 ; ; i++){
			String nomeFileDaTrovare = parte1 + i + parte2;
			File f = new File(nomeFileDaTrovare);
			
			if (f.exists())
				filesDaUnire.add(f);
			else
				break;
		}
	}

	/**
	 * Se il primoFile era compresso, il processo di unione parte dalla estrazione dei file originari. Questi sostituiscono poi 
	 * i file compressi nel Vector di file da unire. Viene poi tolta l'estensione .zip dal nome del file finale.
	 * 
	 * <p>Poi vengono uniti tutti i file nel formato originale e, se i file erano compressi e sono stati estratti, i file estratti
	 * vengono eliminati. 
	 * Il Vector viene poi svuotato.
	 */
	
	@Override
	public void run() {
		cercaFile();
		if (zip){
			int pos = parte2.lastIndexOf(".zip");
			parte2 = parte2.substring(0, pos);
			
			for(int i=0 ; i<filesDaUnire.size(); i++){
				filesDaUnire.add(i, unzip(filesDaUnire.get(i)));
				filesDaUnire.remove(i+1);
			}
			nomeFile = parte1 + parte2;
		}
		File fileFinale = new File(nomeFile);
		
		try {
			FileOutputStream fos = new FileOutputStream(fileFinale);
			FileInputStream fis = null;
			String primoC; 
				if (zip)
					primoC = "z";
				else
					primoC = "d";
				
			for (int i=0 ; i<filesDaUnire.size() ;i++){
				byte[] buffer = new byte[4096];
				fis = new FileInputStream(parte1 + primoC + parte2);
				
				int length;
				while((length = fis.read(buffer)) >= 0){
					fos.write(buffer, 0, length);
				}
				primoC = (i+1)+"";
				fis.close();
			}
			fos.close();
			
			if(zip){
				primoC = "z";
				for(int i=0 ; i<filesDaUnire.size() ; i++){
					File f = new File(parte1 + primoC + parte2);
					f.delete();
					primoC = (i+1) + "";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		filesDaUnire.removeAllElements();
	}
}
