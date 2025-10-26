package Bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {

		public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			boolean salir = false;
			
			int edad ;
			double precio = 0;
			
			char miercoles;
			char combo = 's';
			
			char grupoPersonas = 's';
			int numeroPersonas ;
			
			int precioGrupo = 0;
			
			System.out.println("=== BIENVENIDO A [NOMBRE_APP] ===");
			
			do {
			
			System.out.println("\n--- MENÚ PRINCIPAL ---");
			System.out.println("1. Precio de entrada según la edad");
			System.out.println("2. Precio con descuento de los Miercoles");
			System.out.println("3. Precio del combo Palomitas + Refresco");
			System.out.println("4. Precio para grupo de personas");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");
			
			int opcion = Integer.parseInt(br.readLine());
			
			switch (opcion) {
			
			case 1:
			System.out.println("Opcion 1");
				System.out.println("¿Cuál es tu edad?");
					edad = Integer.parseInt(br.readLine());
				
				if (edad <= 17) {
					System.out.println("Eres un niño, por lo que tu entrada cuesta 5€.");
				
				} else if (edad >= 18 && edad < 65) {
					System.out.println("Eres un adulto y tu entrada vale 8€.");
					
				}else {
					System.out.println("Eres un jubilado y tu entrada vale 6€.");
				}
					
			break;
			
			case 2:
			System.out.println("Opcion 2");
			
			System.out.println("Cuánto vale tu entrada?");
				precio = Integer.parseInt(br.readLine());
			
			System.out.println("¿Hoy es Miercoles? S/N");
				miercoles = br.readLine().toLowerCase().charAt(0);
			
				if (miercoles == 's') {
					System.out.println("Hoy al ser Miercoles hay un descuento del 50%. \nEl precio de tu entrada se queda en: " + (precio * 0.50));
					
				}else {
					System.out.println("El precio de tu entrada el no ser Miercoles es de:  " + precio);
				}
			
			break;
			
			case 3:
			System.out.println("Opcion 3");
			
			System.out.println("¿Quieres incluir el combo de palomitas y refresco? S/N");
				combo = br.readLine().toLowerCase().charAt(0);
				
				if (combo == 's') {
					System.out.println("El precio total de la entrada más el combo será de: " + (precio + 5));
					
				}else {
					System.out.println("El precio de la entrada al cine sin el combo es de " + precio);
				}
			
			break;
			
			case 4:
			System.out.println("Opcion 4");
			
			System.out.println("¿Sois un grupo de personas? S/N");
			grupoPersonas = br.readLine().toLowerCase().charAt(0);
			
			if (grupoPersonas == 's') {
				System.out.println("¿Cuantas personas sois?");
					numeroPersonas = Integer.parseInt(br.readLine());
				
			for( int i = 0; i < numeroPersonas; i++) {
				
				System.out.println("¿Cuál es la edad de la " + (i+1) + " persona?");
					edad = Integer.parseInt(br.readLine());
					
					if (edad <= 17) {
						System.out.println("Eres un niño, por lo que tu entrada cuesta 							5€.");
						precioGrupo += 5;
					
					} else if (edad >= 18 && edad < 65) {
						System.out.println("Eres un adulto y tu entrada vale 8€.");
						precioGrupo += 8;
						
					}else {
						System.out.println("Eres un jubilado y tu entrada vale 6€.");
						precioGrupo += 6;
					}	
					
			} 
			
			System.out.println("El precio de las entradas del grupo son: " + precioGrupo);
				
			} else {
				System.out.println("No sois un grupo, asique se cobrará la entrada individual.");
				
			}
			
			break;
			
			case 5:
			salir = true;
			System.out.println("¡Hasta luego!");
			break;
			
			default:
			System.out.println("Opción no válida");
			}
			
			} while(!salir);
			
			
		
	}

}
