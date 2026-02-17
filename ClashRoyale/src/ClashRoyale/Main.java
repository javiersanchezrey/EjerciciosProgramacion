package ClashRoyale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
			ArrayList<Carta> cartas = new ArrayList<Carta>();
		
			boolean salir = false;

			do {
				System.out.println("== CONCESIONARIO NO QUEREMOS HACER UN EXAMEN ==");
				System.out.println("1. Añadir carta");
				System.out.println("2. Mostrar cartas por rareza");
				System.out.println("3. Añadir carta al mazo");
				System.out.println("4. Estadísticas de la colección");
				System.out.println("5. Salir");
				System.out.println("Introduce una opcion: ");
				int opcion = Integer.parseInt(br.readLine());

				switch (opcion) {
				case 1:
					System.out.println("Añadir carta");
					
						añadirCarta(cartas);
					
						
					break;
				case 2:
					System.out.println("Mostrar cartas por rareza");
					
						mostrarCartasPorRareza(cartas);
					
					break;
				case 3:
					System.out.println("Añadir carta al mazo");
					
						añadirCartaAlMazo(cartas);
					
					break;
				case 4:
					System.out.println("Estadísticas de la colección");
					
						
						
					break;
					
				case 5:
					System.out.println("Saliendo de sistema...");
						salir = true;
						
					break;
				}
				
			} while (!salir);
		}


	private static void añadirCarta(ArrayList<Carta> cartas) throws NumberFormatException, IOException {
		
		int cartasAAñadir = 0;
		int numAñadir = 0;
		
			String tipoContenido = "";
			
			try {
				
				System.out.println("¿Cuantas cartas quieres añadir?");
					cartasAAñadir = Integer.parseInt(br.readLine());
				
					while(cartasAAñadir > numAñadir) {
						
						do {
							System.out.println("Escribe el tipo de carta que quieres añadir (Tropa o Hechizo)");
								tipoContenido = br.readLine();
								
								if(tipoContenido.equalsIgnoreCase("Tropa")) {
									
									Tropa tropas = new Tropa();
									
									tropas.añadirDatos();
									
										cartas.add(tropas);
									
								} else if(tipoContenido.equalsIgnoreCase("Hechizo")) {
									
									Hechizo hechizos = new Hechizo();
									
									hechizos.añadirDatos();
									
										cartas.add(hechizos);
										
								} 
								
								if(!tipoContenido.equalsIgnoreCase("Tropa") && !tipoContenido.equalsIgnoreCase("Hechizo")) {
									System.err.println("El contenido unicamente puede ser un Hechizo o una Tropa.");
								}
							
						}while(!tipoContenido.equalsIgnoreCase("Tropa") && !tipoContenido.equalsIgnoreCase("Hechizo"));
						
						numAñadir ++;
					}
				
				
			} catch (NumberFormatException | IOException e) {
				System.err.println("Has escrito algún dato mal.");
					e.getStackTrace();
			}
			
	}
	
	
	private static void mostrarCartasPorRareza(ArrayList<Carta> cartas) throws IOException {
		
		String tipoContenido = null;
		
		boolean todoOK = false;
		
		do {
			do {
				System.out.println("Escribe la rareza de las cartas que quieres mostrar. (Comun, Especial, Unica o Legendaria)");
					tipoContenido = br.readLine();
					
					boolean encontrado = false;
					for(Carta c: cartas) {
						
						if(c.getRareza().equalsIgnoreCase(tipoContenido)) {
							
							System.out.println(c.toString());
							
								encontrado = true;
						}
						
						if (!encontrado) {
							System.out.println("No hay ninguna carta con esa rareza.");
						}
					}
				
					
				if(!tipoContenido.equalsIgnoreCase("Comun") && !tipoContenido.equalsIgnoreCase("Especial") && !tipoContenido.equalsIgnoreCase("Unica") && !tipoContenido.equalsIgnoreCase("Legendaria")){
					System.err.println("La rareza solo puede ser una de las anteriores.");
				}
			
			} while (!tipoContenido.equalsIgnoreCase("Comun") && !tipoContenido.equalsIgnoreCase("Especial") && !tipoContenido.equalsIgnoreCase("Unica") && !tipoContenido.equalsIgnoreCase("Legendaria"));
			
			todoOK = true;
		}while (!todoOK);
		
	}
	
	
	private static void añadirCartaAlMazo(ArrayList<Carta> cartas) throws IOException {
		
		System.out.println("Introduce el nombre de la carta a buscar.");
			String cartaABuscar = br.readLine();
			
			int indiceContenido = -1;
			
			for(int i = 0; i < cartas.size(); i++) {
				
				if(cartas.get(i).getNombre().equalsIgnoreCase(cartaABuscar)) {
					indiceContenido = i;	
				}
			}
			
			if(indiceContenido != -1) {
				
				if(cartas.get(indiceContenido).isUsadaEnMazo()) {
					
					int contador = 0;
					
						for(Carta c: cartas) {
						
							if(c.isUsadaEnMazo()) {
								
								contador ++;
							}
						}
						
					if(contador < 8) {
				
						
							
					}
				}
				
				
				
			}
	}
	
	
}
