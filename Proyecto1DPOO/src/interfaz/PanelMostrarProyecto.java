package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import modelo.DetallesProyecto;
import modelo.Participante;
import modelo.Proyecto;

public class PanelMostrarProyecto extends JPanel implements ActionListener
{
	private VentanaPrincipal principal;
	private Proyecto proyecto;
	private DetallesProyecto deta;
	private Set<String> parti;
	private Participante par;
	
	private JPanel Infor;
	private JPanel PanelRegInfoA;
	private JPanel PanelRegInfoC;
	
	//Panel Centro
	private JLabel txtNombre;
	private JLabel txtDescripcion;
	private JLabel txtTa;
	private JLabel txtFi;
	private JLabel txtFf;
	private JLabel nada;
		
	private JTextField fldNombre;
	private JTextField fldFf;
	private JTextField fldDescripcion;
	private JTextField fldFi;
	private JTextField fldTa;
	
	private JLabel lblNombre;
	private JLabel lblMail;
	
	//Panel Abajo
	private JButton btnListo;
	

	
	
	public PanelMostrarProyecto(VentanaPrincipal Pprincipal, Proyecto Pproyecto)
	{
		Infor=new JPanel();
		BorderLayout layout1 = new BorderLayout();
	    layout1.setHgap(20);
	    layout1.setVgap(20);
	    Infor.setLayout(layout1);
		principal = Pprincipal;
		proyecto = Pproyecto;
		deta=proyecto.getDetalles();
		parti=proyecto.obparticipantes();
		
	    setBorder( new TitledBorder( "Mostrar proyecto" ) );
	      
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
		
		
		PanelRegInfoA.setLayout(new GridLayout(1,5));
		
		JLabel nada1= new JLabel( " " );
		JLabel nada2= new JLabel( "" );
		JLabel nada3= new JLabel( " " );
		JLabel nada4= new JLabel( "" );
        btnListo = new JButton( "LISTO" );
        btnListo.addActionListener( this );
        btnListo.setActionCommand( "LISTO" );
        PanelRegInfoA.add(nada1);
        PanelRegInfoA.add(nada2);
        PanelRegInfoA.add(nada3);
        PanelRegInfoA.add(nada4);
        PanelRegInfoA.add(btnListo);
	}
	private void crearPanelCentro()
	{
		ArrayList tipos=(ArrayList) deta.darTiposs();
		PanelRegInfoC.setLayout(new BorderLayout());
		JPanel panelDatos = new JPanel( );
        JPanel Ppartici = new JPanel( );
        nada=new JLabel(" ");
        PanelRegInfoC.add(Ppartici, BorderLayout.SOUTH);
        PanelRegInfoC.add(panelDatos, BorderLayout.CENTER);
        
        
        panelDatos.setLayout( new GridLayout( 4, 3,20,20 ) );
        Ppartici.setLayout( new GridLayout( parti.size(), 4,20,20 ) );
        Ppartici.setBorder( new TitledBorder( "Participantes" ));
        panelDatos.setBorder( new TitledBorder( "Informacion del proyecto" ));
        
        for (String i:parti) {
        	JLabel nom= new JLabel( "Nombre: " );
            JLabel mail= new JLabel( "E-Mail: " );
        	par=proyecto.obpar(i);
            JTextField nomb= new JTextField( par.darNombre() );
            JTextField email= new JTextField( par.darCorreo() );
            nomb.setEditable(false);
            email.setEditable(false);
            nomb.setBorder(new LineBorder(Color.BLACK, 2, true));
            email.setBorder(new LineBorder(Color.BLACK, 2, true));
            Ppartici.add(nom );
            Ppartici.add(nomb );
            Ppartici.add(mail );
            Ppartici.add(email);
            
        }
        
       /* panelDueño.add( nom );
        panelDueño.add( nomb );
        panelDueño.add( mail );
        panelDueño.add( email );*/
        
        txtNombre= new JLabel( "Nombre: " );
    	txtDescripcion= new JLabel( "Descripcion: " );
    	txtTa= new JLabel( "Tipos de actividades: " );
    	txtFi= new JLabel( "Fecha de inicio: " );
    	txtFf= new JLabel( "Fecha de finalizacion: " );
    	
    	fldNombre=new JTextField(deta.darNombre());
    	fldNombre.setEditable(false);
    	fldFf=new JTextField( deta.darFechaF() );
    	fldFf.setEditable(false);
    	fldDescripcion=new JTextField(deta.darDescripcion());
    	fldDescripcion.setEditable(false);
    	fldFi=new JTextField( deta.darFechaI() );
    	fldFi.setEditable(false);
    	fldTa=new JTextField( tipos.get(0)+"\n" + tipos.get(1)+"\n"+tipos.get(2));
    	fldTa.setEditable(false);
    	fldNombre.setBorder(new LineBorder(Color.BLACK, 2, true));
    	fldFf.setBorder(new LineBorder(Color.BLACK, 2, true));
    	fldFi.setBorder(new LineBorder(Color.BLACK, 2, true));
    	fldTa.setBorder(new LineBorder(Color.BLACK, 2, true));
    	fldDescripcion.setBorder(new LineBorder(Color.BLACK, 2, true));
        
        panelDatos.add( txtNombre );
        panelDatos.add( fldNombre );
        panelDatos.add( txtTa );
        panelDatos.add( txtDescripcion );
        panelDatos.add( fldDescripcion );
        panelDatos.add( fldTa);
        panelDatos.add( txtFi );
        panelDatos.add( fldFi);
        panelDatos.add(nada);
        panelDatos.add( txtFf );
        panelDatos.add( fldFf);
 
		
	}
	
	
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
	    String comando = e.getActionCommand( );
	    if (comando.equals("LISTO")) {
	    	this.setVisible(false);
	        principal.ejecutarMostrarMenu();
	    	principal.borrarMostrarProyecto();
	    }
	    

	}	
}
	
		
	
	


