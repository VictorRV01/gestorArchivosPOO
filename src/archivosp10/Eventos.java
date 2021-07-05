package archivosp10;
import java.awt.event.*;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Eventos {//EVENTOS2
	//LooknFeel ventana;
		//File fileImagen;
		//protected File fileToCopy
		//protected File destinationFile;
		//protected boolean fileToCopySelected = false;
		//protected File destinationFile;
		//protected boolean destinationFileSelected = false;
	
	//public Eventos(LooknFeel objeto) {
		//super(objeto);
		// TODO Auto-generated constructor stub
	//}	
	public LooknFeel ventana;
	
	
	//public boolean fileToCopySelected = false;
	//public File destinationFile;
	//public boolean destinationFileSelected = false;
	//public File fileToCopy;
	
	public Eventos(LooknFeel objeto){
		ventana = objeto;
	}
		
/*
	public void actionPerformed(ActionEvent evento){
				
		if (destinationFileSelected && fileToCopySelected) {
			
			//Boolean to check if file has been copied.
			boolean isFileCopied = false;
			
			
			try{
				
				if(destinationFile.exists()){
					//If file exists, it ask the client to choose between overwrite or exit
					int selectedOption = JOptionPane.showConfirmDialog(
							null, "El archivo ya existe, ¿desea reemplazarlo?",
							"Escoga una opcion", JOptionPane.YES_NO_OPTION);
					if (selectedOption == JOptionPane.YES_OPTION) {
						//Calls method copyFile from ManageFiles class if option YES is selected
						isFileCopied = ManejoArchivos.copyFile(fileToCopy, destinationFile);								
					}
				}else{
					//Calls method copyFile from ManageFiles class if file doesn't exists
					isFileCopied = ManejoArchivos.copyFile(fileToCopy, destinationFile);
					
				}
				
				//Show message depending on the result of copyFile method 
			if(isFileCopied){
				JOptionPane.showMessageDialog(getContentPane(), "Archivo"
						+ fileToCopy.getName() + " copiado correctamente.");
			}else{
				JOptionPane.showMessageDialog(getContentPane(), "Error al copiar");
			}
			
				
			}catch(Exception e){
				//Show the error to user
				JOptionPane.showMessageDialog(getContentPane(),"Error! "+e);	
			}

		} else {
			// Error messages if there aren't files selected
			if (!destinationFileSelected && !fileToCopySelected) {
				JOptionPane
						.showMessageDialog(getContentPane(),
								"Seleccione el archivo de origen y el de destino");
			} else if (!destinationFileSelected) {
				JOptionPane.showMessageDialog(getContentPane(),
						"Seleccione antes una ruta para guardar");
			} else if (!fileToCopySelected) {
				JOptionPane.showMessageDialog(getContentPane(),
						"Seleccione antes un archivo a copiar");

			}
		}
*/	
		
//////////////////////////////////////////////////////////////////////////////////		
		/*if (evento.getSource()==ventana.jbExaminar){
			int returnVal = ventana.jfcExaminarEntrada.showOpenDialog(ventana);
			if(returnVal==JFileChooser.APPROVE_OPTION){
				fileToCopy = ventana.jfcExaminarEntrada.getSelectedFile();
				fileToCopySelected = true;
				File archivos[]=ventana.jfcExaminarEntrada.getSelectedFiles();
				int i=0;
				for(File f:archivos){
					ventana.tabla.setValueAt(f.getName(), i, 0);
					i++;
				}
				i=0;
			}
		}*/
//////////////////////////////////////////////////////////////////////////////
		/*if (evento.getSource()==ventana.jbExaminarSalida){
			int returnVal = ventana.jfcExaminarSalida.showOpenDialog(ventana);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				destinationFile = ventana.jfcExaminarSalida.getSelectedFile();
				// set destinationFolderSelected as true, to permit the
				// program to copy of the file
				destinationFileSelected = true;
			}
		}*/
//////////////////////////////////////////////////////////////////////////////
		/*if (destinationFileSelected && fileToCopySelected) {
			
			//Boolean to check if file has been copied.
			boolean isFileCopied = false;
				
			try{
				
				if(destinationFile.exists()){
					//If file exists, it ask the client to choose between overwrite or exit
					int selectedOption = JOptionPane.showConfirmDialog(
							null, "El archivo ya existe, ¿desea reemplazarlo?",
							"Escoga una opcion", JOptionPane.YES_NO_OPTION);
					if (selectedOption == JOptionPane.YES_OPTION) {
						//Calls method copyFile from ManageFiles class if option YES is selected
						isFileCopied = ManejoArchivos.copyFile(fileToCopy, destinationFile);								
					}
				}else{
					//Calls method copyFile from ManageFiles class if file doesn't exists
					isFileCopied = ManejoArchivos.copyFile(fileToCopy, destinationFile);
					
				}
				
				//Show message depending on the result of copyFile method 
			if(isFileCopied){
				JOptionPane.showMessageDialog(getContentPane(), "Archivo"
						+ fileToCopy.getName() + " copiado correctamente.");
			}else{
				JOptionPane.showMessageDialog(getContentPane(), "Error al copiar");
			}
			
				
			}catch(Exception e){
				//Show the error to user
				JOptionPane.showMessageDialog(getContentPane(),"Error! "+e);	
			}

		} else {
			// Error messages if there aren't files selected
			if (!destinationFileSelected && !fileToCopySelected) {
				JOptionPane
						.showMessageDialog(getContentPane(),
								"Seleccione el archivo de origen y el de destino");
			} else if (!destinationFileSelected) {
				JOptionPane.showMessageDialog(getContentPane(),
						"Seleccione antes una ruta para guardar");
			} else if (!fileToCopySelected) {
				JOptionPane.showMessageDialog(getContentPane(),
						"Seleccione antes un archivo a copiar");

			}
		}*/
//////////////////////////////////////////////////////////////////////////////		
	}
	
