package Bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int distancia = 0;
		double consumoGasolina;
		double precioGasolina;
		
			boolean salir = false;
			
			System.out.println("=== BIENVENIDO A CALCULADOR DE VIAJES POR CARRETERA ===");
			
			do {
			
			System.out.println("\n--- MENÚ PRINCIPAL ---");
			System.out.println("1. Coste por Gasolina");
			System.out.println("2. planificar paradas");
			System.out.println("3. Tiempo Estimado de Llegada");
			System.out.println("4. Contador de Peajes.");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");
			
			int opcion = Integer.parseInt(br.readLine());
			
			switch (opcion) {
			
			case 1:
			System.out.println("1. Coste por Gasolina");

			System.out.println("¿Cuál es la distancia en Kilometros?");
				distancia = Integer.parseInt(br.readLine());
				
			System.out.println("¿Cuál es el consumo de tu coche a los 100?");
				consumoGasolina = Double.parseDouble(br.readLine());
				
			System.out.println("¿Cuanto vale la gasolina donde la hechas?");
				precioGasolina = Double.parseDouble(br.readLine());
				
				
				double litrosNecesarios = (distancia * consumoGasolina) / 100;
			System.out.println("Los litros necesarios para realizar el viaje son: " + litrosNecesarios);
			
			double costeGasolinaTotal = litrosNecesarios * precioGasolina;
			
			System.out.println("Y el coste total de gasolina son: " + costeGasolinaTotal);
			
			if (distancia > 300) {
				System.out.println("El viaje supera los 300 kilometros, tienes un descuento de 5%.");
				double descuento5 = costeGasolinaTotal * 0.05;
				
			System.out.println("El precio de la gasolina con el descuento se te queda en: " + (costeGasolinaTotal - descuento5));
			
				
			}
			
			break;
			
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			
			case 2:
			System.out.println("2. planificar paradas");
		
			System.out.println("¿Podrías decir cuál es la distancia total del viaje?");
				int distanciaTotalViaje = Integer.parseInt(br.readLine());
				
				
			System.out.println("Distancia total del viaje: " + distanciaTotalViaje);
			
			
			
			
			break;
			
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			//PREGUNTAR A ADRIAN
			
			case 3:
			System.out.println("3. Tiempo Estimado de Llegada");
			
			System.out.println("¿A que hora saliste?");
				int horaDeSalida = Integer.parseInt(br.readLine());
				
				while (horaDeSalida < 0 || horaDeSalida > 23) {
					System.out.println("La hora escrita es incorrecta.");
					
					System.out.println("Escribe correctamente la hora de salida.");
						horaDeSalida = Integer.parseInt(br.readLine());
				}
				
				System.out.println("¿Cuál es la distancia en kilometros para llegar al destino?");
					distancia = Integer.parseInt(br.readLine());
					
				System.out.println("¿Cuál es la velocidad media que has llevado?");
					int velocidadMedia = Integer.parseInt(br.readLine());
					
					
				int horasTardaraViaje = distancia / velocidadMedia;
			System.out.println("Las horas que tardará en el viaje son: " + horasTardaraViaje + " horas.");
			
			System.out.println();
			
			int horaEstimadaLlegada = horaDeSalida + horasTardaraViaje;
			
			if (horaEstimadaLlegada > 23) {
				System.out.println("Llegará el día siguiente.");
				
			} else {
				System.out.println("La hora estimada de llegada es: " + horaEstimadaLlegada + " horas.");
				
			}
			
			break;
			
			case 4:
			System.out.println("4. Contador de Peajes");
			
			System.out.println("¿Cuántos peajes hay en tu ruta?");
				int peajes = Integer.parseInt(br.readLine());
				double precioPeajes = 0;
				
				double precioPeajesTotal = 0;
				
				double descuentoPeajes = 0;
				
			for ( int i = 0; i < peajes; i++) {
				System.out.println("¿Cuál es el precio de los peajes?");
					System.out.println((i + 1) + "º Peaje: ");
						precioPeajes = Double.parseDouble(br.readLine());
						
					precioPeajesTotal += precioPeajes;
			}
		
			System.out.println("El precio de los peajes es: " + precioPeajesTotal);
			
			if (precioPeajesTotal > 20) {
				System.out.println("Al superar los 20€ de peaje, se te hará un descuento del 10%");
				
				descuentoPeajes = precioPeajesTotal * 0.10;
				
			System.out.println("Ahora lo que vas a pagar de peajes es: " + (precioPeajesTotal - descuentoPeajes));
			}
			
			System.out.println("El precio sin descuento es: " + precioPeajesTotal + "\nEl descuento es: " + descuentoPeajes + "\nEl total a pagar es: " + (precioPeajesTotal - descuentoPeajes));
			
			break;
			
			case 5:
				
			salir = true;
			System.out.println("¡Buen Viaje y Conduce Seguro!");
			
			break;
			
			default:
			System.out.println("Opción no válida");
			}
			
			} while(!salir);
			
			
		
	}
	
}
