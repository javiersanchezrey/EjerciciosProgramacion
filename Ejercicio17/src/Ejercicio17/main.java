package Ejercicio17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {

private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
			ArrayList<Pedidos> pedidos = new ArrayList<Pedidos>(15);
		
			boolean salir = false;

			do {
				System.out.println("== CONCESIONARIO NO QUEREMOS HACER UN EXAMEN ==");
				System.out.println("1. Crear Pedido");
				System.out.println("2. Añadir Producto a Pedido");
				System.out.println("3. Actualizar Estado");
				System.out.println("4. Calcular Facturación");
				System.out.println("5. Ranking de Tenis");
				System.out.println("6. Estadísticas Globales");
				System.out.println("7. Salir");
				System.out.println("Introduce una opcion: ");
				int opcion = Integer.parseInt(br.readLine());

				switch (opcion) {
				case 1:
					System.out.println("Crear Pedido");
					
						registrarPaquetes(pedidos);
						
					break;
				case 2:
					System.out.println("Añadir Producto a Pedido");
					
					añadirProductoAPedido(pedidos);
					
					break;
				case 3:
					System.out.println("Actualizar Estado");
					
					actualizarEstado(pedidos);
					
					break;
				case 4:
					System.out.println("Calcular Facturación");
					
						calcularFacturacion(pedidos);
						
					break;
					
				case 5:
					System.out.println("Ranking de Tenis");
					
						
						
					break;
					
				case 6:
					System.out.println("Estadísticas Globales");
					
						
						
					break;
					
				case 7:
					System.out.println("Saliendo de sistema...");
						salir = true;
						
					break;
				}
				
			} while (!salir);
		}

	
	private static void calcularFacturacion(ArrayList<Pedidos> pedidos) throws IOException {
		
boolean todoOK = false;
		
		int idABuscar = -1;
		
		while(!todoOK) {
			
			try {
				do {
					
					System.out.println("Escribe el id del pedido ha buscar.");
					idABuscar = Integer.parseInt(br.readLine());
					
					if(idABuscar < 0) {
						System.err.println("No se puede tener un id negativo.");
						
					}
				}while (idABuscar < 0);
				
				todoOK = true;
				
			}catch(NumberFormatException | IOException e) {
				System.err.println("Has escrito algun dato mal.");
					e.printStackTrace();
				
			}
		}
		
		boolean encontrado = false;
		for(Pedidos P: pedidos) {
			
			if(idABuscar == P.getId()) {
				
				encontrado = true;
				
				if(P instanceof Nacional) {
					
					((Nacional)P).calculoFacturacion();
					
				} else {
					
					((Internacional)P).calculoFacturacion();
					
				}	
			}
		}
		
		if (!encontrado) {
	        System.err.println("No se ha encontrado el id del paquete.");
	    }
		
	}


	private static void actualizarEstado(ArrayList<Pedidos> pedidos) throws IOException {
		
		boolean todoOK = false;
		
		int idABuscar = -1;
		
		while(!todoOK) {
			
			try {
				do {
					
					System.out.println("Escribe el id del pedido ha buscar.");
					idABuscar = Integer.parseInt(br.readLine());
					
					if(idABuscar < 0) {
						System.err.println("No se puede tener un id negativo.");
						
					}
				}while (idABuscar < 0);
				
				todoOK = true;
				
			}catch(NumberFormatException | IOException e) {
				System.err.println("Has escrito algun dato mal.");
					e.getStackTrace();
				
			}
		}
		
		for(Pedidos P: pedidos) {
			
			if(idABuscar == P.getId()) {
				
				if(P instanceof Nacional) {
					
					((Nacional)P).cambioDeEstado();
					
				} else {
					
					((Internacional)P).cambioDeEstado();
					
				}
				
			} else {
				System.err.println("No se ha encontrado el id del paquete.");
			}
		}
	}


	private static void añadirProductoAPedido(ArrayList<Pedidos> pedidos) {
		
		boolean todoOK = false;
		
		int idABuscar = -1;
		
		while(!todoOK) {
			
			try {
				do {
					
					System.out.println("Escribe el id del pedido ha buscar.");
					idABuscar = Integer.parseInt(br.readLine());
					
					if(idABuscar < 0) {
						System.err.println("No se puede tener un id negativo.");
						
					}
				}while (idABuscar < 0);
				
				todoOK = true;
				
			}catch(NumberFormatException | IOException e) {
				System.err.println("Has escrito algun dato mal.");
					e.getStackTrace();
				
			}
			
			for(Pedidos P: pedidos) {
				
				if(idABuscar == P.getId()) {
					
					if(P instanceof Nacional) {
						
						((Nacional)P).añadirProducto();
						
					} else {
						
						((Internacional)P).añadirProducto();
						
					}
					
				} else {
					System.err.println("No se ha encontrado el id del paquete.");
				}
			}
			
			
		}
		
	}


	private static void registrarPaquetes(ArrayList<Pedidos> pedidos) throws IOException {
		
		boolean todoOK = false;
		
		String tipoPaquete = "";
		
		while(!todoOK) {
			
			try {
					
				do {
					
					System.out.println("¿Cuál va a ser el tipo de paquete que vas a mandar? (Nacional o Internacional)");
						tipoPaquete = br.readLine();
					
					if(!tipoPaquete.equalsIgnoreCase("Nacional") && !tipoPaquete.equalsIgnoreCase("Internacional")) {
						
						System.err.println("Solo puede ser una de las opciones anteriores.");
					}
					
				}while (!tipoPaquete.equalsIgnoreCase("Nacional") && !tipoPaquete.equalsIgnoreCase("Internacional"));
				
				todoOK = true;
				
			}catch(NumberFormatException | IOException e) {
				System.err.println("Has escrito algun dato mal.");
					e.getStackTrace();
				
			}
			
		}
		
		if(tipoPaquete.equalsIgnoreCase("Nacional")) {
			
			Nacional N = new Nacional();
			
			N.añadirDatos(pedidos);
				pedidos.add(N);
					
		} else {
				
				Internacional IN = new Internacional();
				
					IN.añadirDatos(pedidos);
						pedidos.add(IN);
			}
		
	}
	
	

}
