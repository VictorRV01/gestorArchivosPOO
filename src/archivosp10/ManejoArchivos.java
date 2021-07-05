package archivosp10;

import java.io.BufferedReader;  
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

public class ManejoArchivos {
	public static int  EntraIncial=0;    
	 
	
public static boolean copyFile(File source, File destination){
	
	try{
		FileInputStream fis = new FileInputStream(source); //inFile -> Archivo a copiar
		FileOutputStream fos = new FileOutputStream(destination); //outFile -> Copia del archivo
		FileChannel inChannel = fis.getChannel(); 
		FileChannel outChannel = fos.getChannel(); 
		inChannel.transferTo(0, inChannel.size(), outChannel); 
		fis.close(); 
		fos.close();
		}catch (Exception e) {
		//System.err.println("Error al Generar Copia");
			
		}
	return true;

}
public static void CopiarDirectorio(File source, File destination) throws Exception { 
	try {
		if (source.isDirectory()) { 
			if (!destination.exists())
				destination.mkdir(); 
 
			String[] hijos = source.list(); 
			for (int i=0; i < hijos.length; i++) { 
				CopiarDirectorio(new File(source, hijos[i]), 
					new File(destination, hijos[i])); 
			} // end for
		} else { 
			//ManejoArchivos copiar = new ManejoArchivos();
			ManejoArchivos.copyFile(source, destination);
			//Copiar(source, destination); 
		} // end if
	} catch (Exception e) {
		throw e;
	} // end try
}
}

