package Spotify;

import java.io.IOException;

public class Podcast extends Contenido{
	
	private String presentador;
	
	private int numeroEpisodio;
	
	private char transcripcion;
	
	public void añadirContenido(int id) throws IOException {
		
		super.añadirContenido(id);
			System.out.println("Introduce el nombre del presentador");
				presentador = br.readLine();
				
			System.out.println("Introduce el número de episodio");
				numeroEpisodio = Integer.parseInt(br.readLine());
			
				do {
					System.out.println("¿Tiene transcripción disponible? S/N");
					transcripcion = br.readLine().charAt(0);	
					
				}while(transcripcion != 'S' | transcripcion != 'N');
	}
	
	
	public void mostrarContenido() {
		
		super.mostrarContenido();
			System.out.println("El nombre del presentador es: " + presentador);
			System.out.println("El numero de Episodios totales son: " + numeroEpisodio);
			System.out.println("¿Tiene transcripción? " + transcripcion);
		
	}

	
	
}
