package ejerciciosFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio9 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new
		
				InputStreamReader(System.in));
		boolean salir = false;
		
		
		System.out.println("=== BIENVENIDO A [NOMBRE_APP] ===");
		
		do {

		System.out.println("\n--- MENÚ PRINCIPAL ---");
		System.out.println("1. Pedido Personalizado");
		System.out.println("2. Preparar Cola de Pedidos");
		System.out.println("3. Control de Inventario de Granos");
		System.out.println("4. Generador de nombre para Café Especial");
		System.out.println("5. Salir");
		System.out.print("Elige una opción: ");
		
		int opcion = Integer.parseInt(br.readLine());
		
		switch (opcion) {
		
		
		case 1:
		System.out.println("1. Pedido Personalizado");
		
		System.out.println("Escribe tu nombre para ordenar tu pedido personalizado.");
			String nombreCliente = br.readLine();
		
		System.out.println("¿Que tipo de café quieres? Hay expresso, cappuccino o latte");
			String tipoCafe = br.readLine();
			
			if (tipoCafe.equalsIgnoreCase("expresso")) {
				System.out.println("El pedido del café será: " + tipoCafe);
				
			} else if (tipoCafe.equalsIgnoreCase("cappuccino")) {
				System.out.println("El pedido del café será: " + tipoCafe);
				
			} else if (tipoCafe.equalsIgnoreCase("latte")) {
				System.out.println("El pedido del café será: " + tipoCafe);
				
			} else {
				System.out.println("Lo siento no tenemos ese tipo de café. ¿Quieres pedir algun cafe que si dispongamos?");
				tipoCafe = br.readLine();
			}
			
		System.out.println("Que tamaño de cafe quieres?");
			String tamañoCafe = br.readLine();	
			
			double precioCafe = 0;
			
			if (tamañoCafe.equalsIgnoreCase("pequeño")) {
				precioCafe = 2;
				System.out.println("El precio del café será: " + precioCafe);
				
			} else if (tamañoCafe.equalsIgnoreCase("mediano")) {
				precioCafe = 3;
				System.out.println("El precio del café será: " + precioCafe);
				
			} else if (tamañoCafe.equalsIgnoreCase("grande")) {
				precioCafe = 4;
				System.out.println("El precio del café será: " + precioCafe);
				
			} else {
				System.out.println("Lo siento no tenemos ese tipo de café. ¿Quieres pedir algun cafe que si dispongamos?");
				tipoCafe = br.readLine();
			}
			
		System.out.println("Quieres extra de leche?");
			char extraLeche = br.readLine().toLowerCase().charAt(0);
			double precioTotal = 0;
			
			if (extraLeche == 's') {
				System.out.println("Perfecto serán 0.5 € más.");
				precioTotal = precioCafe + 0.5;
			}else {
				System.out.println("Perfecto no quiere extra de leche.");
			}
			
			String codigoPedido = nombreCliente.substring(0,1).toUpperCase() + tipoCafe.toLowerCase() + tamañoCafe.toUpperCase().charAt(0) ;
			
		System.out.println("El código de pedido es: " + codigoPedido +  ", y el precio es: " + precioTotal + "€.");
		
		if (precioTotal > 4 ) {
			System.out.println("Por una compra superior a 4€ se te hará un 15% de descuento.");
			
			double descuento = precioTotal * 0.15;
			
				double PrecioTotalDescuento = precioTotal - descuento;
			
			System.out.println("El precio con el descuento es de: " + PrecioTotalDescuento + "€.");
		}
		
		break;
		
		
		case 2:
		System.out.println("2. Preparar Cola de Pedidos");
		
		System.out.println("¿Cuantos pedidos hay en cola?");
			int pedidosEnCola = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < pedidosEnCola; i++) {
				System.out.println("¡Cuanto es el tiempo de preparacion de tu café?");
					int tiempoPreparacion = Integer.parseInt(br.readLine());
					
				while ( tiempoPreparacion < 0 || tiempoPreparacion > 10) {
					System.out.println("El numero de tiempo introducido es incorrecto, solo se puede de 1 a 10 minutos.");
						tiempoPreparacion = Integer.parseInt(br.readLine());
				}
				
				if (tiempoPreparacion == 0) {
					System.out.println("Pedido Cancelado.");
					
				}
				
			}
		
		break;
		
		
		case 3:
		System.out.println("3. Control de Inventario de Granos");
		//....
		break;
	
		
		case 4:
		System.out.println("4. Generador de nombre para Café Especial");
		//....
		break;
		
		
		case 5:
			salir = true;
			System.out.println("¡Gracias Por Visitarnos!");
			
		break;
			
		
		default:
			System.out.println("Opción no válida");
			
		}
			
		}while(!salir);
			
	
	}
	

}

		
		
	
