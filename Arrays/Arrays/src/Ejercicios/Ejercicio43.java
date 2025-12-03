package EjerciciosArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio43 {

	//Apartado1.
	public static void RegistroEquipos(String [] nombreEquipos, String [][] matrizPuntuaciones) throws IOException {
		
		String nombreEquiposTotales = "";
		
		for (int i = 0; i < nombreEquipos.length; i++) {
			
			System.out.println("Escribe el nombre del " + (i+1) + "º equipo:");
				String nombreEquipo = br.readLine();
				
			while (nombreEquipo.isEmpty()) {
				System.out.println("Lo siento pero no puedes dejar el nombre en blanco, Escribelo otra vez.");
					nombreEquipo = br.readLine();
			}
			
			
			
			for (int j = 0; j < nombreEquipos.length; j++) {
			
			while (nombreEquipos[i].equalsIgnoreCase(nombreEquipo)) {
				System.out.println("No se pueden tener 2 equipos con el mismo nombre, escribe otro nombre.");
					nombreEquipo = br.readLine();
			}
			
			}
			
			nombreEquipos[i] = nombreEquipo;
			
			nombreEquiposTotales += nombreEquipos[i];
			
			
		}
		
	}
	
	
	//Apartado2.
	
	public static void RegistroPuntuacionJornadas(String [] nombreEquipos, String [][] matrizPuntuaciones, String [] numeroJornada) throws IOException {
		
		int estadoEquipo = -1;
		
		System.out.println("Registra la puntación.");
		
			
			int posicionEquipo = -1;
			
			System.out.println("Escribe la posición del equipo que quieras registrar la puntuación.");
				posicionEquipo = Integer.parseInt(br.readLine());
				
				while (posicionEquipo < 0 || posicionEquipo > 7) {
					System.out.println("Lo siento pero la posicion indicada no corresponde a ningún equipo. Escribela correctamente");
						posicionEquipo = Integer.parseInt(br.readLine());
				}
				
			if (estadoEquipo[posicionEquipo] == 1) {
				
				System.out.println("Lo siento pero este equipo esta Descalificado y no se le puede dar una puntuación.");
			}
	
			
		int numeroDeJornada = -1;
		
		System.out.println("Introduce el numero de la Jornada.");
			numeroDeJornada = Integer.parseInt(br.readLine());
			
			while (numeroDeJornada < 0 || numeroDeJornada > 7) {
				System.out.println("Lo siento pero la posicion indicada no corresponde a ninguna jornada. Escribela correctamente");
				numeroDeJornada = Integer.parseInt(br.readLine());
			}
			
	}
	
	
	
	//Ejercicio 43.
			public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			public static void main(String[] args) throws NumberFormatException, IOException {
				
				String [] nombreEquipos = new String [8];
				
				String [][] matrizPuntuaciones = new String [8][7];
				
				String [] numeroJornada = new String [7];
				
				
				boolean salir = false;
				System.out.println("=== BIENVENIDO A [NOMBRE_APP] ===");
				
				do {
					
				//MOSTRAR MENU
					
				System.out.println("\n--- MENÚ PRINCIPAL ---");
				System.out.println("1. Registro de Equipos");
				System.out.println("2. Registrar Puntuación de Jornada.");
				System.out.println("3. Tabla de Clasificación");
				System.out.println("4. Análisis de Rendimiento");
				System.out.println("5. Descalificar Equipo");
				System.out.println("6. Salir");


				System.out.print("Elige una opción: ");
				
				int opcion = Integer.parseInt(br.readLine());
				
				switch (opcion) {
				
				case 1:
				System.out.println("1. Registro de Equipos");
				
					RegistroEquipos (nombreEquipos, matrizPuntuaciones);
					
				break;
				
				case 2:
					System.out.println("2. Registrar Puntuación de Jornada.");
					
					RegistroPuntuacionJornadas (nombreEquipos, matrizPuntuaciones, numeroJornada);
						
					break;
			}

		}while (!salir);

		}

	}
