package archivosp10;
import java.awt.Dimension;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

//import files.FileManagement;

//import Copiar.ManageFiles;


public class LooknFeel extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public static int  EntraIncial=0;  
	public JFileChooser jfcExaminarEntrada;
	public JFileChooser jfcExaminarSalida;
    public JButton jbExaminar;
    public JButton jbLoad;
    public JButton jbExaminarSalida;
    public JButton jbSave;
    public JDesktopPane jDesktopPane1;
    public JTextPane jTxtPane;
    public JPanel jPanel1;
    public JPanel jPanel2;
    public JPanel jPanel3;
    public JTextField jtfRutaEntrada;
    public JTextField jtfRutaSalida;
    public JTable tabla;
    public JScrollPane scroll;
    
    
    Eventos2 controlaEventos2 = new Eventos2 (this);
    Eventos1 controlaEventos1 = new Eventos1 (this);
    //Eventos controlaEventos = new Eventos (this);
    
    public boolean fileToCopySelected = false;
	public File destinationFile;
	public boolean destinationFileSelected = false;
	public File fileToCopy;
	
    public LooknFeel() {
        initComponents(); 
    }

    private void initComponents() {	
    	
    	
    	
		setResizable(false);
		jfcExaminarEntrada = new JFileChooser();
		jfcExaminarSalida = new JFileChooser();
		
		jfcExaminarEntrada.setMultiSelectionEnabled(true);
		jfcExaminarEntrada.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
        jPanel1 = new  JPanel();
        jtfRutaEntrada = new  JTextField();
        jbExaminar = new  JButton();
        //jbLoad = new  JButton();
        jPanel2 = new  JPanel();
        jbSave = new  JButton();
        jbExaminarSalida = new  JButton();
        jtfRutaSalida = new  JTextField();
        jPanel3 = new  JPanel();
        jDesktopPane1 = new  JDesktopPane();
        jTxtPane = new JTextPane();
        tabla = new JTable(100,1);
        scroll = new JScrollPane(tabla);
///////////////////////////////////////////////////////////////////////////////////////////
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        jPanel1.setBorder( BorderFactory.createTitledBorder("Ruta del Archivo: / File path:"));
        jPanel1.setLayout(null);
        jPanel1.add(jtfRutaEntrada);
        jtfRutaEntrada.setText("C:/ ...");//cuadro de ruta 
        jtfRutaEntrada.setBounds(20, 30, 350, 19);

        jbExaminar.setText("Search");//boton para abrir directorios
        jPanel1.add(jbExaminar);
        jbExaminar.setBounds(400, 30, 120, 25);
        jbExaminar.addActionListener(controlaEventos2);
        
        //jbLoad.setText("Load");//boton para cargar vista de archivos seleccionados
        //jPanel1.add(jbLoad);
        //jbLoad.setBounds(460, 30, 70, 25);

        getContentPane().add(jPanel1);//agrega elementos al panel 1
        jPanel1.setBounds(30, 10, 550, 70);
        
///////////////////////////////////////////////////////////////////////////////////////////
        
        jPanel3.setBorder( BorderFactory.createTitledBorder("Vista Previa"));//cambiar para mostrar archivos a cargar
        jPanel3.setLayout(null);
        scroll.setPreferredSize(new Dimension(400,99));		        
        jPanel3.add(scroll);//muestra archivos seleccionados 
        scroll.setBounds(20, 25, 540, 280);
        
        
        getContentPane().add(jPanel3);//agrega elementos de vista al panel 3
        jPanel3.setBounds(20, 85, 570, 330);
        
///////////////////////////////////////////////////////////////////////////////////////////
        jPanel2.setBorder( BorderFactory.createTitledBorder("Ruta para guardar: /Path to save:"));
        jPanel2.setLayout(null);
        jPanel2.add(jtfRutaSalida);
        jtfRutaSalida.setBounds(20, 30, 350, 19);
        
        jbExaminarSalida.setText("...");//boton para abrir ficheros para guardar
        jPanel2.add(jbExaminarSalida);
        jbExaminarSalida.setBounds(400, 30, 50, 25);
        jbExaminarSalida.addActionListener(controlaEventos1);
        jbSave.setText("Save");//boton para iniciar la copia
        
        jbSave.setBounds(460, 30, 70, 25);
        jbSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (destinationFileSelected && fileToCopySelected) {
					
					//Boolean to check if file has been copied.
					boolean isFileCopied = false;
					
					try{
						if (fileToCopy.isDirectory()) { 
							ManejoArchivos.CopiarDirectorio(fileToCopy, destinationFile);
						}else{

						if(destinationFile.exists()){						
							//If file exists, it ask the client to choose between overwrite or exit
							int selectedOption = JOptionPane.showConfirmDialog(
									null, "Archivo existente, ¿Desea reemplazarlo?",
									"Choose selection", JOptionPane.YES_NO_OPTION);
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
						JOptionPane.showMessageDialog(getContentPane(), "El archivo: "
								+ fileToCopy.getName() + " se ha copiado correctamente.");
					}else{
						JOptionPane.showMessageDialog(getContentPane(), "Error al copiar");
					}
					
						
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
								"Seleccione antes una ruta para guardar.");
					} else if (!fileToCopySelected) {
						JOptionPane.showMessageDialog(getContentPane(),
								"Seleccione antes un archivo a copiar.");

					}
				
				}
				
			}
		});
        jPanel2.add(jbSave);
        //jbSave.addActionListener(controlaEventos);
        
        getContentPane().add(jPanel2);//agrega elementos al panel 2
        jPanel2.setBounds(30, 420, 550, 70); 
   
        
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-618)/2, (screenSize.height-542)/2, 618, 542);//tamaño de la ventana
        
        
        
		//jbExaminar.addActionListener(controlaEventos2);
		//jbExaminarSalida.addActionListener(controlaEventos1);
		//jbSave.addActionListener(controlaEventos);
        }
    
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}