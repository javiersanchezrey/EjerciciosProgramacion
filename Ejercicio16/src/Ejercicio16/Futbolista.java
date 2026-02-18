package Ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Futbolista extends Deportistas{

	private String posicion;
	
	private int numeroGoles;
	
	private String equipoActual;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
public void añadirDatos(ArrayList<Deportistas> deportistas) throws IOException {
		
		super.añadirDatos(deportistas);
		
			System.out.println("Escribe la posición del futbolista.");
				posicion = br.readLine();
				
				do {
					
					System.out.println("Escribe el numero de goles que lleva.");
						numeroGoles = Integer.parseInt(br.readLine());
					
					if (numeroGoles < 0){
						System.err.println("No puede marcas goles negativos.");
					}
				} while(numeroGoles < 0);
				
				System.out.println("Escribe su equipo actual.");
					equipoActual = br.readLine();
	}


public void mostrarDatos() {
	
	super.mostrarDatos();
	System.out.println("Su posición es: " + this.posicion);
	System.out.println("El numero de goles marcados es: " + this.numeroGoles);
	System.out.println("Su equipo actual es: " + this.equipoActual);
}


public String getEquipoActual() {
	return equipoActual;
}

public String getNombre() {
	return super.getNombre();
}

public void mostrarEquipo(ArrayList<Deportistas> deportistas, String equipoAEncontrar) {
	
	for(Deportistas D: deportistas) {
		
		System.out.println(D.getNombre());
		
	}
	
}

}
