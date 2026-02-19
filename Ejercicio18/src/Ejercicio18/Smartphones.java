package Ejercicio18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Smartphones extends Dispositivos{

	private String sistemaOperativo;
	
	private int capacidadBateria;
	
	private ArrayList<String> listaAplicaciones = new ArrayList<String>(30);
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public void pedirDatos(ArrayList<Dispositivos> dispositivos) {
		super.pedirDatos(dispositivos);
			
		boolean todoOK = false;
		
			while(!todoOK) {
				
				try {
					
					System.out.println("Escribe el sistema Operativo del telefono");
					sistemaOperativo = br.readLine();
						
						do {
							
							System.out.println("¿Cuanta capacidad de Bateria tiene el telefono?");
								capacidadBateria = Integer.parseInt(br.readLine());
							
							if(capacidadBateria < 0) {
								System.err.println("No puedes tener tan poca memoria RAM.");
							}
						}while(capacidadBateria < 0);
					
						todoOK = true;
						
				} catch (NumberFormatException | IOException e) {
					System.err.println("Has introducido algún dato mal.");
					e.printStackTrace();
				}	
				
			}	
	}
	
	public void instalarAplicaciones() {
		
		if(listaAplicaciones.size() < 30) {
			boolean todoOK = false;
			
			while(!todoOK) {
				
				try {
					
					System.out.println("Escribe la aplicación que quieres añadir al telefono");
						String nombreAplicacion = br.readLine();
						
							listaAplicaciones.add(nombreAplicacion);
							
							System.out.println("La aplicacion " + nombreAplicacion + " se ha instalado correctamente.");
					
							todoOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Has introducido algún dato mal.");
					e.printStackTrace();
				}	
			}
			
		}else {
			System.err.println("No se pueden añadir mas aplicaciones.");
		}
		
	}

	public ArrayList<String> getListaAplicaciones() {
		return listaAplicaciones;
	}

	@Override
	public String toString() {
		return "Smartphones [sistemaOperativo=" + sistemaOperativo + ", capacidadBateria=" + capacidadBateria
				+ ", listaAplicaciones=" + listaAplicaciones + "]";
	}
	
}
