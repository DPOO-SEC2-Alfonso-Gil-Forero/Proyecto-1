package modelo;

public class AvanceProyecto {
	private String fechaPF;
	private String fechaRF;
	private float tareasCST;
	private float promTTC;
	private DetallesProyecto detalles;
	
	public AvanceProyecto(Proyecto proyecto) {
		detalles= proyecto.getDetalles();
		fechaPF=detalles.darFechaF();
		
		}
	public void setFRF(String fecha) {
		fechaRF=fecha;
	}

	public String darFRF() {
		return fechaRF;
	}

}
