package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import modelo.PaqueteTrabajo;
import modelo.Participante;
import modelo.Proyecto;
import modelo.Tarea;

public class PanelMostrarWBS extends JPanel implements ActionListener
{
	private VentanaPrincipal principal;

	private Participante participante;
	
	private JLabel txtEncabezado;

	//Panel Centro
	private JPanel PanelOpciones;


	private JButton btnRegTarea;
	private JButton btnRegPaquete;
	private JButton btnVerTarea;
	private JButton btnVerPaquete;
	
	
	
	//Panel Reg

	private JPanel PanelRegistrarInfo;
	private JPanel PanelRegInfoI;
	private JPanel PanelRegInfoD;
	
	private JLabel txtTitulo;
	private JLabel txtDescripcion;
	private JLabel txtTipo;
	private JLabel txtPadre;
	
	private JTextField fldTitulo;
	private JTextField fldDescripcion;
	private JTextField fldTipo;
	private JTextField fldPadre;
	
	private JLabel txtTiempoE;
	private JLabel txtFechaE;
	private JLabel txtParticipantes;
	
	private JTextField fldTiempoE;
	private JTextField fldFechaE;
	private JTextField fldParticipantes;
	

	private JButton btnRegistrar;
	
	//Panel Ver
	

	private JPanel PanelBusqueda;
	private JLabel txtIngreseNombre;
	private JTextField fldNombre2;
	private JButton btnBuscar;
	
	
	
	
	private Proyecto proyecto;
	
	public PanelMostrarWBS(VentanaPrincipal Pprincipal, Proyecto Pproyecto)
	{
		principal = Pprincipal;
		proyecto = Pproyecto;
		setBackground(new Color(203, 203, 203));
		setBorder( new TitledBorder( "Mostrar WBS" ) );
		
		txtEncabezado = new JLabel("<html><div style='text-align: center;'>Seleccione una Opción</div><html>");
	    txtEncabezado.setFont(new Font("Calibri", Font.BOLD, 20));
		txtEncabezado.setVerticalAlignment(JLabel.CENTER);
	    txtEncabezado.setHorizontalAlignment(JLabel.CENTER);
	    txtEncabezado.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
    	txtEncabezado.setPreferredSize(new Dimension(700,75));
	    txtEncabezado.setSize(getPreferredSize());
	    txtEncabezado.setOpaque(true);
	    txtEncabezado.setBackground(new Color(180, 180, 180));
	    add(txtEncabezado, BorderLayout.CENTER);
		
		PanelOpciones = new JPanel();
		
		
		crearPanelOpciones();
		add(PanelOpciones, BorderLayout.CENTER);


	}

	private void crearPanelOpciones()
	{
		PanelOpciones.setBackground(new Color(203, 203, 203));
		PanelOpciones.setPreferredSize(new Dimension(700,125));
		
		btnRegTarea = new JButton("Registrar tarea nueva");
		btnRegTarea.setBackground(new Color(166, 166, 166));
		btnRegTarea.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		btnRegPaquete = new JButton("Registrar paquete nuevo");
		btnRegPaquete.setBackground(new Color(166, 166, 166));
		btnRegPaquete.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		btnVerTarea = new JButton("Ver tarea");
		btnVerTarea.setBackground(new Color(166, 166, 166));
		btnVerTarea.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		btnVerPaquete = new JButton("Ver paquete");
		btnVerPaquete.setBackground(new Color(166, 166, 166));
		btnVerPaquete.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		btnRegTarea.addActionListener(this);
		btnRegPaquete.addActionListener(this);
		btnVerTarea.addActionListener(this);
		btnVerPaquete.addActionListener(this);
		
		btnRegTarea.setActionCommand("REG_TAREA");
		btnRegPaquete.setActionCommand("REG_PAQUETE");
		btnVerTarea.setActionCommand("VER_TAREA");
		btnVerPaquete.setActionCommand("VER_PAQUETE");
		
		GridLayout layout1 = new GridLayout(2,2);
	    layout1.setHgap(5);
	    layout1.setVgap(5);
		PanelOpciones.setLayout(layout1);
		PanelOpciones.add(btnRegTarea);
		PanelOpciones.add(btnRegPaquete);
		PanelOpciones.add(btnVerTarea);
		PanelOpciones.add(btnVerPaquete);
	}
	
	
	
