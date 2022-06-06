package modelo;

public class Actividad 
{

	
	
	
	//Atributos

	private DetallesActividad detalles;

	//Constructor
	
	public Actividad()
	{
		detalles = new DetallesActividad();
	}
	
	//Métodos
	
	public DetallesActividad darDetalles()
	{
		return detalles;
	}
	
	public void guardarInfoActividad(String titulo, String descripcion, String tipo, String participante, String tarea)
	{
		detalles.guardarInfoActividad(titulo, descripcion, tipo, participante, tarea);
	}
	
	public void agregarFechaHoraI(String fecha, String horaI)
	{
		detalles.agregarFechaHoraI(fecha, horaI);
	}
	
	public void agregarHoraF(String horaF)
	{
		detalles.agregarHoraF(horaF);
	}
}
