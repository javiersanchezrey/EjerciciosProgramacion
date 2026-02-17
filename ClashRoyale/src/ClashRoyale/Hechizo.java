package ClashRoyale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hechizo extends Carta{

	private int dañoDeArea;
	
	private double radioDeJuego;
	
	private int duracion;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	
public void añadirDatos() throws IOException {
		
		super.añadirDatos();
			
			System.out.println("Añade el daño de aréa del hechizo");
				dañoDeArea = Integer.parseInt(br.readLine());
				
			System.out.println("Añade el daño que puede realizar la Tropa");
				radioDeJuego = Double.parseDouble(br.readLine());
				
			do {
				
				System.out.println("¿Cual es la duración del hechizo?");
					duracion = Integer.parseInt(br.readLine());
					
					if (duracion < 0 || duracion > 60) {
						System.err.println("Lo siento pero la duracion tiene que ser entre 0 y 60 segundos.");
					}
				
			}while (duracion < 0 || duracion > 60);
				
	}
}
