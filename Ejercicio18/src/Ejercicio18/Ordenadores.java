package Ejercicio18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ordenadores extends Dispositivos{

	private String procesador;
	
	private int memoriaRAM;
	
	private int almacenamiento;
	
	private ArrayList<String> componentesAdicionales = new ArrayList<String>(10);
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public void pedirDatos(ArrayList<Dispositivos> dispositivos) {
		super.pedirDatos(dispositivos);
			
		boolean todoOK = false;
		
			while(!todoOK) {
				
				try {
					
					System.out.println("Escribe el procesador del ordenador");
						procesador = br.readLine();
						
						do {
							
							System.out.println("¿Cuanta memoria RAM tiene el ordenador?");
								memoriaRAM = Integer.parseInt(br.readLine());
							
							if(memoriaRAM < 0) {
								System.err.println("No puedes tener tan poca memoria RAM.");
							}
						}while(memoriaRAM < 0);
					
						do {
							
							System.out.println("¿Cuanto almacenamiento tiene el ordenador?");
								almacenamiento = Integer.parseInt(br.readLine());
							
							if(almacenamiento < 0) {
								System.err.println("No puedes tener tan poco almacenamiento.");
							}
						}while(almacenamiento < 0);
					
						todoOK = true;
						
				} catch (NumberFormatException | IOException e) {
					System.err.println("Has introducido algún dato mal.");
					e.printStackTrace();
				}	
				
			}
		
	}
	
	public void añadirComponente() {
		
		if(componentesAdicionales.size() < 10) {
			boolean todoOK = false;
			
			while(!todoOK) {
				
				try {
					
					System.out.println("Escribe el componente adicional que quieres añadir");
						String nombreComponenteAdicional = br.readLine();
						
							componentesAdicionales.add(nombreComponenteAdicional);
							
							System.out.println("El componente " + nombreComponenteAdicional + " se ha añadido correctamente.");
					
							todoOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Has introducido algún dato mal.");
					e.printStackTrace();
				}	
			}
			
		}else {
			System.err.println("No se pueden añadir mas componentes adicionales.");
		}
		
	}

	public ArrayList<String> getComponentesAdicionales() {
		return componentesAdicionales;
	}

	@Override
	public String toString() {
		return "Ordenadores [procesador=" + procesador + ", memoriaRAM=" + memoriaRAM + ", almacenamiento="
				+ almacenamiento + ", componentesAdicionales=" + componentesAdicionales + "]";
	}
	
	
	
	
}
