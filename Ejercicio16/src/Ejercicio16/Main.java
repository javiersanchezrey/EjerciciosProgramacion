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
				System.out.println("== CONCESIONARIO NO QUEREMOS HACER UN EXAMEN ==");
				System.out.println("1. Registrar Deportista");
				System.out.println("2. Añadir Torneo a Tenista");
				System.out.println("3. Mostrar todos los Deportistas");
				System.out.println("4. Buscar por Equipo");
				System.out.println("5. Ranking de Tenis");
				System.out.println("6. Estadísticas Globales");
				System.out.println("7. Salir");
				System.out.println("Introduce una opcion: ");
				int opcion = Integer.parseInt(br.readLine());

				switch (opcion) {
				case 1:
					System.out.println("Registrar Deportista");
					
						registrarDeportistas(deportistas);
						
					break;
				case 2:
					System.out.println("Añadir Torneo a Tenista");
					
						añadirTorneoATenista(deportistas);
					
					break;
				case 3:
					System.out.println("Mostrar todos los Deportistas");
					
						mostrarTodosLosDeportistas(deportistas);
					
					break;
				case 4:
					System.out.println("Buscar por Equipo");
					
						buscarPorEquipo(deportistas);
						
					break;
					
				case 5:
					System.out.println("Ranking de Tenis");
					
						rankingTenis(deportistas);
						
					break;
					
				case 6:
					System.out.println("Estadísticas Globales");
					
						
						
					break;
					
				case 7:
					System.out.println("Saliendo de sistema...");
						salir = true;
						
					break;
				}
				
			} while (!salir);
		}

	
	private static void rankingTenis(ArrayList<Deportistas> deportistas) {
		
		boolean todoOK = false;
		
		int mejorPosicion = 100;
		
		while(!todoOK) {
			
			for(Deportistas D: deportistas) {
				
				if(D instanceof Tenista) {
					
					((Tenista)D).getPosicionRanking();
					
					
					
				}
				
			}
			
		}
		
	}


	private static void buscarPorEquipo(ArrayList<Deportistas> deportistas) {
		
		boolean todoOK = false;
		
		String equipoAEncontrar = "";
		
		while(!todoOK) {
			
			try {
				
				System.out.println("Escribe el nombre del equipo a buscar.");
					equipoAEncontrar = br.readLine();
				
					todoOK = true;
			} catch(NumberFormatException | IOException e) {
				
				System.err.println("Lo siento pero has introducido algún dato mal.");
					e.getStackTrace();
			}
			
			for(Deportistas D: deportistas) {
				
				if(D instanceof Futbolista) {
					
					if(((Futbolista) D).getEquipoActual().equalsIgnoreCase(equipoAEncontrar)) {
						
						((Futbolista)D).mostrarEquipo(deportistas, equipoAEncontrar);
						
					} else {
						System.err.println("No se ha encontrado ningún futbolista en el equipo");
					}
				}
			}
		}
	}


	private static void mostrarTodosLosDeportistas(ArrayList<Deportistas> deportistas) {
		
		for(Deportistas D: deportistas) {
			
			if(D instanceof Futbolista) {
				((Futbolista)D).mostrarDatos();
			
			} else {
				
				((Tenista)D).mostrarDatos();
			}
			
		}
		
	}


	private static void añadirTorneoATenista(ArrayList<Deportistas> deportistas) {
		
		int buscarDNI = -1;
		
		boolean todoOK = false;
		
		while(!todoOK) {
			
			try {
				
				do {
					
					System.out.println("Escribe el DNI del tenista para añadirle un torneo.");
						buscarDNI = Integer.parseInt(br.readLine());
					
				} while (buscarDNI < 0);
				
				todoOK = true;
			} catch(NumberFormatException | IOException e) {
				
				System.err.println("Lo siento pero has introducido algún dato mal.");
					e.getStackTrace();
			}
			
			boolean encontrado = false;
			
			for(Deportistas D: deportistas) {
				
				if(D.getDNI() == buscarDNI) {
					
					if(D instanceof Tenista) {
						((Tenista)D).añadirTorneo();
					
						encontrado = true;
					} else {
						System.err.println("El DNI introducido no es el de un tenista.");
					}
					
				}
				
				if(encontrado) {
					System.err.println("No se ha encontrado el DNI.");
					
				}
				
			}
			
		}
		
	}


	private static void registrarDeportistas(ArrayList<Deportistas> deportistas) throws IOException {
		
		boolean todoOK = false;
		
		String tipoCategoria = "";
		
		while(!todoOK) {
			
			try {
				
					do {
						
						System.out.println("Escribe la categoría del deportista (Futbolista o profesional)");
						tipoCategoria = br.readLine();
						
						if (!tipoCategoria.equalsIgnoreCase("Futbolista") && !tipoCategoria.equalsIgnoreCase("profesional")){
							System.err.println("Solo puede ser una de las categorías anteriores.");
						}
						
					} while(!tipoCategoria.equalsIgnoreCase("Futbolista") && !tipoCategoria.equalsIgnoreCase("profesional"));
				
				todoOK = true;
			} catch(NumberFormatException | IOException e) {
				
				System.err.println("Lo siento pero has introducido algún dato mal.");
					e.getStackTrace();
			}
			
			if(tipoCategoria.equalsIgnoreCase("Futbolista")) {
				Futbolista F = new Futbolista();
					
					F.añadirDatos(deportistas);
						deportistas.add(F);

			} else {
				
				Tenista T = new Tenista();
					
					T.añadirDatos(deportistas);
						deportistas.add(T);
				
			}
			
		}
		
	}
	
	
	

}
