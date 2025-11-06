package Sánchez_Rey_Javier_Ejercicio_Tema2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sánchez_Rey_Javier_Ejercicio_Tema2 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
// Opción 1.1: Crear nuevo usuario
	
	public static void crearNuevoUsuario() throws IOException {
		
		System.out.println("1. Crear Nuevo Usuario");
		
						//Nombre Usuario
					
				System.out.println("Introduce tu nombre");
					String nombreUsuario = br.readLine()	;
					
					
				System.out.println("Introduce el año de nacimiento.");
					int añoNacimiento = Integer.parseInt(br.readLine());
				
					
				System.out.println("¿Cuál es tu plataforma plataforma? (PC, PlayStation, Xbox o Nintendo)");
					String plataformaFavorita = br.readLine();
					
					while (!plataformaFavorita.equalsIgnoreCase("PC") && !plataformaFavorita.equalsIgnoreCase("PlayStation") && !plataformaFavorita.equalsIgnoreCase("Xbox") && 
							!plataformaFavorita.equalsIgnoreCase("Nintendo")) {
						
						System.out.println("Lo siento pero esa plataforma no la reconocesmos, ¿Podrías volver a escribir alguna de las del ejemplo?");
						
						plataformaFavorita = br.readLine();
						
					}
				
					
				System.out.println("¿Tienes suscripción premium?");
					char suscripcionPremium = br.readLine().toLowerCase().charAt(0);
				
					
					String idUsuario = nombreUsuario.substring(0, 3) + "GAME" + añoNacimiento;
				
				System.out.println("Tu ID de Usuario es: " + idUsuario);	
				
				
				//Edad Usuario
				
				int edadUsuario = 2025 - añoNacimiento;
					System.out.println("Tu edad es: " + edadUsuario);
				
				
				//Tipo de Usuario
				
				if(edadUsuario >= 0 && edadUsuario<= 17) {
					System.out.println("Eres un jugador 'Junior Game'");
					
				} else if (edadUsuario >= 18 && edadUsuario <= 30) {
					System.out.println("Eres un jugador 'Pro Gamer'");
					
				}else {
					System.out.println("Eres un jugador 'Master Gamer'");
					
				}
				
				//Plataforma Favorita
				
				System.out.println("Tu plataforma favorita es: " + plataformaFavorita);
				
				
				//Premium o no
				if (suscripcionPremium == 's') {
					System.out.println("Felicidades, Eres PREMIUM.");
					
				} else {
					System.out.println("No eres Premium, Lo siento.");
					
				}
		
	}
	
	
	public static void calcularEdadUsuario() throws NumberFormatException, IOException {
		
		System.out.println("2. Calcular Edad del Usuario");
		
		System.out.println("¿Cuál es tu año de Nacimiento?");
			int añoNacimiento = Integer.parseInt(br.readLine());
			
			//Edad Usuario
			
			while (añoNacimiento < 1920 || añoNacimiento > 2025) {
				System.out.println("Lo siento pero la fecha introducida es inválida. Repita un fecha correcta.");
				
				añoNacimiento = Integer.parseInt(br.readLine());
			}
			
			int edadUsuario = 2025 - añoNacimiento;
			
			System.out.println("Tu edad es: " + edadUsuario);
			
			System.out.println("El año de nacimiento es: " + añoNacimiento);

			
			//PEGI
			
			if (edadUsuario >= 18) {
				System.out.println("Eres mayor de edad por lo que puedes jugar con la etiqueta PEGI 18.");
				
			} else if (edadUsuario >= 16 && edadUsuario < 18) {
				System.out.println("Puedes jugar con la etiqueta PEGI 16.");
			
			} else if (edadUsuario >= 12 && edadUsuario < 16) {
				System.out.println("Puedes jugar con la etiqueta PEGI 12.");
			} else if (edadUsuario >= 7 && edadUsuario < 12) {
				System.out.println("Puedes jugar con la etiqueta PEGI 7.");
			
			} else {
				System.out.println("Puedes jugar con la etiqueta PEGI 3.");
			
			} 
	}
	
	
	
	
		public static void main(String[] args) throws NumberFormatException, IOException{
			
				boolean salir = false;
				
				System.out.println("=== BIENVENIDO A Control de Biblioteca Parental ===");
				
				do {
				
				System.out.println("\n--- Biblioteca Calasanz Games ---");
				System.out.println("1. Gestión de Usuarios");
				System.out.println("2. Catálogo de Juegos");
				System.out.println("3. Sistema de Valoraciones");
				System.out.println("4. Estadísticas y Reportes.");
				System.out.println("5. Calculadora de Descuentos");
				System.out.println("6. Salir");
				System.out.print("Elige una opción: ");
				
				int opcion = Integer.parseInt(br.readLine());
				
				switch (opcion) {
				
				case 1:
			
			//SUBMENÚ 1
		boolean salirSubmenu1 = false;
					
			do {
						
			System.out.println("\n--- Gestion de Usuarios ---");
			System.out.println("1. Crear nuevo Usuario");
			System.out.println("2. Calcular la edad del Usuario");
			System.out.println("3. Volver al menú principal");
			System.out.print("Estas en el Submenú, Elige una Opción: ");
						
			int submenu1 = Integer.parseInt(br.readLine());
				
		switch (submenu1) {
	
		case 1:
			
			crearNuevoUsuario();
		
		break;
			
		
		case 2:
		
			calcularEdadUsuario();
			
		break;
				
		case 3:
			salirSubmenu1 = true;
			System.out.println("¡Volviendo al menú Principal!");
			
			break;
	
	default:
		System.out.println("Opcion no válida.");
	
	}
	
	} while (!salirSubmenu1);
				
	
			break;
	
				
				case 2:
				System.out.println("2. Catalogar un libro");
						
					
				break;
				
				case 3:
				System.out.println("3. Valorar Saga Completa");
				

			
				break;
				
				case 4:
				System.out.println("4. Recomendación Aleatoria.");
				
				
				
				break;
				
				case 5:
					
				salir = true;
				System.out.println("¡Feliz Lectura!");
				
				break;
				
				default:
				System.out.println("Opción no válida");
				}
				
				} 
				
				while(!salir);
				
				
			
	}
		
}
