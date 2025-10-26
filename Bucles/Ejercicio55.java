package Bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio55 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int golesEquipoTotal = 0;
		int golesJugador = 0;
		
		String nombreJugador = "";
		
		double mediaGolesEquipo = 0;
		
		int maxGoles = 0;
		String jugadorMasGoleador = "";
		String equipoMasGoleador = "";
		
		String nombreEquipo = "";
		
		
		for (int i = 1; i <= 2; i++) {
			
			System.out.println("Escribe el nombre del equipo:");
				nombreEquipo = br.readLine();
				
			for (int j = 1; j <= 3; j++) {
				System.out.println("Escriba el nombre del jugador para saber sus goles.");
				nombreJugador = br.readLine();
				System.out.println("¿Cuantos goles lleva este jugador?");
					golesJugador = Integer.parseInt(br.readLine());
					
					golesEquipoTotal += golesJugador;	
			}
			
				mediaGolesEquipo = golesEquipoTotal / 11;
				
			System.out.println("La media de goles de " + nombreEquipo + ", es de " + mediaGolesEquipo);
			System.out.println();
			
			if (golesJugador > maxGoles) {
				maxGoles = golesJugador;
				jugadorMasGoleador = nombreJugador;
				equipoMasGoleador = nombreEquipo;
				
			}
				
		}
		
		System.out.println("El jugador con más goles es : " + jugadorMasGoleador + ", y el equipo más goleador es: " + equipoMasGoleador + ", su media de goles es: " + mediaGolesEquipo);
		
		
	}

}
