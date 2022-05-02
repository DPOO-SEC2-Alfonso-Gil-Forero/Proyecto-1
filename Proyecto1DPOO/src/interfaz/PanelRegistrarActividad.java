package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
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
		
		
	    setBorder( new TitledBorder( "Registrar Actividad" ) );
	    setBackground(new Color(203, 203, 203));
	    
	    txtEncabezado = new JLabel("<html><div style='text-align: center;'>Para registrar la actividad correctamente, por favor llene todos los campos a continuación</div><html>");
	    txtEncabezado.setFont(new Font("Calibri", Font.BOLD, 20));
	    txtEncabezado.setVerticalAlignment(JLabel.CENTER);
	    txtEncabezado.setHorizontalAlignment(JLabel.CENTER);
	    txtEncabezado.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
    	txtEncabezado.setPreferredSize(new Dimension(700,100));
	    txtEncabezado.setSize(getPreferredSize());
	    txtEncabezado.setOpaque(true);
	    txtEncabezado.setBackground(new Color(180, 180, 180));
	    add(txtEncabezado, BorderLayout.NORTH);
	    
	    PanelRegistrarInfo = new JPanel();
	    PanelRegistrarInfo.setBackground(new Color(203, 203, 203));
	    PanelRegInfoI = new JPanel();
	    PanelRegInfoD = new JPanel();
	    

	    GridLayout layout1 = new GridLayout(1,2);
	    layout1.setHgap(50);
	    layout1.setVgap(50);
	    PanelRegistrarInfo.setLayout(layout1);

	    crearPanelIzquierdo();
	    
	    crearPanelDerecho();
		
	    PanelRegistrarInfo.add(PanelRegInfoI);
	    PanelRegistrarInfo.add(PanelRegInfoD);
	    PanelRegistrarInfo.setPreferredSize(new Dimension(800,500));
	    add(PanelRegistrarInfo, BorderLayout.SOUTH);
	    
	    
	    
	}
	
	
	
	
	private void crearPanelIzquierdo()
	{

	    PanelRegInfoI.setBackground(new Color(203, 203, 203));
		txtUsuario = new JLabel("Ingrese su usuario o el de aquel que hizo la actividad: ");
	    txtTitulo = new JLabel("Ingrese el título de la actividad: ");
		txtDescripcion = new JLabel("Ingrese una breve descripción: ");
		
		fldUsuario = new JTextField();
		fldUsuario.setBorder(new LineBorder(Color.BLACK, 2, true));
		fldTitulo = new JTextField();
		fldTitulo.setBorder(new LineBorder(Color.BLACK, 2, true));
		fldDescripcion = new JTextField();
		fldDescripcion.setBorder(new LineBorder(Color.BLACK, 2, true));

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
		

	    PanelRegInfoD.setBackground(new Color(203, 203, 203));
		PanelTipos = new JPanel();
		PanelCrono = new JPanel();
		PanelRegCrono = new JPanel();
		PanelTipos.setBackground(new Color(203, 203, 203));
		PanelCrono.setBackground(new Color(203, 203, 203));
		PanelRegCrono.setBackground(new Color(203, 203, 203));
		
		List<String> lista = proyecto.getDetalles().darTiposs();
		
		

		PanelRegInfoI.setLayout(new GridLayout(6,1));
		GridLayout layout2 = new GridLayout(((lista.size()+3)/2),2);
	    layout2.setHgap(15);
	    layout2.setVgap(15);
		PanelTipos.setLayout(layout2);
		PanelTipos.add(new JLabel("Elija uno de estos tipos: "));
		PanelTipos.add(new JLabel(""));
		for (String tipoL : lista) 
	    {
			JButton btnTipo = new JButton(tipoL);
			btnTipo.addActionListener(this);
			btnTipo.setActionCommand(tipoL);
			btnTipo.setBackground(new Color(166, 166, 166));
			btnTipo.setBorder(new LineBorder(Color.BLACK, 2, true));
			PanelTipos.add(btnTipo);
	    }


		GridLayout layout7 = new GridLayout(3,1);
	    layout7.setHgap(15);
	    layout7.setVgap(15);
		PanelCrono.setLayout(layout7);
		PanelCrono.add(new JLabel("<html>¿Desea empezar a cronometrar la actividad o esta ya fue terminada previamente?<html>"));
		
		
		PanelBtnCrono = new JPanel();
		PanelBtnCrono.setBackground(new Color(203, 203, 203));
		GridLayout layout3 = new GridLayout(1,2);
	    layout3.setHgap(15);
	    layout3.setVgap(15);
		PanelBtnCrono.setLayout(layout3);
		btnCronoAuto = new JButton("Cronometrar");
		btnCronoAuto.setBackground(new Color(166, 166, 166));
		btnCronoAuto.setBorder(new LineBorder(Color.BLACK, 2, true));
		btnCronoManual = new JButton("Registrar manualmente");
		btnCronoManual.setBackground(new Color(166, 166, 166));
		btnCronoManual.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		btnCronoAuto.addActionListener(this);
		btnCronoManual.addActionListener(this);
		
		btnCronoAuto.setActionCommand("CRONO_AUTO");
		btnCronoManual.setActionCommand("CRONO_MANUAL");
		
		PanelBtnCrono.add(btnCronoAuto);
		PanelBtnCrono.add(btnCronoManual);
		PanelCrono.add(PanelBtnCrono);
				
		
		
		PanelRegCrono = new JPanel();
		PanelRegCrono.setBackground(new Color(203, 203, 203));
		btnPausa = new JButton("Pausar");
		btnPausa.setBackground(new Color(166, 166, 166));
		btnPausa.setBorder(new LineBorder(Color.BLACK, 2, true));
		btnPausa.addActionListener(this);
		btnPausa.setActionCommand("PAUSAR");

		btnReanudar = new JButton("Reanudar");
		btnReanudar.setBackground(new Color(166, 166, 166));
		btnReanudar.setBorder(new LineBorder(Color.BLACK, 2, true));
		btnReanudar.addActionListener(this);
		btnReanudar.setActionCommand("REANUDAR");
		
		btnTerminar = new JButton("Terminar");
		btnTerminar.setBackground(new Color(166, 166, 166));
		btnTerminar.setBorder(new LineBorder(Color.BLACK, 2, true));
		btnTerminar.addActionListener(this);
		btnTerminar.setActionCommand("TERMINAR");
		
		

		fldFecha = new JTextField("dd/MM/yyyy");
		fldFecha.setBorder(new LineBorder(Color.BLACK, 2, true));
		fldHoraI = new JTextField("HH:mm:ss");
		fldHoraI.setBorder(new LineBorder(Color.BLACK, 2, true));
		fldHoraF = new JTextField("HH:mm:ss");
		fldHoraF.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		
		btnRegistrar = new JButton("Registrar Actividad");
		btnRegistrar.setBackground(new Color(59, 56, 56));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Calibri", Font.BOLD, 20));
		btnRegistrar.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand("REGISTRAR");
		

		GridLayout layout6 = new GridLayout(2,1);
	    layout6.setHgap(15);
	    layout6.setVgap(15);
		PanelRegInfoD.setLayout(layout6);
		PanelRegInfoD.add(PanelTipos);
		PanelRegInfoD.add(PanelCrono);
	}
	
	
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
	    String comando = e.getActionCommand( );
	    

		List<String> lista = proyecto.getDetalles().darTiposs();
		
		
	    for (String tipoL : lista) 
	    {
			if(comando.equals(tipoL))
		    {
		    	tipo = tipoL;
		    }
	    }
	    
	    if(comando.equals("CRONO_AUTO"))
	    {
	    	CronometroActividad cronometro = proyecto.obpar(fldUsuario.getText()).darReporte().darCronometro();	
	    	cronometro.iniciarCronoActividad(actividad);
			
			PanelCrono.remove(PanelBtnCrono);
	    	PanelRegCrono = new JPanel();
	    	PanelRegCrono.setBackground(new Color(203, 203, 203));
	    	GridLayout layout4 = new GridLayout(1,2);
		    layout4.setHgap(15);
		    layout4.setVgap(15);
	    	PanelRegCrono.setLayout(layout4);
			PanelRegCrono.add(btnPausa);
			PanelRegCrono.add(btnTerminar);
			PanelCrono.add(PanelRegCrono);
			PanelCrono.revalidate();
	    }
	    else if(comando.equals("CRONO_MANUAL"))
	    {
			

			PanelCrono.remove(PanelBtnCrono);
	    	PanelRegCrono = new JPanel();
	    	PanelRegCrono.setBackground(new Color(203, 203, 203));
	    	GridLayout layout5 = new GridLayout(2,3);
		    layout5.setHgap(15);
		    layout5.setVgap(15);
	    	PanelRegCrono.setLayout(layout5);

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
	    		Participante participante = proyecto.obpar(fldUsuario.getText());	
				Reporte reporte = participante.darReporte();
				CronometroActividad cronometro = reporte.darCronometro();
				
		    	actividad.guardarInfoActividad(fldTitulo.getText(), fldDescripcion.getText(), tipo, fldUsuario.getText());
		    	
			    if (ManualCrono) 
			    {
			    	actividad.agregarFechaHoraI(fldFecha.getText(), fldHoraI.getText());
					actividad.agregarHoraF(fldHoraF.getText());
					try 
					{
						cronometro.cronoManual(actividad, fldFecha.getText(), fldHoraI.getText(), fldHoraF.getText());
					} catch (ParseException e1) 
					{
						e1.printStackTrace();
					}
			    }
			    reporte.registrarInfoReporte(actividad);
			    proyecto.addActividad(actividad);
		    	this.setVisible(false);
		        principal.ejecutarMostrarMenu();
		    	principal.borrarRegistrarActividad();
		    	
	    	}
	    }
	    else if(comando.equals("PAUSAR"))
	    {
	    	CronometroActividad cronometro = proyecto.obpar(fldUsuario.getText()).darReporte().darCronometro();	
	    	cronometro.pausarCronoActividad();
	    	
	    	PanelCrono.remove(PanelRegCrono);
	    	PanelRegCrono = new JPanel();
	    	PanelRegCrono.setBackground(new Color(203, 203, 203));
	    	PanelRegCrono.setLayout(new GridLayout(1,1));
			PanelRegCrono.add(btnReanudar);
			PanelCrono.add(PanelRegCrono);
			PanelCrono.revalidate();
	    }
	    else if(comando.equals("REANUDAR"))
	    {
	    	CronometroActividad cronometro = proyecto.obpar(fldUsuario.getText()).darReporte().darCronometro();	
	    	cronometro.reanudarCronoActividad();
	    	
	    	PanelCrono.remove(PanelRegCrono);
	    	PanelRegCrono = new JPanel();
	    	PanelRegCrono.setBackground(new Color(203, 203, 203));
	    	GridLayout layout4 = new GridLayout(1,2);
		    layout4.setHgap(15);
		    layout4.setVgap(15);
	    	PanelRegCrono.setLayout(layout4);
	    	PanelRegCrono.add(btnPausa);
			PanelRegCrono.add(btnTerminar);
			PanelCrono.add(PanelRegCrono);
			PanelCrono.revalidate();
		}
	    else if(comando.equals("TERMINAR"))
	    {
	    	CronometroActividad cronometro = proyecto.obpar(fldUsuario.getText()).darReporte().darCronometro();	
	    	cronometro.terminarCronoActividad(actividad);
	    	PanelCrono.remove(PanelRegCrono);

	    	PanelCrono.add(new JLabel("Se registró correctamente el tiempo"));
			PanelCrono.add(btnRegistrar);
			PanelCrono.revalidate();
	    	
	    }
		
	    
	    
	}
}
