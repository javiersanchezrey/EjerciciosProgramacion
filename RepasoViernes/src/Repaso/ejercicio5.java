package Repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Necesito que me digas que edad tienes.");
	int edad = Integer.parseInt(br.readLine());
	
		System.out.println("Y que nivel tienes? Bajo, Medio o Alto.");
	String nivel = br.readLine();
	
		if (edad<12) {
			System.out.println("Estarás en el equipo infantil.");
			
		} else if (edad > 12 && edad < 15 && nivel.equalsIgnoreCase("Bajo")) {
			System.out.println("Estarás en el equipo infantil.");
			
		} else if (edad > 12 && edad < 15 && nivel.equalsIgnoreCase("Medio") || 	nivel.equalsIgnoreCase("Alto")) {
				System.out.println("Estarás en el equipo Juvenil.");
				
		} else if (edad > 16 && edad < 18 && nivel.equalsIgnoreCase("Bajo")) {
			System.out.println("Estarás en el equipo Juvenil.");
			
		} else if (edad > 16 && edad < 18 && nivel.equalsIgnoreCase("Medio") || 	nivel.equalsIgnoreCase("Alto")) {
			System.out.println("Estarás en el equipo Senior.");
			
		} else if (edad > 18 && nivel.equalsIgnoreCase("Bajo") || nivel.equalsIgnoreCase("Medio") || 	nivel.equalsIgnoreCase("Alto")) {
			System.out.println("Estarás en el equipo Senior.");
		}
		
		
	}

}
