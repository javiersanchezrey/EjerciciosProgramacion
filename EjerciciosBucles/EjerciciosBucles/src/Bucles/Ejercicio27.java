package Bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio27 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Escribe un numero para saber si es divisible entre 2, 3 o 5.");
		
	double numero = Integer.parseInt(br.readLine());
	
	while(numero % 2 == 0 && numero % 3 == 0 && numero % 5 == 0) {
		
		System.out.println("El numero es un multiplo de los 3.");
		
		if(numero % 2 == 0 && numero % 3 != 0 && numero % 5 != 0 ) {
			System.out.println("El numero es multiplo solo de 2");
			
		} else if(numero % 2 != 0 && numero % 3 == 0 && numero % 5 != 0 ) {
			System.out.println("El numero es multiplo solo de 3");
			
		} else if(numero % 2 != 0 && numero % 3 != 0 && numero % 5 == 0 ) {
			System.out.println("El numero es multiplo solo de 5");
			
		} else {
			System.out.println("No es multiplo de ninguno.");
		}
		
		System.out.println("Escribe otro numero");
		numero = Integer.parseInt(br.readLine());
	}
		
		
	
}
}
