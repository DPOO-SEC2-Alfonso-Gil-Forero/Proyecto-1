package modelo;

public class Resumen {
	
	private CalidadPlaneacion calidad;
	private AvanceProyecto avance;
	private ReporteEquipo reporte;
	
	public Resumen(Proyecto proyecto){
		reporte= new ReporteEquipo(proyecto);
		
	}
	

}
