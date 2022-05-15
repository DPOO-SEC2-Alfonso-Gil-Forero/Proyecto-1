package modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CronometroActividad 
{

	
	
	
	
	//Atributos
	
	private Date momento1;
	
	private Date momento2;
	
	private DateFormat fechaFormato;
	
	private DateFormat horaFormato;
	
	private DateFormat fechaHoraFormato;
	
	private long acarreo;
	
	private long tiempoTotal;

	private Map<String, List<Long>> tiempoProm;

	private Map<String, Long> tiempoPorDia;


	//Constructor
	
	public CronometroActividad()
	{
		fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
		horaFormato = new SimpleDateFormat("HH:mm:ss");
		fechaHoraFormato = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
		tiempoTotal = 0;
		tiempoProm = new HashMap<String, List<Long>>();
		tiempoPorDia = new HashMap<String, Long>();
	}
	
	//Métodos
	
	
	public void  iniciarCronoActividad(Actividad actividad)
	{
		acarreo = 0;
		momento1 = Calendar.getInstance().getTime();
		actividad.agregarFechaHoraI(fechaFormato.format(momento1), horaFormato.format(momento1));
	}
	
	
	public void  pausarCronoActividad()
	{
		acarreo += Calendar.getInstance().getTime().getTime() - momento1.getTime();
	}
	
	
	public void  reanudarCronoActividad()
	{
		momento1 = Calendar.getInstance().getTime();
	}
	
	
	public void  terminarCronoActividad(Actividad actividad, String tipo)
	{
		momento2 = Calendar.getInstance().getTime();
		actividad.agregarHoraF(horaFormato.format(momento2));
		acarreo += Calendar.getInstance().getTime().getTime() - momento1.getTime();
		actualizarTiempo(actividad, tipo);
		
	}
	
	
	
	public void cronoManual(Actividad actividad, String fecha, String horaI, String horaF) throws ParseException
	{
		momento1 = fechaHoraFormato.parse(fecha+"-"+horaI);
		momento2 = fechaHoraFormato.parse(fecha+"-"+horaF);
		acarreo = momento2.getTime() - momento1.getTime();
		String llave2 = actividad.darDetalles().darTipo();
		actualizarTiempo(actividad, llave2);
	}

	
	
	
	public void actualizarTiempo(Actividad actividad,String llave2)
	{
		tiempoTotal += acarreo;
		String llave1 = fechaFormato.format(momento1);
		if (tiempoPorDia.containsKey(llave1))
		{
			long suma = tiempoPorDia.get(llave1);
			tiempoPorDia.put(llave1, acarreo+suma);
		}
		else
		{
			tiempoPorDia.put(llave1, acarreo);
		}
		if (tiempoProm.containsKey(llave2))
		{
			List<Long> lista = tiempoProm.get(llave2);
			lista.add(acarreo);
		}
		else
		{
			List<Long> lista = new ArrayList<Long>();
			lista.add(acarreo);
			tiempoProm.put(llave2, lista);
		}
	}
	
	
	public float darTiempoTotal() 
	{
		return tiempoTotal;
	}

	public Map<String, List<Long>> darTiempoProm() 
	{
		return tiempoProm;
	}

	public Map<String, Long> darTiempoPorDia() 
	{
		return tiempoPorDia;
	}
	
}
