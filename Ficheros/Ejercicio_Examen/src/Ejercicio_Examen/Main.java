package Ejercicio_Examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

	private static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

			boolean salir = false;
			do {
				System.out.println("\n=== Elecciones de Programadores CYL ===");
				System.out.println("1. Añadir candidato.");
				System.out.println("2. Ver candidatos de un partido.");
				System.out.println("3. Actualizar votos.");
				System.out.println("4. Exportar acta final.");
				System.out.println("5. Salir");
				System.out.print("Introduce una opción: ");

				int opcion = -1;
				boolean datosOK = false;
				while (!datosOK) {
					try {
						opcion = Integer.parseInt(leer.readLine());
						datosOK = true;
					} catch (IOException e) {
						System.err.println("Solo puedes introducir números");
					}
				}

				switch (opcion) {
				case 1:
					System.out.println("=== Añadir candidato ===");
						añadirCandidato();
					break;
				case 2:
					System.out.println("=== Ver candidatos de un partido ===");
						verCandidatos();
					break;
				case 3:
					System.out.println("=== Actualizar votos ===");
						actualizarVotos();
					break;
				case 4:
					System.out.println("=== Exportar acta final ===");
						exportarActaFinal();
					break;
				case 5:
					System.out.println("Salir");
					salir = true;
					break;
				default:
					System.out.println("Opción no válida");
				}

			} while (!salir);
		}


	private static void añadirCandidato() {
		
		try {
			Candidatos c = new Candidatos();
				
				c.pedirDatos();
				c.escribirFichero();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private static void verCandidatos() {
		
		String partidoABuscar = Lecturas.leerOpcion("Escribe el nombre del partido a buscar: (Alianza Java Enterprise o Partido JavaScriptero o P.C.D o Movimiento IA First)", new String[]{"Alianza Java Enterprise", "Partido JavaScriptero", "P.C.D", "Movimiento IA First"});
		
		boolean encontrado = false;
		
		long totalVotosPorPartido = 0;
		
		try {
			File fichero_candidatos = new File("candidatos.txt");
			
			if(fichero_candidatos.exists()) {
				
				FileReader fr = new FileReader(fichero_candidatos);
				
				BufferedReader bf = new BufferedReader(fr);
				
			String linea = bf.readLine();
			
			while(linea != null) {
				Candidatos c = new Candidatos();
				
					c.splitLineaCandidatos(linea);
				
					
				if(partidoABuscar.equalsIgnoreCase(c.getPartidoCandidato())) {
					System.out.println("Nombre del candidato que va por el partido " + partidoABuscar + ": " + c.getNombreCandidato());
					System.out.println("Número de votos: "+ c.getNumeroVotos());
						encontrado = true;
						
						totalVotosPorPartido += c.getNumeroVotos();
				}
			
				linea = bf.readLine();
				
			}
			
				if(encontrado) {
					System.out.println("El total de votos del " + partidoABuscar + " es de " + totalVotosPorPartido + " votos.");
					
				} else {	
					System.err.println("No se ha encontrado ningun candidato por ese partido.");
					
				}
				
			fr.close();
			bf.close();
				
			}else {
				System.err.println("El fichero no se ha encontrado o no existe.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static void actualizarVotos() {
		
		boolean encontrado = false;
		
		int idABuscar = -1;
		
		ArrayList<Candidatos> listaCandidatos = new ArrayList<>();
		
		long nuevoNumeroVotos;
		
		do {
			
			try {
				
				File fichero_candidatos = new File("candidatos.txt");
				
				if(fichero_candidatos.exists()) {
					
					idABuscar = Lecturas.leerEntero("Escribe el id del candidato a buscar");
					
							FileReader fr = new FileReader(fichero_candidatos);
						
								BufferedReader bf = new BufferedReader(fr);
								
							String linea = bf.readLine();
							
						while(linea != null) {
							
							Candidatos c = new Candidatos();
							
								c.splitLineaCandidatos(linea);
							
								listaCandidatos.add(c);
								
							if(idABuscar == c.getIdCandidato()){
								
								do {
									nuevoNumeroVotos = Lecturas.leerEntero("Escribe los nuevos votos del candidato: " + c.getIdCandidato());
									
									if(nuevoNumeroVotos < c.getNumeroVotos()) {
										System.err.println("El candidato no puede tener un numero menor de votos.");
										
									}
									
								} while(nuevoNumeroVotos < c.getNumeroVotos());

								c.setNumeroVotos(nuevoNumeroVotos);
								
								encontrado = true;
							}
							
							linea = bf.readLine();
						}
						
						bf.close();
						fr.close();
						
					if(!encontrado) {
						System.err.println("No se ha encontrado al candidato con el id: " + idABuscar);
					}
						
						if(encontrado) {
							File fichero_candidatos_temp = new File("candidatos_temp.txt");
							try {
								
								PrintWriter pw = new PrintWriter(fichero_candidatos_temp);
								
									for(Candidatos c: listaCandidatos) {
										pw.println(c.getIdCandidato() + "-" + c.getNombreCandidato() + "-" + c.getPartidoCandidato() + "-" + c.getNumeroVotos());
										
									}
									
								pw.close();
									
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
						
							
							if(fichero_candidatos.delete()) {
								fichero_candidatos_temp.renameTo(fichero_candidatos);
								
							} else {
								System.err.println("No se ha podido reemplazar al fichero original.");
							}
							
					}
						
				} else {
					System.err.println("El fichero no existe.");
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}while(!encontrado);
		
	}
	
	
	private static void exportarActaFinal() {
		
		File fichero = new File("candidatos.txt");
		
		long votosTotales = 0;
		
			if(fichero.exists()) {
				
				ArrayList<Candidatos> listaCandidatos = new ArrayList<>();
				
					try {
						FileReader fr = new FileReader(fichero);
						
						BufferedReader bf = new BufferedReader(fr);
						
							String linea = bf.readLine();
							
								while(linea != null) {
									
									Candidatos c = new Candidatos();
										c.splitLineaCandidatos(linea);
										
									listaCandidatos.add(c);
									
										votosTotales += c.getNumeroVotos();
								
								linea = bf.readLine();
						}
						
					bf.close();
					
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				for(int i = 0; i < listaCandidatos.size(); i++) {
					
					Candidatos c = listaCandidatos.get(i);
						
						System.out.println("El nombre del candidato es: " + c.getNombreCandidato());
						System.out.println("El nombre del partido es: " + c.getPartidoCandidato());
						System.out.println("El numero de votos del candidato " + c.getNombreCandidato() + " es: " + c.getNumeroVotos());
					
				}
					
					System.out.println("El numero total de votos es de: " + votosTotales);
					
					
					String candidatoGanador = "";
					
					long numeroVotosGanador = 0;
					
					String partidoGanador = "";
					
					for(int i = 0; i < listaCandidatos.size(); i++) {
						
						Candidatos c = listaCandidatos.get(i);
						
							if(c.getNumeroVotos() > numeroVotosGanador) {
								
								candidatoGanador = c.getNombreCandidato();
									numeroVotosGanador = c.getNumeroVotos();
										partidoGanador = c.getPartidoCandidato();
							}
					}
					
					System.out.println("El candidato que ha ganado las elecciones ha sido: " + candidatoGanador + ", su partido politico era: " + partidoGanador + " y el numero de votos que ha conseguido ha sido de: " + numeroVotosGanador);
				
					
					try {
						File actaFinal = new File("actaFinal.txt");
						
						PrintWriter pw = new PrintWriter(actaFinal);
						
							pw.println("=== Acta Final de las Elecciones ===");
								
								for(int i = 0; i < listaCandidatos.size(); i++) {
									
									Candidatos c = listaCandidatos.get(i);
									
										pw.println(c.getNombreCandidato() + "-" + c.getPartidoCandidato() + "-" + c.getNumeroVotos());
									
								}
								
								pw.println("Los votos totales han sido: " + votosTotales);
								
								pw.println("El candidato que ha ganado las elecciones ha sido: " + candidatoGanador + ", su partido politico era: " + partidoGanador + " y el numero de votos que ha conseguido ha sido de: " + numeroVotosGanador);
						
								
						pw.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
			}else {
				System.err.println("El fichero no existe o no se ha encontrado.");
			}
			
	}
}
