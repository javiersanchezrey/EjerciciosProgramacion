package Bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio8 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			boolean salir = false;
			
			System.out.println("=== BIENVENIDO A Control de Biblioteca Parental ===");
			
			do {
			
			System.out.println("\n--- MENÚ PRINCIPAL ---");
			System.out.println("1. Catalogar un libro");
			System.out.println("2. Sesion de Lectura");
			System.out.println("3. Valorar Saga Completa");
			System.out.println("4. Recomendación Aleatoria.");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");
			
			int opcion = Integer.parseInt(br.readLine());
			
			switch (opcion) {
			
			case 1:
			System.out.println("1. Catalogar un libro");

			System.out.println("¿Cuál es el titulo del libro?");
				String tituloLibro = br.readLine();
				
			System.out.println("¿Cuantas paginas tiene el libro?");
				int numeroPaginas = Integer.parseInt(br.readLine());
				
			System.out.println("¿Cuál es su año de publicación?");
				String añoPublicacion = br.readLine();
				
			System.out.println("¿Cuál es su genero?");
				String generoLibro = br.readLine();
				
			
			String codigoEstanteria = generoLibro.toUpperCase() + añoPublicacion.substring(2) + tituloLibro.toUpperCase().charAt(0) ;

			System.out.println("El codigo de la estanteria es: " + codigoEstanteria);
			
			int tiempodeLectura = numeroPaginas * 2;
			
			int horas = tiempodeLectura / 60;
			int minutos = tiempodeLectura % 60;
			
			System.out.println("El tiempo estimado de lectura son: " + tiempodeLectura + " minutos, lo qeu viene a ser: " + horas + " horas y " + minutos + " minutos.");
			
			
			break;
			
			case 2:
			
				int paginasLeidas = 0;
				
				int capitulosCompletados = 0;
				
				int capitulosFaltantes = 0;
				
				int paginasLeidasTotal = 0;
				
			System.out.println("¿Cuantos capitulos tiene el libro?");
				int capitulosLibro = Integer.parseInt(br.readLine());
				
				for (int i = 0; i < capitulosLibro; i++) {
					
					System.out.println("¿Cuantas paginas te has leido del capitulo " + (i+1) + "?");
						paginasLeidas = Integer.parseInt(br.readLine());
					
					if (paginasLeidas != 0) {
						
						capitulosCompletados++;
						
					}
					
					paginasLeidasTotal +=paginasLeidas;
				}
				
				capitulosFaltantes = capitulosLibro - capitulosCompletados;
				
				System.out.println("Has terminado de leer.");
				System.out.println();
				
				System.out.println("Los capitulos completados han sido " + capitulosCompletados + " has leido " + paginasLeidasTotal + " paginas");
				
				if(capitulosFaltantes > 0) {
					
					System.out.println("Te quedan " + capitulosFaltantes + " capitulo");
					
				} else if (capitulosFaltantes == 0) {
					
					System.out.println("Felicidades has acabado el libro.");
				}
					
				
			break;
			
			case 3:
			System.out.println("3. Valorar Saga Completa");
			
			//Adrian ha dicho que un ejercicio del examen era como lo que esta aqui debajo.
			
			double notaMediaTemporada = 0;
			double notasDeLosCapitulos = 0;
			
			double notaCapitulo = 0;
			double notaMediaSerie = 0;
			
			double notaMediaSerieFinal= 0;
			
			double sumaNotaMediaTemporada = 0;
		
		System.out.println("¿Cuantos temporadas tiene la serie que estas viendo?");
			int temporadasSerie = Integer.parseInt(br.readLine());
			
		for (int i = 0; i < temporadasSerie; i++) {
			
			notasDeLosCapitulos = 0;
			
			System.out.println("¿Cuantos capitulos tiene " + (i+1) + " temporada?");
				int capitulosTemporada = Integer.parseInt(br.readLine());
				
				
				for (int j = 0; j < capitulosTemporada; j++) {
					
			System.out.println("¿Que nota le das al " + (j+1) + "º capitulo de la temporada " + (i+1));
					notaCapitulo = Double.parseDouble(br.readLine());
					
				while (notaCapitulo < 0 || notaCapitulo > 10) {
					System.out.println("Lo sieto pero la nota introducida no es valida, solo valen notas del 1 al 10");
					notaCapitulo = Double.parseDouble(br.readLine());
					
				}
				
				notasDeLosCapitulos += notaCapitulo;
				
				notaMediaTemporada = notasDeLosCapitulos / capitulosTemporada;
					
				}
				
				System.out.println("La nota Media de la temporada es de: " + notaMediaTemporada);
				
				sumaNotaMediaTemporada += notaMediaTemporada;		
		}
		
		notaMediaSerie = sumaNotaMediaTemporada / temporadasSerie;
		
		
		
		System.out.println("La nota media de la serie es: " + notaMediaSerie);
		
			break;
			
			case 4:
			System.out.println("4. Recomendación Aleatoria.");
			
			System.out.println("¿Quieres una recomendacion aleatoria?");
			
			char recomendacion = br.readLine().toLowerCase().charAt(0);
			
			if (recomendacion != 's') {
				System.out.println("Perfecto no quieres ninguna recomendacion.");
				
			}
			
			while (recomendacion == 's') {
				
			int adjetivos = (int) (Math.random()*5 +1);
				
			String Adjetivos = "";
				
				switch (adjetivos){
				
					case 1:
						Adjetivos = " Gran ";		
					break;
					
					case 2:
						Adjetivos = " Pequeño ";		
					break;
					
					case 3:
						Adjetivos = " Nuevo ";		
					break;
					
					case 4:
						Adjetivos = " Viejo ";		
					break;
					
					case 5:
						Adjetivos = " Último ";		
					break;
				
				}
				
				
			int sustantivos = (int) (Math.random()*5 +1);
				
			String Sustantivos = "";
				
				switch (sustantivos){
				
					case 1:
						Sustantivos = " Libro ";		
					break;
					
					case 2:
						Sustantivos = " Historia ";		
					break;
					
					case 3:
						Sustantivos = " Misterio ";		
					break;
					
					case 4:
						Sustantivos = " Aventura ";		
					break;
					
					case 5:
						Sustantivos = " Secreto ";		
					break;
				
				}
				
				System.out.println("El libro que te recomendamos es: " + Adjetivos + Sustantivos);
				System.out.println();
				
				System.out.println("¿Quieres alguna otra recomendacion?");
					recomendacion = br.readLine().toLowerCase().charAt(0);
			}
			
			
			
			break;
			
			case 5:
				
			salir = true;
			System.out.println("¡Feliz Lectura!");
			
			break;
			
			default:
			System.out.println("Opción no válida");
			}
			
			} while(!salir);
			
			
		
	}
	
}
