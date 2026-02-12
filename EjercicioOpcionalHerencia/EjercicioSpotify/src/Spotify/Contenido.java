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
	
	public void añadirContenido(int id) throws IOException {
		
		this.id = id;
		
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
		
		System.out.println("Mostrando el contenido del " + id + "º contenido");
		System.out.println("El ID del contenido es: " + id);
		System.out.println("El titulo es " + titulo);
		System.out.println("La categoría es " + categoria);
		System.out.println("Las reproducciones totales son " + reproduccionesTotales);
		System.out.println("¿Está en una Playlist activa? " + playlistActiva);
		
	}
	
	
	public String getTitulo() {
		return titulo;
		
	}
	
	
}
