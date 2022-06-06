package modelo;

import java.util.HashMap;
import java.util.Iterator;

public class PaqueteTrabajo 
{

	
	
	//Atributos

	private String nombre;

	private String descripcion;
	
    private HashMap<String,Tarea> tareas;
	
    private HashMap<String,PaqueteTrabajo> paquetes;
	
	
	//Constructor
	
	
	public PaqueteTrabajo(String pNombre, String pDescripcion)
	{
		nombre = pNombre;
		descripcion = pDescripcion;
		tareas = new HashMap<String,Tarea>();
		paquetes = new HashMap<String,PaqueteTrabajo>();
	}
	
	
		
	//Métodos
	
	public void agregarTarea(String nombreTarea, Tarea laTarea)
	{
		tareas.put(nombreTarea, laTarea);
	}

	
	public void agregarPaquete(String nombrePaquete, PaqueteTrabajo elPaquete)
	{
		paquetes.put(nombrePaquete, elPaquete);
	}
		
	

	public String darNombre() 
	{
		return nombre;
	}
	
	
	
	public String darDescripcion() 
	{
		return descripcion;
	}
	
	
	
	public HashMap<String,Tarea> darTareas()
	{
		return tareas;
	}
	
	
	public HashMap<String,PaqueteTrabajo> darPaquetes()
	{
		return paquetes;
	}
	
	
	public Tarea darUnaTarea(String nombreTarea)
	{
		Tarea laTarea = null;
		boolean existe = false;
		if (tareas.containsKey(nombreTarea))
		{
			laTarea = tareas.get(nombreTarea);
		}
		else
		{
			if (!(paquetes.isEmpty()))
			{
				Iterator iterator = paquetes.keySet().iterator();
				while(iterator.hasNext() && !existe) 
				{
					laTarea = paquetes.get((String) iterator.next()).darUnaTarea(nombreTarea);
					if (!(laTarea.equals(null)))
					{
						existe = true;
					}
				}
				
			}
		}
		return laTarea;
	}
	
	
	
	public PaqueteTrabajo darUnPaquete(String nombrePaquete)
	{
		PaqueteTrabajo elPaquete = null;
		boolean existe = false;
		if (paquetes.containsKey(nombrePaquete))
		{
			elPaquete = paquetes.get(nombrePaquete);
		}
		else
		{
			if (!(paquetes.isEmpty()))
			{
				Iterator iterator = paquetes.keySet().iterator();
				while(iterator.hasNext() && !existe) 
				{
					elPaquete = paquetes.get((String) iterator.next()).darUnPaquete(nombrePaquete);
					if (!(elPaquete.equals(null)))
					{
						existe = true;
					}
				}
				
			}
		}
		return elPaquete;
	}
		
	
}
