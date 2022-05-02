package interfaz;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import modelo.Participante;
import modelo.Proyecto;

public class PanelAgregarParticipante extends JPanel implements ActionListener
{
	private VentanaPrincipal principal;

	private Participante participante;
	
	private JLabel txtEncabezado;

	//Panel Centro
	private JPanel PanelDatos;

	private JLabel txtNombre;
	private JLabel txtCorreo;
	private JLabel txtTipo;

	private JTextField fldNombre;
	private JTextField fldCorreo;
	private JTextField fldTipo;
	
	//panel sur
	private JPanel panelBtnAceptar;

	private JButton bttnAceptar;

	private Proyecto proyecto;
	
	public PanelAgregarParticipante(VentanaPrincipal Pprincipal, Proyecto Pproyecto)
	{
		principal = Pprincipal;
		proyecto = Pproyecto;
		participante = new Participante(fldNombre.getText(), fldCorreo.getText(), fldTipo.getText());
		setBackground(new Color(203, 203, 203));
		setBorder( new TitledBorder( "Registrar parcipante" ) );
		
		txtEncabezado = new JLabel("<html><div style='text-align: center;'>Ingrese los datos del participante que desea añadir:</div><html>");
	    txtEncabezado.setFont(new Font("Calibri", Font.BOLD, 20));
		txtEncabezado.setVerticalAlignment(JLabel.CENTER);
	    txtEncabezado.setHorizontalAlignment(JLabel.CENTER);
	    txtEncabezado.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
    	txtEncabezado.setPreferredSize(new Dimension(700,100));
	    txtEncabezado.setSize(getPreferredSize());
	    txtEncabezado.setOpaque(true);
	    txtEncabezado.setBackground(new Color(180, 180, 180));
	    add(txtEncabezado, BorderLayout.NORTH);
		
		PanelDatos = new JPanel();
		PanelDatos.setBackground(new Color(203, 203, 203));

		panelBtnAceptar = new JPanel();
		panelBtnAceptar.setBackground(new Color(203, 203, 203));

		crearPanelDatos();
		add(PanelDatos, BorderLayout.CENTER);

		crearPanelBtnAceptar();
		add(panelBtnAceptar, BorderLayout.SOUTH);

	}

	private void crearPanelDatos()
	{
		PanelDatos.setBackground(new Color(203, 203, 203));
		txtNombre = new JLabel("ingrese su nombre completo:");
		txtCorreo = new JLabel("ingrese su correo electronico:");
		txtTipo = new JLabel("Indique si es participante normal o si es dueño del proyecto:");
		
		fldNombre = new JTextField();
		fldNombre.setBorder(new LineBorder(Color.BLACK, 2, true));
		fldCorreo = new JTextField();
		fldCorreo.setBorder(new LineBorder(Color.BLACK, 2, true));
		fldTipo = new JTextField();
		fldTipo.setBorder(new LineBorder(Color.BLACK, 2, true));

		PanelDatos.setLayout(new GridLayout(6,1));
		PanelDatos.add(txtNombre);
		PanelDatos.add(fldNombre);
		PanelDatos.add(txtCorreo);
		PanelDatos.add(fldCorreo);
		PanelDatos.add(txtTipo);
		PanelDatos.add(fldTipo);
	}
	
	private void crearPanelBtnAceptar()
	{
		panelBtnAceptar.setBackground(new Color(203, 203, 203));
		GridLayout layoutBttn = new GridLayout(1,4);
		panelBtnAceptar.setLayout(layoutBttn);

		bttnAceptar = new JButton("ACEPTAR");
		bttnAceptar.setBackground(new Color(166, 166, 166));
		bttnAceptar.setBorder(new LineBorder(Color.BLACK, 2, true));

		bttnAceptar.addActionListener(this);

		bttnAceptar.setActionCommand("ACEPTAR");

		panelBtnAceptar.add(bttnAceptar);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand( );
		String nombre = fldNombre.getText();
		if(comando.equals("ACEPTAR"))
		{
			if(fldNombre.getText().isEmpty()|| fldCorreo.getText().isEmpty() || fldTipo.getText().isEmpty())
	    	{
	    		JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos");
	    	}
			else
			{
				Participante.GuardarParticipante(nombre, participante);
			}		
			principal.ejecutarMostrarMenu();
		}
			
	}
		
}

