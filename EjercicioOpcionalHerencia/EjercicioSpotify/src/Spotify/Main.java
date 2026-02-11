package Spotify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		ArrayList<Contenido> contenidos = new ArrayList<Contenido>();

		boolean salir = false;
		do {
			System.out.println("\n=== Spotify ===");
			System.out.println("1. Añadir contenido ");
			System.out.println("2. Mostrar contenido por Categoría");
			System.out.println("3. Añadir contenido a la Playlist");
			System.out.println("4. Estadisticas del perfil");
			System.out.println("5. Salir");
			System.out.print("Introduce una opción: ");

			int opcion = -1;
			boolean datosOK = false;
			
			while (!datosOK) {
				
				try {
					opcion = Integer.parseInt(br.readLine());
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir números");
				}
			
			}
			switch (opcion) {
			case 1:
				System.out.println("===  Registrar Paciente ===");
				
					añadirContenido(contenidos);
				
				break;
			case 2:
				System.out.println("=== Añadir tratamiento a paciente urgencias ===");

					mostrarContenidoPorCategoria(contenidos);
				
				break;
			case 3:
				System.out.println("=== Añadir consulta a paciente cita previa ===");

					añadirContenidoAPlaylist(contenidos);
				
				break;
			case 4:
				System.out.println("=== Mostrar Historial de un Paciente ===");

					estadisticasDelPerfil(contenidos);
				
				break;
			case 5:
				System.out.println("=== Mostrar los datos ===");
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (!salir);

	}

	private static void añadirContenido(ArrayList<Contenido> contenidos) throws IOException {
		
		int contenidoAAñadir = 0;
		
		int numAñadir = 0;
		
		boolean todoOK = false;
		
		String tipoContenido = "";
		
		do {
			
			try {
				
				System.out.println("Cuantos contenidos desea añadir?");
					contenidoAAñadir = Integer.parseInt(br.readLine());
					
					do {
						
						System.out.println("Que tipo de contenido vas a añadir? (Canción o Podcast)");
							tipoContenido = br.readLine();
								
								if(tipoContenido.equalsIgnoreCase("Canción")) {
									
									Cancion canciones = new Cancion();
									
										canciones.añadirContenido();
											contenidos.add(canciones);		
								} else {
									
									Podcast podcasts = new Podcast();
									
									podcasts.añadirContenido();
										contenidos.add(podcasts);
								}
							
					} while(!tipoContenido.equalsIgnoreCase("Canción") && !tipoContenido.equalsIgnoreCase("Podcast"));
				
			} catch(NumberFormatException | IOException e) {
				System.out.println("Has introducido algun dato mal.");	
				e.getStackTrace();
		}
			
			
			numAñadir++;
			
			todoOK = true;
			
		}while (!todoOK && (numAñadir < contenidoAAñadir));
		
	}

	private static void mostrarContenidoPorCategoria(ArrayList<Contenido> contenidos) {

		
		
	}

	private static void añadirContenidoAPlaylist(ArrayList<Contenido> contenidos) {

		
		
	}

	private static void estadisticasDelPerfil(ArrayList<Contenido> contenidos) {

		
		
	}
}
