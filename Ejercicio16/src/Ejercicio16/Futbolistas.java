package Ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Futbolistas extends Deportistas{

	private String posicionCampo;
	
	private int numeroGoles;
	
	private String equipoActual;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


	public void añadirDatos(ArrayList<Deportistas> deportista) throws NumberFormatException, IOException {
		
		super.añadirDatos(deportista);
		try {
			
			System.out.println("Escribe la posición del campo del futbolista.");
			posicionCampo = br.readLine();
			
		System.out.println("Escribe el numero de goles del futbolista");
			numeroGoles = Integer.parseInt(br.readLine());
			
		System.out.println("Escribe el equipo actual del futbolista.");
			equipoActual = br.readLine();
			
		}catch(NumberFormatException | IOException e) {
			System.out.println("Has escrito algun dato mal.");
				e.getStackTrace();
		}
	}	
	
	public void mostrarDatos() {
		super.mostrarDatos();
			System.out.println("Posicion: " + this.posicionCampo);
			System.out.println("numero Goles: " + this.numeroGoles);
			System.out.println("equipo Actual: " + this.equipoActual);
	}

	public String getEquipoActual() {
		return equipoActual;
	}

	public int getNumeroGoles() {
		return numeroGoles;
	}
	
	
	
}
