package EjerciciosArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio41 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	//Ejercicio1
	public static void nombreDeAlumnosyAsignaturas(String[] nombreAlumnos, String[] nombreAsignaturas) throws IOException {
		
		System.out.println("Escribe el nombre del alumno que quieras añadir.");
			String nombreAlumno = br.readLine();
		
	}
	
	
	
	//Ejercicio41
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		String [] nombreAlumnos = new String [6];
		
		double [][] notasAlumnos = new double [6][5];
		
		String [] nombreAsignaturas = new String [5];
		
		
		
boolean salir = false;
		

		do {
				// MOSTRAR MENU
			
			System.out.println();
			System.out.println("\n ========== Gestión Alumnos y Notas ==========");
			System.out.println("1. Introducir nombres de alumnos y asignaturas");
			System.out.println("2. Introducir todas las notas (validar 0-10)");
			System.out.println("3. Mostrar tabla completa (nombres de alumnos en filas, asignaturas en columnas) ");
			System.out.println("4. Calcular y mostrar media de cada alumno con su nombre.");
			System.out.println("5. Buscar alumno por nombre y mostrar todas sus notas.");
			System.out.println("6. Mostrar la asignatura con menor media");
			System.out.println("7. Contar alumnos que tienen todas las asignaturas aprobadas");
			System.out.println("8.  Mostrar qué alumnos suspendieron una asignatura específica (pedir asignatura)");
			System.out.println("9.  Modificar nota (pedir nombre de alumno y asignatura).");
			System.out.println("10. Salir.");
			System.out.print("Elige una opción: ");
			
			int opcion = Integer.parseInt(br.readLine());
				
			switch (opcion) {
				
				
			case 1:
				System.out.println("1. Introducir nombres de alumnos y asignaturas");
				
				nombreDeAlumnosyAsignaturas(nombreAlumnos, nombreAsignaturas);
			
			break;
					
					
			case 2:
				System.out.println("2. Sumar los elementos del array");
					
				
					
			break;
					
			case 3:
				System.out.println("3. Encontrar el numero máximo ");
					
				
			break;
					
					
			case 4:
				System.out.println("4. Calcular la media");
				
				
					
			break;
				
			case 5:
				System.out.println("5. Buscar un elemento");
					
			
					
			break;
				
			case 6:
				System.out.println("6. Contar las veces que aparece un numero en el array");
					
				
					
			break;
				
			case 7:
				System.out.println("7. Invertir el array (y luego imprimirlo)");
					
				
					
			break;
				
			case 8:
				System.out.println("8. Crear un nuevo array pidiendo los valores al usuario y comparando si alguno de sus valores son iguales al primero");
					
				
					
			break;
			
			case 9:
				salir = true;
				System.out.println("Saliendo");
			break;
					
					
			default:
				System.out.println("Opción no válida");
			}
		} while (!salir);

	}

}


