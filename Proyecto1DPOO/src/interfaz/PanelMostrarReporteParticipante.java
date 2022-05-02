package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import modelo.Actividad;
import modelo.Proyecto;
import modelo.Reporte;

public class PanelMostrarReporteParticipante extends JPanel implements ActionListener
{
	
	private VentanaPrincipal principal;
	private Proyecto proyecto;
	private Reporte reporte;
	
	private JPanel PanelBusqueda;
	private JLabel txtIngreseNombre;
	private JTextField fldUsuario;
	private JButton btnBuscar;
	
	private JPanel PanelReporte;
	
	private JPanel PanelTiempo;
	private JLabel txtEncabezado;
	private JPanel PanelTiemposT;
	private JLabel txtTTotal;
	private JLabel txtTProm;
	private JLabel txtTDia;
	private JLabel txtTTotalO;
	private JLabel txtTPromO;
	private JLabel txtTDiaO;
	
	
	
	private JPanel PanelLReportes;
	private JPanel PanelInfoReporte;
	private int Pagina = 0;
	private JPanel PanelInfoD;
	private JPanel PanelInfoI;
	private JPanel PanelInfoI1;
	private JLabel txtInfo2;
	
	
	private JPanel PanelMenu;
	private JButton btnAtras;
	private JButton btnSiguiente;
	private JButton btnMenu;
	    
	
	
	
	public PanelMostrarReporteParticipante(VentanaPrincipal Pprincipal, Proyecto Pproyecto)
	{
		principal = Pprincipal;
		proyecto = Pproyecto;
		
	    setBorder( new TitledBorder( "Mostrar Reporte Participante" ) );
	    setBackground(new Color(203, 203, 203));
	    setPreferredSize(new Dimension(1000,750));
	    
	    PanelBusqueda = new JPanel();
    	PanelReporte = new JPanel();
    	
    	PanelReporte.setVisible(false);
	    
	    crearPanelBusqueda();
	    
	    add(PanelBusqueda, BorderLayout.NORTH);
	    add(PanelReporte);
	}
	
	
	
	private void crearPanelBusqueda()
	{
		PanelBusqueda.setBackground(new Color(203, 203, 203));
	    PanelBusqueda.setPreferredSize(new Dimension(600,75));
	    
	    GridLayout layout1 = new GridLayout(2,2);
	    layout1.setHgap(15);
	    layout1.setVgap(15);
	    PanelBusqueda.setLayout(layout1);
	    
	    txtIngreseNombre = new JLabel("Ingrese el nombre del usuario: ");

	    fldUsuario = new JTextField();
		fldUsuario.setBorder(new LineBorder(Color.BLACK, 2, true));
	    
	    btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(166, 166, 166));
		btnBuscar.setBorder(new LineBorder(Color.BLACK, 2, true));
		btnBuscar.addActionListener(this);
		btnBuscar.setActionCommand("BUSCAR");
		
