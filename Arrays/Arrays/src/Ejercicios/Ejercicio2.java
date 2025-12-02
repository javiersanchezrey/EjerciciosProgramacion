package Ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {

	//Ejercicio 42.
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		boolean salir = false;
		System.out.println("=== BIENVENIDO A [NOMBRE_APP] ===");
		
		do {
			
		//MOSTRAR MENU
			
		System.out.println("\n--- MENÚ PRINCIPAL ---");
		System.out.println("1. Introducir nombres de candidatos y ciudades");
		System.out.println("2. Registrar votos de todas las ciudades (introducir la matriz completa)");
		System.out.println("3. Mostrar tabla de votos completa");
		System.out.println("4. Calcular total de votos por candidato");
		System.out.println("5. Calcular total de votos por ciudad");
		System.out.println("6. Mostrar ganador general (candidato con más votos totales)");
		System.out.println("7. Mostrar qué candidato ganó en cada ciudad");
		System.out.println("8. Mostrar la ciudad con mayor participación (más votos totales)");
		System.out.println("9. Comprobar si algún candidato ganó en todas las ciudades");
		System.out.println("10. Mostrar diferencia de votos entre el primero y segundo lugar");
		System.out.println("11. Salir.");


		System.out.print("Elige una opción: ");
		
		int opcion = Integer.parseInt(br.readLine());
		
		switch (opcion) {
		
		case 1:
		System.out.println("Opcion 1");
		
			
		break;
	}

}while (!salir);

	}

}
