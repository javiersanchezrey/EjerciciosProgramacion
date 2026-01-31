package tipoExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntrenadorPokemon {

	private int id;
	
	private String nombreEntrenador;
	
	private String region;
	
	private String[] pokemon = new String[6];
	
	private int[] niveles = new int[6];
	
	private int numPokemon = 0;
	
	
	private static int contadorId = 1;
	
	//------------------------------------//
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	//------------------------------------//
	
	public void añadirDatos(EntrenadorPokemon[] entrenador, int pos) {
		
		
		boolean datosOK = false;
		
		do {
			
			try {

				System.out.print("Escribe el nombre del entrenador Pokemon: ");
				nombreEntrenador = br.readLine();

				System.out.println("Escribe la región del entrenador pokemon: " + nombreEntrenador);
					region = br.readLine();
					
				datosOK = true;
				
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato, crack");
				e.printStackTrace();
			}
			
		} while (!datosOK);
			
			

		this.id = contadorId++;
		
		this.numPokemon = 0;
		
		entrenador[pos] = this;
		
		System.out.println("El id del entrenador " + nombreEntrenador + " es: " + this.id);
	}
	
	
	public int getId() {
		
		return id;
	}
	
	//------------------------------------//
	
	public void añadirPokemon() throws NumberFormatException, IOException {
		
		System.out.println("Escribe los pokemon del entrenador " + nombreEntrenador);
		
		
		if(numPokemon >= pokemon.length) {
			
			System.err.println("Lo siento pero el equipo ya esta al completo.");
			
		}
		
		try {
			
			if(numPokemon <= pokemon.length) {
				
				System.out.println("Escribe el " + (numPokemon + 1) + " º pokemon del equipo:");
				pokemon[numPokemon] = br.readLine();
				
				System.out.println("¿Cuál es el nivel de este pokemon?");
					niveles[numPokemon] = Integer.parseInt(br.readLine());
					
					while(niveles[numPokemon] < 0 || niveles[numPokemon] > 100) {
						
						System.err.println("El nivel del pokemon no puede ser ese.");
						
						System.out.println("Escribe un nivel correcto:");
							niveles[numPokemon] = Integer.parseInt(br.readLine());
						
					}
				
				numPokemon++;
			}
			
		}catch(IOException | NumberFormatException e) {
			
			System.err.println("Has introducido algún dato mal.");
		}
		
	}
	
	//------------------------------------//
	
	public void mostrarPokemon() {
		
		
		int nivelMasAlto = niveles[0];
		int nivelMasBajo = niveles[0];
		
		int nivelMayor = 0;
		int nivelMenor = 0;
		
		System.out.println("Los pokemon que estan en el equipo de " + nombreEntrenador + " son: ");
		
		if(numPokemon > 0) {
			
			for(int i = 0; i < numPokemon; i++) {
				
				System.out.print(pokemon[i] + ", ");
				System.out.println();
					
					if(niveles[i] > nivelMasAlto) {
						
						nivelMasAlto = niveles[i];
						nivelMayor = i;
						
					}
					
					
					if(niveles[i] < nivelMasBajo) {
						
						nivelMasBajo = niveles[i];
						nivelMenor = i;
						
					}
			}
			
			
			System.out.println("El nivel más alto es " + nivelMasAlto + " del Pokemon " + pokemon[nivelMayor]);
			
			System.out.println("El nivel más bajo es " + nivelMasBajo + " del Pokemon " + pokemon[nivelMenor]);
			
		} else {
			System.err.println("Todavia no tiene pokemon´s registrados.");
		}
		
	}
	
	
	public void mostrarNivelMedio() {
		
		int nivelMedio = 0;
		
		int nivelFinal = 0;
		
		
		for(int i = 0; i < numPokemon; i++) {
			
			nivelMedio += niveles[i];
			
		}
		
		nivelFinal = nivelMedio / numPokemon;
		
		System.out.println("El nivel medio del equipo pokemon es " + nivelFinal);
		
	}
	
	
	public double mostrarMediaEquipo() {
		
		if (numPokemon > 0) {
			
			double nivelMedioEquipo = 0;
			
			for(int i = 0; i < numPokemon; i++) {
				
				nivelMedioEquipo += niveles[i];
				
			}
			
			nivelMedioEquipo = nivelMedioEquipo /numPokemon;
			
			return nivelMedioEquipo;
			
		} else {
			return -1;
		}
		
		
	}


	public String getNombreEntrenador() {
		return nombreEntrenador;
	}
	
	
	
}
