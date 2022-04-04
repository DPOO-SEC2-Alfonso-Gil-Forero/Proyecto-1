package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelo.Actividad;
import modelo.Participante;
import modelo.Reporte;

public class ConsolaProyecto {
	
	

	public void ejecutarAplicacion()
	{
		System.out.println("Consola Seguimiento Proyecto\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opci�n: "));
				if (opcion_seleccionada == 1)
				{
					
				}
				else if (opcion_seleccionada == 2)
				{
					
				}
				else if (opcion_seleccionada == 3)
				{
					
				}
				else if (opcion_seleccionada == 4)
				{
					
				}
				else if (opcion_seleccionada == 5)
				{
					ejecutarAgregarActividad();
				}
				else if (opcion_seleccionada == 6)
				{
					ejecutarMostrarReporte();
				}
				else if (opcion_seleccionada == 7)
				{
					ejecutarGenerarInforme();
				}
				else if (opcion_seleccionada == 8)
				{
					System.out.println("Saliendo de la aplicaci�n ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	
	
	
	
	




	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicaci�n\n");
		System.out.println("1. Guardar informaci�n nuevo Proyecto");
		System.out.println("2. Mostrar informaci�n de proyecto");
		System.out.println("3. Agregar participante");
		System.out.println("4. Modificar datos participante");
		System.out.println("5. Registrar actividad");
		System.out.println("6. Mostrar reporte de un participante");
		System.out.println("7. Generar documento con toda la informaci�n del proyecto");
		System.out.println("8. Salir de la aplicaci�n\n");
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public void ejecutarAgregarActividad()
	{
		Actividad actividad = new Actividad();
		String participanteNombre = input("Ingrese su usuario o el de aquel que realiz� la actividad: ");
		String titulo = input("Ingrese el t�tulo de la actividad: ");
		String descripcion = input("Ingrese una breve descripci�n de la actividad: ");
		//Participante participante = proyecto.obpar(participanteNombre);	
		//Reporte reporte = participante.darReporte();	
		//CronometroActividad cronometro = reporte.darCronometro();	
		System.out.println("\nDe los siguientes tipos, escriba el tipo de la actividad: ");
		//List<String> lista = proyecto.detalles.darTipos();
		List<String> lista = new ArrayList<String>();
		for (String tipoL : lista) 
	    {
	    	System.out.println("\n"+tipoL);
	    }
	    boolean cont = true;
	    String tipo = "";
		while (cont)
		{
			tipo = input("Ingrese el tipo de la actividad: ");
			if (lista.contains(tipo))
			{
				cont = false;
			}
			else
			{
				System.out.println("\nTipo no valido");
			}
		}
		actividad.guardarInfoActividad(titulo, descripcion, tipo, participanteNombre);
		System.out.println("\nDesea empezar a cron�metrar la actividad o esta ya fue terminada previamente:\n");
		boolean cont2 = true;
	    while (cont2)
		{
	    	String opcionCrono = input("a) Empezar cron�metro\nb) Ingresar datos manualmente\n");
			if (opcionCrono.equals("a"))
			{
				//cronometro.iniciarCronoActividad()	
				boolean cont3 = true;
			    while (cont3)
				{
			    	String opcionCrono2 = input("a) Pausar cron�metro\nb) Finalizar cron�metro\n");
					if (opcionCrono2.equals("a"))
					{
						//cronometro.pausarCronoActividad()
						input("Escriba cualquier tecla para reanudar el conteo del tiempo\n");
						//cronometro.reanudarCronoActividad()
					}
					else if (opcionCrono2.equals("b"))
					{
						//cronometro.terminarCronoActividad()
						System.out.println("\nCron�metro terminado\n");
						cont3 = false;
					}
					else
					{
						System.out.println("\nOpci�n no v�lida");
					}
				}
				cont2 = false;
			}
			else if (opcionCrono.equals("b"))
			{
				String fecha = input("Escriba la fecha en la que realiz� la actividad en formato dd/MM/yyyy\n");
				String horaI = input("Escriba la hora en la que inici� la actividad en formato HH:mm:ss\n");
				String horaF = input("Escriba la hora en la que termino la actividad en formato HH:mm:ss\n");
				actividad.agregarFechaHoraI(fecha, horaI);
				actividad.agregarHoraF(horaF);
				//cronometro.cronoManual(actividad, fecha, horaI, horaF);
				cont2 = false;
			}
			else
			{
				System.out.println("\nOpci�n no v�lida");
			}
		}
	    //reporte.registrarInfoReporte(actividad);
	    //proyecto.addActividad(actividad);
	    System.out.println("\nLa actividad fue agregada");
		
	}
	
	
	
	
	
	
	private void ejecutarMostrarReporte() 
	{
		String participante = input("Ingrese el usuario del que quiere obtener su reporte: ");
		//Reporte reporte = proyecto.obpar(participante).darReporte();	
		//System.out.println(reporte.mostrarReporteMiembro());
		
	}
	
	
	private void ejecutarGenerarInforme() 
	{
		try 
		{
			File file = new File("proyecto.txt");
		 }
		catch (IOException e) 
		{
			System.out.println("Ocurrio un error, intente de nuevo.");
		    e.printStackTrace();
		}
		String informe = "";
		
		informe += "Nombre Proyecto: "+proyecto.getDetalles().getNombre();
		informe += "\nDescripci�n\n: "+proyecto.getDetalles().getDescripcion();
		informe += "\nFecha inicio: "+proyecto.getDetalles().getFechaI();
		informe += "\nFecha finalizaci�n estimada: "+proyecto.getDetalles().getFechaF();
		

		informe += "\nParticipantes: ";
		
		Map<String, Participante> participantes = proyecto.getParticipantes();
		for (String llave : participantes.keySet()) 
		{
		    Participante participante = participantes.get(llave);
		    informe += "\n"+participante.getReporte().mostrarReporteMiembro();
		}
		
		
		try 
		{
			FileWriter myWriter = new FileWriter("proyecto.txt");
		    myWriter.write(informe);
		    myWriter.close();
		 } 
		catch (IOException e) 
		{
			System.out.println("Ocurri� un error.");
		    e.printStackTrace();
		}
	}



	
	
	
	
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	public static void main(String[] args)
	{
		ConsolaProyecto consola = new ConsolaProyecto();
		consola.ejecutarAplicacion();
	}
}
