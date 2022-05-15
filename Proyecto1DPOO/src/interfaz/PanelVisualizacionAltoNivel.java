package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import modelo.Participante;
import modelo.Proyecto;

public class PanelVisualizacionAltoNivel extends JPanel implements ActionListener
{

	private VentanaPrincipal principal;
	private Proyecto proyecto;
	private int[][] cantidades;
	private HashMap<String,Participante> participantes;
	private DateFormat fechaFormato;
	private JPanel PanelSuperior;

	private JLabel txtEncabezado;

	private JButton btnMenu;
	
	
	public PanelVisualizacionAltoNivel(VentanaPrincipal Pprincipal, Proyecto Pproyecto)
	{
		
		principal = Pprincipal;
		proyecto = Pproyecto;
		participantes = proyecto.darParticipantes();
		fechaFormato = new SimpleDateFormat("dd/MM/yyyy");

		try {
			tiempoPorDia();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setSize(1000, 750);
		
		setBorder( new TitledBorder( "Panel visualización de alto nivel" ) );
	    setBackground(new Color(203, 203, 203));
	    
	    PanelSuperior = new JPanel();
	    PanelSuperior.setBackground(new Color(203, 203, 203));
	    PanelSuperior.setPreferredSize(new Dimension(700,150));
	    
	    txtEncabezado = new JLabel("<html><div style='text-align: center;'>Nivel de actividad en el último año</div><html>");
	    txtEncabezado.setFont(new Font("Calibri", Font.BOLD, 20));
	    txtEncabezado.setVerticalAlignment(JLabel.CENTER);
	    txtEncabezado.setHorizontalAlignment(JLabel.CENTER);
	    txtEncabezado.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
    	txtEncabezado.setPreferredSize(new Dimension(700,75));
	    txtEncabezado.setOpaque(true);
	    txtEncabezado.setBackground(new Color(180, 180, 180));
	    
	    btnMenu = new JButton("Menú");
		btnMenu.setBackground(new Color(59, 56, 56));
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setFont(new Font("Calibri", Font.BOLD, 18));
		btnMenu.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnMenu.setPreferredSize(new Dimension(90,50));
		btnMenu.addActionListener(this);
		btnMenu.setActionCommand("MENU");
		

	    PanelSuperior.add(txtEncabezado, BorderLayout.NORTH);
	    PanelSuperior.add(btnMenu, BorderLayout.SOUTH);

	    
	    

		this.add(PanelSuperior, BorderLayout.NORTH);
        this.add(new PanelJava2d(), BorderLayout.CENTER);
        

		
	}
	
	
	 public class PanelJava2d extends JPanel 
	 {
	        public PanelJava2d()
	        {
	            this.setPreferredSize(new Dimension(800,400));

	        }
			public void paint(Graphics g)
			{
				Graphics2D g2d = (Graphics2D) g;
				int trozo = 700/31;
				for (int i = 0; i < 12; i++)
				{
					g2d.setColor(Color.black);
					g2d.drawString(retornarMes(i+1),35,i*trozo+83);
				}
				for (int i = 0; i < 31; i++)
				{
					g2d.setColor(Color.black);
					g2d.drawString(String.valueOf(i+1),i*trozo+73,60);
				}
				for (int i = 0; i < 31; i++)
					for (int ii = 0; ii < 12; ii++)
					{
						if (cantidades[i][ii]==0)
						{
							g2d.setColor(new Color(255,255,255));
						}
						else if (cantidades[i][ii]==1)
						{
							g2d.setColor(new Color(200,200,200));
						}
						else if (cantidades[i][ii]==2)
						{
							g2d.setColor(new Color(150,150,150));
						}
						else if (cantidades[i][ii]==3)
						{
							g2d.setColor(new Color(100,100,100));
						}
						else if (cantidades[i][ii]==4)
						{
							g2d.setColor(new Color(50,50,50));
						}
						else
						{
							g2d.setColor(new Color(0,0,0));
						}
						g2d.fillRoundRect(i*trozo+70,ii*trozo+70,trozo-5,trozo-5,30,30);
					}
				
				}
	
	        }
	
	
	
	
	
	
	
	private int[][] tiempoPorDia() throws ParseException
	{

		cantidades = new int[31][12];
		
		for (String llParticipante: participantes.keySet())
		{
			Participante participante = participantes.get(llParticipante);
			Map<String, Long> tiempoPorDia = participante.darReporte().darCronometro().darTiempoPorDia();
			for (String llave : tiempoPorDia.keySet()) 
			{
				Calendar fecha  = Calendar.getInstance();
				fecha.setTime(fechaFormato.parse(llave));
				
				cantidades[fecha.get(Calendar.DAY_OF_MONTH)-1][fecha.get(Calendar.MONTH)] += 1;
			}
		}
		
		return cantidades;
	}
	
	private String retornarMes(int numero)
	{
		switch(numero)
		{
		case 1:
			return "ENE";
		case 2:
			return "FEB";
		case 3:
			return "MAR";
		case 4:
			return "ABR";
		case 5:
			return "MAY";
		case 6:
			return "JUN";
		case 7:
			return "JUL";
		case 8:
			return "AGO";
		case 9:
			return "SEP";
		case 10:
			return "OCT";
		case 11:
			return "NOV";
		case 12:
			return "DIC";
		default:
			return "";
		}
	}
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
	    String comando = e.getActionCommand( );
	   
	    if(comando.equals("MENU"))
	    {
	    	this.setVisible(false);
	        principal.ejecutarMostrarMenu();
	    	principal.borrarVisualizacionAltoNivel();
	    }
	    
	}
	
}
