package Ejercicio16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Personas {

	private int DNI;
	
	private String nombre;
	
	private int edad;
	
	private String nacionalidad;
	
	private LocalDate fechaNacimiento;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void añadirDatos(ArrayList<Deportistas> deportista) throws NumberFormatException, IOException {
		
		int idGenerado = -1;
		Random rand = new Random();
			do {
				
				idGenerado = rand.nextInt(99999999) + 10000000;
				
			}while (estaRepetido(deportista, idGenerado));
			
			System.out.println("");
			
			DNI = idGenerado;
		
		boolean todoOK = false;
		while(!todoOK) {
			
			try {
				
				do {
					
					System.out.println("Escribe el nombre del deportista.");
					nombre = br.readLine();
					
					System.out.println("Escribe la edad del deportista.");
					edad = Integer.parseInt(br.readLine());
					
				}while(edad < 0);
				
					
				System.out.println("Escribe la nacionalidad del deportista.");
					nacionalidad = br.readLine();
					
				System.out.println("Escribe la fecha de Nacimiento del deportista. (dd/MM/yyyy");
				
					DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String fechaTemp = br.readLine();
						fechaNacimiento = LocalDate.parse(fechaTemp, formato);
				
			}catch(NumberFormatException | IOException e) {
				System.out.println("Has escrito algun dato mal.");
					e.getStackTrace();
			}
			
		}
		
		
	}
	
	private boolean estaRepetido(ArrayList<Deportistas> deportistas, int idGenerado) {
		
		for(int i = 0; i < (deportistas.size() -1); i++) {
			if(deportistas.get(i).getDNI() == idGenerado) {
				return true;
			}
			
		}
		
		return false;
	}
	
	public int getDNI() {
		return DNI;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void mostrarDatos() {
		System.out.println("El DNI es: " + this.DNI);
		System.out.println("El nombre es: " + this.nombre);
		System.out.println("La edad es: " + this.edad);
		System.out.println("La fecha de Nacimiento es : " + this.fechaNacimiento);
		System.out.println("La nacionalidad es: " + this.nacionalidad);
		System.out.println("-------------------------------------------");
	}
}
