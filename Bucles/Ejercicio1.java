package Bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new
			InputStreamReader(System.in));
			boolean salir = false;
			System.out.println("=== BIENVENIDO A [NOMBRE_APP] ===");
			do {
			//MOSTRAR MENU
			System.out.println("\n--- MENÚ PRINCIPAL ---");
			System.out.println("1. [Opción 1]");
			System.out.println("2. [Opción 2]");
			System.out.println("3. [Opción 3]");
			System.out.println("4. [Opción 4]");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");
			int opcion = Integer.parseInt(br.readLine());
			switch (opcion) {
			
			case 1:
			System.out.println("Opcion 1");
			//....
			break;
			
			case 2:
			System.out.println("Opcion 2");
			//....
			break;
			
			case 3:
			System.out.println("Opcion 3");
			//....
			break;
			
			case 4:
			System.out.println("Opcion 4");
			//....
			break;
			
			case 5:
			salir = true;
			System.out.println("¡Hasta luego!");
			break;
			
			default:
			System.out.println("Opción no válida");
			}
			
			}while(!salir);
			
			}
		
	}
