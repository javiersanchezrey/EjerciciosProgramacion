package ClashRoyale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Carta {

	private int id;
	
	private String nombre;
	
	private int costeElixir;
	
	private String rareza;
	
	private int cantidadDisponible;
	
	private boolean usadaEnMazo;
	
	//--------------------------------------//
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void añadirDatos() throws IOException {
		
		System.out.println("Escribe el nombre de la carta.");
			nombre = br.readLine();
		
			
			do {
				System.out.println("Escribe el coste de elexir.");
					costeElixir = Integer.parseInt(br.readLine());
					
				
				if(costeElixir < 0 || costeElixir > 10) {
					System.out.println("Lo siento pero el coste de elixir es erronéo. Intentalo de nuevo");
				}
				
			}while(costeElixir < 0 || costeElixir > 10);
		
			
			do {
				System.out.println("Escribe la rareza de la carta. (Comun, Especial, Unica o Legendaria)");
				rareza = br.readLine();
				
				if(!rareza.equalsIgnoreCase("Comun") && !rareza.equalsIgnoreCase("Especial") && !rareza.equalsIgnoreCase("Unica") && !rareza.equalsIgnoreCase("Legendaria")){
					System.err.println("La rareza solo puede ser una de las anteriores.");
				}
			
			} while (!rareza.equalsIgnoreCase("Comun") && !rareza.equalsIgnoreCase("Especial") && !rareza.equalsIgnoreCase("Unica") && !rareza.equalsIgnoreCase("Legendaria"));
		
			
		System.out.println("Escribe la cantidad disponible de la carta.");
			cantidadDisponible = Integer.parseInt(br.readLine());
			
		System.out.println("¿La carta se esta utilizando en el mazo?");
			char respuestaUsada = br.readLine().toUpperCase().charAt(0);
			
				if(respuestaUsada == 'S') {
					usadaEnMazo = true;
					
				} else {
					usadaEnMazo = false;
				}
	}

	public String getRareza() {
		return rareza;
	}
	
	

	public void setUsadaEnMazo(boolean usadaEnMazo) {
		this.usadaEnMazo = usadaEnMazo;
	}

	public boolean isUsadaEnMazo() {
		return usadaEnMazo;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Carta [id=" + id + ", nombre=" + nombre + ", costeElixir=" + costeElixir + ", rareza=" + rareza
				+ ", cantidadDisponible=" + cantidadDisponible + ", usadaEnMazo=" + usadaEnMazo + "]";
	}
	
}
