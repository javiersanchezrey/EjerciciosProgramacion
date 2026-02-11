package Spotify;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contenido {

	private int id;
	
	private String titulo;
	
	private int duracion;
	
	private String categoria;
	
	private int reproduccionesTotales;
	
	private boolean playlistActiva;
	
	//----------------------------------------//
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void añadirContenido() throws IOException {
		
		boolean todoOK = false;
		
		do {
			try {
				
				System.out.println("Introduce el titulo del contenido:");
					this.titulo = br.readLine();
					
				do {
					System.out.println("Introduce la duracion del contenido");
					this.duracion = Integer.parseInt(br.readLine());
					
					if(this.duracion < 0 || this.duracion > 180) {
						System.err.println("Has escrito mal la duracion");
					}
					
				}while(this.duracion < 0 | this.duracion > 180);
					
				do {
					System.out.println("Introduce la categoría del contenido, (música, podcast, audiolibro o meditación)");
					this.categoria = br.readLine();
					
				} while (!categoria.equalsIgnoreCase("música") && !categoria.equalsIgnoreCase("podcast") && !categoria.equalsIgnoreCase("audiolibro") && !categoria.equalsIgnoreCase("meditacion"));
					
				System.out.println("Introduce le numero de las reproducciones totales");
					reproduccionesTotales = Integer.parseInt(br.readLine());

			}catch(NumberFormatException | IOException e) {
				System.out.println("Has introducido algun dato mal.");	
					e.getStackTrace();
			}
			
			todoOK = true;
			
		}while (!todoOK);
		
	}
	
	
	public void mostrarContenido() {
		
		
		
	}
	
	
}
