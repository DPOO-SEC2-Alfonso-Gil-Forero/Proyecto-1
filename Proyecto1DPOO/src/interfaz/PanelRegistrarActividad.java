package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Proyecto;

public class PanelRegistrarActividad extends JPanel
{

	private VentanaPrincipal principal;
	private Proyecto proyecto;
	
	private JLabel txtEncabezado;
	
	private JPanel PanelRegistrarInfo;
	private JPanel PanelRegInfoI;
	private JPanel PanelRegInfoD;
	
	//Panel Izquierdo
	private JLabel txtUsuario;
	private JLabel txtTitulo;
	private JLabel txtDescripcion;
	
	private JTextField fldUsuario;
	private JTextField fldTitulo;
	private JTextField fldDescripcion;
	
	
	
	public PanelRegistrarActividad(VentanaPrincipal Pprincipal, Proyecto Pproyecto)
	{
		principal = Pprincipal;
		proyecto = Pproyecto;
		

	    setBorder( new TitledBorder( "Menú Principal" ) );
	    
	    txtEncabezado = new JLabel("Para registrar la actividad correctamente, por favor llene todos los campos a continuación");
	    add(txtEncabezado, BorderLayout.NORTH);
	    
	    PanelRegistrarInfo = new JPanel();
	    PanelRegInfoI = new JPanel();
	    PanelRegInfoD = new JPanel();
	    PanelRegInfoI.setBorder( new TitledBorder( "Izquierda" ));
	    PanelRegInfoD.setBorder( new TitledBorder( "Derecha" ));
	    PanelRegistrarInfo.setLayout(new GridLayout(1,2));
	    
	    //Panel Izquierdo
	    txtUsuario = new JLabel("Ingrese su usuario o el de aquel que hizo la actividad: ");
	    txtTitulo = new JLabel("Ingrese el título de la actividad: ");
		txtDescripcion = new JLabel("Ingrese una breve descripción: ");
		
		fldUsuario = new JTextField();
		fldTitulo = new JTextField();
		fldDescripcion = new JTextField();

		PanelRegInfoI.setLayout(new GridLayout(6,1));
		PanelRegInfoI.add(txtUsuario);
		PanelRegInfoI.add(fldUsuario);
		PanelRegInfoI.add(txtTitulo);
		PanelRegInfoI.add(fldTitulo);
		PanelRegInfoI.add(txtDescripcion);
		PanelRegInfoI.add(fldDescripcion);
	    
	    
	    PanelRegistrarInfo.add(PanelRegInfoI);
	    PanelRegistrarInfo.add(PanelRegInfoD);
	    add(PanelRegistrarInfo, BorderLayout.SOUTH);
	    
	    
	    
	}
	
	
	
}
