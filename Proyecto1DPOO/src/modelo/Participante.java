package modelo;

import java.util.HashMap;
import java.util.List;

import javax.swing.JTextField;

public class Participante 
{

	
	// ************************************************************************
	// Atributos
	// ************************************************************************

	
	protected String nombre;	
	protected String correo;
	protected String tipo;
	protected List<Actividad> actividades;
	protected Reporte reporte;

	protected HashMap<String, Participante> hashParticipantes;


	
	
	// ************************************************************************
	// Constructores
	// ************************************************************************

	public Participante(String elNombre, String elCorreo, String elTipo) 
	{
		this.nombre = elNombre;
		this.correo = elCorreo;
		this.tipo = elTipo;
		reporte = new Reporte(nombre);
	}

	// ************************************************************************
	// Metodos para consultar los atributos
	// ************************************************************************
	
	public String darNombre()
	{
		return nombre;
	}
	
	public String darCorreo()
	{
		return correo;
	}
	
	public String darTipo()
	{
		return tipo;
	}
		
	public Reporte darReporte()
	{
		return reporte;
	}
	
	public void modificarDatos(String elNombre, String elCorreo, String elTipo)
	{
		this.nombre = elNombre;
		this.correo = elCorreo;
		this.tipo = elTipo;

	}
	public String mostrarDatosParticipante()
	{
		this.nombre = darNombre();
		this.correo = darCorreo();
		this.tipo = darTipo();
		String r = "nombre: "+this.nombre + "correo: "+ this.correo +"tipo: "+ this.tipo;
		return r;
	}
	
	public static void GuardarParticipante(String fldNombre, Participante participante)
	{
		HashMap<String, Participante> hashParticipantes = new HashMap<>();
		hashParticipantes.put(fldNombre, participante);	
	}
	
	
	

	}
