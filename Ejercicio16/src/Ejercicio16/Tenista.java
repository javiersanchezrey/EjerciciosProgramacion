package Ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Tenista extends Deportistas{

	private int posicionRanking;
	
	private ArrayList<String> historialTorneos = new ArrayList<String>();
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
public void añadirDatos(ArrayList<Deportistas> deportistas) throws IOException {
		
		super.añadirDatos(deportistas);
				
				do {
					
					System.out.println("Escribe la posición del tenista en el ranking.");
						posicionRanking = Integer.parseInt(br.readLine());
					
					if (posicionRanking < 0){
						System.err.println("No puede tener una posción negativa.");
					}
				} while(posicionRanking < 0);
	}


public void añadirTorneo() {
	
		if(historialTorneos.size() < 10) {
			
			boolean todoOK = false;
			
			while(!todoOK) {
				
				try {
					
					System.out.println("Escribe el nombre del torneo.");
						String nombreTorneo = br.readLine();
						
							historialTorneos.add(nombreTorneo);
					
				} catch(NumberFormatException | IOException e) {
					
					System.err.println("Lo siento pero has introducido algún dato mal.");
						e.getStackTrace();
				}
				
			}
			
		}else {
			System.err.println("Ya has completado los 10 torneos.");
		}
	
}


public void mostrarDatos() {
	
	super.mostrarDatos();
	
	System.out.println("Su posicion en el ranking mundial es: " + this.posicionRanking);
	System.out.println("Su historial de torneos es: ");
		
		for(String torneo: historialTorneos) {
			System.out.println(torneo + ", ");
		}
}


public int getPosicionRanking() {
	return posicionRanking;
}



}
