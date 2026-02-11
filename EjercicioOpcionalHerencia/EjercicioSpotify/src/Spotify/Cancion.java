package Spotify;

import java.io.IOException;

public class Cancion extends Contenido{

	private String Artista;
	
	private int streamsGlobales;
	
	private int añoLanzamiento;
	
	public void añadirContenido() throws IOException {
		
		super.añadirContenido();
		System.out.println("Introduce el nombre del artista");
			Artista = br.readLine();
			
		System.out.println("Introduce el número de streams globales");
			streamsGlobales = Integer.parseInt(br.readLine());
		
			do {
				System.out.println("Introduce el año de lanzamiento (1950-2025)");
					añoLanzamiento = br.readLine().charAt(0);	
				
			}while(añoLanzamiento < 1950 | añoLanzamiento > 2026);
		
	}
	
}
