package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	
	
public static void main(String[] args) throws IOException {
		  
		
		Factura[] facturas = new Factura[3];
		  
		  boolean salir = false;
			do {
				System.out.println();
				System.out.println("== GESTIÓN NOTAS ESTUDIANTES  ==");
				System.out.println("1. Crear Factura");
				System.out.println("2  Añadir Concepto");
				System.out.println("3. Ver Desglose ");
				System.out.println("4. Calcular Total");
				System.out.println("5. Factura Más alta");
				System.out.println("6. Resumen Contable");
				System.out.println("7. Salir");
				System.out.println("Introduce una opcion: ");

				int opcion = -1;
				boolean datosOK = false;
				while (!datosOK) {
				
						try {
							opcion = Integer.parseInt(br.readLine());
							
						} catch (NumberFormatException | IOException e) {
							System.err.println("Solo puedes introducir numeros");
						}
				
					datosOK = true;
				}

				switch (opcion) {
				case 1:
						crearFactura(facturas);
					
				break;
				
				
				case 2:
						añadirConcepto(facturas);
					
				break;
					
					
				case 3:
						verDesglose(facturas);
					
				break;
					
					
				case 4:
						calcularTotal(facturas);
					
				break;
				
					
				case 5:
						facturaMasAlta(facturas);
					
				break;
					
					
				case 6:
						resumenContable(facturas);
					
				break;
					
					
				case 7:
					System.out.println("Saliendo del sistema...");
					salir = true;
				break;
					
				
				default:
					System.out.println("Opcion no valida");
				}

			} while (!salir);
		}


	private static void crearFactura(Factura[] facturas) throws IOException {
		
		System.out.println("===  Crear una Factura ===");
		
		for(int i = 0; i < facturas.length; i++) {
			
			facturas[i] = new Factura();
			
			facturas[i].añadirNombreCliente(facturas, i);;
			
		}
		
	}
	
	
	private static void añadirConcepto(Factura[] facturas) {
		
		System.out.println("===  Añadir un Concepto ===");
			
		int idABuscar = -1;
		boolean todoOK = false;
		
		do {
			
			try {
				System.out.println("Escribe el id a buscar:");
					idABuscar = Integer.parseInt(br.readLine());
				
				todoOK = true;
					
			} catch(NumberFormatException | IOException e) {
				e.getStackTrace();
				
			}
			
		} while (todoOK != true);
		
			for(int i = 0; i < facturas.length; i++) {
				
				if(facturas[i].getId() == idABuscar) {
					
					facturas[i].añadirConcepto(facturas, i);	
				}	
			}
		
	}
	
	
	private static void verDesglose(Factura[] facturas) {
		
		System.out.println("===  Ver Desglose de la Factura ===");
		
		int idABuscar = -1;
		boolean todoOK = false;
		
		do {
			
			try {
				
				System.out.println("Escribe el id del numero de factura.");
					idABuscar = Integer.parseInt(br.readLine());
					
				todoOK = true;
				
			}catch (NumberFormatException | IOException e) {
				e.getStackTrace();
				
			}
			
		}while (todoOK != true);
		
			for(int i = 0; i < facturas.length; i++) {
				
				if(facturas[i].getId() == idABuscar) {
					
					facturas[i].verDesgloseFactura();
				}
			}
	}
	
	
	private static void calcularTotal(Factura[] facturas) {
		
		System.out.println("=== Calcular el total de la Factura ===");
		
		int idABuscar = -1;
		boolean todoOK = false;
		
		do {
			
			try {
				
				System.out.println("Escribe el id del numero de factura.");
					idABuscar = Integer.parseInt(br.readLine());
					
				todoOK = true;
				
			}catch (NumberFormatException | IOException e) {
				e.getStackTrace();
				
			}
			
		}while (todoOK != true);
		
			for(int i = 0; i < facturas.length; i++) {
				
				if(facturas[i].getId() == idABuscar) {
					
					facturas[i].calcularTotalFinal();;
				}
			}
	}
	
	
	private static void facturaMasAlta(Factura[] facturas) {
	
		System.out.println("=== Factura más alta ===");
		
		String facturaAlta = null;
		Double importeTotalMasAlto = 0.0;
		
			for(int i = 0; i < facturas.length; i++) {
				
				if(facturas[i].facturaMasAlta() > importeTotalMasAlto) {
					
					importeTotalMasAlto = facturas[i].facturaMasAlta();
						
					facturaAlta = facturas[i].getNombre();
				}
			}
	}


private static void resumenContable(Factura[] facturas) {
	// TODO Auto-generated method stub
	
}

}
