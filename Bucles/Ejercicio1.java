package EjerciciosBucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int precioProducto = 0;
		
		double Descuento = 0;
		double PrecioFinal = 0;
		
		boolean salir = false;
		System.out.println("=== BIENVENIDO A Gestión de Ventas ===");
		
		do {
		//MOSTRAR MENU
		System.out.println("\n--- MENÚ PRINCIPAL ---");
		System.out.println("1. Calcula el 21% de IVA");
		System.out.println("2. Descuento para pedidos superiores a 3 figuras");
		System.out.println("3. Cálculo para envío gratis (Mínimo 50€)");
		System.out.println("4. Tabla de precios.");
		System.out.println("5. Salir");
		System.out.print("Elige una opción: ");
		
		int opcion = Integer.parseInt(br.readLine());
		
		switch (opcion) {
		
		case 1:
		System.out.println("1. Calcula el 21% de IVA");
		
		System.out.println("¿Podrías escribir el precio del producto?");
		
			precioProducto = Integer.parseInt(br.readLine());;
			double IVA = precioProducto - (precioProducto * 0.21);
			
		System.out.println("Perfecto. \nEl precio del producto es: " + precioProducto + "\nY el precio del producto sin IVA es de: " + IVA);
		
		
		break;
		
		case 2:
		System.out.println("2. Descuento para pedidos superiores a 3 figuras");
			System.out.println("¿Cuántas figuras vas a querer comprar?");
			int compraDeFiguras = Integer.parseInt(br.readLine());
				
			if (compraDeFiguras > 3) {
			
			for (int i = 0 ; i < compraDeFiguras; i++) {
				System.out.println("Las figuras que vas a comprar son: " + compraDeFiguras + ", por lo que vas a tener un descuento de un 10%.");
				
				System.out.println("Figura " + (i+1));
					System.out.println("¿Cuál es su precio?");
						precioProducto = Integer.parseInt(br.readLine());
						
				PrecioFinal += precioProducto;
						
			}
			
			Descuento = PrecioFinal * 0.10;
			
			double precioTotal = PrecioFinal - Descuento;
			
				System.out.println("El 10% de descuento es de: " + Descuento + ",y el precio a pagar sin el descuento es: " + PrecioFinal + ". \nPor lo que el precio con el descuento es de: " + precioTotal);
		
			}else if (compraDeFiguras < 3) {
			System.out.println("La cantidad no es mayor a 3 figuras, por lo que no hay descuento del 10%.");
		}
			
		break;
		
		case 3:
		System.out.println("3. Cálculo para envío gratis (Mínimo 50€)");
		
		double envioGratuito = 50 - PrecioFinal;
		
			if (PrecioFinal < 50) {
				System.out.println("El envío gratuito es a partir de 50€, y tu ahora mismo tienes: " + PrecioFinal + " por lo que actualmente no tienes envío gratuito. \nTe faltan " + envioGratuito);
				
			} else {
				System.out.println("Felicidades tienes " + PrecioFinal + ", por lo que tienes envío gratuito");
				
			}
		
		
		break;
		
		case 4:
		System.out.println("4. Tabla de precios.");
			System.out.println("--- Tabla de Precios ---");
			double precio = 3.30;
			
			for (int i = 0; i < 10; i++) {
				double preciosinIVA = precio - (precio * 0.21);
				double DescuentoCase4 = precio * 0.10;
				
				double precioFinalCase4 = precio - DescuentoCase4;
				 
				precio += 3.30;
				
				if (i >= 0 && i < 3) {
					System.out.println((i+1) + " unidades " + precio + " y el precio sin IVA es de: " + preciosinIVA);
				}
				
				
				if (i >= 3) {
					System.out.println((i+1) + " unidades " + precio + " y el precio sin IVA es de: " + preciosinIVA + ",el precio con descuento es de: " + precioFinalCase4 + " y el desceunto es de: " + DescuentoCase4);
					
				}
				
			}
		
		
		break;
		
		case 5:
			salir = true;
			
			System.out.println("¡Hasta luego!");
		break;
		
		default:
		System.out.println("Opción no válida");
			
		}
		
		}while(!salir);
		
	}

}
