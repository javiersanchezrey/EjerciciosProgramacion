package Bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio9 {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
				boolean salir = false;
				
				System.out.println("=== BIENVENIDO A Control de Biblioteca Parental ===");
				
				do {
				
				System.out.println("\n--- MENÚ PRINCIPAL ---");
				System.out.println("1. Crear Pedido Personalizado");
				System.out.println("2. Preparar Cola de Pedidos");
				System.out.println("3. Control de Inventario");
				System.out.println("4. Generador de Nombres para Cafe Especial.");
				System.out.println("5. Salir");
				System.out.print("Elige una opción: ");
				
				int opcion = Integer.parseInt(br.readLine());
				
				switch (opcion) {
				
				case 1:
				System.out.println("1. Crear Pedido Personalizado");
				
			System.out.println("¿Cual es tu nombre?");
				String nombreCliente = br.readLine();
				
			System.out.println("Qué cafe quieres? (expresso/cappuccino/latte)");
				String tipoCafe = br.readLine();
				
				if (tipoCafe.equalsIgnoreCase("expresso")) {
					
					System.out.println("Has seleccionado: " + tipoCafe);
					
				} else if (tipoCafe.equalsIgnoreCase("cappuccino")) {
					
					System.out.println("Has seleccionado: " + tipoCafe);
					
				} else if (tipoCafe.equalsIgnoreCase("latte")) {
					
					System.out.println("Has seleccionado: " + tipoCafe);
					
				} else {
					System.out.println("Lo siento no disponemos de ese tipo de café. Escriba uno que tengamos disponible.");
				
					tipoCafe = br.readLine();
				}
				
				
			System.out.println("¿Que tamaño quieres, pequeño, mediano o grande?");
				String tamañoCafe = br.readLine();
				
				double precio = 0;
				
				if (tamañoCafe.equalsIgnoreCase("pequeño")) {
					precio = 2;
					
					System.out.println("Has seleccionado el tamaño pequeño.");
					
				} else if (tamañoCafe.equalsIgnoreCase("mediano")) {
					precio = 3;
					
					System.out.println("Has seleccionado el tamaño mediano.");
					
				} else if (tamañoCafe.equalsIgnoreCase("grande")) {
					precio = 4;
					
					System.out.println("Has seleccionado el tamaño grande.");
					
				} else {
					System.out.println("Lo siento no disponemos de ese tipo de café. Escriba uno que tengamos disponible.");
				
					tamañoCafe = br.readLine();
				}
					
				
				
				
			System.out.println("¿Quieres extra de Leche?");
				char extraLeche = br.readLine().toLowerCase().charAt(0);
				
			double precioConExtra = precio + 0.50;
				
				if (extraLeche == 's') {
					
					System.out.println("Has saleccionado un extra de Leche. \nEl precio de tu cesta ahora es de: " + precioConExtra );
					
				} else {
					System.out.println("Perfecto no quieres ningun extra.");
					
				}
				
			String codigoPedido = nombreCliente.substring(0,1).toUpperCase() + tipoCafe.toLowerCase() + tamañoCafe.toUpperCase().charAt(0);
			
			if (precioConExtra > 4) {
				System.out.println("Se te hará un 15% de descuento por superar los 4€.");
				
				double precioDescuento = precioConExtra - (precioConExtra *0.15);
				
				System.out.println("Debes de pagar: " + precioDescuento + "€");
			
			} else {
				System.out.println("El codigo del pedido es: " + codigoPedido + " y su precio es de: " + precio + "€.");
			
			}
			
				break;
				
				case 2:
				System.out.println("2. Preparar Cola de Pedidos");
			
			System.out.println("¿Cuantos pedidos hay en cola?");
				int pedidosEnCola = Integer.parseInt(br.readLine());
				
				int tiempoPreparacionPedidos = 1;
				
				int tiempoTotal = 0;
				
				int pedidosCompletadosTotales = 0;
				int pedidosCompletados = 0;
				
				int pedidosCanceladosTotales = 0;
				int pedidosCancelados = 0;
				
				
			for ( int i = 0; i < pedidosEnCola; i++) {
				
				System.out.println("¿Cuál es el tiempo de preparación para el pedido " + (i+1) + "?");
				tiempoPreparacionPedidos = Integer.parseInt(br.readLine());
				
			if (tiempoPreparacionPedidos >= 1 && tiempoPreparacionPedidos <= 10) {
					
				System.out.println("Tu pedido va a tardar: " + tiempoPreparacionPedidos + " Minutos");
				
				tiempoTotal += tiempoPreparacionPedidos;	
				
				pedidosCompletadosTotales ++;
				
					} else if (tiempoPreparacionPedidos == 0) {
				System.out.println("Pedido cancelado");	
				
				pedidosCanceladosTotales ++;
			} 
			
			while (tiempoPreparacionPedidos > 10) {
				System.out.println("Lo siento pero el numero seleccionado es incorrecto. solo servimo con un tiempo maximo de 10 minutos. Ingrese un numero adecuado.");
				
				tiempoPreparacionPedidos = Integer.parseInt(br.readLine());
			}
			
			}
			
			
					
			System.out.println("El tiempo total que van a tardar es: " + tiempoTotal);
			
			System.out.println("Los pedidos completas han sido: " + pedidosCompletadosTotales + " y los pedidos cancelados han sido: " + pedidosCanceladosTotales);
				
				break;
				
				case 3:
				System.out.println("3. Control de Inventario");
		
			System.out.println("¿Cuantos kilos de café tienes disponibles?");
				int kilosDeCafe = Integer.parseInt(br.readLine());
				
				int kilosDeCafeAGramos = kilosDeCafe * 1000;
				
			System.out.println("¿Cuantos cafes se han vendido hoy?");
				int cafesVendidos = Integer.parseInt(br.readLine());
				
			int gramosCafeTotales = cafesVendidos * 15;
			
			if (kilosDeCafeAGramos > gramosCafeTotales) {
				int diferenciaGramos = kilosDeCafeAGramos - gramosCafeTotales;
				
				System.out.println("Todavia te quedan kilos para hacer café, te sobrasn " + diferenciaGramos + " gramos.");
				
				double alcanzaParaCafes = diferenciaGramos / 15;
				
				System.out.println("Todavia puedes hacer: " + alcanzaParaCafes + " cafes.");
				
			} else if (kilosDeCafeAGramos < gramosCafeTotales) {
				int faltanGramos =  gramosCafeTotales - kilosDeCafeAGramos;
				
				System.out.println("No tienes suficientes kilos de cafe para hacer los pedidos, te faltan: " + faltanGramos + " gramos.");
			}
				
				break;
				
				case 4:
				System.out.println("4. Generador de Nombres para Cafe Especial.");
				System.out.println("Quieres que te recomendemos algun cafe de especialidad?");
				
				char recomendar = br.readLine().toLowerCase().charAt(0);
				
				while (recomendar == 's') {
					
			int origenes = (int) (Math.random()*4 +1);
			
			String Origenes = "";
			
				switch (origenes) {
				
				case 1:
					Origenes = "Colombiano";
				break;
				
				case 2:
					Origenes = "Etíope";
				break;
				
				case 3:
					Origenes = "Brasileño";
				break;
				
				case 4:
					Origenes = "Italiano";
				break;
				
				}
			
			int caracteristicas = (int) (Math.random()*4 +1);
			
			String Caracteristicas = "";
			
				switch (caracteristicas) {
				
				case 1:
					Caracteristicas = "Intenso";
				break;
				
				case 2:
					Caracteristicas = "Suave";
				break;
				
				case 3:
					Caracteristicas = "Aromático";
				break;
				
				case 4:
					Caracteristicas = "Premium";
				break;
				
				}
				
				System.out.println("El cafe seleccionado para ti es: " + Origenes + " " + Caracteristicas);
				
			System.out.println("Quieres alguna otra recomendación?");
				recomendar = br.readLine().toLowerCase().charAt(0);
				
				}	
				
	System.out.println("Perfecto no quieres ninguna recomendacion.");
				
				break;
				
				case 5:
					
				salir = true;
				System.out.println("¡Gracias Por Visitarnos!");
				
				break;
				
				default:
				System.out.println("Opción no válida");
				}
				
				} while(!salir);
				
				
			
	}

}