		PanelBusqueda.add(txtIngreseNombre);
		PanelBusqueda.add(fldUsuario);
		PanelBusqueda.add(new JLabel(""));
		PanelBusqueda.add(btnBuscar);
	}
	
	private void crearPanelReporte()
	{
		PanelReporte.setBackground(new Color(203, 203, 203));
	    PanelReporte.setPreferredSize(new Dimension(800,600));
	    
		PanelTiempo = new JPanel();
		PanelLReportes = new JPanel();
		    
		crearPanelTiempo();
		crearPanelLReportes();
		    
		PanelReporte.add(PanelTiempo, BorderLayout.NORTH);
		PanelReporte.add(PanelLReportes, BorderLayout.SOUTH);
	}	
	
	
	private void crearPanelTiempo()
	{
		PanelTiempo.setBackground(new Color(203, 203, 203));
	    PanelTiempo.setPreferredSize(new Dimension(800,175));
	    
		txtEncabezado = new JLabel("<html><div style='text-align: center;'>Reporte de "+fldUsuario.getText()+"</div></html>");
	    txtEncabezado.setFont(new Font("Calibri", Font.BOLD, 20));
	    txtEncabezado.setVerticalAlignment(JLabel.CENTER);
	    txtEncabezado.setHorizontalAlignment(JLabel.CENTER);
	    txtEncabezado.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
    	txtEncabezado.setPreferredSize(new Dimension(700,50));
	    txtEncabezado.setSize(getPreferredSize());
	    txtEncabezado.setOpaque(true);
	    txtEncabezado.setBackground(new Color(180, 180, 180));
		    
	    PanelTiemposT = new JPanel();
	    PanelTiemposT.setBackground(new Color(203, 203, 203));
	    PanelTiemposT.setPreferredSize(new Dimension(700,100));
	    
	    
	    
	    GridLayout layout2 = new GridLayout(2,3);
	    layout2.setHgap(15);
	    layout2.setVgap(15);
    	PanelTiemposT.setLayout(layout2);

    	txtTTotal = new JLabel("Tiempo total: ");
    	txtTProm = new JLabel("Tiempo promedio por tipo: ");
    	txtTDia = new JLabel("Tiempo por día: ");
    	
    	
    	txtTTotalO = new JLabel(String.valueOf(reporte.darCronometro().darTiempoTotal())+" ms");
    	txtTTotalO.setBorder(new LineBorder(Color.BLACK, 2, true));
    	
    	
    	Map<String, List<Long>> tiempoProm = reporte.darCronometro().darTiempoProm();
    	
    	
    	JPanel PanelPromTipo = new JPanel();
    	JScrollPane scrollFrame1 = new JScrollPane(PanelPromTipo);
	    scrollFrame1.setBorder(new LineBorder(Color.BLACK, 2, true));
	    scrollFrame1.getVerticalScrollBar().setUnitIncrement(10);
    	PanelPromTipo.setAutoscrolls(true);
    	PanelPromTipo.setBackground(new Color(203, 203, 203));
    	GridLayout layout8 = new GridLayout(tiempoProm.size(),2);
	    layout8.setHgap(5);
	    layout8.setVgap(5);
		PanelPromTipo.setLayout(layout8);
		
		for (String llave : tiempoProm.keySet()) 
		{
			Long promedio = 0L;
		    List<Long> lista = tiempoProm.get(llave);
		    for (Long tiempo : lista) 
		    {
		        promedio += tiempo;
		    }
		    String prom = Long.toString(promedio / lista.size());
		    
		    txtTPromO = new JLabel(llave);
			PanelPromTipo.add(txtTPromO);
			
			JLabel txtTPromO2 = new JLabel(prom+" ms");
			PanelPromTipo.add(txtTPromO2);
		}
    	
    	
		Map<String, Long> tiempoPorDia = reporte.darCronometro().darTiempoPorDia();
		
    	
    	JPanel PanelPorDia = new JPanel();
    	JScrollPane scrollFrame2 = new JScrollPane(PanelPorDia);
	    scrollFrame2.setBorder(new LineBorder(Color.BLACK, 2, true));
	    scrollFrame2.getVerticalScrollBar().setUnitIncrement(10);
    	PanelPorDia.setAutoscrolls(true);
    	PanelPorDia.setBackground(new Color(203, 203, 203));
    	GridLayout layout9 = new GridLayout(tiempoPorDia.size(),2);
	    layout9.setHgap(5);
	    layout9.setVgap(5);
	    PanelPorDia.setLayout(layout9);
		
		for (String llave : tiempoPorDia.keySet()) 
		{
		    txtTDiaO = new JLabel(llave);
	    	PanelPorDia.add(txtTDiaO);
			
			JLabel txtTDiaO2 = new JLabel(String.valueOf(tiempoPorDia.get(llave))+" ms");
		    PanelPorDia.add(txtTDiaO2);
		}
    	
    	PanelTiemposT.add(txtTTotal);
    	PanelTiemposT.add(txtTProm);
    	PanelTiemposT.add(txtTDia);
    	PanelTiemposT.add(txtTTotalO);
    	PanelTiemposT.add(scrollFrame1);
    	PanelTiemposT.add(scrollFrame2);
	    
	    PanelTiempo.add(txtEncabezado, BorderLayout.NORTH);
		PanelTiempo.add(PanelTiemposT, BorderLayout.SOUTH);
	}	
	
	
	private void crearPanelLReportes()
	{
		PanelLReportes.setBackground(new Color(203, 203, 203));
	    PanelLReportes.setPreferredSize(new Dimension(700,450));
		
	    List<Actividad> listaAct = reporte.darActividades();
	 
	    Actividad actividad = listaAct.get(Pagina);
		   
	    
	    PanelInfoReporte = new JPanel();
	    PanelInfoReporte.setBackground(new Color(203, 203, 203));
	    PanelInfoReporte.setPreferredSize(new Dimension(700,250));
		GridLayout layout4 = new GridLayout(1,2);
	    layout4.setHgap(15);
	    layout4.setVgap(15);
		PanelInfoReporte.setLayout(layout4);
		
	     
		PanelInfoI = new JPanel();
		PanelInfoI.setBackground(new Color(203, 203, 203));
		GridLayout layout7 = new GridLayout(2,1);
	    layout7.setHgap(15);
	    layout7.setVgap(15);
		PanelInfoI.setLayout(layout7);
		
		PanelInfoI1 = new JPanel();
		PanelInfoI1.setBackground(new Color(203, 203, 203));
		GridLayout layout5 = new GridLayout(2,2);
	    layout5.setHgap(5);
	    layout5.setVgap(5);
		PanelInfoI1.setLayout(layout5);
		PanelInfoI1.add(new JLabel("Título: "));
		PanelInfoI1.add(new JLabel(actividad.darDetalles().darTitulo()));
		PanelInfoI1.add(new JLabel("Descripcion: "));
		PanelInfoI1.add(new JLabel(""));
		
		txtInfo2 = new JLabel("<html>"+actividad.darDetalles().darDescripcion()+"</html>");
		txtInfo2.setVerticalAlignment(JLabel.TOP);
		
		PanelInfoI.add(PanelInfoI1);
		PanelInfoI.add(txtInfo2);
		
		
		
		PanelInfoD = new JPanel();
		PanelInfoD.setBackground(new Color(203, 203, 203));
		GridLayout layout6 = new GridLayout(4,2);
	    layout6.setHgap(5);
	    layout6.setVgap(5);
		PanelInfoD.setLayout(layout6);
		PanelInfoD.add(new JLabel("Tipo: "));
		PanelInfoD.add(new JLabel(actividad.darDetalles().darTipo()));
		PanelInfoD.add(new JLabel("Fecha: "));
		PanelInfoD.add(new JLabel(actividad.darDetalles().darFecha()));
		PanelInfoD.add(new JLabel("Hora Inicio: "));
		PanelInfoD.add(new JLabel(actividad.darDetalles().darHoraI()));
		PanelInfoD.add(new JLabel("Hora Final: "));
		PanelInfoD.add(new JLabel(actividad.darDetalles().darHoraF()));
	    
		
		
		PanelInfoReporte.add(PanelInfoI);
		PanelInfoReporte.add(PanelInfoD);
	    
	    
	    
	    
		PanelMenu = new JPanel();
	    PanelMenu.setPreferredSize(new Dimension(700,50));
		PanelMenu.setBackground(new Color(203, 203, 203));
		GridLayout layout3 = new GridLayout(1,3);
	    layout3.setHgap(15);
	    layout3.setVgap(15);
		PanelMenu.setLayout(layout3);
		
		btnAtras = new JButton("<<");
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand("ATRAS");
		btnAtras.setBackground(new Color(166, 166, 166));
		btnAtras.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		
		btnSiguiente = new JButton(">>");
		btnSiguiente.addActionListener(this);
		btnSiguiente.setActionCommand("SIGUIENTE");
		btnSiguiente.setBackground(new Color(166, 166, 166));
		btnSiguiente.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		
		btnMenu = new JButton("Menú");
		btnMenu.setBackground(new Color(59, 56, 56));
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setFont(new Font("Calibri", Font.BOLD, 18));
		btnMenu.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnMenu.setPreferredSize(new Dimension(90,50));
		btnMenu.addActionListener(this);
		btnMenu.setActionCommand("MENU");
		
		if (Pagina == 0) 
		{
			PanelMenu.add(new JLabel(""));
			PanelMenu.add(btnMenu);
			PanelMenu.add(btnSiguiente);
		}
		else if (Pagina == listaAct.size()-1)
		{
			PanelMenu.add(btnAtras);
			PanelMenu.add(btnMenu);
			PanelMenu.add(new JLabel(""));
		}
		else
		{
			PanelMenu.add(btnAtras);
			PanelMenu.add(btnMenu);
			PanelMenu.add(btnSiguiente);
		}
		
		
		    
		PanelLReportes.add(PanelInfoReporte, BorderLayout.NORTH);
		PanelLReportes.add(PanelMenu, BorderLayout.SOUTH);
		   
	}	
	

	
	@Override
	public void actionPerformed( ActionEvent e )
	{
	    String comando = e.getActionCommand( );
	    

		
	    
	    if(comando.equals("BUSCAR"))
	    {
	    	reporte = proyecto.obpar(fldUsuario.getText()).darReporte();
	    	remove(PanelReporte);
	    	PanelReporte = new JPanel();
		    crearPanelReporte();
		    add(PanelReporte, BorderLayout.SOUTH);
			revalidate();
	    }
	    
	    else if(comando.equals("MENU"))
	    {
	    	this.setVisible(false);
	        principal.ejecutarMostrarMenu();
	    	principal.borrarMostrarReporteParticipante();
	    }
	    
	    else if(comando.equals("SIGUIENTE"))
	    {
	    	Pagina += 1;
	    	PanelReporte.remove(PanelLReportes);
			PanelLReportes = new JPanel();
	    	crearPanelLReportes();
	    	PanelReporte.add(PanelLReportes, BorderLayout.SOUTH);
			PanelLReportes.revalidate();
	    }
	    
	    else if(comando.equals("ATRAS"))
	    {
	    	Pagina -= 1;
	    	PanelReporte.remove(PanelLReportes);
			PanelLReportes = new JPanel();
	    	crearPanelLReportes();
	    	PanelReporte.add(PanelLReportes, BorderLayout.SOUTH);
			PanelLReportes.revalidate();
			
	    }
	}
	
}
