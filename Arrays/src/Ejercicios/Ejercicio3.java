package Ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	//Apartado1.
	
	public static void registroEquipos(String [] equipos, int [][] matrizPuntuaciones, int [] estadoEquipos) throws IOException {
		
		String equiposTotales = "";
		
		for (int i = 0; i < equipos.length; i++) {
		
		System.out.println("Escribe el nombre del " + (i+1) + "º equipo:");
			String nombreEquipo = br.readLine();
			
			int estadoEquipo = 0;
			
			
			while (nombreEquipo.isEmpty()) {
				System.out.println("Lo siento pero no se puede dejar este nombre en blanco. Escribe un nombre.");
				nombreEquipo = br.readLine();
			}
			
			boolean repetido = false;
			
			do {
				
				repetido = false;
				
				for (int k = 0; k < i; k++) {
					
					if (equipos[k].equalsIgnoreCase(nombreEquipo)) {
						
					System.out.println("Lo siento pero no puede haber 2 nombres iguales. Excribe otro nombre.");
						nombreEquipo = br.readLine();
						
						while (nombreEquipo.isEmpty()) {
						System.out.println("Lo siento pero no se puede dejar este nombre en blanco. Escribe un nombre.");
							nombreEquipo = br.readLine();
						}
						
							repetido = true;
					}
					
					
				}
				
			} while(repetido);
			
			 equipos[i] = nombreEquipo;
			 
			 equiposTotales += equipos[i] + ", ";
			
			for (int fila = 0; fila < matrizPuntuaciones.length; fila++) {
				for(int columna = 0; columna < matrizPuntuaciones[fila].length; columna++) {
					
					matrizPuntuaciones[fila][columna] = 0;
				}
				
			}
			 
			 for (int j = 0; j < estadoEquipos.length; j++	) {
				
				estadoEquipos[i] = 0;	
			 }
		}
		
		System.out.println("Los nombres de los equipos son: " + equiposTotales);
		
	}
	
	//Apartado2.
	public static void registrarPuntuacionJornada(String [] equipos, int [][] matrizPuntuaciones, int [] estadoEquipos) throws IOException {
		
		for (int i = 0; i < equipos.length; i++) {
			System.out.print((i) + ". " + equipos[i]);
			
			if (estadoEquipos[i] == 0) {
				System.out.print(" - Calificado");
				
			} else {
				System.out.print(" - Descalificado");
			}
			
			System.out.println();
		}
		
		
		int posicionEquipo = -1;
		boolean calificado = true;
		
		do {
			calificado = true;
			
			System.out.println("Introduce el número del equipo:");
			posicionEquipo = Integer.parseInt(br.readLine());
			
			while (posicionEquipo < 0 || posicionEquipo > 7) {
				
				System.out.println("Lo siento pero el numero de equipo introducido es incorrecto, escribe uno correcto:");
				posicionEquipo = Integer.parseInt(br.readLine());
			}
			
			
			if (estadoEquipos[posicionEquipo] == 1) {
				
				System.out.println("El equipo seleccionado esta Descalificado, y no puede seguir compitiendo.");
				calificado = false;
				
			}
			
		} while (posicionEquipo < 0 || posicionEquipo > 7 || calificado == false);
		
		
		
		int numeroJornada = -1;
		
		do {
			
			System.out.println("Introduce el número de la jornada:");
			numeroJornada = Integer.parseInt(br.readLine());
			
			while (numeroJornada < 1 || numeroJornada > 7) {
				
				System.out.println("Lo siento pero el numero de la jornada introducido es incorrecto, escribe uno correcto:");
				numeroJornada = Integer.parseInt(br.readLine());
			}	
			
		} while (numeroJornada < 1 || numeroJornada > 7);
		
		int puntuacionObtenida = 0;	
			
			System.out.println("Introduce el numero de puntos de: " + equipos[posicionEquipo]);
				puntuacionObtenida = Integer.parseInt(br.readLine());
				
			while (puntuacionObtenida < 0 || puntuacionObtenida > 100) {
					
				System.out.println("La puntuación no puede ser inferior a 0 o superior a 100. Escribe una puntuación correcta.");
				puntuacionObtenida = Integer.parseInt(br.readLine());
			}
		
		matrizPuntuaciones[posicionEquipo][numeroJornada - 1] = puntuacionObtenida;
		
		System.out.println("El equipo " + equipos[posicionEquipo] + ", ha obtenido " + puntuacionObtenida + " puntos, en la " + numeroJornada + "º jornada.");
		
		
		
	}
	
	//Apartado3.
		public static void mostrarTabla(String [] equipos, int [][] matrizPuntuaciones, int [] estadoEquipos) {
			
			System.out.println("Mostrando la tabla con los equipos y sus respectivas puntuaciones:");
			
			
			System.out.print("Equipos \t");
				
			for(int j = 0; j < matrizPuntuaciones[0].length; j++) {
		        
				System.out.print("J" + (j+1) + "\t");
		    
			}
				
				System.out.println();
				
			for (int i = 0; i < equipos.length; i++) {
				
				System.out.print(equipos[i] + "\t \t");
				
				for (int j = 0; j < matrizPuntuaciones[i].length; j++) {
					
		            System.out.print(matrizPuntuaciones[i][j] + "\t");
		            
		        }
				
				System.out.println();	
			}
		}
	
	
	public static void main(String[] args) throws IOException {
		
		String [] equipos = new String [8];
		
		int [] estadoEquipos = new int [8];
		
		int [][] matrizPuntuaciones = new int [8][7];
		
		boolean salir = false;
		
		System.out.println("=== BIENVENIDO A [NOMBRE_APP] ===");
		
		do {
		
		//MOSTRAR MENU
		
		System.out.println("\n--- MENÚ PRINCIPAL ---");
		System.out.println("1. Registro de Equipos");
		System.out.println("2. Registrar Puntuación de Jornada");
		System.out.println("3. Tabla de Clasificación");
		System.out.println("4. Análisis de Rendimiento");
		System.out.println("5. Descalificar Equipo");
		System.out.println("6. Salir");
		
		System.out.print("Elige una opción: ");
		int opcion = Integer.parseInt(br.readLine());
		
		switch (opcion) {
		
			case 1:
			System.out.println("1. Registro de Equipos");
			
				registroEquipos(equipos, matrizPuntuaciones, estadoEquipos);
			
			break;
			
			case 2:
			System.out.println("2. Registrar Puntuación de Jornada");
				
				registrarPuntuacionJornada(equipos, matrizPuntuaciones, estadoEquipos);
				
			break;
				
			case 3:
			System.out.println("3. Tabla de Clasificación");
				
			mostrarTabla(equipos, matrizPuntuaciones, estadoEquipos);
				
			break;
				
			case 4:
			System.out.println("4. Análisis de Rendimiento");
				
					
				
			break;
		
			case 5:
			System.out.println("5. Descalificar Equipo");
				
					
				
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
