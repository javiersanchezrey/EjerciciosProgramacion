package EjerciciosArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio42 {

	
	//Apartado1
	public static void nombresCandidatosYCiudades(String [] nombreCandidatos, String [] nombreCiudades) throws IOException {
		
		//Nombre de Candidatos
		
		String nombreCandidatosTotales = "";
		
		for (int i = 0; i < nombreCandidatos.length; i++) {
			
			System.out.println("Escribe el nombre del " + (i+1) + "º candidato.");
				String nombreCandidato = br.readLine();
				
			while (nombreCandidato.isEmpty()) {
				System.out.println("Lo siento pero no se puede dejar en blanco el nombre del candidato. Escribelo de nuevo.");
					nombreCandidato = br.readLine();
			}
			
			nombreCandidatos[i] = nombreCandidato + ", ";
			
			nombreCandidatosTotales += nombreCandidatos[i];
			
		}
		
		
		//Nombre de Ciudades.
		
		String nombreCiudadesTotales = "";
		
		for(int i = 0; i < nombreCiudades.length; i++) {
			
			System.out.println("Escribe el nombre de la " + (i+1) + "º ciudad.");
				String nombreCiudad = br.readLine();
				
				while (nombreCiudad.isEmpty()) {
					System.out.println("Lo siento pero no se puede dejar en blanco el nombre de la ciudad. Escribelo de nuevo.");
					nombreCiudad = br.readLine();
				}
				
				nombreCiudades[i] = nombreCiudad + ", ";
				
				nombreCiudadesTotales += nombreCiudades[i];
		}
		
		System.out.println("Los candidatos seleccionados son: " + nombreCandidatosTotales + "y las ciudades seleccionadas son: " + nombreCiudadesTotales);
		
	}
	
	//Apartado2.
	
	public static void registrarVotosCiudades(String [] nombreCandidatos, String [] nombreCiudades, String [][] matrizVotos) throws IOException {
		for (int i = 0; i < nombreCandidatos.length; i++) {
			
			System.out.println("Escribe los votos para " + nombreCandidatos[i] + ", que es el " + (i+1) + "º candidato");
			
		}
		
		
	}
	
	
	//Ejercicio 42.
		public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		public static void main(String[] args) throws NumberFormatException, IOException {
			
			String [] nombreCandidatos = new String [4];
			
			String [][] matrizVotos = new String [4][6];
			
			String [] nombreCiudades = new String [6];
			
			
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
			
				nombresCandidatosYCiudades(nombreCandidatos, nombreCiudades);
				
			break;
			
			case 2:
				System.out.println("2. Registrar votos de todas las ciudades (introducir la matriz completa)");
				
					registrarVotosCiudades(nombreCandidatos, nombreCiudades, matrizVotos);
					
				break;
		}

	}while (!salir);

	}

}


