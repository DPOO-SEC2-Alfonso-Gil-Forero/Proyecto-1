package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Actividad;
import modelo.CronometroActividad;
import modelo.Participante;
import modelo.Reporte;
import modelo.DetallesProyecto;
import modelo.Dueno;
import modelo.Proyecto;

public class ConsolaProyecto {
	
	private Proyecto proyecto;

	public void ejecutarAplicacion() throws IOException
	{
		System.out.println("Consola Seguimiento Proyecto\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción: "));
				if (opcion_seleccionada == 1)
				{
					ejecutarCrearProyecto();
				}
				else if (opcion_seleccionada == 2)
				{
					ejecutarMostrarProyecto();
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
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opciÃ³n vÃ¡lida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los nÃºmeros de las opciones.");
			}
		}
	}
	
	
	
	
	
	




	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Guardar información nuevo Proyecto");
		System.out.println("2. Mostrar información de proyecto");
		System.out.println("3. Agregar participante");
		System.out.println("4. Modificar datos participante");
		System.out.println("5. Registrar actividad");
		System.out.println("6. Mostrar reporte de un participante");
		System.out.println("7. Generar documento con toda la información del proyecto");
		System.out.println("8. Salir de la aplicación\n");
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public void ejecutarAgregarActividad() throws ParseException
	{
		Actividad actividad = new Actividad();
		String participanteNombre = input("Ingrese su usuario o el de aquel que realizó la actividad: ");
		String titulo = input("Ingrese el título de la actividad: ");
		String descripcion = input("Ingrese una breve descripción de la actividad: ");
		Participante participante = proyecto.obpar(participanteNombre);	
		Reporte reporte = participante.darReporte();
		CronometroActividad cronometro = reporte.darCronometro();	
		System.out.println("\nDe los siguientes tipos, escriba el tipo de la actividad: ");
		List<String> lista = proyecto.getDetalles().darTiposs();
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
		System.out.println("\nDesea empezar a cronómetrar la actividad o esta ya fue terminada previamente:\n");
		boolean cont2 = true;
	    while (cont2)
		{
	    	String opcionCrono = input("a) Empezar cronómetro\nb) Ingresar datos manualmente\n");
			if (opcionCrono.equals("a"))
			{
				cronometro.iniciarCronoActividad(actividad);
				boolean cont3 = true;
			    while (cont3)
				{
			    	String opcionCrono2 = input("a) Pausar cronómetro\nb) Finalizar cronómetro\n");
					if (opcionCrono2.equals("a"))
					{
						cronometro.pausarCronoActividad();
						input("Escriba cualquier tecla para reanudar el conteo del tiempo\n");
						cronometro.reanudarCronoActividad();
					}
					else if (opcionCrono2.equals("b"))
					{
						cronometro.terminarCronoActividad(actividad);
						System.out.println("\nCronómetro terminado\n");
						cont3 = false;
					}
					else
					{
						System.out.println("\nOpción no válida");
					}
				}
				cont2 = false;
			}
			else if (opcionCrono.equals("b"))
			{
				String fecha = input("Escriba la fecha en la que realizó la actividad en formato dd/MM/yyyy\n");
				String horaI = input("Escriba la hora en la que inició la actividad en formato HH:mm:ss\n");
				String horaF = input("Escriba la hora en la que termino la actividad en formato HH:mm:ss\n");
				actividad.agregarFechaHoraI(fecha, horaI);
				actividad.agregarHoraF(horaF);
				cronometro.cronoManual(actividad, fecha, horaI, horaF);
				cont2 = false;
			}
			else
			{
				System.out.println("\nOpción no válida");
			}
		}
	    reporte.registrarInfoReporte(actividad);
	    proyecto.addActividad(actividad);
	    System.out.println("\nLa actividad fue agregada");
		
	}
	
	
	
	
	
	
	private void ejecutarMostrarReporte() 
	{
		String participante = input("Ingrese el usuario del que quiere obtener su reporte: ");	
		Reporte reporte = proyecto.obpar(participante).darReporte();
		System.out.println(reporte.mostrarReporteMiembro());
		
	}
	
	
	private void ejecutarGenerarInforme() 
	{
		String informe = "";
		
		informe += "Nombre Proyecto: "+proyecto.getDetalles().darNombre();
		informe += "\nDescripción\n: "+proyecto.getDetalles().darDescripcion();
		informe += "\nFecha inicio: "+proyecto.getDetalles().darFechaI();
		informe += "\nFecha finalización estimada: "+proyecto.getDetalles().darFechaF();
		

		informe += "\nParticipantes: ";
		
		HashMap<String, Participante> participantes = proyecto.darParticipantes();
		for (String llave : participantes.keySet()) 
		{
		    Participante participante = participantes.get(llave);
		    informe += "\n"+participante.getReporte().mostrarReporteMiembro();
		}
		
		System.out.println(informe);
		
	}
	
	
	
	public void ejecutarCrearProyecto() throws IOException {
		
		String nombre=input("ingrese el nombre del nuevo proyecto");
		String descripcion=input("ingrese la descripcion del nuevo proyecto");
		String fechai=input("ingrese la fecha de inicio del proyecto");
		String fechaf=input("ingrese la fecha estimada de finalizacion del proyecto");
		String duenio=input("ingrese el nombre del dueño del proyecto");
		String tipos=input("ingrese los tipoos de actividades separadas por comas");
		String[] tiposA=tipos.split(",");
		List<String> tiposAc=new ArrayList();
		for (String a:tiposA) {
			tiposAc.add(a);
		}
		proyecto= new Proyecto(nombre, descripcion, fechai, fechaf, null, tiposAc);
		guardarInfo();
		
	}
	public void ejecutarMostrarProyecto(){
		String nombre=input("ingrese la direccion del proyecto que desea que se muestre");
		try {
			proyecto.mostrarProyecto(nombre);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("no se encontro el proyecto");
		}
	}
    public void guardarInfo() throws IOException {
    	String ruta=input("ingrese la ruta del proyecto");
    	DetallesProyecto detalles=proyecto.getDetalles();
    	detalles.guardarInfo(ruta);
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
	
	
	
	
	
	
	public static void main(String[] args) throws IOException
	{
		ConsolaProyecto consola = new ConsolaProyecto();
		consola.ejecutarAplicacion();
	}
}
