package modelo;

import java.util.HashMap;

public class ReporteEquipo {
	private String desempeño;
	private String tiempoPP;
	private String tareasPP;
	private String tiempoPTP;
	private HashMap<String,Participante> participantes;
	
	public ReporteEquipo(Proyecto proyecto) {
		participantes=proyecto.darParticipantes();
		long i=0;
		int j=0;
		for(String llave: participantes.keySet()) {
			CronometroActividad cronometro=participantes.get(llave).darReporte().darCronometro();
			tiempoPP+= llave + ": "+ cronometro.darTiempoTotal()+" ms \n";
			i+=cronometro.darTiempoTotal();
			j++;
			
		}
		i=i/j;
		desempeño=Long.toString(i)+ " ms/participante";
		
		
	}
	public String mostrarRE() {
		return tiempoPP + " " + desempeño;
	}

}
