package modelo;

import java.util.HashMap;

public class WBS 
{

	
	//Atributos

	
    private PaqueteTrabajo raiz;
	
	
	//Constructor
	
	
	public WBS()
	{
		raiz = new PaqueteTrabajo("raiz","El paquete trabajo nodo");
	}

	
	
		
	//M�todos
	
	
	public PaqueteTrabajo darRaiz() 
	{
		return raiz;
	}
		
}
