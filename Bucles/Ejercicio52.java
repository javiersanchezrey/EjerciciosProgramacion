package Bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio52 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Introduzca su fecha de nacimiento: |n¿Cuál es su día de nacimiento?");
			int dia = Integer.parseInt(br.readLine());
		
		System.out.println("¿Cuál es su mes de nacimiento?");
			int mes = Integer.parseInt(br.readLine());
		
		System.out.println("¿Cuál es su año de nacimiento?");
			int año = Integer.parseInt(br.readLine());

			while (dia < 1 || dia > 31) {
				System.out.println("El dia introducido es erróneo, Introduzca un dia correcto.");
				dia = Integer.parseInt(br.readLine());
				
		}
			
		while (mes < 1 || mes > 12) {
				System.out.println("El mes introducido es erróneo, Introduzca un mes correcto.");
				mes = Integer.parseInt(br.readLine());
				
		}
			
		while (año < 1900 || año > 2025) {
				System.out.println("El año introducido es erróneo, Introduzca un año correcto.");
				año = Integer.parseInt(br.readLine());
			
		}
			
			if (dia >= 1 && dia <=31 || mes>=1 && mes <=12 || año >= 1900 && año <=2025) {
				System.out.println("Su fecha de nacimiento es: \n" + dia + "-" + mes + "-" + año);
				
			}
				

		
		
		
	}

}
