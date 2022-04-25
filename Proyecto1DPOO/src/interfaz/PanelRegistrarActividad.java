package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Actividad;
import modelo.CronometroActividad;
import modelo.Participante;
import modelo.Proyecto;
import modelo.Reporte;

public class PanelRegistrarActividad extends JPanel implements ActionListener
{

	private VentanaPrincipal principal;
	private Proyecto proyecto;
	
	private Actividad actividad;
	
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
	
	//Panel Derecho
	private JPanel PanelTipos;
	private JPanel PanelCrono;
	
	private JPanel PanelBtnCrono;
	private JButton btnCronoManual;
	private JButton btnCronoAuto;
	
	private JPanel PanelRegCrono;
	private JButton btnPausa;
	private JButton btnReanudar;
	private JButton btnTerminar;
	private JTextField fldFecha;
	private JTextField fldHoraI;
	private JTextField fldHoraF;
	
	private JButton btnRegistrar;
	
	
	private boolean ManualCrono = false;
	private String tipo = "";
	
	
	
	public PanelRegistrarActividad(VentanaPrincipal Pprincipal, Proyecto Pproyecto)
	{
		principal = Pprincipal;
		proyecto = Pproyecto;
		actividad = new Actividad();
		
		
	    setBorder( new TitledBorder( "Menú Principal" ) );
	    
	    txtEncabezado = new JLabel("Para registrar la actividad correctamente, por favor llene todos los campos a continuación");
	    add(txtEncabezado, BorderLayout.NORTH);
	    
	    PanelRegistrarInfo = new JPanel();
	    PanelRegInfoI = new JPanel();
	    PanelRegInfoD = new JPanel();
	    PanelRegistrarInfo.setLayout(new GridLayout(1,2));

	    crearPanelIzquierdo();
	    
	    crearPanelDerecho();
		
	    PanelRegistrarInfo.add(PanelRegInfoI);
	    PanelRegistrarInfo.add(PanelRegInfoD);
	    PanelRegistrarInfo.setPreferredSize(new Dimension(800,500));
	    add(PanelRegistrarInfo, BorderLayout.SOUTH);
	    
	    
	    
	}
	
	
	
	
	private void crearPanelIzquierdo()
	{
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
	}
	
	
	
	private void crearPanelDerecho()
	{
		PanelTipos = new JPanel();
		PanelCrono = new JPanel();
		PanelRegCrono = new JPanel();
		
		//List<String> lista = proyecto.getDetalles().darTiposs();
		List<String> lista = new ArrayList<String>();
		lista.add("Tipo 1");
		lista.add("Tipo 2");
		lista.add("Tipo 3");
		

		PanelRegInfoI.setLayout(new GridLayout(6,1));
		PanelTipos.setLayout(new GridLayout(((lista.size()+3)/2),2));
		PanelTipos.add(new JLabel("Elija uno de estos tipos: "));
		PanelTipos.add(new JLabel(""));
		for (String tipoL : lista) 
	    {
			JButton btnTipo = new JButton(tipoL);
			btnTipo.addActionListener(this);
			btnTipo.setActionCommand(tipoL);
			PanelTipos.add(btnTipo);
	    }
		
		
		PanelCrono.setLayout(new GridLayout(3,1));
		PanelCrono.add(new JLabel("<html>¿Desea empezar a cronometrar la actividad o esta ya fue terminada previamente?<html>"));
		
		
		PanelBtnCrono = new JPanel();
		PanelBtnCrono.setLayout(new GridLayout(1,2));
		btnCronoAuto = new JButton("Cronometrar");
		btnCronoManual = new JButton("Registrar manualmente");
		
		btnCronoAuto.addActionListener(this);
		btnCronoManual.addActionListener(this);
		
		btnCronoAuto.setActionCommand("CRONO_AUTO");
		btnCronoManual.setActionCommand("CRONO_MANUAL");
		
		PanelBtnCrono.add(btnCronoAuto);
		PanelBtnCrono.add(btnCronoManual);
		PanelCrono.add(PanelBtnCrono);
				
		
		
		PanelRegCrono = new JPanel();
		btnPausa = new JButton("Pausar");
		btnPausa.addActionListener(this);
		btnPausa.setActionCommand("PAUSAR");

		btnReanudar = new JButton("Reanudar");
		btnReanudar.addActionListener(this);
		btnReanudar.setActionCommand("REANUDAR");
		
		btnTerminar = new JButton("Terminar");
		btnTerminar.addActionListener(this);
		btnTerminar.setActionCommand("TERMINAR");
		
		

		fldFecha = new JTextField("dd/MM/yyyy");
		fldHoraI = new JTextField("HH:mm:ss");
		fldHoraF = new JTextField("HH:mm:ss");
		
		
		btnRegistrar = new JButton("Registrar Actividad");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand("REGISTRAR");
		

		PanelRegInfoD.setLayout(new GridLayout(2,1));
		PanelRegInfoD.add(PanelTipos);
		PanelRegInfoD.add(PanelCrono);
	}
	
	
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
	    String comando = e.getActionCommand( );
	    

