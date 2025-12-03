package Ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {

	//Apartado1.
	public static void introducirCandidatosyCiudades (String [] candidatos, String [] ciudades) throws IOException {
		
		//Introducir nombres de los cantidatos.
		
		String nombresCandidatosTotales = "";
		
		for (int i = 0; i < candidatos.length; i++) {
			
			System.out.println("Escribe el nombre del " + (i+1) + "º candidato.");
				String nombreCandidato = br.readLine();
			
				while (nombreCandidato.isEmpty()) {
					System.out.println("Lo siento pero no se puede dejar el nombre en blanco. Escribalo de nuevo");
					nombreCandidato = br.readLine();
				}
			
				candidatos[i] = nombreCandidato;
				
				nombresCandidatosTotales += candidatos[i] + ", ";
				
		}
		
		//Introducir nombres de las ciudades.
		
		String nombresCiudadesTotales = "";
		
		for (int j = 0; j < ciudades.length; j++) {
			
			System.out.println("Escribe el nombre de la " + (j+1) + "º ciudad.");
			String nombreCiudad = br.readLine();
		
			while (nombreCiudad.isEmpty()) {
				System.out.println("Lo siento pero no se puede dejar el nombre en blanco. Escribalo de nuevo");
				nombreCiudad = br.readLine();
			}
		
			ciudades[j] = nombreCiudad;
			
			nombresCiudadesTotales += ciudades[j]+ ", ";
			
		}
		
		System.out.println("Los candidatos seleccionados han sido: " + nombresCandidatosTotales + "\nY las ciudades elegidas han sido: " + nombresCiudadesTotales);
		
	}
	
	//Apartado2.
	public static void registrarVotosCiudades(String[] candidatos, int [][] matrizVotos, String[] ciudades) throws NumberFormatException, IOException {
		
		for (int i = 0; i < candidatos.length; i++) {
			
			System.out.println("Introduce los votos para " + candidatos[i]);
			
			for(int j = 0; j < ciudades.length; j++) {
				
				System.out.println("Introduce los votos de la ciudad: " + ciudades[j]);
					int numeroVotos = Integer.parseInt(br.readLine());
					
					while (numeroVotos < 0) {
						
						System.out.println("Lo siento pero no puede haber votos negativos. introduce un número de votos correctos.");
							numeroVotos = Integer.parseInt(br.readLine());
					}
					
				matrizVotos[i][j] = numeroVotos;
			}
			System.out.println();	
		}
	}
	
	//Apartado3.
	public static void mostrarTabla(String [] candidatos, int [][] matrizVotos, String [] ciudades) {
		
		System.out.println("Mostrando la tabla con los estudiantes y sus respectivas notas:");
		
		
		//Muestra la parte superior, es decir, "Candidatos" y tambien las ciudades en la misma linea.
		
		System.out.print("Candidatos \t");
			
		for(int i = 0; i < ciudades.length; i++) {
				System.out.print(ciudades[i] + "\t");
				
			}
		
		//Muestra la parte superior, es decir, "Candidatos" y tambien las ciudades en la misma linea.
			
			System.out.println();
			
		for (int i = 0; i < candidatos.length; i++) {
			
			System.out.print(candidatos[i] + "\t \t");
			
			for (int j = 0; j < ciudades.length; j++) {
				
				System.out.print(matrizVotos[i][j] + "\t ");	
			}
			
			System.out.println();	
		}
	}

	//Apartado4.
	public static void calcularVotosCandidatos(String [] candidatos, int [][] matrizVotos, String [] ciudades) {
		
		for(int i = 0; i< candidatos.length; i++) {
			
			int votosTotalesCandidatos = 0;
			
			System.out.println("Los votos que ha obtenido el candidato: " + candidatos[i]);
			
			for (int j = 0; j < ciudades.length; j++) {
				
				votosTotalesCandidatos += matrizVotos[i][j];
				
			}
			
			System.out.println(votosTotalesCandidatos);
		}
		
	}
	
	//Apartado5.
	public static void totalVotosPorCiudad(String [] candidatos, int [][] matrizVotos, String [] ciudades) {
		
		for  (int j = 0; j < ciudades.length; j++){
			
			int votosTotalesCiudad = 0;
			
			for (int i = 0; i < candidatos.length; i++) {	
				
				votosTotalesCiudad += matrizVotos[i][j];
			}	
			
		System.out.println("Los votos totales de " + ciudades[j] + " han sido: " + votosTotalesCiudad);
		}
	}
	
	//Apartado6.
		public static void ganadorGeneral(String [] candidatos, int [][] matrizVotos, String [] ciudades) {
			
			int votosTotalesCandidato = 0;
			String ganadorGeneral = "";
			
			for (int i = 0; i < candidatos.length; i++) {
				
				int votosCandidato = 0;
				
				for (int j = 0; j < ciudades.length; j++)  {	
					
					votosCandidato += matrizVotos[i][j];
				}	
				
				if (votosTotalesCandidato < votosCandidato) {
					
					votosTotalesCandidato = votosCandidato;
					
					ganadorGeneral = candidatos[i];
					
				}
			}
			
			System.out.println("El candidato que más votos tiene es: " + ganadorGeneral + ", y tiene " + votosTotalesCandidato + " votos.");
		}
		
	//Apartado7.
		public static void ganadorPorCiudad(String [] candidatos, int [][] matrizVotos, String [] ciudades) {
			
			for (int j = 0; j < ciudades.length; j++) {
				String ganadorCiudad = "";
				
				int maximoVotosCiudad = 0;
				
				
				for (int i = 0; i < candidatos.length; i++) {	
					
				int	votosCandidato = matrizVotos[i][j];
					
					if (maximoVotosCiudad < votosCandidato) {
						
						maximoVotosCiudad = votosCandidato;
						
						ganadorCiudad = candidatos[i];
						
					}
				}	
			System.out.println("El ganador de " + ciudades[j] + ", es: " + ganadorCiudad);
				
			}
		}
		
	//Apartado8.
		public static void participacionCiudad (String [] candidatos, int [][] matrizVotos, String [] ciudades) {
			
			String ciudadConMasParticipacion = "";
			
			int votosTotalesCiudad = 0;
			
		for(int j = 0; j < ciudades.length; j++)	{
			
			int votosCiudades = 0;
			
			for (int i = 0; i < candidatos.length; i++) {
				
				votosCiudades +=	 matrizVotos[i][j];
				
			}
			
			if (votosTotalesCiudad < votosCiudades) {
				
				votosTotalesCiudad = votosCiudades;
				
				ciudadConMasParticipacion = ciudades[j];
				
			}
			
		}
		
		System.out.println("La ciudad con más participaciones es: " + ciudadConMasParticipacion + ", con: " + votosTotalesCiudad + " votos.");
			
			
		}
		
	//Apartado9.	
		public static void ganadorTodasCiudades (String [] candidatos, int [][] matrizVotos, String [] ciudades) {
			boolean ganadorEncontrado = false;
			
			for (int i = 0; i < candidatos.length; i++) {
				
				boolean ganoTodas = true;
				
				for(int j = 0; j < ciudades.length; j++) {
					
					int votoCandidatos = matrizVotos[i][j];
					
					for (int k = 0; k < candidatos.length; k++) {
						
						if (k != i && matrizVotos[k][j] >= votoCandidatos){
							
							ganoTodas = false;
						}	
					}
					
					if (ganoTodas) {
						
						System.out.println("El ganaodr en todas las ciudades ha sido: " + candidatos[i]);
						ganadorEncontrado = true;	
					}	
				}
			}
			
			if (!ganadorEncontrado) {
				System.out.println("No hubo ningún ganador que ganara en todas las ciudades.");
			}
			
		}
		
		
	//Apartado10.
		public static void diferenciasPrimeroSegundo (String [] candidatos, int [][] matrizVotos, String [] ciudades) {

			int[] totalVotos = new int[candidatos.length];
	    
		// Sumar los votos de todas las ciudades por candidato
			   
		for (int i = 0; i < candidatos.length; i++) {
			int suma = 0;
			      
			for (int j = 0; j < ciudades.length; j++) {
			         
				suma += matrizVotos[i][j];
			}

			totalVotos[i] = suma;
		}


		// Encontrar primero y segundo lugar
			  
		int max1 = -1, max2 = -1;
			    
		String primero = "", segundo = "";

		for (int i = 0; i < candidatos.length; i++) {
			       
			if (totalVotos[i] > max1) {
			    
				max2 = max1;
				segundo = primero;

				max1 = totalVotos[i];
				primero = candidatos[i];
			        
			} else if (totalVotos[i] > max2) {
				max2 = totalVotos[i];

				segundo = candidatos[i];
			}
		}

		int diferencia = max1 - max2;

		System.out.println("Ganador general: " + primero + " (" + max1 + " votos)");
		System.out.println("Segundo lugar: " + segundo + " (" + max2 + " votos)");
		System.out.println("Diferencia de votos entre primero y segundo: " + diferencia);
		}
		
	
	
	//Ejercicio 42.
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		String [] candidatos = new String [4];
		
		int [][] matrizVotos = new int [4][6];
		
		String [] ciudades = new String [6];
		
		boolean salir = false;
		System.out.println("=== BIENVENIDO A [NOMBRE_APP] ===");
		
		do {
			
		//MOSTRAR MENU
			
		System.out.println("\n--- MENÚ PRINCIPAL ---");
		System.out.println("1. Introducir nombres de candidatos y ciudades");
		System.out.println("2. Registrar votos de todas las ciudades (introducir la matriz completa)");
		System.out.println("3. Mostrar tabla de votos completa");
		System.out.println("4. Calcular total de votos por candidato");
		System.out.println("5. Calcular total de votos por ciudad");
		System.out.println("6. Mostrar ganador general (candidato con más votos totales)");
		System.out.println("7. Mostrar qué candidato ganó en cada ciudad");
		System.out.println("8. Mostrar la ciudad con mayor participación (más votos totales)");
		System.out.println("9. Comprobar si algún candidato ganó en todas las ciudades");
		System.out.println("10. Mostrar diferencia de votos entre el primero y segundo lugar");
		System.out.println("11. Salir.");


		System.out.print("Elige una opción: ");
		
		int opcion = Integer.parseInt(br.readLine());
		
		switch (opcion) {
		
		case 1:
		System.out.println("1. Introducir nombres de candidatos y ciudades");
		
			introducirCandidatosyCiudades(candidatos, ciudades);
		
		break;
		
		case 2:
			System.out.println("2. Registrar votos de todas las ciudades (introducir la matriz completa)");
			
				registrarVotosCiudades(candidatos, matrizVotos, ciudades);
			
		break;
		
		case 3:
			System.out.println("3. Mostrar tabla de votos completa");
			
				mostrarTabla(candidatos, matrizVotos, ciudades);
			
		break;
		
		case 4:
			System.out.println("4. Calcular total de votos por candidato");
			
				calcularVotosCandidatos(candidatos, matrizVotos, ciudades);
			
		break;
		
		case 5:
			System.out.println("5. Calcular total de votos por ciudad");
			
				totalVotosPorCiudad(candidatos, matrizVotos, ciudades);
			
		break;
		
		case 6:
			System.out.println("6. Mostrar ganador general (candidato con más votos totales)");
			
			ganadorGeneral(candidatos, matrizVotos, ciudades);
			
		break;
		
		case 7:
			System.out.println("7. Mostrar qué candidato ganó en cada ciudad");
			
			ganadorPorCiudad(candidatos, matrizVotos, ciudades);
			
		break;
		
		case 8:
			System.out.println("8. Mostrar la ciudad con mayor participación (más votos totales)");
			
			participacionCiudad(candidatos, matrizVotos, ciudades);
			
		break;
		
		case 9:
			System.out.println("9. Comprobar si algún candidato ganó en todas las ciudades");
			
			ganadorTodasCiudades(candidatos, matrizVotos, ciudades);
			
		break;
		
		case 10:
			System.out.println("10. Mostrar diferencia de votos entre el primero y segundo lugar");
			
			diferenciasPrimeroSegundo(candidatos, matrizVotos, ciudades);
			
		break;
		
		case 11:
			System.out.println("Salir");
			
			System.out.println("Saliendo del Sistema...");
			
		break;
	}

}while (!salir);

	}

}
