package ejercicio14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Principal {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static void registrarEstudiante(EstudianteNotas[] estudiantes) throws IOException {
		
		System.out.println("=== Resgistrar Estudiante ===");
		
		for(int i = 0; i < estudiantes.length; i++) {
			
			estudiantes[i] = new EstudianteNotas();
			
			estudiantes[i].añadirDatos(estudiantes, i);
			
		}
		
	}
	
	
	private static EstudianteNotas añadirNota(EstudianteNotas[] estudiantes) {
		
		System.out.println("===  Añadir Notas  ===");
		
		int id = -1;
		
		boolean todoOK = false;
		
		do {
			
			try {
				
				System.out.println("Escribe el ID del estudiante al que le quieras añadir alguna nota:");
				id =Integer.parseInt(br.readLine());
				
				todoOK = true;
			
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		
		} while (todoOK != true);
		
		
		for(int i = 0; i < estudiantes.length; i++) {
		
			if(estudiantes[i].getId() == id) {
				
				return estudiantes[i];
				
			}
			
		}
		
		return null;
			
	}

	
	private static void verCalificaciones(EstudianteNotas[] estudiantes) {
		
		System.out.println("===  Ver calificaciones  ===");
		
		
		int id = -1;
		
		boolean todoOK = false;
		
		do {
			
			try {
				
				System.out.println("Escribe el ID del estudiante al que le quieras añadir alguna nota:");
				id =Integer.parseInt(br.readLine());
				
				todoOK = true;
			
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		
		} while (todoOK != true);
		
		
		for(int i = 0; i < estudiantes.length; i++) {
			
			
			estudiantes[i].notaMaxima(); 
			
			
			estudiantes[i].notaMinima();; 
		}
		
	}

	
	private static void calcularMedia(EstudianteNotas[] estudiantes) {
		
		System.out.println("===  Calcular Nota Media  ===");
		
		int id = -1;
		
		boolean todoOK = false;
		
		do {
			
			try {
				
				System.out.println("Escribe el ID del estudiante del que quieras calcular su nota media:");
				id =Integer.parseInt(br.readLine());
				
				todoOK = true;
			
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		
		} while (todoOK != true);
		
		for(int i = 0; i < estudiantes.length; i++) {
			
			estudiantes[i].notaMedia();
		}
		
	}

	
	private static void estudianteBrillante(EstudianteNotas[] estudiantes) {
		
		System.out.println("===  Estudiante Brillante  ===");
		
	}

	
	private static void alertaSuspensos(EstudianteNotas[] estudiantes) {
		
		System.out.println("===  Alerta de Suspensos  ===");
		
	}
	
	

	public static void main(String[] args) throws IOException {
		  
		
		EstudianteNotas[] estudiantes = new EstudianteNotas[15];
		  
		  boolean salir = false;
			do {
				System.out.println("== GESTIÓN DE OFERTAS POR GROENLANDIA  ==");
				System.out.println("1. Registrar estudiante");
				System.out.println("2  Añadir nota");
				System.out.println("3. Ver calificaciones ");
				System.out.println("4. Calcular media");
				System.out.println("5. Estudiante brillante");
				System.out.println("6. Alerta de suspensos");
				System.out.println("7. Salir");
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
						registrarEstudiante(estudiantes);
					
				break;
				
				
				case 2:
						añadirNota(estudiantes);
					
				break;
					
					
				case 3:
						verCalificaciones(estudiantes);
					
				break;
					
					
				case 4:
						calcularMedia(estudiantes);
					
				break;
				
					
				case 5:
						estudianteBrillante(estudiantes);
					
				break;
					
					
				case 6:
						alertaSuspensos(estudiantes);
					
				break;
					
					
				case 7:
					System.out.println("Saliendo del sistema...");
					salir = true;
				break;
					
				
				default:
					System.out.println("Opcion no valida");
				}

			} while (!salir);
		}

}
