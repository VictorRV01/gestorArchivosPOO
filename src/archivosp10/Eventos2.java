package archivosp10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

//import javax.swing.JOptionPane;

public class Eventos2 extends Eventos implements ActionListener {//EVENTOS
	/*LooknFeel ventana;
	public boolean fileToCopySelected = false;
	public File destinationFile;
	public boolean destinationFileSelected = false;
	public File fileToCopy;
	*/
	//public Eventos2(LooknFeel objeto){
		//ventana = objeto;
	//}
	
	public Eventos2(LooknFeel objeto) {
		super(objeto);
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent evento2) {
		// TODO Auto-generated method stub
		//if (evento2.getSource()==ventana.jbExaminar){
			/*int returnVal = ventana.jfcExaminarEntrada.showOpenDialog(ventana);
			if(returnVal==JFileChooser.APPROVE_OPTION){
				fileToCopy = ventana.jfcExaminarEntrada.getSelectedFile();
				fileToCopySelected = true;
			}*/
		if (evento2.getSource()==ventana.jbExaminar){//si hay evento en el boton examinar
			int returnVal = ventana.jfcExaminarEntrada.showOpenDialog(ventana);//mostramos el jFileChooser
		 	if (returnVal == ventana.jfcExaminarEntrada.APPROVE_OPTION) {//nos aseguramos q haya selecionado algun archivo
		 		
		 		ventana.fileToCopy = ventana.jfcExaminarEntrada.getSelectedFile();//obtenemos el archivo selecionado
		 		ventana.jtfRutaEntrada.setText(ventana.fileToCopy.toString());
				ventana.fileToCopySelected= true;
		 	}
		
				File archivos[]=ventana.jfcExaminarEntrada.getSelectedFiles();
				int i=0;
				for(File f:archivos){
					ventana.tabla.setValueAt(f.getName(), i, 0);
					i++;
				}
				i=0;
		}
		
	}
	

}
		
///////////////////////////////////////////////////////////////////////		
		/*if (destandfiletocopy.destinationFileSelected && destandfiletocopy.fileToCopySelected) {
			
			//Boolean to check if file has been copied.
			boolean isFileCopied = false;
				
			try{
				
				if(destandfiletocopy.destinationFile.exists()){
					//If file exists, it ask the client to choose between overwrite or exit
					int selectedOption = JOptionPane.showConfirmDialog(
							null, "El archivo ya existe, ¿desea reemplazarlo?",
							"Escoga una opcion", JOptionPane.YES_NO_OPTION);
					if (selectedOption == JOptionPane.YES_OPTION) {
						//Calls method copyFile from ManageFiles class if option YES is selected
						isFileCopied = ManejoArchivos.copyFile(destandfiletocopy.fileToCopy, destandfiletocopy.destinationFile);								
					}
				}else{
					//Calls method copyFile from ManageFiles class if file doesn't exists
					isFileCopied = ManejoArchivos.copyFile(destandfiletocopy.fileToCopy, destandfiletocopy.destinationFile);
					
				}
				
				//Show message depending on the result of copyFile method 
			if(isFileCopied){
				JOptionPane.showMessageDialog(getContentPane(), "Archivo"
						+ destandfiletocopy.fileToCopy.getName() + " copiado correctamente.");
			}else{
				JOptionPane.showMessageDialog(getContentPane(), "Error al copiar");
			}
			
				
			}catch(Exception e){
				//Show the error to user
				JOptionPane.showMessageDialog(getContentPane(),"Error! "+e);	
			}

		} else {
			// Error messages if there aren't files selected
			if (!destandfiletocopy.destinationFileSelected && !destandfiletocopy.fileToCopySelected) {
				JOptionPane
						.showMessageDialog(getContentPane(),
								"Seleccione el archivo de origen y el de destino");
			} else if (!destandfiletocopy.destinationFileSelected) {
				JOptionPane.showMessageDialog(getContentPane(),
						"Seleccione antes una ruta para guardar");
			} else if (!destandfiletocopy.fileToCopySelected) {
				JOptionPane.showMessageDialog(getContentPane(),
						"Seleccione antes un archivo a copiar");

			}
		}*/
	
