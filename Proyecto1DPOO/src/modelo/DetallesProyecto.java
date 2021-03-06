package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class DetallesProyecto 
{




	//Atributos

	private String nombre;

	private String descripcion;

	private String fechaI;

	private String fechaF;
	
	private String dueno;

	private List<String> tiposActividad;



	//Constructor
	public DetallesProyecto(String nombre, String descripcion, String fechai, String fechaf,List<String> tiposActividad, String nombreDueno ){
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.fechaI=fechai;
		this.fechaF=fechaf;
		this.tiposActividad=tiposActividad;
		dueno = nombreDueno;
	}

	//M?todos
	public List<String> darTiposs(){
		return tiposActividad;
	}
	
	
	public String darNombre()
	{
		return nombre;
	}

	public String darDescripcion()
	{
		return descripcion;
	}

	public String darFechaI()
	{
		return fechaI;
	}

	public String darFechaF()
	{
		return fechaF;
	}
	
	public String darDueno()
	{
		return dueno;
	}
	
	public void setFechaF(String FechaF) {
		this.fechaF=FechaF;
	}
	public void guardarInfo(String nombrear) throws IOException {
		File file = new File(nombrear);
		String message=nombre + descripcion + fechaI + fechaF+ tiposActividad.toString();
		if(file.createNewFile()) {
		System.out.println("File created: " + file.getName());
		BufferedWriter writer = new BufferedWriter(new FileWriter(nombrear));
		writer.write(nombre +"\n");
		writer.write(descripcion+"\n");
		writer.write(fechaI+"\n");
		writer.write(fechaF+"\n");
		writer.write(tiposActividad.toString()+"\n");
		writer.close();}
		else{
			System.out.println("File already exists.");
			RandomAccessFile archivo = new RandomAccessFile(nombrear, "rw");
			archivo.seek(0);
			archivo.writeBytes(message);
			archivo.close();
		}	
	}
}
