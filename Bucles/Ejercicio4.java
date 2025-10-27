package EjerciciosBucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double notaExamen = 0.0;
		
		boolean salir = false;
		
		System.out.println("=== BIENVENIDO A Tu Banco de Confianza ===");
		
		do {
		
			System.out.println("\n--- MENÚ PRINCIPAL ---");
			System.out.println("1. Introducir nota del Examen");
			System.out.println("2. ¿Está aprobado o suspenso?");
			System.out.println("3. ¿Tienes un extra de Participación?");
			System.out.println("4. Comparación notas media de la clase");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");
		
		int opcion = Integer.parseInt(br.readLine());
		
		switch (opcion) {
		
		case 1:
		System.out.println("1. Introducir nota del Examen");
		
			System.out.println("¿Puedes introducir la nota de tu examen?");
				notaExamen = Double.parseDouble(br.readLine());
				System.out.println("La nota introducida ha sido: " + notaExamen);
		
		break;
		
		case 2:
		System.out.println("2. ¿Está aprobado o suspenso?");
		
			if (notaExamen >= 5 && notaExamen <= 10) {
				System.out.println("Felicidades has aprobado el examen. \nTu nota es: " + notaExamen);
				
			} else if (notaExamen < 5) {
				System.out.println("Lo siento, pero has suspendido el examen. \nTu nota es: " + notaExamen);
				
			} else {
				System.out.println("Lo siento pero el numero introducido debe de ser incorrecto. Miralo Bien.");
			}
		
		
		break;
		
		case 3:
		System.out.println("3. ¿Tienes un extra de Participación? S/N");
			
			char participacion = br.readLine().toLowerCase().charAt(0);
			
			if (participacion == 's') {
				System.out.println("Felicidades has conseguido 0,5 puntos extra por participar en clase, tu nota ahora es: " + (notaExamen + 0.5));
				
			}else {
				System.out.println("Lo siento no has conseguido el 0,5 extra por participar en clase. \nTu nota es " + notaExamen);
			}
			
		break;
		
		case 4:
		System.out.println("4. ¿Quieres comparar tu nota con la media de las notas de clase?");
			char comparacion = br.readLine().toLowerCase().charAt(0);
			
			double numeroCompañeros = 0;
			double sumaNotasCompañeros = 0;
			
			double notasCompañeros = 0;
			
			if (comparacion == 's') {
				System.out.println("Cuantas personas hay en tu clase?");
					numeroCompañeros = Integer.parseInt(br.readLine());
				
				for (int i = 0; i < numeroCompañeros; i++) {
					
					System.out.println("¿Cuál es la nota de tus compañeros?");
					notasCompañeros = Double.parseDouble(br.readLine());
					
					sumaNotasCompañeros += notasCompañeros;
				}
				
			} else if (comparacion != 's') {
				System.out.println("Perfecto, no quieres comparar tus notas con las de tu compañero.");
			}
			
			
			double notaMedia = sumaNotasCompañeros / numeroCompañeros;
			
			System.out.println("La nota media de la clase es: " + notaMedia + ", y tu nota es: " + notaExamen);
			
			if (notaMedia > notaExamen) {
				System.out.println("La nota media de la clase es mayor que tu nota.");
				
			} else if (notaMedia == notaExamen) {
				System.out.println("La nota media de la clase es igual que tu nota.");
				
			}else {
				System.out.println("Felicidades, tu nota es superior a la media de la clase.");
				
			}
		
		break;
		
		case 5:
			salir = true;
			
		System.out.println("¡Hasta luego!");
		
		break;
		
			
		default:
			
			System.out.println("Opción no válida");
			
		}
		
		}while(!salir);
	
	
		}

		
}
