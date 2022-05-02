package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import modelo.Actividad;
import modelo.CronometroActividad;
import modelo.DetallesProyecto;
import modelo.Participante;
import modelo.Proyecto;
import modelo.Reporte;

public class PanelCrearProyecto extends JPanel implements ActionListener
{

	private VentanaPrincipal principal;
	private Proyecto proyectoy;
		
	private JPanel Infor;
	private JPanel PanelRegInfoA;
	private JPanel PanelRegInfoC;
	
	//Panel Centro
	private JLabel txtNombre;
	private JLabel txtDescripcion;
	private JLabel txtTa;
	private JLabel txtFi;
	private JLabel txtFf;
		
	private JTextField fldNombre;
	private JTextField fldFf;
	private JTextField fldDescripcion;
	private JTextField fldFi;
	private JTextField fldTa;
	private JTextField nomb;
	private JTextField email;
	
	private JLabel lblImagen;
	
	//Panel Abajo
	private JButton btnCrear;
	

	
	
	public PanelCrearProyecto(VentanaPrincipal Pprincipal, Proyecto proyecto)
	{
		Infor=new JPanel();
		BorderLayout layout1 = new BorderLayout();
	    layout1.setHgap(20);
	    layout1.setVgap(20);
	    Infor.setLayout(layout1);
		principal = Pprincipal;
		
		
	    setBorder( new TitledBorder( "Crear proyecto" ) );
	      
	    PanelRegInfoA= new JPanel();
	    PanelRegInfoC= new JPanel();
	    
        crearPanelAbajo();
	    crearPanelCentro();
		
	    Infor.add(PanelRegInfoA, BorderLayout.SOUTH);
	    Infor.add(PanelRegInfoC, BorderLayout.CENTER);
	    Infor.setPreferredSize(new Dimension(900,650));
	    add(Infor, BorderLayout.SOUTH);
	    

	    
	    
	}
	
	
	
	
	
	

	private void crearPanelAbajo()
	{
		
		
		PanelRegInfoA.setLayout(new GridLayout(1,5,20,20));
		
		JLabel nada1= new JLabel( " " );
		JLabel nada2= new JLabel( "" );
		JLabel nada3= new JLabel( " " );
		JLabel nada4= new JLabel( "" );
        btnCrear = new JButton( "CREAR" );
        btnCrear.addActionListener( this );
        btnCrear.setActionCommand( "CREAR" );
        PanelRegInfoA.add(nada1);
        PanelRegInfoA.add(nada2);
        PanelRegInfoA.add(nada3);
        PanelRegInfoA.add(nada4);
        PanelRegInfoA.add(btnCrear);
	}
	private void crearPanelCentro()
	{
		PanelRegInfoC.setLayout(new BorderLayout());
		JPanel panelDueño = new JPanel( );
        JPanel panelDatos = new JPanel( );
        lblImagen = new JLabel( "" );
        PanelRegInfoC.add(panelDueño, BorderLayout.SOUTH);
        PanelRegInfoC.add(lblImagen, BorderLayout.WEST);
        PanelRegInfoC.add(panelDatos, BorderLayout.CENTER);
        
        ImageIcon imagenEjemplo = new ImageIcon( "./data/imagenes/descarga.jpg" );
        lblImagen.setIcon( imagenEjemplo );
        
        
        panelDatos.setLayout( new GridLayout( 5, 2,50,50 ) );
        panelDueño.setLayout( new GridLayout( 1, 4 ) );
        panelDueño.setBorder( new TitledBorder( "Dueño" ));

        JLabel nom= new JLabel( "Nombre: " );
        JLabel mail= new JLabel( "E-Mail" );
        nomb= new JTextField( );
        email= new JTextField(  );
        nomb.setBorder(new LineBorder(Color.BLACK, 2, true));
        email.setBorder(new LineBorder(Color.BLACK, 2, true));
        
        panelDueño.add( nom );
        panelDueño.add( nomb );
        panelDueño.add( mail );
        panelDueño.add( email );
        
        txtNombre= new JLabel( "Nombre: " );
    	txtDescripcion= new JLabel( "Descripcion: " );
    	txtTa= new JLabel( "Tipos de actividades: " );
    	txtFi= new JLabel( "Fecha de inicio: " );
    	txtFf= new JLabel( "Fecha de finalizacion: " );
    	
    	fldNombre=new JTextField();
    	fldFf=new JTextField( "DD/MM/AAAA" );
    	fldDescripcion=new JTextField();
    	fldFi=new JTextField( "DD/MM/AAAA" );
    	fldTa=new JTextField( "Tipo1, Tipo2, Tipo3" );
    	fldNombre.setBorder(new LineBorder(Color.BLACK, 2, true));
    	fldFf.setBorder(new LineBorder(Color.BLACK, 2, true));
    	fldFi.setBorder(new LineBorder(Color.BLACK, 2, true));
    	fldTa.setBorder(new LineBorder(Color.BLACK, 2, true));
    	fldDescripcion.setBorder(new LineBorder(Color.BLACK, 2, true));
        
        panelDatos.add( txtNombre );
        panelDatos.add( fldNombre );
        panelDatos.add( txtDescripcion );
        panelDatos.add( fldDescripcion );
        panelDatos.add( txtFi );
        panelDatos.add( fldFi);
        panelDatos.add( txtFf );
        panelDatos.add( fldFf);
        panelDatos.add( txtTa );
        panelDatos.add( fldTa);
		
		
	}
	
	
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
	    String comando = e.getActionCommand( );
	    if (comando.equals("CREAR")){
	    	if (fldNombre.getText().isEmpty()|| fldDescripcion.getText().isEmpty() || fldFi.getText().isEmpty()||fldFf.getText().isEmpty()||
	    			fldTa.getText().isEmpty()|| nomb.getText().isEmpty()||email.getText().isEmpty() )
	    	{
	    		JOptionPane.showMessageDialog(null, "Rellene todos los campos");
	    	}
	    	else 
	    	{
	    		String tipos=fldTa.getText();
	    		String[] tiposA=tipos.split(",");
	    		List<String> tiposAc=new ArrayList<String>();
	    		for (String a:tiposA) {
	    			tiposAc.add(a);
	    	    }
	    		proyectoy=principal.CrearProyecto(fldNombre.getText(), fldDescripcion.getText(), fldFi.getText(), fldFf.getText(), 
	    				nomb.getText(), tiposAc, email.getText());
	    		
	    		
	    		String ruta=JOptionPane.showInputDialog("Ingrese la ruta de donde se guardara el proyecto ");
	    		String ruta1=ruta+"\\" +fldNombre.getText()+".txt";
	    		DetallesProyecto detalles=proyectoy.getDetalles();
	        	try {
					detalles.guardarInfo(ruta1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	this.setVisible(false);
		        principal.ejecutarMostrarMenu();
		    	principal.borrarCrearProyecto();
	        }
	    		
	    }

	}	
	
}

