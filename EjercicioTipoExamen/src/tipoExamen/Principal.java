package tipoExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static void registrarEntrenador(EntrenadorPokemon[] entrenador) {
		
		System.out.println("== Registrar Entrenador Pokemon  ==");
		
		boolean registrado = false;
		
		for(int i = 0; i < entrenador.length && !registrado; i++) {
			
			if (entrenador[i] == null) {
				
				entrenador[i ]= new EntrenadorPokemon();
				
				entrenador[i].añadirDatos(entrenador, i);
				
					registrado = true;
			}
			
			if(!registrado) {
				System.err.println("Lo siento pero todas las posiciones estan ocupadas.");
				
			}
			
		}
		
	}
	
	
	private static void añadirPokemon(EntrenadorPokemon[] entrenador) throws NumberFormatException, IOException {
		
		int idABuscar = -1;
		
		boolean todoOK = false;
		
		System.out.println("== Añadir Pokemon´s  ==");
		
		do {
			
			try {
				
				System.out.println("Escribe el ID del entrenador Pokemon para añadir a su equipo algún Pokemon:");
				idABuscar = Integer.parseInt(br.readLine());
				
			todoOK = true;
				
			} catch(IOException | NumberFormatException e) {
				
				e.getStackTrace();
			}
			
		}while (todoOK != true);
		
		
			for(int i = 0; i < entrenador.length; i++) {
				
				if (idABuscar == entrenador[i].getId()) {
					
					entrenador[i].añadirPokemon();
					
				}	
			}
	}
	
	
	private static void verEquipo(EntrenadorPokemon[] entrenador) {
		
		
	int idABuscar = -1;
		
		boolean todoOK = false;
		
		System.out.println("== Ver Equipo Completo  ==");
		
		do {
			
			try {
				
				System.out.println("Escribe el ID del entrenador Pokemon para ver a su equipo.:");
				idABuscar = Integer.parseInt(br.readLine());
				
			todoOK = true;
				
			} catch(IOException | NumberFormatException e) {
				
				e.getStackTrace();
			}
			
		}while (todoOK != true);
		
		
			for(int i = 0; i < entrenador.length; i++) {
				
				if (idABuscar == entrenador[i].getId()) {
					
					entrenador[i].mostrarPokemon();;
					
				}	
			}
	}
	
	
	private static void calcularNivelMedio(EntrenadorPokemon[] entrenador) {
		
		int idABuscar = -1;
		
		boolean todoOK = false;
		
		System.out.println("== Calcular Nivel Medio del Equipo  ==");
		
		do {
			
			try {
				
				System.out.println("Escribe el ID del entrenador Pokemon para mostrar el nivel medio de su equipo:");
				idABuscar = Integer.parseInt(br.readLine());
				
			todoOK = true;
				
			} catch(IOException | NumberFormatException e) {
				
				e.getStackTrace();
			}
			
		}while (todoOK != true);
		
		
			for(int i = 0; i < entrenador.length; i++) {
				
				if (idABuscar == entrenador[i].getId()) {
					
					entrenador[i].mostrarNivelMedio();;
					
				}	
			}
	}
	
	
	private static void maestroPokemon(EntrenadorPokemon[] entrenador) {
		
		double nivelMasAlto = -1;
		String maestroPokemon = null;
		
		System.out.println("== Maestro Pokemon  ==");
		
		for(int i = 0; i < entrenador.length; i++) {
			
			if( entrenador[i].mostrarMediaEquipo() > nivelMasAlto) {
				
				nivelMasAlto = entrenador[i].mostrarMediaEquipo();
				
				maestroPokemon = entrenador[i].getNombreEntrenador()	;
				
			}
			
		}
		
		System.out.println("El nivel medio de equipo es " + nivelMasAlto + " y es del equipo del entrenador " + maestroPokemon);
	}
	
	
	public static void main(String[] args) throws IOException {
		  
		EntrenadorPokemon[] entrenador = new EntrenadorPokemon[3];
		
		  
		  boolean salir = false;
			do {
				System.out.println("== GESTIÓN DE ENTRENADORES POKEMÓN  ==");
				System.out.println("1. Registrar entrenador");
				System.out.println("2  Añadir Pokemon");
				System.out.println("3. Ver equipo Pokemón ");
				System.out.println("4. Calcular nivel medio");
				System.out.println("5. Maestro Pokemón");
				System.out.println("6. Salir");
				System.out.println("Introduce una opcion: ");

				int opcion = -1;
				boolean datosOK = false;
				while (!datosOK) {
				
						try {
							opcion = Integer.parseInt(br.readLine());
							
						} catch (NumberFormatException | IOException e) {
							System.err.println("Solo puedes introducir numeros");
						}
				
					datosOK = true;
				}

				switch (opcion) {
				case 1:
					registrarEntrenador(entrenador);
					
				break;
				
				
				case 2:
					añadirPokemon(entrenador);
					
				break;
					
					
				case 3:
					verEquipo(entrenador);
					
				break;
					
					
				case 4:
					calcularNivelMedio(entrenador);
					
				break;
				
					
				case 5:
					maestroPokemon(entrenador);
					
				break;
					
					
				case 6:
					System.out.println("Saliendo del sistema...");
					salir = true;
				break;
					
				
				default:
					System.out.println("Opcion no valida");
				}

			} while (!salir);
		}

}

