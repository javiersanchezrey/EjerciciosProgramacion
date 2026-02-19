package Ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	
	public static void main(String[] args) throws IOException {
			
			ArrayList<Deportistas> deportistas = new ArrayList<Deportistas>();
		
			boolean salir = false;
			do {
				System.out.println("\n=== HOSPITAL ===");
				System.out.println("1. Registrar Deportista");
				System.out.println("2. Añadir torneo a Tenista");
				System.out.println("3. Mostrar todos los deportistas");
				System.out.println("4. Buscar por Equipo");
				System.out.println("5. Ranking de Tenis");
				System.out.println("6. Estadisticas Globales");
				System.out.println("7. Salir");
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
					System.out.println("=== Registrar Deportista ===");

						registrarDeportista(deportistas);
					
					break;
					
				case 2:
					System.out.println("=== Añadir torneo a Tenista ===");

						añadirTorneoATenista(deportistas);
					
					break;
					
				case 3:
					System.out.println("=== Mostrar todos los deportistas ===");
					
						mostrarTodosLosDeportistas(deportistas);
						
					
					break;
					
				case 4:
					System.out.println("=== Buscar por Equipo ===");
					
						buscarPorEquipo(deportistas);
					
					break;
					
				
				case 5:
					System.out.println("=== Ranking de Tenis ===");
					
						rankingTenistas(deportistas);
					
					break;
					
				case 6:
					System.out.println("=== Estadisticas Globales ===");
					
						estadisticasGlobales(deportistas);
					
					break;
					
				case 7:
					System.out.println("Saliendo del concesionario");
					salir = true;
					break;
					
				default:
					System.out.println("Opción no válida");
				}

			} while (!salir);
		}


	private static void estadisticasGlobales(ArrayList<Deportistas> deportistas) {
		
		boolean todoOK = false;
		
		int totalGoles = 0;
		int totalFutbolistas = 0;
		
		for(Deportistas D: deportistas) {
			if(D instanceof Futbolistas) {
				
				totalGoles += ((Futbolistas)D).getNumeroGoles();
				totalFutbolistas ++;
				
			}
		}
		
		System.out.println("La media de goles es: " + (totalGoles / totalFutbolistas));
	}


	private static void rankingTenistas(ArrayList<Deportistas> deportistas) {

		boolean todoOK = false;
		
		int numeroLimite = -1;
		
		while(!todoOK) {
			
			try {
				
				System.out.println("Escribe la posición de filtrado de tenistas.");
					numeroLimite = Integer.parseInt(br.readLine());
				
				todoOK = true;
			}catch(NumberFormatException | IOException e) {
				System.err.println("Has escrito algun dato mal.");
					e.printStackTrace();
			}
			
		}
			
		boolean encontrado = false;
			for(Deportistas D: deportistas){
				
				if (D instanceof Tenistas) {
			
						if(((Tenistas)D).getPosicionRanking() <= numeroLimite){
							encontrado = true;
							
							((Tenistas)D).getNombre();
						}
				}
			}
			
			if(!encontrado) {
				System.err.println("Lo siento pero no se ha encontrado al tenista.");
				
			}
	}


	private static void buscarPorEquipo(ArrayList<Deportistas> deportistas) {
		
		String equipoABuscar = "";
		
		boolean todoOK = false;
		
		
		while(!todoOK) {
			
			try {
				
				System.out.println("Escribe el el equipo a buscar");
				equipoABuscar = br.readLine();
			
			todoOK = true;
				
			}catch(NumberFormatException | IOException e) {
				System.out.println("Has escrito algun dato mal.");
					e.getStackTrace();
			}
			
		}
		 boolean encontrado = false;
		for(Deportistas D: deportistas) {
			
			if(D instanceof Futbolistas) {
				
				if(((Futbolistas)D).getEquipoActual().equalsIgnoreCase(equipoABuscar))  {
					encontrado = true;
					
						D.mostrarDatos();
				}
			}
			
			if(!encontrado) {
				System.out.println("No existen deportistas en ese equipo.");
			}
		}
	}


	private static void mostrarTodosLosDeportistas(ArrayList<Deportistas> deportistas) {

		for(Deportistas D: deportistas) {
			
			if(D instanceof Futbolistas) {
				
				((Futbolistas)D).mostrarDatos();
				
			} else {
				
				((Tenistas)D).mostrarDatos();
			}
		}
		
	}


	private static void registrarDeportista(ArrayList<Deportistas> deportistas) throws IOException {

		boolean todoOK = false;
		String tipoDeportista = "";
		
		while(!todoOK) {
			
			try {
				
				do {
					
					System.out.println("Que quieres añadir un futbolista o un tenista");
						tipoDeportista = br.readLine();
					
						if(!tipoDeportista.equalsIgnoreCase("Futbolista") && !tipoDeportista.equalsIgnoreCase("tenista")) {
							System.err.println("Los siento pero solo puede ser una de las anteriores.");
						}
						
				}while(!tipoDeportista.equalsIgnoreCase("Futbolista") && !tipoDeportista.equalsIgnoreCase("tenista"));
			
				todoOK = true;
				
			}catch(NumberFormatException | IOException e) {
				System.out.println("Has escrito algun dato mal.");
					e.getStackTrace();
			}
			
			if(tipoDeportista.equalsIgnoreCase("Futbolista")) {
				
				Futbolistas futbolista = new Futbolistas();
					deportistas.add(futbolista);
				
			}else {
				Tenistas tenista = new Tenistas();
					deportistas.add(tenista);
				
			}	
		}
	}
	
	
	private static void añadirTorneoATenista(ArrayList<Deportistas> deportistas) {

		int dniABuscar = 0;
		
		boolean todoOK = false;
		
		
		while(!todoOK) {
			
			try {
				
				System.out.println("Escribe el DNI del tenista a buscar");
				dniABuscar = Integer.parseInt(br.readLine());
			
			todoOK = true;
				
			}catch(NumberFormatException | IOException e) {
				System.out.println("Has escrito algun dato mal.");
					e.getStackTrace();
			}
			
		}
		
		boolean encontrado = false;
		for(Deportistas D: deportistas) {
			
			if(dniABuscar == D.getDNI()) {
				
				encontrado = true;
				
				if(D instanceof Tenistas) {
					
					((Tenistas) D).añadirTorneo();
					
				} else {
					System.err.println("No se a encontrado a ningún tenista.");
				}
			}
		}
	}
	
	
	

}
