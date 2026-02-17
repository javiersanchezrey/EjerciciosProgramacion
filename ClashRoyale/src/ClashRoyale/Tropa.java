package ClashRoyale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tropa extends Carta{

	private int puntosDeVida;
	
	private int daño;
	
	private String velocidad;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	
	public void añadirDatos() throws IOException {
		
		super.añadirDatos();
			
			System.out.println("Añade los puntos de vida de la Tropa");
				puntosDeVida = Integer.parseInt(br.readLine());
				
			System.out.println("Añade el daño que puede realizar la Tropa");
				daño = Integer.parseInt(br.readLine());
				
			do {
				
				System.out.println("Escribe la velocidad de la tropa (Lenta, Media o Alta");
					velocidad = br.readLine();
					
					if (!velocidad.equalsIgnoreCase("Lenta") && !velocidad.equalsIgnoreCase("Media") && !velocidad.equalsIgnoreCase("Alta")) {
						System.err.println("Lo siento pero la velocidad solo puede ser una de las anteriores.");
					}
				
			}while (!velocidad.equalsIgnoreCase("Lenta") && !velocidad.equalsIgnoreCase("Media") && !velocidad.equalsIgnoreCase("Alta"));
				
	}

}
