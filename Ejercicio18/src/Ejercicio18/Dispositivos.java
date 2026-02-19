package Ejercicio18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Dispositivos {

	private int codigoAleatorio;
	
	private String marca;
	
	private String modelo;
	
	private double precioBase;
	
	private int mesesGarantia;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void pedirDatos(ArrayList<Dispositivos> dispositivos) {
		
Random rand = new Random();
		
		int idGenerado = -1;
		do {
			idGenerado = rand.nextInt(999) + 100;
		} while (estaRepetido(dispositivos, idGenerado));
		System.out.println("Asignado el id " + idGenerado);
		codigoAleatorio = idGenerado;
		
		
		boolean todoOK = false;
		
		while(!todoOK) {
			
			try {
				
				System.out.println("Escribe la marca del dispositivo");
					marca = br.readLine();
					
				System.out.println("Escribe el modelo del dispositivo");
					modelo = br.readLine();
					
					do {
						
						System.out.println("Escribe el precio base del dispositivo");
							precioBase = Double.parseDouble(br.readLine());
						
						if(precioBase < 0) {
							System.err.println("El precio introducido no puede ser negativo");	
						}
					}while(precioBase < 0);
					
					do {
						
						System.out.println("Escribe los meses de garantia del dispositivo");
							mesesGarantia = Integer.parseInt(br.readLine());
						
						if(mesesGarantia <= 0) {
							System.err.println("Los meses de garantia introducido no puede ser negativo");	
						}
					}while(precioBase <= 0);
				
					todoOK = true;
					
			} catch (NumberFormatException | IOException e) {
				System.err.println("Has introducido algún dato mal.");
				e.printStackTrace();
			}	
		}
	}
	
	private boolean estaRepetido(ArrayList<Dispositivos> dispositivos, int idGenerado) {
		for (int i = 0; i < (dispositivos.size() - 1); i++) {
			if (dispositivos.get(i).getCodigoAleatorio() == idGenerado) {
				return true;
			}

		}
		return false;

	}

	public int getCodigoAleatorio() {
		return codigoAleatorio;
	}
	
	public double garantiaExtendida() {
		
		
		double subtotal = precioBase + (mesesGarantia * 5 );
			
		return subtotal;	
	}
	
	
	
}
