package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Proyecto 
{

	
	
	
	//Atributos

	private HashMap<String,Participante> participantes;
	
	private List<Actividad> actividades;
	
	private Dueno dueno;
	
	private DetallesProyecto detalles;
	
	private Reporte reporte;

	//Constructor
	public Proyecto(String nombre, String descripcion, String fechai, String fechaf, Dueno dueno,List<String> tiposActividad ){
		this.dueno=dueno;
		this.detalles=new DetallesProyecto(nombre, descripcion, fechai, fechaf, tiposActividad);
		//this.reporte=new Reporte(dueno.nombre); 
		
	}
	//Métodos

	public List<String> darTipos() {
		return detalles.darTiposs();	
	}
	
	public void mostrarProyecto(String direccion) throws IOException{
		FileReader file = null;
		try {
			file = new FileReader(direccion);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("no se encontro este proyecto");
		}
		BufferedReader br = new BufferedReader(file);
		String message = "";
		String line = br.readLine();
		while(line != null) {
		message += line + " ";
		line = br.readLine();
		}
		System.out.println(message);
		br.close();
		
	}
	public void addPart(String nombrepar, Participante par ) {
		this.participantes.put(nombrepar,par);
	}
	public Participante obpar(String nombrepar) {
		Participante par=this.participantes.get(nombrepar);
		return par;
	}
	public Set<String> obparticipantes() {
		Set<String> participantes=this.participantes.keySet();
		return participantes;
	}
	public void addActividad(Actividad actividad) {
		this.actividades.add(actividad);		
	}
	public DetallesProyecto getDetalles() {
		return detalles;
	}
	
}
