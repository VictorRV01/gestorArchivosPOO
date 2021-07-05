package archivosp10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.File;

import javax.swing.JFileChooser;

public class Eventos1 extends Eventos implements ActionListener {
	
	public Eventos1(LooknFeel objeto) {
		super(objeto);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	//public LooknFeel ventana;
	
	//public Eventos1(LooknFeel objeto){
		//ventana = objeto;
	//}
	//protected File destinationFile;
	//protected boolean destinationFileSelected = false;
	//protected boolean fileToCopySelected = false;
	//protected File fileToCopy;
	//Eventos window = new Eventos(ventana);
	
	public void actionPerformed(ActionEvent evento1) {
		// TODO Auto-generated method stub
		/*int returnVal = ventana.jfcExaminarSalida.showOpenDialog(ventana);
		//if (evento1.getSource()==ventana.jbExaminarSalida){
			//int returnVal = ventana.jfcExaminarSalida.showOpenDialog(ventana);
			
		//}
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			destinationFile = ventana.jfcExaminarSalida.getSelectedFile();
			// set destinationFolderSelected as true, to permit the
			// program to copy of the file
			destinationFileSelected = true;
		}*/
		if (evento1.getSource()==ventana.jbExaminarSalida){//si hay evento en el boton examinar
			int returnVal = ventana.jfcExaminarSalida.showOpenDialog(ventana);//mostramos el jFileChooser
		 	if (returnVal == ventana.jfcExaminarSalida.APPROVE_OPTION) {//nos aseguramos q haya selecionado algun archivo
		 		
		 		ventana.destinationFile = ventana.jfcExaminarSalida.getSelectedFile();//obtenemos el archivo selecionado
		 		ventana.jtfRutaSalida.setText(ventana.destinationFile.toString());
				ventana.destinationFileSelected = true;
		 	}
		}	
}

}



