package Ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {

	// 1. Introducir Nombre de Alumno y Asignaturas
	public static void introducirNombreyAsignaturas(String [] arrayNombreAlumnos, String [] nombreAsignaturas) throws IOException {
		
		//Pedir nombres de Alumnos
		
		String nombreAlumnosTotales = "";
		
		for (int i = 0; i <arrayNombreAlumnos.length; i++) {
			
			System.out.println("Escribe el nombre del " + (i+1) + "º alumno.");
				String nombreAlumno = br.readLine();
				
				while (nombreAlumno.isEmpty()) {
					System.out.println("Lo siento pero no puedes dejar el nombre en blanco.");
					nombreAlumno = br.readLine();
				}
				
				arrayNombreAlumnos[i] = nombreAlumno;
				
				nombreAlumnosTotales += arrayNombreAlumnos[i] + ", ";
		}
		
		//Pedir Asignaturas
		
		String nombreAsignaturasTotales = "";
		
		for (int i = 0; i < nombreAsignaturas.length; i++) {
			
			System.out.println("Escribe la " + (i+1) + "º asignatura de los alumnos seleccionados.");
				String nombreAsignatura = br.readLine();
				
				nombreAsignaturas[i] = nombreAsignatura;
				
				nombreAsignaturasTotales += nombreAsignaturas[i] + ", ";
		}
		
		System.out.println("Los alumnos seleccionados han sido: " + nombreAlumnosTotales + " y sus asignaturas son: " + nombreAsignaturasTotales);
	}

	//Ejercicio2
	public static void introducirNotasAlumnos(double [][] matrizNotas, String [] arrayNombreAlumnos, String [] nombreAsignaturas) throws NumberFormatException, IOException {
		
		for (int i = 0; i < arrayNombreAlumnos.length; i++) {
			
			System.out.println("Escribe las notas del alumno: " + arrayNombreAlumnos[i]);
				
			
			for (int j = 0; j < nombreAsignaturas.length; j++) {
				
				System.out.println("Escribe la nota de: " + nombreAsignaturas[j]);
					double notasAlumnos = Double.parseDouble(br.readLine());
					
				while (notasAlumnos < 0 || notasAlumnos > 10) {
									
			System.out.println("Lo siento pero la nota introducida es incorrecta, Escribela de nuevo:");
					notasAlumnos = Double.parseDouble(br.readLine());	
				}
					
				matrizNotas[i][j] = notasAlumnos;
			}
			
			System.out.println("Notas de " + arrayNombreAlumnos[i] + ":");
			
			for (int j = 0; j < nombreAsignaturas.length; j++) {
				
			System.out.print(nombreAsignaturas[j] + ": " + matrizNotas[i][j] + " | ");
				
			}
			
			System.out.println();
		}
	}
	
	//Ejercicio3
	public static void mostrarTabla(String [] arrayNombreAlumnos, double [][] matrizNotas, String [] nombreAsignaturas) {
		
		System.out.println("Mostrando la tabla con los estudiantes y sus respectivas notas:");
		
		
		//Muestra la parte superior, es decir, "Estudiantes" y tambien las asignaturas en la misma linea.
		
		System.out.print("Estudiantes \t");
			
		for(int i = 0; i < nombreAsignaturas.length; i++) {
				System.out.print(nombreAsignaturas[i] + "\t");
				
			}
		
		//Muestra la parte superior, es decir, "Estudiantes" y tambien las asignaturas en la misma linea.
			
			System.out.println();
			
		for (int i = 0; i < arrayNombreAlumnos.length; i++) {
			
			System.out.print(arrayNombreAlumnos[i] + "\t \t");
			
			for (int j = 0; j < nombreAsignaturas.length; j++) {
				
				System.out.print(matrizNotas[i][j] + "\t ");	
			}
			
			System.out.println();	
		}
	}
	
	
	//Ejercicio4
	
	public static void calcularMedia(String [] arrayNombreAlumnos, double [][] matrizNotas, String [] nombreAsignaturas){
		
		for (int i = 0; i < arrayNombreAlumnos.length; i++) {
			
			double notaMediaFinal = 0;
			double notaMedia = 0;
			
			System.out.print(arrayNombreAlumnos[i] + "\t");
			
			for (int j = 0; j < nombreAsignaturas.length; j++	) {
				
				System.out.print(nombreAsignaturas[j] + ": " + matrizNotas[i][j] + "\t");
				
				 notaMedia += matrizNotas[i][j];
				
				 notaMediaFinal = notaMedia / 5;
			}
			System.out.println();
			
		System.out.println("La nota media de " + arrayNombreAlumnos[i] + ", es de: " + notaMediaFinal);
		}
		
	}
	
	//Ejercicio5
	
	public static void buscarAlumno(String [] arrayNombreAlumnos, double [][] matrizNotas, String [] nombreAsignaturas) throws IOException{
		
		System.out.println("Escribe el nombre del alumno del que quieras conocer sus notas: ");
		String nombreAConocer = br.readLine();
		
		boolean encontrado = false;
		
			for (int i = 0; i < arrayNombreAlumnos.length; i++) {
				
				if (arrayNombreAlumnos[i].equalsIgnoreCase(nombreAConocer)) {
				System.out.println("Las notas de " + arrayNombreAlumnos[i] + ", son las siguientes:");
					
				
					for (int j = 0; j < nombreAsignaturas.length; j++) {
						
						System.out.print(nombreAsignaturas[j] + ": " + matrizNotas[i][j]);
						
					}
					
					encontrado = true;
				}
			}
			
			if (!encontrado) {
				
				System.out.println("Lo siento pero el nombre escrito no coincide con ningún alumno.");
			}
	}
	
	//Ejercicio6
	
	public static void asignaturaConMenorMedia (String [] arrayNombreAlumnos, double [][] matrizNotas, String [] nombreAsignaturas) throws IOException {
		
		double mediaMenor = 10;
		
		String peorMediaAsignatura = "";
		
		for (int j = 0; j < nombreAsignaturas.length; j++) {
			
			double sumaNotas = 0;
			
			for (int i = 0; i < arrayNombreAlumnos.length; i++) {
				
				sumaNotas += matrizNotas[i][j];
			}
		
			double media = sumaNotas / arrayNombreAlumnos.length;
			
			if (media < mediaMenor) {
				
				mediaMenor = media;
				
				peorMediaAsignatura = nombreAsignaturas[j];
			}
			
		}
		
		System.out.println("La asignatura con peor media es: " + peorMediaAsignatura + ", y su media es: " + mediaMenor);
		
	}
	
	
	//Ejercicio7
	
	public static void alumnosConTodoAprobado (String [] arrayNombreAlumnos, double [][] matrizNotas, String [] nombreAsignaturas) throws IOException {
		
		int alumnosTodoAprobado = 0;
		
		for (int i = 0; i < arrayNombreAlumnos.length; i++) {
			
			boolean todoAprobado = true;
			
			for (int j = 0; j < nombreAsignaturas.length; j++) {
				
				if (matrizNotas[i][j] < 5) {
					
					todoAprobado = false;
				}
			}
			
			if (todoAprobado == true) {
				
				alumnosTodoAprobado++;
			}
			
		}
		
		System.out.println("Ha habido " + alumnosTodoAprobado + " alumnos que han aprobado todas las asignaturas.");
	}
	
	
	//Ejercicio8
	
	public static void asignaturaSuspensa (String [] arrayNombreAlumnos, double [][] matrizNotas, String [] nombreAsignaturas) throws IOException {
		
		System.out.println("Escribe la asignatura de la que quieras ver las notas:");
			String asignatura = br.readLine();
			
			int alumnosSuspensos = 0;
			
			String nombreSuspensos = "";
			
			for (int i = 0; i < arrayNombreAlumnos.length; i++) {
				
				boolean suspensos = false;
				
				int indiceAsignatura = -1;
				
				for (int j = 0; j < nombreAsignaturas.length; j++) {
					
					if (nombreAsignaturas[j].equalsIgnoreCase(asignatura)) {
						
						indiceAsignatura = j;
						
							if (matrizNotas[i][indiceAsignatura] < 5) {
								
								suspensos = true;
								
								alumnosSuspensos++;
								
								nombreSuspensos += arrayNombreAlumnos[i] + ", ";
							}
					}
				}
			}
			
		System.out.println("El número de alumnos suspensos es: " + alumnosSuspensos);
		
		System.out.println("Los alumnos que suspendieron " + asignatura + ", fueron " + nombreSuspensos);
	}
	
	//Ejercicio9
	
	public static void modificarNotas (String [] arrayNombreAlumnos, double [][] matrizNotas, String [] nombreAsignaturas) throws IOException {
		
		System.out.println("Escribe el nombre del alumno del que quieres cambiar la nota:");
			String nombreAlumno = br.readLine();
		
		int indiceAlumno = -1;
			
		for ( int i = 0; i < arrayNombreAlumnos.length; i++) {
			
			if (arrayNombreAlumnos[i].equalsIgnoreCase(nombreAlumno)) {
				
				indiceAlumno = i;	
			}
			
			if (indiceAlumno == -1) {
				
				System.out.println("El nombre escrito no pertenece a ningún alumno.");
			}
			
		}
		
		System.out.println("Escribe el nombre de la asignatura que quieres cambiar la nota.");
		String nombreAsignatura = br.readLine();
			
		int indiceAsignatura = -1;
		
		for(int j = 0; j < nombreAsignaturas.length; j++) {
			
			if (nombreAsignaturas.equals(nombreAsignatura)) {
				indiceAsignatura = j;
				
			}
			
			if (indiceAsignatura == -1) {
				
				System.out.println("La asignatura escrita no existe.");
			}
			
		}
		
		System.out.println("El alumno seleccionado es: " + nombreAlumno);
		System.out.println("La asignatura seleccionada es: " + nombreAsignatura);
		
		System.out.println("¿Que nota quiere poner?");
			Double nuevaNota = Double.parseDouble(br.readLine());
			
			matrizNotas[indiceAlumno][indiceAsignatura] = nuevaNota;
			
			System.out.println("La nota se ha modificado correctamente.");
		
		
	}
	
	
	//Ejercicio 41
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		String [] arrayNombreAlumnos = new String [6];
		
		double [][] matrizNotas = new double [6][5];

		
		String [] nombreAsignaturas = new String [5];
		
		
		boolean salir = false;
		System.out.println(" === BIENVENIDO A [NOMBRE APP] === ");
		do {
		//MOSTRAR MENU
		System.out.println("\n--- MENÚ PRINCIPAL ---");
		System.out.println("1. Introducir nombre de alumnos y asignaturas");
		System.out.println("2. Introducir todas las notas");
		System.out.println("3. Mostrar tabla completa (nombre de alumnos en filas, asignaturas en columnas.");
		System.out.println("4. Calcular y mostrar media de cada alumno con su nombre.");
		System.out.println("5. Buscar alumno por nombre y mostrar todas sus notas.");
		System.out.println("6. Mostrar la asignatura con menor media.");
		System.out.println("7. Contar alumnos que tienen todas las asignaturas aprobadas.");
		System.out.println("8. Mostrar alumnos que suspendieron una asignatura específica (pedir asignatura).");
		System.out.println("9. modificar nota (Pedir nombre de alumno y asignatura.");
		System.out.println("10. salir.");
		
		System.out.print("Elige una opción: ");
		
		int opcion = Integer.parseInt(br.readLine());
		
		switch (opcion) {
		
		case 1:
		System.out.println("1. Introducir nombre de alumnos y asignaturas");
		
			introducirNombreyAsignaturas(arrayNombreAlumnos, nombreAsignaturas);
		
		break;
		
		case 2:
			System.out.println("2. Introducir todas las notas");
			
				introducirNotasAlumnos(matrizNotas, arrayNombreAlumnos, nombreAsignaturas);
			
		break;
		
		case 3:
			System.out.println("3. Mostrar tabla completa (nombre de alumnos en filas, asignaturas en columnas.");
			
				mostrarTabla(arrayNombreAlumnos, matrizNotas, nombreAsignaturas);
			
		break;
		
		case 4:
			System.out.println("4. Calcular y mostrar media de cada alumno con su nombre.");
			
			calcularMedia(arrayNombreAlumnos, matrizNotas, nombreAsignaturas);
			
		break;
		
		case 5:
			System.out.println("5. Buscar alumno por nombre y mostrar todas sus notas.");
			
			buscarAlumno(arrayNombreAlumnos, matrizNotas, nombreAsignaturas);
			
		break;
		
		case 6:
			System.out.println("6. Mostrar la asignatura con menor media.");
			
			asignaturaConMenorMedia(arrayNombreAlumnos, matrizNotas, nombreAsignaturas);
			
		break;
		
		case 7:
			System.out.println("7. Contar alumnos que tienen todas las asignaturas aprobadas.");
			
			alumnosConTodoAprobado(arrayNombreAlumnos, matrizNotas, nombreAsignaturas);
			
		break;
		
		case 8:
			System.out.println("8. Mostrar alumnos que suspendieron una asignatura específica (pedir asignatura).");
			
			asignaturaSuspensa(arrayNombreAlumnos, matrizNotas, nombreAsignaturas);
			
		break;
		
		case 9:
			System.out.println("9. modificar nota (Pedir nombre de alumno y asignatura.)");
			
			modificarNotas(arrayNombreAlumnos, matrizNotas, nombreAsignaturas);
			
		break;
		
		
	}
		
	} while (!salir);
}
}


