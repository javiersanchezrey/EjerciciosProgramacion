package Bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio7 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			boolean salir = false;
			
			System.out.println("=== BIENVENIDO A GESTOR TORNEO DE AJEDREZ ===");
			
			do {
			
			System.out.println("\n--- MENÚ PRINCIPAL ---");
			System.out.println("1. Registrar a jugadores");
			System.out.println("2. Simular partidas de una ronda");
			System.out.println("3. Registrar tiempo de partidas");
			System.out.println("4. Generador de Aperturas");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");
			
			int opcion = Integer.parseInt(br.readLine());
			
			switch (opcion) {
			
			case 1:
			System.out.println("1. Registrar a jugadores");
				
				System.out.println("¿Cual es el nombre completo del jugador a registrar?");
					String nombreJugador = br.readLine();
				
				System.out.println("¿Cuantos años de experiencia tiene?");
					int anosExperiencia = Integer.parseInt(br.readLine());
					
				System.out.println("¿Cúal es su categoría? principiante/ intermedio / avanzado");
					String categoria = br.readLine();
					
					int puntos = 0;
				
				if ( categoria.equalsIgnoreCase("principiante") ) {
					puntos = 100;
					
					System.out.println("Su categoria es Principiante y tiene " + puntos);
					
				} else if ( categoria.equalsIgnoreCase("intermedio") ) {
					puntos = 500;
					
					System.out.println("Su categoria es Intermedio y tiene " + puntos);
					
				} else if ( categoria.equalsIgnoreCase("avanzado") ) {
					puntos = 1000;
					
					System.out.println("Su categoria es Avanzado y tiene " + puntos);
				} 
				
				int puntosTotales = puntos;
				
				if (anosExperiencia > 5) {
					
					int bonusPuntos = 200;
					puntosTotales += bonusPuntos;
					
				}
				
				System.out.println("El jugador ha sido registrado correctamente:");
				
				System.out.println("El nombre del jugador es: " + nombreJugador);
				System.out.println("Puntos Bases: " + puntos);
				System.out.println("Su categoría es: " + categoria);
				System.out.println("Puntos totales: " + puntosTotales);
				
				if (puntosTotales < 400) {
					System.out.println("Tu rango es Bronce");
					
				} else if (puntosTotales >= 400 && puntosTotales <= 800) {
					System.out.println("Tu rango es Plata.");
					
				}else {
					System.out.println("Tu rango es Oro.");
				}
				
			break;
			
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			case 2:
			System.out.println("2. Simular partidas de una ronda");
			
			System.out.println("¿Cuantos jugadores participan en la ronda?");
				int participantes = Integer.parseInt(br.readLine());
				
				while (participantes % 2 != 0) {
					
					System.out.println("Lo siento pero no pueden ser jugadores impares.\nCambia el numero de participantes a uno par.");
					participantes = Integer.parseInt(br.readLine());	
				}
			
				if (participantes % 2 == 0) {
					
					
				}
			
			break;
			
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			
			case 3:
			System.out.println("3. Registrar tiempo de partidas");
			
			System.out.println("¿Cuantas partidas se han jugado hoy?");
				int numeroPartidas = Integer.parseInt(br.readLine());
				
				int tiempoMedioPartida = 0;
				
				for ( int i = 0; i < numeroPartidas; i++) {
					System.out.println("¿Cuanto a durado esta " + (i+1) + "º partida.");
						int tiempoPartida = Integer.parseInt(br.readLine());
						
					if (tiempoPartida <= 0 || tiempoPartida > 60) {
						System.out.println("Lo siento pero el tiempo seleccionado no es válido. \nEsta partida cuenta como nula.");	
						tiempoPartida = 0;
					}
					
					tiempoMedioPartida += tiempoPartida;
				}
				
			double tiempoMedioPorPartida = tiempoMedioPartida / numeroPartidas;
			
			System.out.println("El tiempo medio por partida es de: " + tiempoMedioPorPartida);
				
			break;
			
			case 4:
			System.out.println("4. Generador de Aperturas");
			
			System.out.println("Quieres una sugerencia para las Aperturas?");
			char sugerencia = br.readLine().toLowerCase().charAt(0);
			
			while (sugerencia == 's') {
				
			int colores = (int) (Math.random() *3 +1);
				
			String color = "";
				
				switch (colores){
				
				case 1:
				
					color = "Blancas";
					
				break;
				
				case 2:
					
					color = "Negras";
					
				break;
					
				case 3:
					
					color = "Mixtas";
					
				break;
				}
				
				System.out.println("El color es: " + color);
				
			int estrategias = (int) (Math.random() * 5 +1);
				
			String tipoEstrategia = "";
				
				switch (estrategias){
				
				case 1:
				
					tipoEstrategia = "Agresiva";
					
				break;
				
				case 2:
					
					tipoEstrategia = "Defensiva";
					
				break;
					
				case 3:
					
					tipoEstrategia = "Italiana";
					
				break;
				
				case 4:
					
					tipoEstrategia = "Española";
					
				break;
				
				case 5:
	
				tipoEstrategia = "India";
	
				break;	
				}
				
			System.out.println("El tipo de Estrategia es: " + tipoEstrategia);
				
			int nivelDificultad = (int) (Math.random() *10 +1);
				
			 System.out.println("El nivel de dificultad es: " + nivelDificultad);
			 
			 System.out.println();
			 
			 System.out.println("¿Quieres otras sugerencias? S/N");
			 	sugerencia = br.readLine().toLowerCase().charAt(0);
			}
			
			System.out.println("Perfecto, has elegido una buena estrategia.");
			
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
