package Ejercicio17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Internacional extends Pedidos{

	private String paisDestino;
		
	private int tasaDeAduana;

	private ArrayList<String> listaProductos = new ArrayList<String>(15);
	
	private int cantidad;
	
	private double precioUnitario;
	
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public void añadirDatos(ArrayList<Pedidos> pedidos) throws IOException {
		super.añadirDatos(pedidos);
		
		try {
			
			System.out.println("Escribe el país de Destino del paquete");
				paisDestino = br.readLine();
			
		}catch(NumberFormatException | IOException e) {
			System.err.println("Has escrito algun dato mal.");
				e.getStackTrace();
			
		}
	}
	

public void añadirProducto() {
		
		if(listaProductos.size() < 15) {
			
			boolean todoOK = false;
			
			while(!todoOK) {
				
				try {
					
					System.out.println("Escribe el nombre del producto:");
						String nombreProducto = br.readLine();
						
					do {
						
						System.out.println("Escribe la cantidad que quieras del producto.");
							cantidad = Integer.parseInt(br.readLine());
						
						if(cantidad < 0) {
							System.err.println("No se puede tener una cantidad inferior a 0.");
							
						}
					}while(cantidad < 0);
					
					
					do {
						
						System.out.println("Escribe el precio unitario del producto.");
							precioUnitario = Double.parseDouble(br.readLine());
						
						if(precioUnitario < 0) {
							System.err.println("No se puede tener un precio inferior a 0.");
							
						}
					}while(precioUnitario < 0);
					
					todoOK = true;
					
				}catch(NumberFormatException | IOException e) {
					System.err.println("Has escrito algun dato mal.");
						e.getStackTrace();
					
				}
				
			}
			
		}else {
			System.err.println("No se pueden enviar mas paquetes esta todo completo.");
		}
		
	}


public void cambioDeEstado() throws IOException {
	
	String nuevoEstado = "";
	
	do {
		
		System.out.println("Escribe el estado del pedido.");
			nuevoEstado = br.readLine();
		
		if(!nuevoEstado.equalsIgnoreCase("pendiente") && !nuevoEstado.equalsIgnoreCase("procesado") && !nuevoEstado.equalsIgnoreCase("enviado")) {
			System.err.println("Solo puede ser uno de los anteriores.");
			
		}
		
	} while(!nuevoEstado.equalsIgnoreCase("pendiente") && !nuevoEstado.equalsIgnoreCase("procesado") && !nuevoEstado.equalsIgnoreCase("enviado"));
	
	System.out.println("El pedido se ha cambiado de estado correctamente a: " + nuevoEstado);
	super.setEstado(nuevoEstado);
}


public void calculoFacturacion() {
	
	double Subtotal = 0;
	
	for (int i = 0; i < listaProductos.size(); i++) {
		
		double precio = 0;
		
			precio = cantidad * precioUnitario;
			
		Subtotal += precioUnitario;
		
	}
	
	double precioTotal = Subtotal + 20 + tasaDeAduana;
	
	System.out.println("El subtotal del pedido es: " + Subtotal);
	System.out.println("El precio final ya con gastos de envío es de: " + precioTotal);
}

}
