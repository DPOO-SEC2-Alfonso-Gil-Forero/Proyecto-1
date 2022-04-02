package modelo;

import java.util.ArrayList;
import java.util.List;

public class Participante 
{

	
	// ************************************************************************
	// Atributos
	// ************************************************************************

	
	/**
	 * el nombre del participante que hace parte del proyecto
	 */
	protected String nombre;
	
	
	/**
	 * correo del participante que hace parte del proyecto
	 */	
	protected String correo;
	
	
	/**
	 * indica si es dueño del proyecto o un participante normal
	 */
	protected String tipo;
	
	
	/**
	 * una lista con los participantes de proyecto
	 */
	protected List<Participante> participantes;
		
	
	/**
	 * una lista con las actividades de cada participante
	 */
	protected List<Actividad> actividades;
	
	/**
	 * reporte de las actividades de cada miembro del
	 * equipo incluyendo información como: tiempo total
	 * invertido, tiempo promedio por tipo de actividad,
	 * tiempo por cada día.
	 */
	protected Reporte reporte;
	
	// ************************************************************************
	// Constructores
	// ************************************************************************

	/**
	 * Construye un nuevo participante e inicializa sus atributos
	 * con los parametros. La lista de participantes se inicializa
	 * vacia.
	 * 
	 * @param elNombre = Nombre participante
	 * @param elCorreo = Correo del participante
	 * @param elTipo = indica si es dueño del proyecto o participante normal
	 */
	public Participante(String elNombre, String elCorreo, String elTipo) 
	{
		this.nombre = elNombre;
		this.correo = elCorreo;
		this.tipo = elTipo;
		this.participantes = new ArrayList<>();
	}

	// ************************************************************************
	// Metodos para consultar los atributos
	// ************************************************************************
	/**
	 * constulta el nombre del participante
	 * @return nombre
	 */
	public String darNombre()
	{
		return nombre;
	}
	/**
	 * constulta el correo del participante
	 * @return correo
	 */
	public String darCorreo()
	{
		return correo;
	}
	/**
	 * constulta si el participante es dueño del proyecto o no
	 * @return tipo
	 */
	public String darTipo()
	{
		return tipo;
	}
	
	}
