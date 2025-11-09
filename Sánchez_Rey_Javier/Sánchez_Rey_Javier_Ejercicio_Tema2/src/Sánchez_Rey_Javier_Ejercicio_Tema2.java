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
	
	
	// Opción 1.2: Calcular edad del usuario
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
	
	//OPCIÓN 2: CATALOGO DE JUEGOS
public static void juegosBiblioteca() throws IOException {
		
		System.out.println("1. Añadir juegos a la Bibilioteca");
		
		System.out.println("¿Cuántos juegos quieres añadir?");
			int numeroJuegos = Integer.parseInt(br.readLine());
			
		double dineroTotalGastado = 0;
			
		for (int i = 0; i < numeroJuegos; i++) {
			
			System.out.println("¿Cuál es el nombre del " + (i+1) + "º juego que quieres añadir?");
				String nombreJuego = br.readLine();
				
			System.out.println("¿Cuál es el tamaño de "  + nombreJuego + "? ");
				int tamañoJuego = Integer.parseInt(br.readLine());
				
			System.out.println("¿Cuál es el precio de "  + nombreJuego + "?");
				double precioJuego = Double.parseDouble(br.readLine());
				
			System.out.println("El nombre del " + (i+1) + "º juego es: " + nombreJuego + " su tamaño es de " + tamañoJuego + " GB y el precio es de " + precioJuego + "€.");
			
			dineroTotalGastado += precioJuego;
		}
		
			System.out.println("El dinero total gastado es de: " + dineroTotalGastado + "€.");
		
	}


// Opción 2.2. Calcular espacio total ocupado
public static void calcularMemoria() throws IOException {
	
		System.out.println("2. Calcular espacio total ocupado");
		
		System.out.println("¿Cuál es el espacio que tiene disponible en su ordenador?");
			int espacioDisponible = Integer.parseInt(br.readLine());
			
		System.out.println("¿Cuántos juegos quieres instalar?");
			int numeroJuegosInstalar = Integer.parseInt(br.readLine());
			
			int tamañoJuego = 0;
			int tamañoTotalJuegos = 0;
			
			for (int i = 0; i < numeroJuegosInstalar && tamañoTotalJuegos < espacioDisponible; i++) {
				
				System.out.println("¿Cuál es el tamaño del " + (i+1) + "º juego en GB?");
					tamañoJuego = Integer.parseInt(br.readLine());
					
				tamañoTotalJuegos += tamañoJuego;
				
			}
			
			int gbSobrantes = espacioDisponible - tamañoTotalJuegos;
			
			if (tamañoTotalJuegos > espacioDisponible) {
				System.out.println("Lo siento, pero no tienes sufienciente capacidad para instalar todos los juegos");
				
			} else if (espacioDisponible > tamañoTotalJuegos){
				System.out.println("Felicidades has podido instalar todos los juegos y todavía te sobran " + gbSobrantes + " GB.");
					
			} else if (espacioDisponible == tamañoTotalJuegos) {
				System.out.println("Ya has completado los GB que tenias de capacidad, no puedes seguir instalando juegos.");
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
				
				
//CASE 1
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
	
//CASE 2	
			case 2:
				System.out.println("2. Catálogo de Juegos");
				
				//SUBMENÚ 2
			boolean salirSubmenu2 = false;
				
		do {
							
			System.out.println("\n--- Gestion de Usuarios ---");								
			System.out.println("1. Añadir juegos a la Biblioteca");
			System.out.println("2. Calcular espacio total ocupado");
			System.out.println("3. Volver al menú principal");
			System.out.print("Estas en el Submenú, Elige una Opción: ");
							
	int submenu2 = Integer.parseInt(br.readLine());
					
	switch (submenu2) {

	case 1:
				
		juegosBiblioteca();
			
	break;
				
	case 2:
			
		calcularMemoria();
				
	break;
					
	case 3:
		salirSubmenu2 = true;
		System.out.println("¡Volviendo al menú Principal!");
				
	break;
		
	default:
		System.out.println("Opcion no válida.");
		
	}
		
	} while (!salirSubmenu2);
				
				
				break;
				
				
//CASE 3
				case 3:
				System.out.println("3. Valorar Saga Completa");
				

			
				break;
	
//CASE 4
				case 4:
				System.out.println("4. Recomendación Aleatoria.");
				
				
				
				break;
				
//CASE 5
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