	private void crearPanelRegTarea()
	{
		setBackground(new Color(203, 203, 203));
		setBorder( new TitledBorder( "Registrar Tarea" ) );
		
	    txtEncabezado = new JLabel("<html><div style='text-align: center;'>Para registrar la tarea correctamente, por favor llene todos los campos a continuación</div><html>");
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

		PanelRegInfoI.setBackground(new Color(203, 203, 203));
		txtTitulo = new JLabel("Ingrese el nombre de la tarea: ");
		txtDescripcion = new JLabel("Ingrese una breve descripción: ");
		txtTipo = new JLabel("Ingrese el tipo de la tarea: ");
		txtPadre = new JLabel("Ingrese el paquete padre de la tarea (\"raiz\" si es el origen): ");
	    
		fldTitulo = new JTextField();
		fldTitulo.setBorder(new LineBorder(Color.BLACK, 2, true));
		fldDescripcion = new JTextField();
		fldDescripcion.setBorder(new LineBorder(Color.BLACK, 2, true));
		fldTipo= new JTextField();
		fldTipo.setBorder(new LineBorder(Color.BLACK, 2, true));
		fldPadre= new JTextField();
		fldPadre.setBorder(new LineBorder(Color.BLACK, 2, true));
		

		PanelRegInfoI.setLayout(new GridLayout(8,1));
		PanelRegInfoI.add(txtTitulo);
		PanelRegInfoI.add(fldTitulo);
		PanelRegInfoI.add(txtDescripcion);
		PanelRegInfoI.add(fldDescripcion);
		PanelRegInfoI.add(txtTipo);
		PanelRegInfoI.add(fldTipo);
		PanelRegInfoI.add(txtPadre);
		PanelRegInfoI.add(fldPadre);

		
		PanelRegInfoD.setBackground(new Color(203, 203, 203));
		txtTiempoE = new JLabel("Ingrese el tiempo estimado de la tarea: ");
		txtFechaE = new JLabel("Ingrese la fecha estimada de finalización: ");
		txtParticipantes = new JLabel("Ingrese los participantes separados por comas: ");


		fldTiempoE = new JTextField();
		fldTiempoE.setBorder(new LineBorder(Color.BLACK, 2, true));
		fldFechaE = new JTextField();
		fldFechaE.setBorder(new LineBorder(Color.BLACK, 2, true));
		fldParticipantes= new JTextField();
		fldParticipantes.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		btnRegistrar = new JButton("Registrar Tarea");
		btnRegistrar.setBackground(new Color(59, 56, 56));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Calibri", Font.BOLD, 20));
		btnRegistrar.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand("REGISTRAR");
		
		GridLayout layout2 = new GridLayout(7,1);
	    layout2.setHgap(15);
	    layout2.setVgap(15);
		PanelRegInfoD.setLayout(layout2);
		PanelRegInfoD.add(txtTiempoE);
		PanelRegInfoD.add(fldTiempoE);
		PanelRegInfoD.add(txtFechaE);
		PanelRegInfoD.add(fldFechaE);
		PanelRegInfoD.add(txtParticipantes);
		PanelRegInfoD.add(fldParticipantes);
		PanelRegInfoD.add(btnRegistrar);
		
		PanelRegistrarInfo.add(PanelRegInfoI);
		PanelRegistrarInfo.add(PanelRegInfoD);
		PanelRegistrarInfo.setPreferredSize(new Dimension(800,500));
		add(PanelRegistrarInfo, BorderLayout.SOUTH);
	    
	}
	
	
	private void crearPanelRegPaquete()
	{
		setBackground(new Color(203, 203, 203));
		setBorder( new TitledBorder( "Registrar Paquete" ) );
		
	    txtEncabezado = new JLabel("<html><div style='text-align: center;'>Para registrar el paquete correctamente, por favor llene todos los campos a continuación</div><html>");
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
	    
	    GridLayout layout1 = new GridLayout(1,2);
	    layout1.setHgap(50);
	    layout1.setVgap(50);
	    PanelRegistrarInfo.setLayout(layout1);

		PanelRegInfoI.setBackground(new Color(203, 203, 203));
		txtTitulo = new JLabel("Ingrese el nombre del paquete: ");
		txtDescripcion = new JLabel("Ingrese una breve descripción: ");
		txtPadre = new JLabel("Ingrese el paquete padre del paquete (\"raiz\" si es el origen): ");
	    
		fldTitulo = new JTextField();
		fldTitulo.setBorder(new LineBorder(Color.BLACK, 2, true));
		fldDescripcion = new JTextField();
		fldDescripcion.setBorder(new LineBorder(Color.BLACK, 2, true));
		fldPadre= new JTextField();
		fldPadre.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		GridLayout layout2 = new GridLayout(7,1);
	    layout2.setHgap(15);
	    layout2.setVgap(15);
		PanelRegInfoI.setLayout(layout2); 
		PanelRegInfoI.add(txtTitulo);
		PanelRegInfoI.add(fldTitulo);
		PanelRegInfoI.add(txtDescripcion);
		PanelRegInfoI.add(fldDescripcion);
		PanelRegInfoI.add(txtPadre);
		PanelRegInfoI.add(fldPadre);

		btnRegistrar = new JButton("Registrar Paquete");
		btnRegistrar.setBackground(new Color(59, 56, 56));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Calibri", Font.BOLD, 20));
		btnRegistrar.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand("REGISTRAR2");
		
		
		PanelRegInfoI.add(btnRegistrar);
		
		PanelRegistrarInfo.add(PanelRegInfoI);
		PanelRegistrarInfo.setPreferredSize(new Dimension(800,500));
		add(PanelRegistrarInfo, BorderLayout.SOUTH);
	    
	}
	
