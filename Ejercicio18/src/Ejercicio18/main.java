package Ejercicio18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {

private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
			ArrayList<Dispositivos> dispositivos = new ArrayList<Dispositivos>();
		
			boolean salir = false;

			do {
				System.out.println("== CONCESIONARIO NO QUEREMOS HACER UN EXAMEN ==");
				System.out.println("1. Registrar Producto");
				System.out.println("2. Añadir Componente a Ordenador");
				System.out.println("3. Instalar App en Smartphone");
				System.out.println("4. Filtrar Ordenadores por Componente");
				System.out.println("5. Filtrar Smartphones por Aplicación");
				System.out.println("6. Presupuesto de Garantía Extendida");
				System.out.println("7. Salir");
				System.out.println("Introduce una opcion: ");
				int opcion = Integer.parseInt(br.readLine());

				switch (opcion) {
				case 1:
					System.out.println("Registrar Producto");
					
					registrarProducto(dispositivos);
						
					break;
				case 2:
					System.out.println("Añadir Componente a Ordenador");
					
						añadirComponente(dispositivos);
					
					break;
				case 3:
					System.out.println("Instalar App en Smartphone");
					
						añadirAplicacion(dispositivos);
					
					break;
				case 4:
					System.out.println("Filtrar Ordenadores por Componente");
					
						filtrarOrdenadoresPorComponentes(dispositivos);
						
					break;
					
				case 5:
					System.out.println("Filtrar Smartphones por Aplicación");
					
						filtrarSmartphonesPorAplicacion(dispositivos);
						
					break;
					
				case 6:
					System.out.println("Presupuesto de Garantía Extendida");
					
						garantiaExtendida(dispositivos);
						
					break;
					
				case 7:
					System.out.println("Saliendo de sistema...");
						salir = true;
						
					break;
				}
				
			} while (!salir);
		}

	
	private static void garantiaExtendida(ArrayList<Dispositivos> dispositivos) {
		
		int codigoABuscar = -1;
		
		boolean todoOK = false;
		
		while(!todoOK) {
			
			try {
				do {
					
					System.out.println("Escribe el codigo del dispositivo a buscar.");
					codigoABuscar = Integer.parseInt(br.readLine());
					
					if(codigoABuscar < 100) {
						System.err.println("No puede haber un codigo inferior a 100.");
						
					}
					
				}while(codigoABuscar < 100);
				
				todoOK = true;
					
			}catch(NumberFormatException | IOException e) {
				System.err.println("Has introducido algún dato mal.");
					e.printStackTrace();
			}
			
		}
		
		boolean encontrado = false;
		for(Dispositivos D: dispositivos) {
			
			if(codigoABuscar == D.getCodigoAleatorio()) {
				
				if(D instanceof Ordenadores) {
					
					((Ordenadores)D).garantiaExtendida();
					encontrado = true;
					
				}else if (D instanceof Smartphones) {
					
					((Smartphones)D).garantiaExtendida();
					encontrado = true;
				}
				
			}
			
		}
		
		if(!encontrado) {
			
			System.err.println("No se ha encontrado ningún codigo.");
		}
		
	}


	private static void filtrarSmartphonesPorAplicacion(ArrayList<Dispositivos> dispositivos) {
		
		String aplicacionABuscar = "";
		
		boolean todoOK = false;
		
		while(!todoOK) {
			
			try {
				
				System.out.println("Escribe la aplicacion que quieras buscar.");
					aplicacionABuscar = br.readLine();
				
					todoOK = true;
			} catch(NumberFormatException | IOException e) {
				System.err.println("Has introducido algún dato mal.");
					e.printStackTrace();
			}
			
		}
		
		boolean encontrado = false;
		
		for(Dispositivos D: dispositivos) {
			
			if(D instanceof Smartphones) {
				
				if( ((Smartphones)D).getListaAplicaciones().contains(aplicacionABuscar) ) {
					
					System.out.println("Smartphone encontrado");
						encontrado = true;
						
					System.out.println( ((Smartphones)D).toString() );
				}
				
			}
			
		}
		
		if(!encontrado) {
			System.err.println("No se ha conseguido encontrar un smartphone con esa aplicación.");
		}
		
	}


	private static void filtrarOrdenadoresPorComponentes(ArrayList<Dispositivos> dispositivos) {
		
		String componenteABuscar = "";
		
		boolean todoOK = false;
		
		while(!todoOK) {
			
			try {
				
					System.out.println("Escribe el componente del ordenador que quieras buscar");
						componenteABuscar = br.readLine();
			
					todoOK = true;
					
			} catch (NumberFormatException | IOException e) {
				System.err.println("Has introducido algún dato mal.");
				e.printStackTrace();
			}
		}
		
		boolean encontrado = false;
		
		for(Dispositivos D: dispositivos) {
			
			if(D instanceof Ordenadores) {
				
				if( ((Ordenadores)D).getComponentesAdicionales().contains(componenteABuscar) ) {
					
					System.out.println("Ordenador encontrado.");
						encontrado = true;
					
					System.out.println( ((Ordenadores)D).toString() );
				}
				
			}
			
		}
		
		if(!encontrado) {
			System.err.println("No se a encontrado ese componente en ningún ordenador.");
			
		}
		
	}


	private static void añadirAplicacion(ArrayList<Dispositivos> dispositivos) {

		int codigoABuscar = 0;
		
		boolean todoOK = false;
		
		while(!todoOK) {
			
			try {
				
				do {
					
					System.out.println("Escribe el código del dispositivo que quieras buscar");
						codigoABuscar = Integer.parseInt(br.readLine());
					
						if(codigoABuscar < 100) {
							System.err.println("No puede haber un codigo inferior a 100.");
						}
				}while(codigoABuscar < 100);
			
					todoOK = true;
					
			} catch (NumberFormatException | IOException e) {
				System.err.println("Has introducido algún dato mal.");
				e.printStackTrace();
			}
			
		}
		
		boolean encontrado = false;
		
		for(Dispositivos D: dispositivos) {
			
				if(codigoABuscar == D.getCodigoAleatorio()) {
						
					if(D instanceof Smartphones) {
						encontrado = true;
						((Smartphones)D).instalarAplicaciones();
					}
				}
		}
		
		if(!encontrado) {
			System.err.println("No se ha encontrado ningún dispositivo con ese código.");
			
		}
		
	}

	private static void añadirComponente(ArrayList<Dispositivos> dispositivos) {
		
		int codigoABuscar = 0;
		
		boolean todoOK = false;
		
		while(!todoOK) {
			
			try {
				
				do {
					
					System.out.println("Escribe el código del dispositivo que quieras buscar");
						codigoABuscar = Integer.parseInt(br.readLine());
					
						if(codigoABuscar < 100) {
							System.err.println("No puede haber un codigo inferior a 100.");
						}
				}while(codigoABuscar < 100);
			
					todoOK = true;
					
			} catch (NumberFormatException | IOException e) {
				System.err.println("Has introducido algún dato mal.");
				e.printStackTrace();
			}
			
		}
		
		boolean encontrado = false;
		
		for(Dispositivos D: dispositivos) {
			
				if(codigoABuscar == D.getCodigoAleatorio()) {
						
					if(D instanceof Ordenadores) {
						encontrado = true;
						((Ordenadores)D).añadirComponente();
					}
				}
		}
		
		if(!encontrado) {
			System.err.println("No se ha encontrado ningún dispositivo con ese código.");
			
		}
		
	}

	private static void registrarProducto(ArrayList<Dispositivos> dispositivos) {

		boolean todoOK = false;
		
		String tipoProducto = "";
		
		while(!todoOK) {
			
			try {
				
				do {
					
					System.out.println("Escribe el tipo de dispositivo que quieres registrar. (Ordenador o Smartphone)");
						tipoProducto = br.readLine();
					
				}while(!tipoProducto.equalsIgnoreCase("Ordenador") && !tipoProducto.equalsIgnoreCase("Smartphone"));
				
				todoOK = true;
				
			} catch (NumberFormatException | IOException e) {
				System.err.println("Has introducido algún dato mal.");
				e.printStackTrace();
			}
		}
		
		for(Dispositivos D: dispositivos) {
			
			if(tipoProducto.equalsIgnoreCase("Ordenador")) {
				
				Ordenadores ordenador = new Ordenadores();
				
					ordenador.pedirDatos(dispositivos);
						dispositivos.add(ordenador);
				
			} else {
				Smartphones telefono = new Smartphones();
				
				telefono.pedirDatos(dispositivos);
					dispositivos.add(telefono);
				
			}
			
		}
		
	}
}
