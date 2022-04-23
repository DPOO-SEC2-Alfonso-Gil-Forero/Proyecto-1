package interfaz;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import modelo.Proyecto;


public class VentanaPrincipal extends JFrame
{
    
	
	private Proyecto proyecto;
	

    private PanelMenu panelMenu;
    private PanelCrearProyecto panelCrearProyecto;
    private PanelMostrarProyecto panelMostrarProyecto;
    private PanelAgregarParticipante panelAgregarParticipante;
    private PanelModificarParticipante panelModificarParticipante;
    private PanelMostrarParticipante panelMostrarParticipante;
    private PanelRegistrarActividad panelRegistrarActividad;
    private PanelMostrarReporteParticipante panelMostrarReporteParticipante;
    private PanelVisualizacionAltoNivel panelVisualizacionAltoNivel;

	
    
    public VentanaPrincipal()
    {
        
        
        setSize( 1000, 750 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        setTitle( "Proyecto 2" );
        
        setLayout( new BorderLayout( ) );
        
        ejecutarMostrarMenu();

    }
    
    
    
    public void ejecutarMostrarMenu()
    {
    	panelMenu = new PanelMenu(this,proyecto);
    	panelMenu.setPreferredSize(new Dimension(300,700));
    	Container contentPane = this.getContentPane();
    	contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        add(panelMenu);
    }
    
    
    
    public void ejecutarCrearProyecto()
    {
    	panelCrearProyecto = new PanelCrearProyecto(this,proyecto);
        add(panelCrearProyecto, BorderLayout.CENTER);
    }
    
    
 
    
    public void ejecutarMostrarProyecto()
    {
    	panelMostrarProyecto = new PanelMostrarProyecto(this,proyecto);
        add(panelMostrarProyecto, BorderLayout.CENTER);
    }
    
    
    
    public void ejecutarAgregarParticipante()
    {
    	panelAgregarParticipante = new PanelAgregarParticipante(this,proyecto);
        add(panelAgregarParticipante, BorderLayout.CENTER);
    }
    
    

    public void ejecutarModificarParticipante()
    {
    	panelModificarParticipante = new PanelModificarParticipante(this,proyecto);
        add(panelModificarParticipante, BorderLayout.CENTER);
    }
    
    
    
    public void ejecutarMostrarParticipante()
    {
    	panelMostrarParticipante = new PanelMostrarParticipante(this,proyecto);
        add(panelMostrarParticipante, BorderLayout.CENTER);
    }
    
    
    
    public void ejecutarRegistrarActividad()
    {
    	panelRegistrarActividad = new PanelRegistrarActividad(this,proyecto);
        add(panelRegistrarActividad, BorderLayout.CENTER);
    }
    
    
    public void ejecutarMostrarReporteParticipante()
    {
    	panelMostrarReporteParticipante = new PanelMostrarReporteParticipante(this,proyecto);
        add(panelMostrarReporteParticipante, BorderLayout.CENTER);
    }

    
    public void ejecutarVisualizacionAltoNivel()
    {
    	panelVisualizacionAltoNivel = new PanelVisualizacionAltoNivel(this,proyecto);
        add(panelVisualizacionAltoNivel, BorderLayout.CENTER);
    }
    
    
    

    public void borrarMenu()
    {
    	this.remove(panelMenu);
    }
    
    
    public void borrarCrearProyecto()
    {
    	this.remove(panelCrearProyecto);
    }
    
    
    public void borrarMostrarProyecto()
    {
    	this.remove(panelMostrarProyecto);
    }


    public void borrarAgregarParticipante()
    {
    	this.remove(panelAgregarParticipante);
    }
    
    
    
    public void borrarModificarParticipante()
    {
    	this.remove(panelModificarParticipante);
    }
    
    
    
    public void borrarMostrarParticipante()
    {
    	this.remove(panelMostrarParticipante);
    }
    
    
    
    public void borrarRegistrarActividad()
    {
    	this.remove(panelRegistrarActividad);
    }
    
    
    
    public void borrarMostrarReporteParticipante()
    {
    	this.remove(panelMostrarReporteParticipante);
    }
    
    
    
    public void borrarVisualizacionAltoNivel()
    {
    	this.remove(panelVisualizacionAltoNivel);
    }
    
    
    
    
    
    

	
    
    
    
    
    public static void main (String[] args)
    {
        VentanaPrincipal  ventana = new  VentanaPrincipal( );
        ventana.setVisible( true );
    }
    
	
}
