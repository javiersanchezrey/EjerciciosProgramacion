package Ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Tenistas extends Deportistas{

	private int posicionRanking;
	
	private ArrayList<String> historialTorneos = new ArrayList<>();
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void añadirDatos(ArrayList<Deportistas> deportista) throws NumberFormatException, IOException {
		
		super.añadirDatos(deportista);
		try {
		
			do {
				
			System.out.println("¿Cuál es su posición en el ranking");
				posicionRanking = Integer.parseInt(br.readLine());
				
			}while(posicionRanking < 0);
		
			
		System.out.println("Escribe el equipo actual del futbolista.");
			
			
		}catch(NumberFormatException | IOException e) {
			System.out.println("Has escrito algun dato mal.");
				e.getStackTrace();
		}
	}
	
	public void añadirTorneo() {
		
		if (historialTorneos.size() < 10) {
			
			boolean todoOK = false;
			
			while(!todoOK) {
				
				try {
					
					System.out.println("Escribe el nombre del torneo a añadir.");
						String nombreTorneo = br.readLine();
						
							historialTorneos.add(nombreTorneo);
					
				}catch(NumberFormatException | IOException e) {
					System.out.println("Has escrito algun dato mal.");
						e.getStackTrace();
				}
				
			}
			
		}else {
			System.out.println("No se puede añadir ningun torneo porque ya hay muchos.");
		}
		
	}

	public ArrayList<String> getHistorialTorneos() {
		return historialTorneos;
	}
	
	public void mostrarDatos() {
		super.mostrarDatos();
			System.out.println("posicion Ranking: " + this.posicionRanking);
			System.out.println("historial Torneos: ");
				for(int i = 0; i < historialTorneos.size(); i++) {
					
					
				}
	}

	public int getPosicionRanking() {
		return posicionRanking;
	}
	
	
	
}
