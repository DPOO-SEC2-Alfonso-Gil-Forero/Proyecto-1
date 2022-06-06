package modelo;

import java.util.HashMap;

public class Tarea 
{

	
	//Atributos

	private String nombre;

	private String descripcion;

	private String tipo;
	
	private String tiempoPlaneado;

	private String fechaEstimadaFin;
		
	private HashMap<String,Participante> participantes;

	private HashMap<String,Actividad> actividades;
	
	private boolean finalizada;
	
	
	//Constructor
	
	
	public Tarea(String pNombre, String pDescripcion, String pTipo, String pTiempoPlaneado, String pFechaEstimadaFin)
	{
		nombre = pNombre;
		descripcion = pDescripcion;
		tipo = pTipo;
		tiempoPlaneado = pTiempoPlaneado;
		fechaEstimadaFin = pFechaEstimadaFin;
		participantes = new HashMap<String,Participante>();
		actividades = new HashMap<String,Actividad>();
		finalizada = false;
		
	}
		
		
	//Métodos
	
	public void agregarParticipante(String nombreParticipante, Participante elParticipante)
	{
		participantes.put(nombreParticipante, elParticipante);
	}

	public void agregarActividad(String nombreActividad, Actividad laActividad)
	{
		actividades.put(nombreActividad, laActividad);
	}
	
	


	public String darNombre() 
	{
		return nombre;
	}
	
	
	public String darDescripcion() 
	{
		return descripcion;
	}
	
	
	public String darTipo() 
	{
		return tipo;
	}

	
	public String darTiempoPlaneado() 
	{
		return tiempoPlaneado;
	}
	
	
	public String darFechaEstimadaFin() 
	{
		return fechaEstimadaFin;
	}
	
	
	public HashMap<String,Participante> darParticipantes()
	{
		return participantes;
	}

	
	public HashMap<String,Actividad> darActivdades()
	{
		return actividades;
	}
		
	
	public void finalizarTarea()
	{
		finalizada = true;
	}
	
	
	public boolean estaFinalizada()
	{
		return finalizada;
	}
}
