package logic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * La classe Zip deriva dalla classe NBytes e permette di dividere un file in un numero di bytes scelto, per poi 
 * comprimere il risultato.
 */
public class Zip extends NBytes{
	File[] filesDaComprimere;
	
	/**
	 * Il costruttore richiama quello della classe padre NBytes.
	 * <p>Imposta poi il primo carattere a z e imposta zip a true: infatti una volta terminata la divisione del padre non vogliamo
	 * incrementare la barra, in quanto manca ancora la compressione dei file generati
	 * 
	 * @param f file.
	 * @param n dim_parti.
	 */
	public Zip(File f, int n){
		super(f, n);
		primo_carattere = "z";
		setZip(true);
	}
	
	/**
	 * La divisione sfrutta quella della classe padre, per poi passare a comprimere i file grazie allo ZipOutputStream. 
	 * I file generati dalla classe padre sono eliminati
	 */
	public void run(){
		super.run();
		filesDaComprimere = fileSplitted;
		
		try {
			for (int i=0 ; i<filesDaComprimere.length ; i++){	
				File fileDaComprimere = filesDaComprimere[i];
				
				String s = fileDaComprimere.getName();
				FileOutputStream fos = new FileOutputStream(path + s + ".zip");
				ZipOutputStream zos = new ZipOutputStream(fos);
				FileInputStream fis = new FileInputStream(fileDaComprimere);
				byte[] buffer = new byte[4*1024];
				
		        ZipEntry zipEntry = new ZipEntry(fileDaComprimere.getName());
		        zos.putNextEntry(zipEntry);
		        
		        int length;
		        while((length = fis.read(buffer)) >= 0) {
		            zos.write(buffer, 0, length);
		        }
		        zos.close();
		        fis.close();
		        fos.close();
		     
		        fileDaComprimere.delete();
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		System.out.println("File " + nome_file + " finito!");
		super.avanz.incrementa();
	}
	
	/**
	 * La funzione unzip, utile nel merge dei file, grazie allo ZipInputStream, estrae i file e li salva in formato originale.
	 * @param f file da cui estrarre
	 * @return file estratto
	 */
	public File unzip(File f){
		String vecchioNome = f.getName();
		int pos = vecchioNome.lastIndexOf(".zip");
		String nuovoNome = vecchioNome.substring(0, pos);
		
		File fileEstratto = new File(nuovoNome);
		byte[] buffer = new byte[4096];
		try{
			FileOutputStream fos = new FileOutputStream(path + fileEstratto.getName());
			FileInputStream fis = new FileInputStream(path + vecchioNome);
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = zis.getNextEntry();
			
			if(ze!=null){
				int len;
				while ((len = zis.read(buffer)) > 0) {
				   	fos.write(buffer, 0, len);
				}
			}
			fos.close();
			zis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileEstratto;
	}
}