		//List<String> lista = proyecto.getDetalles().darTiposs();
		List<String> lista = new ArrayList<String>();
		lista.add("Tipo 1");
		lista.add("Tipo 2");
		lista.add("Tipo 3");
		
	    for (String tipoL : lista) 
	    {
			if(comando.equals(tipoL))
		    {
		    	tipo = tipoL;
		    }
	    }
	    
	    if(comando.equals("CRONO_AUTO"))
	    {
	    	//CronometroActividad cronometro = proyecto.obpar(txtUsuario.getText()).darReporte().darCronometro();	
	    	//cronometro.iniciarCronoActividad(actividad);
			
			PanelCrono.remove(PanelBtnCrono);
	    	PanelRegCrono = new JPanel();
	    	PanelRegCrono.setLayout(new GridLayout(1,2));
			PanelRegCrono.add(btnPausa);
			PanelRegCrono.add(btnTerminar);
			PanelCrono.add(PanelRegCrono);
			PanelCrono.revalidate();
	    }
	    else if(comando.equals("CRONO_MANUAL"))
	    {
			

			PanelCrono.remove(PanelBtnCrono);
	    	PanelRegCrono = new JPanel();
	    	PanelRegCrono.setLayout(new GridLayout(3,3));
	    	PanelRegCrono.add(new JLabel("Ingrese: "));
	    	PanelRegCrono.add(new JLabel(""));
	    	PanelRegCrono.add(new JLabel(""));

	    	PanelRegCrono.add(fldFecha);
	    	PanelRegCrono.add(fldHoraI);
	    	PanelRegCrono.add(fldHoraF);
	    	
	    	PanelRegCrono.add(new JLabel("Fecha"));
	    	PanelRegCrono.add(new JLabel("Hora de Inicio"));
	    	PanelRegCrono.add(new JLabel("Hora de Finalización"));


			PanelCrono.add(PanelRegCrono);
			PanelCrono.add(btnRegistrar);
			this.revalidate();
			ManualCrono = true;
			
			
	    }
	    else if(comando.equals("REGISTRAR"))
	    {
	    	if (fldTitulo.getText().isEmpty()|| fldDescripcion.getText().isEmpty() || fldUsuario.getText().isEmpty()|| tipo == "")
	    	{
	    		JOptionPane.showMessageDialog(null, "Rellene todos los campos");
	    	}
	    	else
	    	{
	    		//Participante participante = proyecto.obpar(txtUsuario.getText());	
				//Reporte reporte = participante.darReporte();
				//CronometroActividad cronometro = reporte.darCronometro();
				
		    	actividad.guardarInfoActividad(fldTitulo.getText(), fldDescripcion.getText(), tipo, fldUsuario.getText());
		    	
			    if (ManualCrono) 
			    {
			    	actividad.agregarFechaHoraI(fldFecha.getText(), fldHoraI.getText());
					actividad.agregarHoraF(fldHoraF.getText());
					//try 
					//{
						//cronometro.cronoManual(actividad, fldFecha.getText(), fldHoraI.getText(), fldHoraF.getText());
					//} catch (ParseException e1) 
					//{
					//	e1.printStackTrace();
					//}
			    }
			    //reporte.registrarInfoReporte(actividad);
			    //proyecto.addActividad(actividad);
		    	this.setVisible(false);
		        principal.ejecutarMostrarMenu();
		    	principal.borrarRegistrarActividad();
		    	
	    	}
	    }
	    else if(comando.equals("PAUSAR"))
	    {
	    	//CronometroActividad cronometro = proyecto.obpar(txtUsuario.getText()).darReporte().darCronometro();	
	    	//cronometro.pausarCronoActividad();
	    	
	    	PanelCrono.remove(PanelRegCrono);
	    	PanelRegCrono = new JPanel();
	    	PanelRegCrono.setLayout(new GridLayout(1,1));
			PanelRegCrono.add(btnReanudar);
			PanelCrono.add(PanelRegCrono);
			PanelCrono.revalidate();
	    }
	    else if(comando.equals("REANUDAR"))
	    {
	    	//CronometroActividad cronometro = proyecto.obpar(txtUsuario.getText()).darReporte().darCronometro();	
	    	//cronometro.reanudarCronoActividad();
	    	
	    	PanelCrono.remove(PanelRegCrono);
	    	PanelRegCrono = new JPanel();
	    	PanelRegCrono.setLayout(new GridLayout(1,2));
	    	PanelRegCrono.add(btnPausa);
			PanelRegCrono.add(btnTerminar);
			PanelCrono.add(PanelRegCrono);
			PanelCrono.revalidate();
		}
	    else if(comando.equals("TERMINAR"))
	    {
	    	//CronometroActividad cronometro = proyecto.obpar(txtUsuario.getText()).darReporte().darCronometro();	
	    	//cronometro.terminarCronoActividad(actividad);
	    	PanelCrono.remove(PanelRegCrono);

	    	PanelCrono.add(new JLabel("Se registró correctamente el tiempo"));
			PanelCrono.add(btnRegistrar);
			PanelCrono.revalidate();
	    	
	    }
		
	    
	    
	}
}
