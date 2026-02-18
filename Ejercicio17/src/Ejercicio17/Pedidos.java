package Ejercicio17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Pedidos {

	private int id;
	
	private String nombre;
	
	private LocalDate fecha;
	
	private String estado;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void añadirDatos(ArrayList<Pedidos> pedidos) throws IOException {
		
		Random rand = new Random();
		
		int idGenerado = -1;
		do {
			idGenerado = rand.nextInt(1000) + 1;
		} while (estaRepetido(pedidos, idGenerado));
		System.out.println("Asignado el id " + idGenerado);
		id = idGenerado;
		
		try {
			
			System.out.println("Escribe el nombre del pedido.");
				nombre = br.readLine();
			
			System.out.println("Escribe la fecha del pedido. (dd/MM/yyyy)");
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String fechaTemp = br.readLine();
					fecha = LocalDate.parse(fechaTemp, formato);
				
			do {
				
				System.out.println("Escribe el estado del pedido. (Pendiente, Procesado o Enviado)");
					estado = br.readLine();
				
				if(!estado.equalsIgnoreCase("pendiente") && !estado.equalsIgnoreCase("procesado") && !estado.equalsIgnoreCase("enviado")) {
					System.err.println("Solo puede ser uno de los anteriores.");
					
				}
				
			} while(!estado.equalsIgnoreCase("pendiente") && !estado.equalsIgnoreCase("procesado") && !estado.equalsIgnoreCase("enviado"));
			
		}catch(NumberFormatException | IOException e) {
			System.err.println("Has escrito algun dato mal.");
				e.getStackTrace();
			
		}
	}
	
	private boolean estaRepetido(ArrayList<Pedidos> pedidos, int idGenerado) {
		for (int i = 0; i < (pedidos.size() - 1); i++) {
			if (pedidos.get(i).getId() == idGenerado) {
				return true;
			}

		}
		return false;

	}

	public int getId() {
		return id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
