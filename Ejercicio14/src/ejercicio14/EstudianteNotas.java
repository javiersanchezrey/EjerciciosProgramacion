package ejercicio14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class EstudianteNotas {

	private int id;
	
	private String nombre;
	
	private String asignatura;
	
	private Double[] notas = new Double[6];
	
	private int numNotas = 0;
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public void añadirDatos(EstudianteNotas[] estudiantes, int pos) throws IOException {
		
		Random aleatorio = new Random();

		int idGenerado = -1;
		do {
			idGenerado = aleatorio.nextInt(30) + 1;
			System.err.println("He generado el numero: " + idGenerado);
			
		} while (estaRepetido(estudiantes, pos, idGenerado));
		System.out.println("Asignado el id " + idGenerado);
		id = idGenerado;

		boolean datosOK = false;
		while (!datosOK) {

			try {

				System.out.print("Escribe el nombre del alumno: ");
				nombre = br.readLine();
	
				System.out.println("Escribe la asigatura del alumno " + nombre);
					asignatura = br.readLine();
					
				datosOK = true;
				
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato.");
					e.printStackTrace();
			}

		}

	}
	
	private boolean estaRepetido(EstudianteNotas[] estudiantes, int pos, int idGenerado) {
		
		for (int i = 0; i < (pos - 1); i++) {
			
			if (estudiantes[i].getId() == idGenerado) {
				
				return true;
			}
	
		}
		return false;
	
	}
	
	
	public EstudianteNotas añadirNotas() throws NumberFormatException, IOException {
		
		System.out.println("Escribe las notas del alumno " + nombre + " de la asignatura " + asignatura);
		
		
		if(numNotas <= notas.length) {
			
			System.out.println("Escribe la " + (numNotas +1) + "º nota:");
				notas[numNotas] = Double.parseDouble(br.readLine());
				
				if(numNotas >= notas.length -1) {
					System.out.println("Todas las notas ya estan completas, no se pueden introducir más notas.");
				}
				
				while(notas[numNotas] < 0 || notas[numNotas] > 10) {
					System.err.println("Nota escrita incorrectamente");
					
						System.out.println("Escribe otra nota válida");
							notas[numNotas] = Double.parseDouble(br.readLine());	
				}
				
				
			while(notas[numNotas] < 0 || notas[numNotas] > 10) {
				System.err.println("Nota escrita incorrectamente");
				
					System.out.println("Escribe otra nota válida");
						notas[numNotas] = Double.parseDouble(br.readLine());
					
			}
			
			numNotas++;
			
	}
			
		return null;
	}

		
		
		public int getId() {
			
			return id;
		}
		
		
		
		public void mostrarNotas() {
			
			System.out.println("Las notas del alumno " + nombre + " son:");
			
			for(int i = 0; i < numNotas; i++) {
				
				System.out.print(notas[i] + ", ");
				
			}
			
			double notaMaxima = 0;
			
				for(int i = 0; i < numNotas; i++) {
					
					if(notas[i] > notaMaxima) {
						
						notaMaxima = notas[i];
					}
				}
			
			System.out.println("la nota máxima del alumno " + nombre + " es " + notaMaxima);
			
			double notaMinima = 10;
			
				for(int i = 0; i < numNotas; i++) {
					
					if(notaMinima > notas[i]) {
						
						notaMinima = notas[i];
					}
					
				}
			
			System.out.println("la nota mínima del alumno " + nombre + " es " + notaMinima);
			
		}
		
		
		public void notasSuspensas() {
			
			int notasSuspensas = 0;
			
			for(int i = 0; i < notas.length; i++) {
				
				if (notas[i] < 5) {
					notasSuspensas ++;
					
				}
				
			}
			
			System.out.println("El alumno " + nombre + " ha suspendido " + notasSuspensas + " notas.");
			
		}
		
		
		public void notaMedia() {

			
			double notaMedia = 0;
			double notaFinal = 0;
			
			for(int i = 0; i < numNotas; i++) {
					
					notaMedia += notas[i];
				
			}
			
			notaFinal = notaMedia / numNotas;
			
			System.out.println("La nota media del alumno " + nombre + " es " + notaFinal);
			
		}
		
		
		public void mejorMedia(EstudianteNotas[] estudiantes, double notaFinal) {
			
			double mejorMedia = 0;
			
			for(int i = 0; i < numNotas; i++) {
				
				if(notaFinal > mejorMedia) {
					
					mejorMedia = notaFinal;
					
				}
				
			}
			
			System.out.println("La nota media del mejor alumno es " + mejorMedia + " y ese alumno es: " + nombre);
		}
		
		
		public Double[] getNotas() {
			
			return notas;
		}
		
		
		public String getNombre() {
			
			return nombre;
		}
		
		
		public int getNumNotas() {
			
			return numNotas;
		}
	
}
