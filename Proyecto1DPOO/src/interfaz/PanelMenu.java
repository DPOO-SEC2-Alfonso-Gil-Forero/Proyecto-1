package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.Proyecto;

public class PanelMenu extends JPanel implements ActionListener
{

	private VentanaPrincipal principal;
	private Proyecto proyecto;
	
	
	private JLabel eligaOpcionTxt;
	
	private JButton btnCrearProyecto;
	private JButton btnMostrarInfoProyecto;
	private JButton btnAgregarParticipante;
	private JButton btnModificarParticipante;
	private JButton btnMostrarParticipante;
	private JButton btnRegistrarActividad;
	private JButton btnMostrarReporteParticipante;
	private JButton btnVisualizacionAltoNivel;
	private JButton btnMostrarWBS;
	private JButton btnMostrarResumen;
	
	
	
	
	public PanelMenu(VentanaPrincipal Pprincipal, Proyecto Pproyecto)
	{
		principal = Pprincipal;
		proyecto = Pproyecto;
		

	    setLayout( new GridLayout( 11, 1 ) );
	    setBorder( new TitledBorder( "Men� Principal" ) );
	    
	    eligaOpcionTxt = new JLabel("Seleccione una opci�n: ");
	    add(eligaOpcionTxt);
	    
	    btnCrearProyecto = new JButton("Crear proyecto");
	    btnMostrarInfoProyecto = new JButton("Mostrar informaci�n de un proyecto");
	    btnAgregarParticipante = new JButton("Agregar Participante");
	    btnModificarParticipante = new JButton("Modificar datos de un participante");
		btnMostrarParticipante = new JButton("Mostrar informaci�n de un participante");
		btnRegistrarActividad = new JButton("Registrar actividad");
		btnMostrarReporteParticipante = new JButton("Mostrar reporte de una actividad");
		btnVisualizacionAltoNivel = new JButton("Visualizaci�n actividades por fecha");
		btnMostrarWBS = new JButton("Mostrar WBS");
		btnMostrarResumen = new JButton("Mostrar resumen");
	    
		
	    btnCrearProyecto.addActionListener(this);
	    btnMostrarInfoProyecto.addActionListener(this);
	    btnAgregarParticipante.addActionListener(this);
	    btnModificarParticipante.addActionListener(this);
		btnMostrarParticipante.addActionListener(this);
		btnRegistrarActividad.addActionListener(this);
		btnMostrarReporteParticipante.addActionListener(this);
		btnVisualizacionAltoNivel.addActionListener(this);
		btnMostrarWBS.addActionListener(this);
		btnMostrarResumen.addActionListener(this);
	    
	    
	    btnCrearProyecto.setActionCommand("CREAR_PROYECTO");
	    btnMostrarInfoProyecto.setActionCommand("MOSTRAR_PROYECTO");	    
	    btnAgregarParticipante.setActionCommand("AGREGAR_PARTICIPANTE");
	    btnModificarParticipante.setActionCommand("MODIFICAR_PARTICIPANTE");
		btnMostrarParticipante.setActionCommand("MOSTRAR_PARTICIPANTE");
		btnRegistrarActividad.setActionCommand("REGISTRAR_ACTIVIDAD");
		btnMostrarReporteParticipante.setActionCommand("MOSTRAR_REPORTE_PARTICIPANTE");
		btnVisualizacionAltoNivel.setActionCommand("VISUALIZAR_ALTO_NIVEL");
		btnMostrarWBS.setActionCommand("MOSTRAR_WBS");
		btnMostrarResumen.setActionCommand("MOSTRAR_RESUMEN");

	    
	    add(btnCrearProyecto);
	    add(btnMostrarInfoProyecto);
	    add(btnAgregarParticipante);
	    add(btnModificarParticipante);
	    add(btnMostrarParticipante);
	    add(btnRegistrarActividad);
	    add(btnMostrarReporteParticipante);
	    add(btnVisualizacionAltoNivel);
	    add(btnMostrarWBS);
	    add(btnMostrarResumen);
    
	}


	@Override
	public void actionPerformed( ActionEvent e )
	{
	    String comando = e.getActionCommand( );
	    
	    if(comando.equals("CREAR_PROYECTO"))
	    {
	    	this.setVisible(false);
	    	principal.ejecutarCrearProyecto();
	    	principal.borrarMenu();
	    }
	    else if(comando.equals("MOSTRAR_PROYECTO"))
	    {
	    	this.setVisible(false);
	    	principal.ejecutarMostrarProyecto();
	    	principal.borrarMenu();
	    }
	    else if(comando.equals("AGREGAR_PARTICIPANTE"))
	    {
	    	this.setVisible(false);
	    	principal.ejecutarAgregarParticipante();
	    	principal.borrarMenu();
	    }
	    else if(comando.equals("MODIFICAR_PARTICIPANTE"))
	    {
	    	this.setVisible(false);
	    	principal.ejecutarModificarParticipante();
	    	principal.borrarMenu();
	    }
	    else if(comando.equals("MOSTRAR_PARTICIPANTE"))
	    {
	    	this.setVisible(false);
	    	principal.ejecutarMostrarParticipante();
	    	principal.borrarMenu();
	    }
	    else if(comando.equals("REGISTRAR_ACTIVIDAD"))
	    {
	    	this.setVisible(false);
	    	principal.ejecutarRegistrarActividad();
	    	principal.borrarMenu();
	    }
	    else if(comando.equals("MOSTRAR_REPORTE_PARTICIPANTE"))
	    {
	    	this.setVisible(false);
	    	principal.ejecutarMostrarReporteParticipante();
	    	principal.borrarMenu();
	    }
	    else if(comando.equals("VISUALIZAR_ALTO_NIVEL"))
	    {
	    	this.setVisible(false);
	    	principal.ejecutarVisualizacionAltoNivel();
	    	principal.borrarMenu();
	    }
	    else if(comando.equals("MOSTRAR_WBS"))
	    {
	    	this.setVisible(false);
	    	principal.ejecutarMostrarWBS();
	    	principal.borrarMenu();
	    }
	    else if(comando.equals("MOSTRAR_RESUMEN"))
	    {
	    	this.setVisible(false);
	    	principal.ejecutarMostrarResumen();
	    	principal.borrarMenu();
	    }
	    
		
		
		
	}
}
