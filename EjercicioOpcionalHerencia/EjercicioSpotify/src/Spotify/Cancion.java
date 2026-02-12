package Spotify;

import java.io.IOException;

public class Cancion extends Contenido{

	private String Artista;
	
	private int streamsGlobales;
	
	private int añoLanzamiento;
	
	public void añadirContenido(int id) throws IOException {
		
		super.añadirContenido(id);
		System.out.println("Introduce el nombre del artista");
			Artista = br.readLine();
			
		System.out.println("Introduce el número de streams globales");
			streamsGlobales = Integer.parseInt(br.readLine());
		
			do {
				System.out.println("Introduce el año de lanzamiento (1950-2025)");
					añoLanzamiento = br.readLine().charAt(0);	
				
			}while(añoLanzamiento < 1950 | añoLanzamiento > 2026);
		
	}
	
	
	public void mostrarContenido() {
		
		super.mostrarContenido();
			System.out.println("El nombre del artista es: " + Artista);
			System.out.println("Las streams globales son " + streamsGlobales);
			System.out.println("El año de lanzamiento de la canción fué: " + añoLanzamiento);
		
	}
	
	
	public void añadirContenidoAPlaylist() {
		
	}


	public void añadirContenidoAPlaylist(String tituloContenidoABuscar) {
		
		int elementosPlaylist = 0;
		
		int duracionTotal = 0;
		
		for (int i = 0; i < 15; i++) {
			
			
			
		}
		
		
		System.out.println("El elemento se ha añadido correctamente.");
		System.out.println("La duracion de la playlist es: " + duracionTotal + " minutos.");
	}
	
	
}
