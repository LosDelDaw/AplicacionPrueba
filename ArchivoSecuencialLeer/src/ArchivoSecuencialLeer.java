import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *  @descrition Clase que arbre un archivo en forma secuencial, con stream y buffer para leer las líneas del archivo

 */
public class ArchivoSecuencialLeer {

	public static void main(String[] args) throws IOException{
		Path filein= Paths.get("entrada.txt");
		Path fileout= Paths.get("salida.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader=null;
		BufferedWriter writer=null;
		
		try{
			//Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(filein, charset);		
			writer = Files.newBufferedWriter(fileout, charset,WRITE,TRUNCATE_EXISTING);
			
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		        if (Character.toUpperCase(line.charAt(0))=='A')
		        		writer.write(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}finally {
			
            if (reader != null) {
                reader.close();
            }
            if (writer !=null){
            	writer.close();
            }
		}
	}

}
