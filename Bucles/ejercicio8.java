package ejerciciosFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio8 {
//Ejercicio Adrian
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

			System.out.println("¿Podrias decirme el titulo del libro?");
				String titulo = br.readLine();
				
			System.out.println("¿Cuál ha sido su año de publicación?");
				String añoPublicacion = br.readLine();
				
			System.out.println("¿Cuál es su genero?");
				String generoLibro = br.readLine();
				
			String codigoEstanteria = generoLibro.toUpperCase() + añoPublicacion.substring (2) + titulo.charAt(0); 

			System.out.println("El codigo de la estanteria donde se encuentra este libro es: " + codigoEstanteria);
			
			
			System.out.println("Cuantas paginas tiene tu libro?");
				int paginasLibro = Integer.parseInt(br.readLine());
				
			int tiempoLectura = paginasLibro * 2;
			
			int horas = tiempoLectura / 60;
			int minutos = tiempoLectura % 60;
			
			
			System.out.println("El tiempo estimado de lectura son: " + tiempoLectura + " minnutos, es decir que serán " + horas + " horas y " + minutos +" minutos.");
			
			break;
			
			case 2:
			System.out.println("2. Sesion de Lectura");
			
			System.out.println("¿Cuantos capitulos tiene tu libro?");
				int capitulosLibro = Integer.parseInt(br.readLine());
				
				int paginasLeidas = 1;
				int paginasLeidasTotales = 0;
					
				int capitulosTotalesLeidos = 0;
				
					for ( int i = 0; i < capitulosLibro && paginasLeidas != 0; i++) {
				System.out.println("¿Cuantas paginas te has leido del " + (i+1) + "º capitulo?");
						paginasLeidas = Integer.parseInt(br.readLine());
									
						paginasLeidasTotales += paginasLeidas;
						
						if (paginasLeidas != 0) {
							capitulosTotalesLeidos ++;
						}
					
					
					}
					
					System.out.println("No has acabado el capitulo.");
						
System.out.println("Te has leido " + capitulosTotalesLeidos + " capitulos y te has leido " + paginasLeidasTotales + " paginas.");
			
			
			break;
			
			case 3:
			System.out.println("3. Valorar Saga Completa");
			
				System.out.println("¿Puedes escribir el nombre de la saga de libros completa?");
			String sagaLibros = br.readLine();
			
				System.out.println("¿Cuantos libros tiene esta saga?");
			int numeroLibrosSaga = Integer.parseInt(br.readLine());
			
			double notaLibros = 0;
			double notaSaga = 0;
			double notaMediaSaga = 0;
			
			for ( int i = 0; i < numeroLibrosSaga; i++) {
				System.out.println("Escribe la nota del " + (i+1) + "º libro.");
				notaLibros = Double.parseDouble(br.readLine());
				
				if (notaLibros < 0 || notaLibros > 10) {
		System.out.println("Lo siento pero la nota introducida es invalida. \nRepita la nota.");
			notaLibros = Double.parseDouble(br.readLine());
					
				}
				
				System.out.println("La nota del " + (i+1) + "º libro es de: " + notaLibros);
				
				notaSaga += notaLibros;
			}
			notaMediaSaga = notaSaga / numeroLibrosSaga;
			
			System.out.println("La media de la saga es de: " + notaMediaSaga);
			
			if (notaMediaSaga > 8) {
				System.out.println("La saga es imprecindible");
				
			}else if (notaMediaSaga > 6 && notaMediaSaga < 8) {
				System.out.println("La saga es recomendable");
				
			} else {
				System.out.println("La saga es Prescindible.");
			}
		
				
			break;
			
			case 4:
			System.out.println("4. Recomendación Aleatoria.");
			
			System.out.println("¿Quieres una recomendación?");
			char recomendacion = br.readLine().toLowerCase().charAt(0);
			
		while (recomendacion == 's') {
			
			int adjetivos = (int) (Math.random()* 5 +1);
			
			String palabraAdjetivo = "";
			
			switch (adjetivos) {
			case 1:
				
				palabraAdjetivo = "Gran";
				
			break;
			
			case 2:
							
				palabraAdjetivo = "Pequeño";
				
			break;
			
			case 3:
	
				palabraAdjetivo = "Nuevo";
	
			break;

			case 4:
	
				palabraAdjetivo = "Viejo";
	
			break;

			case 5:
	
				palabraAdjetivo = "Último";
	
			break;
			
			}
			
			
		int sustantivos = (int) (Math.random()* 5 +1);
			
		String palabraSustantivo = "";
			
			switch (sustantivos) {
			case 1:
				
				palabraSustantivo = "Libro";
				
			break;
			
			case 2:
							
				palabraSustantivo = "Historia";
				
			break;
			
			case 3:
	
				palabraSustantivo = "Misterio";
	
			break;

			case 4:
	
				palabraSustantivo = "Aventura";
	
			break;

			case 5:
	
				palabraSustantivo = "Secreto";
	
			break;
			
			}
			
			int estrellas = (int) (Math.random()*5 +1);
			
			
			System.out.println("La recomendación es: " + palabraAdjetivo + " " + palabraSustantivo + " y tiene " + estrellas + " estrellas.");
			

			System.out.println("¿Quieres otra recomendación?");
				recomendacion = br.readLine().toLowerCase().charAt(0);
			
		}
		
		System.out.println("Buena elección, espero que te guste el libro.");
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

