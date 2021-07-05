package copiarcarpeta3;
import java.io.*;
/*
Clase que copia un archivo o una carpeta
con todos sus subdiretorios 
 */

public class CopiarFicherosYCarpetas {
/*
 * Autor:LBVP
 */
public static int  EntraIncial=0;    
public static void main(String[] args) {
        //Fichero desde el cual se van a copiar los datos
        File FOrigen=new File("C:/Users/dell14/Documents/Calculo Integral");
        //Fichero donde se van a copiar los datos
        File FDestino=new File("/Users/dell14/Desktop");
        Copiar(FOrigen,FDestino);
        EntraIncial=0;   
}

/*Metodo que copia completamente una carpeta usando recursividad
 *PARAMETRO1:FOrigen:Fichero o carpeta que se desea copiar
 *PARAMETRO2:FDestino:Carpeta destino
 */
public static void Copiar(File FOrigen,File FDestino){
        //si el origen no es una carpeta
        if(!FOrigen.isDirectory()){
            //Llamo la funcion que lo copia
            CopiarFichero(FOrigen,FDestino);
        }else{
           //incremento el contador de entradas a esta funcion 
           EntraIncial++; 
           //si es el directorio padre(1 carpeta a copiar)
           if(EntraIncial==1){
                //Cambio la ruta destino por el nombre que tenia mas el nombre de
                //la carpeta padre
                FDestino=new File(FDestino.getAbsolutePath()+"/"+FOrigen.getName()); 
                //si la carpeta no existe la creo
                if(!FDestino.exists()){
                    FDestino.mkdir();
                }
           } 
           //obtengo el nombre de todos los archivos y carpetas que 
           //petenecen a este fichero(FOrigen)
           String []Rutas=FOrigen.list();
           //recorro uno a uno el contenido de la carpeta
           for(int i=0;i<Rutas.length;i++){
              //establesco el nombre del nuevo archivo origen 
              File FnueOri=new File(FOrigen.getAbsolutePath()+"/"+Rutas[i]);
              //establesco el nombre del nuevo archivo destino 
              File FnueDest= new File(FDestino.getAbsolutePath()+"/"+Rutas[i]);
              //si no existe el archivo destino lo creo
              if(FnueOri.isDirectory() && !FnueDest.exists()){
                  FnueDest.mkdir();                        
              }
              //uso recursividad y llamo a esta misma funcion has llegar
              //al ultimo elemento    
              Copiar(FnueOri,FnueDest); 
           }
        }
        
}    
public static void CopiarFichero(File FOrigen,File FDestino){
            try {
            //Si el archivo a copiar existe
            if(FOrigen.exists()){
                String copiar="S";
                //si el fichero destino ya existe
                if(FDestino.exists()){
                   System.out.println("El fichero ya existe, Desea Sobre Escribir:S/N ");
                   copiar = ( new BufferedReader(new InputStreamReader(System.in))).readLine();
                }
                //si puedo copiar
                if(copiar.toUpperCase().equals("S")){
                    //Flujo de lectura al fichero origen(que se va a copiar)            
                    FileInputStream LeeOrigen= new FileInputStream(FOrigen);
                    //Flujo de lectura al fichero destino(donde se va a copiar)
                    OutputStream Salida = new FileOutputStream(FDestino);
                    //separo un buffer de 1MB de lectura
                    byte[] buffer = new byte[1024];
                    int tamaño;
                    //leo el fichero a copiar cada 1MB
                    while ((tamaño = LeeOrigen.read(buffer)) > 0) {
                    //Escribe el MB en el fichero destino
                    Salida.write(buffer, 0, tamaño);
                    }
                    System.out.println(FOrigen.getName()+" Copiado con Exito!!");
                    //cierra los flujos de lectura y escritura
                    Salida.close();
                    LeeOrigen.close();
                }
                
            }else{//l fichero a copiar no existe                
                System.out.println("El fichero a copiar no existe..."+FOrigen.getAbsolutePath());
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        
       }
    
    
}

}