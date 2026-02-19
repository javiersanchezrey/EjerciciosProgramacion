package Ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Deportistas extends Personas{
	
	private String deportePactica;
	
	private String categoria;

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void añadirDatos(ArrayList<Deportistas> deportista) throws NumberFormatException, IOException {
		
		super.añadirDatos(deportista);
			System.out.println("Escribe el deporte que practica el Deportista.");
				deportePactica = br.readLine();
				
			do {
				
				System.out.println("Escribe su categoría. (Amateur o Profesional)");
					categoria = br.readLine();
					
					if(!categoria.equalsIgnoreCase("Amateur") && !categoria.equalsIgnoreCase("Profesional")) {
						
						System.err.println("Lo siento pero solo puede ser una de las anteriores categorías.");
					}
				
			} while(!categoria.equalsIgnoreCase("Amateur") && !categoria.equalsIgnoreCase("Profesional"));
	}
	
	public int getDNI() {
		return super.getDNI();
	}
}