	private void crearPanelBusqueda(int tipo)
	{
		setBackground(new Color(203, 203, 203));
		setBorder( new TitledBorder( "Busqueda" ) );
		
		PanelBusqueda = new JPanel();
		PanelBusqueda.setBackground(new Color(203, 203, 203));
	    PanelBusqueda.setPreferredSize(new Dimension(600,75));
	    
	    
	    
	    GridLayout layout1 = new GridLayout(2,2);
	    layout1.setHgap(15);
	    layout1.setVgap(15);
	    PanelBusqueda.setLayout(layout1);
	    
	    if (tipo == 1)
	    {
	    	txtIngreseNombre = new JLabel("Ingrese el nombre de la tarea: ");
	    }
	    else
	    {
	    	txtIngreseNombre = new JLabel("Ingrese el nombre del paquete de trabajo: ");
	    }
	    
	    fldNombre2 = new JTextField();
		fldNombre2.setBorder(new LineBorder(Color.BLACK, 2, true));
	    
	    btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(166, 166, 166));
		btnBuscar.setBorder(new LineBorder(Color.BLACK, 2, true));
		btnBuscar.addActionListener(this);
		if (tipo == 1)
	    {
			btnBuscar.setActionCommand("BUSCAR1");
	    }
	    else
	    {
	    	btnBuscar.setActionCommand("BUSCAR2");
	    }
		
		
		PanelBusqueda.add(txtIngreseNombre);
		PanelBusqueda.add(fldNombre2);
		PanelBusqueda.add(new JLabel(""));
		PanelBusqueda.add(btnBuscar);
		this.add(PanelBusqueda, BorderLayout.NORTH);
		revalidate();
	}
	
	private void crearPanelVerTarea()
	{
		this.removeAll();
		
		setBackground(new Color(203, 203, 203));
		setBorder( new TitledBorder( "Ver Tarea" ) );
		
		Tarea tareaVer = proyecto.darWBS().darRaiz().darUnaTarea(fldNombre2.getText());
				
		
	    txtEncabezado = new JLabel("<html><div style='text-align: center;'>La información de "+tareaVer.darNombre()+"</div><html>");
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

		PanelRegInfoI.setBackground(new Color(203, 203, 203));
		txtTitulo = new JLabel("Nombre: "+tareaVer.darNombre());
		txtDescripcion = new JLabel("Descripción: "+tareaVer.darDescripcion());
		txtTipo = new JLabel("Tipo: "+tareaVer.darTipo());


		String t5 = "";
		for (String a2 : tareaVer.darActivdades().keySet())
		{
			t5 += a2+"   ";
		}
		

		String finalizada = "No";
		if (tareaVer.estaFinalizada())
		{
			finalizada = "Sí";
		}
		
		PanelRegInfoI.setLayout(new GridLayout(5,1));
		PanelRegInfoI.add(txtTitulo);
		PanelRegInfoI.add(txtDescripcion);
		PanelRegInfoI.add(txtTipo);
		PanelRegInfoI.add(new JLabel("Actividades: "+t5));
		PanelRegInfoI.add(new JLabel("Finalizada: "+finalizada));

		
		PanelRegInfoD.setBackground(new Color(203, 203, 203));
		txtTiempoE = new JLabel("Tiempo estimado de la tarea: "+tareaVer.darTiempoPlaneado());
		txtFechaE = new JLabel("Fecha estimada de finalización: "+tareaVer.darFechaEstimadaFin());
		String p3 = "";
		for (String p2 : tareaVer.darParticipantes().keySet())
		{
			p3 += p2+"   ";
		}
		txtParticipantes = new JLabel("Participantes: "+p3);

		
		btnRegistrar = new JButton("Menú");
		btnRegistrar.setBackground(new Color(59, 56, 56));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Calibri", Font.BOLD, 20));
		btnRegistrar.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand("MENU");
		
		GridLayout layout2 = new GridLayout(4,1);
	    layout2.setHgap(15);
	    layout2.setVgap(15);
		PanelRegInfoD.setLayout(layout2);
		PanelRegInfoD.add(txtTiempoE);
		PanelRegInfoD.add(txtFechaE);
		PanelRegInfoD.add(txtParticipantes);
		PanelRegInfoD.add(btnRegistrar);
		
		PanelRegistrarInfo.add(PanelRegInfoI);
		PanelRegistrarInfo.add(PanelRegInfoD);
		PanelRegistrarInfo.setPreferredSize(new Dimension(800,500));
		add(PanelRegistrarInfo, BorderLayout.SOUTH);
	    
		
	}
	
	
	private void crearPanelVerPaquete()
	{
		setBackground(new Color(203, 203, 203));
		setBorder( new TitledBorder( "Ver Paquete" ) );
		
		PaqueteTrabajo paqueteVer;
		
		if (fldNombre2.getText().equals("raiz"))
		{
			paqueteVer = proyecto.darWBS().darRaiz();
		}
		else
		{
			paqueteVer = proyecto.darWBS().darRaiz().darUnPaquete(fldNombre2.getText());
		}
		
		
	    txtEncabezado = new JLabel("<html><div style='text-align: center;'>La información de "+paqueteVer.darNombre()+"</div><html>");
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
	    
	    GridLayout layout1 = new GridLayout(1,2);
	    layout1.setHgap(50);
	    layout1.setVgap(50);
	    PanelRegistrarInfo.setLayout(layout1);

		PanelRegInfoI.setBackground(new Color(203, 203, 203));
		txtTitulo = new JLabel("Nombre del paquete: "+paqueteVer.darNombre());
		txtDescripcion = new JLabel("Descripción: "+paqueteVer.darDescripcion());
	    
		
		
		String t3 = "";
		for (String t2 : paqueteVer.darTareas().keySet())
		{
			t3 += t2+"   ";
		}
		txtParticipantes = new JLabel("Tareas: "+t3);
		
		
		
		
		GridLayout layout2 = new GridLayout(5,1);
	    layout2.setHgap(15);
	    layout2.setVgap(15);
		PanelRegInfoI.setLayout(layout2); 
		PanelRegInfoI.add(txtTitulo);
		PanelRegInfoI.add(txtDescripcion);
		PanelRegInfoI.add(txtParticipantes);
		
		t3 = "";
		for (String t2 : paqueteVer.darPaquetes().keySet())
		{
			t3 += t2+"   ";
		}
		txtParticipantes = new JLabel("Sub-paquetes: "+t3);
		
		PanelRegInfoI.add(txtParticipantes);
		
		btnRegistrar = new JButton("Menú");
		btnRegistrar.setBackground(new Color(59, 56, 56));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Calibri", Font.BOLD, 20));
		btnRegistrar.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand("MENU");
		
		
		PanelRegInfoI.add(btnRegistrar);
		
		PanelRegistrarInfo.add(PanelRegInfoI);
		PanelRegistrarInfo.setPreferredSize(new Dimension(800,500));
		add(PanelRegistrarInfo, BorderLayout.SOUTH);
	    
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand( );
		if(comando.equals("REG_TAREA"))
		{
			this.removeAll();
			crearPanelRegTarea();
		}
		else if(comando.equals("REG_PAQUETE"))	
		{
			this.removeAll();
			crearPanelRegPaquete();
		}
		else if(comando.equals("VER_TAREA"))	
		{
			this.removeAll();
			crearPanelBusqueda(1);
		}
		else if(comando.equals("VER_PAQUETE"))	
		{
			this.removeAll();
			crearPanelBusqueda(2);
		}
		else if(comando.equals("BUSCAR1"))	
		{
			this.removeAll();
			crearPanelVerTarea();
		}
		else if(comando.equals("BUSCAR2"))	
		{
			this.removeAll();
			crearPanelVerPaquete();
		}
		else if(comando.equals("MENU"))	
		{
			this.setVisible(false);
	        principal.ejecutarMostrarMenu();
	    	principal.borrarMostrarWBS();
		}
		else if(comando.equals("REGISTRAR"))
	    {
	    	if (fldTitulo.getText().isEmpty()|| fldDescripcion.getText().isEmpty() || fldTipo.getText().isEmpty() || fldTiempoE.getText().isEmpty() || fldFechaE.getText().isEmpty() || fldParticipantes.getText().isEmpty())
	    	{
	    		JOptionPane.showMessageDialog(null, "Rellene todos los campos");
	    	}
	    	else
	    	{
	    		Tarea tarea = new Tarea(fldTitulo.getText(),fldDescripcion.getText(),fldTipo.getText(),fldTiempoE.getText(),fldFechaE.getText());
	    		String[] participantesT = fldParticipantes.getText().split(",");
	    		for (String p : participantesT) {
	    			if (proyecto.darParticipantes().containsKey(p))
	    			{
	    				tarea.agregarParticipante(p, proyecto.darParticipantes().get(p));
	    			}
	    	    }
	    		if (fldPadre.getText().equals("raiz"))
	    		{
	    			proyecto.darWBS().darRaiz().agregarTarea(fldTitulo.getText(), tarea);
	    		}
	    		else
	    		{
	    			proyecto.darWBS().darRaiz().darUnPaquete(fldPadre.getText()).agregarTarea(fldTitulo.getText(), tarea);
	    		}
	    		
	    		this.setVisible(false);
		        principal.ejecutarMostrarMenu();
		    	principal.borrarMostrarWBS();

	    	
	    	}
	    }
		else if(comando.equals("REGISTRAR2"))
	    {
	    	if (fldTitulo.getText().isEmpty()|| fldDescripcion.getText().isEmpty() || fldPadre.getText().isEmpty())
	    	{
	    		JOptionPane.showMessageDialog(null, "Rellene todos los campos");
	    	}
	    	else
	    	{
	    		PaqueteTrabajo paquete = new PaqueteTrabajo(fldTitulo.getText(),fldDescripcion.getText());
	    		if (fldPadre.getText().equals("raiz"))
	    		{
	    			proyecto.darWBS().darRaiz().agregarPaquete(fldTitulo.getText(), paquete);
	    		}
	    		else
	    		{
	    			proyecto.darWBS().darRaiz().darUnPaquete(fldPadre.getText()).agregarPaquete(fldTitulo.getText(), paquete);
	    		}
	    		this.setVisible(false);
		        principal.ejecutarMostrarMenu();
		    	principal.borrarMostrarWBS();
		    	
	    	
	    	}
	    }
	}
}

