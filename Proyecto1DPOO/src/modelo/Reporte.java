package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Reporte 
{

	
	
	
	//Atributos

	private String nombreParticipante;
	
	private CronometroActividad cronometro;

	private List<Actividad> actividades;
	
	private String reporteStr;

	//Constructor
	
	public Reporte(String PnombreParticipante)
	{
		cronometro = new CronometroActividad();
		nombreParticipante = PnombreParticipante;
		reporteStr = "Nombre Participante: "+nombreParticipante+"\n";
		actividades = new ArrayList<Actividad>();
	}
	
	//Métodos
	
	public void registrarInfoReporte(Actividad actividad)
	{
		actividades.add(actividad);
		reporteStr += "\nTitulo actividad: "+actividad.darDetalles().darTitulo();
		reporteStr += "\nDescripción: \n"+actividad.darDetalles().darDescripcion();
		reporteStr += "\nTipo: "+actividad.darDetalles().darTipo();
		reporteStr += "\nFecha: "+actividad.darDetalles().darFecha();
		reporteStr += "\nHora Inicio : "+actividad.darDetalles().darHoraI();
		reporteStr += "\nHora Final : "+actividad.darDetalles().darHoraF();
		reporteStr += "\n\n";
	}
	
	
	public String mostrarReporteMiembro()
	{
		String reporteTemp = reporteStr + "Tiempo total: " + cronometro.darTiempoTotal()+" ms";
		Map<String, List<Long>> tiempoProm = cronometro.darTiempoProm();
		reporteTemp += "\nTiempo promedio por tipo de actividad: \n";
		for (String llave : tiempoProm.keySet()) 
		{
			Long promedio = 0L;
		    List<Long> lista = tiempoProm.get(llave);
		    for (Long tiempo : lista) 
		    {
		        promedio += tiempo;
		    }
		    String prom = Long.toString(promedio / lista.size());
		    reporteTemp += llave+" : "+prom+" ms\n";
		}
		reporteTemp += "Tiempo por día: \n";
		Map<String, Long> tiempoPorDia = cronometro.darTiempoPorDia();
		for (String llave : tiempoPorDia.keySet()) 
		{
			Long tiempo = tiempoPorDia.get(llave);
			reporteTemp += llave+" : "+tiempo+" ms\n";
		}
		return reporteTemp;
	}
	
	public CronometroActividad darCronometro()
	{
		return cronometro;
	}
}
