package Ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Deportistas extends Personas{

	private String deporteQuePractican;
	
	private String categoria;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public void añadirDatos(ArrayList<Deportistas> deportistas) throws IOException {
		
		super.añadirDatos(deportistas);
		
			System.out.println("Escribe el deporte que practica.");
				deporteQuePractican = br.readLine();
				
				do {
					
					System.out.println("Escribe la categoria del deporte que practica.");
					categoria = br.readLine();
					
					if (!categoria.equalsIgnoreCase("amateur") && !categoria.equalsIgnoreCase("profesional")){
						System.err.println("Solo puede ser una de las categorías anteriores.");
					}
				} while(!categoria.equalsIgnoreCase("amateur") && !categoria.equalsIgnoreCase("profesional"));
	}
	
	public int getDNI() {
		return super.getDNI();
	}
	
	public String getNombre() {
		return super.getNombre();
	}
	
	public void mostrarDatos() {
		
		super.mostrarDatos();
		
		System.out.println("El deporte que practica es: " + this.deporteQuePractican);
		System.out.println("Su categoria es: " + this.categoria);
	}
	
}
