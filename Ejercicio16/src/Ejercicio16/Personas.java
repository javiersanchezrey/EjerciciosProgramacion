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
	
	public void añadirDatos(ArrayList<Deportistas> deportistas) throws IOException {
		
		
		Random rand = new Random();
		
		int idGenerado = -1;
		do {
			idGenerado = rand.nextInt(99999999) + 10000000;
		} while (estaRepetido(deportistas, idGenerado));
		System.out.println("Asignado el id " + idGenerado);
		DNI = idGenerado;
		
		boolean todoOK = false;
		
		while(!todoOK) {
			
			try {
				
				System.out.println("Escribe el nombre de la persona:");
					nombre = br.readLine();
					
				do {
					System.out.println("Escribe la edad");
						edad = Integer.parseInt(br.readLine());
					
						if(edad <= 0) {
							System.err.println("La edad no puede ser menor a 0.");
						}
						
				}while(edad< 0);
				
				System.out.println("Escribe la nacionalidad");
					nacionalidad = br.readLine();
					
					System.out.print("Introduce la fecha (dd/MM/yyyy): ");
					DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String fechaTemp = br.readLine();
					fechaNacimiento = LocalDate.parse(fechaTemp, formato);
				
				todoOK = true;
				
			} catch(NumberFormatException | IOException e) {
				
				System.err.println("Lo siento pero has introducido algún dato mal.");
					e.getStackTrace();
			}
			
		}
		
	}
	
	private boolean estaRepetido(ArrayList<Deportistas> deportistas, int idGenerado) {
		for (int i = 0; i < (deportistas.size() - 1); i++) {
			if (deportistas.get(i).getDNI() == idGenerado) {
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
		
		System.out.println("//------------------------//");
		System.out.println("El DNI es: " + this.DNI);
		System.out.println("El nombre es: " + this.nombre);
		System.out.println("La edad es: " + this.edad);
		System.out.println("La nacionalidad es: " + this.nacionalidad);
		System.out.println("La fecha de nacimiento es: " + this.fechaNacimiento);
	}
	
}
