package EjerciciosBucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int distanciaTotalCocheA = 0;
		int distanciaTotalCocheB = 0;
		
		boolean salir = false;
		
		System.out.println("=== BIENVENIDO A La CARRERA DEL AÑO ===");
		
		do {
		
			System.out.println("\n--- MENÚ PRINCIPAL ---");
			System.out.println("1. Avanza el coche A");
			System.out.println("2. Avanza el coche B");
			System.out.println("3. Muestra la posición de cada uno");
			System.out.println("4. Hace una simulación automática de 10 turnos. (Primero avanza el A y después el B)");
			System.out.println("5. Se reinicia la carrera.");
			System.out.println("6. Salir");
			System.out.print("Elige una opción: ");
		
		int opcion = Integer.parseInt(br.readLine());
		
		switch (opcion) {
		
		case 1:
		System.out.println("1. Avanza el coche A");
		
			System.out.println("Has seleccionado que avance el coche A.");
			
		int distanciaAleatoriaA = (int) (Math.random()*10 +1);
		
			System.out.println("El coche A ha avanzado " + distanciaAleatoriaA + " metros.");
			
			distanciaTotalCocheA += distanciaAleatoriaA;
			
			System.out.println("Distancia total recorrida por el coche A: " + distanciaTotalCocheA);
			
		break;
		
		case 2:
		System.out.println("2. Avanza el coche B");
		
			System.out.println("Has seleccionado que avance el coche B.");
		
		int distanciaAleatoriaB = (int) (Math.random()*10 +1);
		
			System.out.println("El coche b ha avanzado " + distanciaAleatoriaB + " metros.");
			
			distanciaTotalCocheB += distanciaAleatoriaB;
			
			System.out.println("Distancia total recorrida por el coche B: " + distanciaTotalCocheB);
			
		break;
		
		case 3:
		System.out.println("3. Muestra la posición de cada uno");
		
		System.out.println("La posicion del coche A es: " + distanciaTotalCocheA);
		
		System.out.println("La posicion del coche B es: " + distanciaTotalCocheB);
		
		break;
		
		case 4:
		System.out.println("4. Hace una simulación automática de 10 turnos. (Primero avanza el A y después el B)");
			
			System.out.println("¿Quieres realizar la simulación de la carrera?");
			char simulacion = br.readLine().toLowerCase().charAt(0);
			
			if (simulacion == 's') {
					
					for (int i = 0; i<10; i++) {
						
						distanciaAleatoriaA = (int) (Math.random()*10 +1);
							
							System.out.println("El coche A ha avanzado " + distanciaAleatoriaA + " metros.");
							
						distanciaTotalCocheA += distanciaAleatoriaA;
							
							System.out.println("Distancia total recorrida por el coche A: " + distanciaTotalCocheA);
							
							
						distanciaAleatoriaB = (int) (Math.random()*10 +1);
							
							System.out.println("El coche b ha avanzado " + distanciaAleatoriaB + " metros.");
							
						distanciaTotalCocheB += distanciaAleatoriaB;
							
							System.out.println("Distancia total recorrida por el coche B: " + distanciaTotalCocheB);
							
							System.out.println();
							
					if (distanciaTotalCocheA >= 50) {
						System.out.println("El ganador es el coche A");
						
					} else if (distanciaTotalCocheB >= 50) {
						System.out.println("El ganador es el coche B");
					
					}else {
						System.out.println("Nadie a ganado.");
						
					}
				}
				
			}
		
		break;
		
		case 5:
			System.out.println("5. Se reinicia la carrera.");
				
				System.out.println("¿Estas segura de querer reiniciar la carrera?");
			char reinicia = br.readLine().toLowerCase().charAt(0);
			
				if (reinicia == 's') {
					System.out.println("Reiniciando la carrera.");
					
					distanciaTotalCocheA = 0;
					
					distanciaTotalCocheB = 0;
					
				} else {
					
					System.out.println("La carrera no se ha reiniciado.");
				}
			
			break;
		
		case 6:
			salir = true;
			
		System.out.println("¡Hasta luego!");
		
		break;
		
			
		default:
			
			System.out.println("Opción no válida");
			
		}
		
		}while(!salir);
	
	
		}

		
}
