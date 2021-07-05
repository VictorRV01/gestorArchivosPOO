package copiarcarpeta;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.OutputStream;
import java.nio.file.Files; 

/** 
 * @author: Crysfel Villa 
 * Created: Friday, June 03, 2005 4:54:59 PM 
 * Modified: Friday, June 03, 2005 4:54:59 PM 
 */ 


public class Copiar{ 
	
    /** 
     * Copia un directorio con todo y su contendido 
     * @param srcDir 
     * @param dstDir 
     * @throws IOException 
     */ 
    public void copyDirectory(File srcDir, File dstDir) throws IOException { 
        if (srcDir.isDirectory()) { 
            if (!dstDir.exists()) { 
                dstDir.mkdir(); 
            } 
             
            String[] children = srcDir.list(); 
            for (int i=0; i<children.length; i++) { 
                copyDirectory(new File(srcDir, children[i]), 
                    new File(dstDir, children[i])); 
            } 
        } else { 
            copy(srcDir, dstDir); 
        } 
    } 
     
    /** 
     * Copia un solo archivo 
     * @param files 
     * @param files2 
     * @throws IOException 
     */ 
    public void copy(File file, File file2) throws IOException { 
        InputStream in = new FileInputStream(file); 
        OutputStream out = new FileOutputStream(file2); 
         
         
        byte[] buf = new byte[1024]; 
        int len; 
        while ((len = in.read(buf)) > 0) { 
            out.write(buf, 0, len); 
        } 
        in.close(); 
        out.close(); 
    } 
     
    public static void main(String arg[]){ 
        Copiar cp = new Copiar(); 
        
        try{ 
            //cp.copyDirectory(new File("ALGEBRA"),new File("ALGEBRA-COPY")); 
        	cp.copy(new File("C:/Users/dell14/Documents/Calculo Integral"),new File("C:/Users/dell14/Desktop/"));
            System.out.print("Copiado con exito"); 
        }catch(Exception e){ 
            System.out.println(e); 
        } 
    } 
}