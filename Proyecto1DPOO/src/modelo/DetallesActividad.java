package modelo;

public class DetallesActividad 
{

	
	
	
	//Atributos

	private String titulo;

	private String descripcion;

	private String tipo;
	
	private String fecha;

	private String horaI;

	private String horaF;
	
	private String participante;


	//Constructor
	
	
	public DetallesActividad(){}
	
	
	//Métodos
	
	
	public void guardarInfoActividad(String Ptitulo, String Pdescripcion, String Ptipo, String Pparticipante)
	{
		titulo = Ptitulo;
		
		descripcion = Pdescripcion;
		
		tipo = Ptipo;
		
		participante = Pparticipante;
	}


	
	public void agregarFechaHoraI(String Pfecha, String PhoraI)
	{
		fecha = Pfecha;
		
		horaI = PhoraI;
	}
	
	
	public void agregarHoraF(String PhoraF)
	{
		horaF = PhoraF;
	}
	
	
	public String darTitulo() 
	{
		return titulo;
	}


	public String darDescripcion() 
	{
		return descripcion;
	}


	public String darTipo() 
	{
		return tipo;
	}


	public String darFecha() 
	{
		return fecha;
	}


	public String darHoraI() 
	{
		return horaI;
	}


	public String darHoraF() 
	{
		return horaF;
	}


	public String darParticipante() 
	{
		return participante;
	}
}
