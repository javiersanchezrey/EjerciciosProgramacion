package Ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio4 {

		public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		//Apartado1.
		public static void rellenarArrays(String [] alumnos, String [] modulos, int [][] matrizNumeroFaltas) throws IOException {
			
			//Rellenar Alumnos.
			
			String alumnosTotales = "";
			
			for(int i=0; i < alumnos.length; i++) {
				System.out.println("Escribe el nombre del " + (i+1) + "º alumno.");
					String nombreAlumno = br.readLine();
					
				while(nombreAlumno.isEmpty()) {
					System.out.println("Lo siento no se puede dejar este nombre en blanco. Intentalo de nuevo con un nombre correcto.");
						nombreAlumno = br.readLine();
				}	
				
				alumnos[i] = nombreAlumno;
				
				String sumaAlumnos = "";
				
				sumaAlumnos += alumnos[i];
				
				alumnosTotales += sumaAlumnos + ", ";
			}
			
			
			//Rellenar Modulos
			
			String modulosTotales = "";
			
			for(int j = 0; j < modulos.length; j++) {
				System.out.println("Escribe el nombre del " + (j+1) + "º modulo.");
				String nombreModulo = br.readLine();
				
			while(nombreModulo.isEmpty()) {
				System.out.println("Lo siento no se puede dejar este modulo en blanco. Intentalo de nuevo con un modulo correcto.");
					nombreModulo = br.readLine();
			}
			
				modulos[j] = nombreModulo;
				
				String sumaModulos = "";
				
				sumaModulos += modulos[j]; 
				
				modulosTotales += sumaModulos + ", ";
			}
			
			
			//Rellenar matriz a 0.
			
			for(int i=0; i < alumnos.length; i++) {
				
				for(int j = 0; j < modulos.length; j++) {
					
					matrizNumeroFaltas[i][j] = 0;
				}	
			}	
			
			
		System.out.println("Los alumnos seleccionados han sido " + alumnosTotales + " y sus modulos son " + modulosTotales);
		}
		
		
		//Apartado2.
		public static void registrarFaltas(String [] alumnos, String [] modulos, int [][] matrizNumeroFaltas) throws IOException {
			
			//Indice Alumno
				System.out.println("Introduce el nombre del alumno al que le quieras poner la falta.");
					String nombreAlumno = br.readLine();
				
					int indiceAlumno = -1;
					
					for (int i = 0; i < alumnos.length; i++) {
						
						if (nombreAlumno.equalsIgnoreCase(alumnos[i])) {
							indiceAlumno = i;
							
							
						} 
					}
					
					if (indiceAlumno == -1) {
						System.out.println("Lo siento pero no se ha encontrado al alumno, intentalo de nuevo.");
					}
			
			//Indice Modulo
				
					int indiceModulo = -1;
					
				System.out.println("Introduce el nombre del modulo del alumno");
					String nombreModulo = br.readLine();
					
					for (int j = 0; j < modulos.length; j++) {
						
						if (nombreModulo.equalsIgnoreCase(modulos[j])) {
							indiceModulo = j;	
						}
					}
					
					if (indiceModulo == -1) {
						System.out.println("Lo siento pero no se ha encontrado el modulo, intentalo de nuevo.");
						
					}
			
			//Poner número en la matriz.
					
					if (indiceAlumno != -1 && indiceModulo != -1) {
						
						System.out.println("Escribe el numero de faltas para el " + alumnos[indiceAlumno] + ", en la asignatura " + modulos[indiceModulo]);
						int faltasUsuario = Integer.parseInt(br.readLine());
						
						matrizNumeroFaltas[indiceAlumno][indiceModulo] = faltasUsuario;
						
				System.out.println("La falta se ah registrado Correctamente.");
					
					} else {
						System.out.println("No se ha encontrado al alumno o al modulo introducido, por lo que no se puede poner la falta.");
						
					}
				
		}
		
		
		//Apartado3.
		public static void mostrarTabla(String [] alumnos, String [] modulos, int [][] matrizNumeroFaltas) {
				
			System.out.print("\t\t");
			
			for (int j = 0; j < modulos.length; j++) {
				System.out.print(modulos[j] + "\t \t");
				
			}
			
			System.out.println();
				
			
			for (int fila = 0; fila < alumnos.length; fila++) {
				System.out.print(alumnos[fila] + "\t \t");
				
				for (int columna = 0; columna < modulos.length; columna++) {
					
					System.out.print(matrizNumeroFaltas[fila][columna] + "\t \t");
				}
				System.out.println();
			}
			
			int posicionConMasFaltas = -1;
			
			int faltasMayor = -1;
			
			for( int conlumna = 0; conlumna < modulos.length; conlumna++) {
				int sumaFaltas = 0;
				
				for(int fila = 0; fila < alumnos.length; fila++) {
					
					sumaFaltas += matrizNumeroFaltas[fila][conlumna];
					
					if (sumaFaltas > faltasMayor) {
						
						posicionConMasFaltas = fila;
						
						faltasMayor = sumaFaltas;
					}
				}
				
			}
		}
			
		
		//Apartado4.
		public static void perdidaEvaluacion(String [] alumnos, String [] modulos, int [][] matrizNumeroFaltas) {
			
			for (int fila = 0; fila < matrizNumeroFaltas.length; fila++) {
				
				for( int columna = 0; columna < matrizNumeroFaltas.length; columna++) {
					
					if (matrizNumeroFaltas[fila][columna] >= 5) {
						System.out.println("El alumno " + alumnos[fila] + " en la asignatura " + modulos[columna] + " ha perdido la evaluacion continua porque tiene " + matrizNumeroFaltas[fila][columna] + " faltas.");
					}
				}
			}
		}
		
	
		
	//Ejercicio
		public static void main(String[] args) throws IOException {
			
			String [] alumnos = new String [4];
			
			String [] modulos = new String [5];
			
			int [][] matrizNumeroFaltas = new int [4][5];
			
			boolean salir = false;
			
			System.out.println("=== BIENVENIDO A [NOMBRE_APP] ===");
			
			do {
			
			//MOSTRAR MENU
			
			System.out.println("\n--- MENÚ PRINCIPAL ---");
			System.out.println("1. Rellenar Arrays");
			System.out.println("2. Registrar faltas");
			System.out.println("3. Mostrar tablas");
			System.out.println("4. Pérdida de Evalución Contínua.");
			System.out.println("5. Salir");
			
			System.out.print("Elige una opción: ");
			int opcion = Integer.parseInt(br.readLine());
			
			switch (opcion) {
			
				case 1:
				System.out.println("1. Rellenar Arrays");
				
					rellenarArrays(alumnos, modulos, matrizNumeroFaltas);
				
				break;
				
				case 2:
				System.out.println("2. Registrar faltas");
					
					registrarFaltas(alumnos, modulos, matrizNumeroFaltas);
					
				break;
					
				case 3:
				System.out.println("3. Mostrar tablas");
					
					mostrarTabla(alumnos, modulos, matrizNumeroFaltas);
					
				break;
					
				case 4:
				System.out.println("4. Pérdida de Evalución Contínua");
					
					perdidaEvaluacion(alumnos, modulos, matrizNumeroFaltas);
					
				break;
					
				case 5:
					salir = true;
					
					System.out.println("¡Hasta luego!");
				break;
				
			default:
				System.out.println("Opción no válida");
			
			}
				
			}while(!salir);
				
	}

}
