package Ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio5 {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	//Apartado1.
	public static void rellenarLibros(String [] autores, int [][] matrizPrestamos, String [] titulo) throws IOException {
		
		//Recorrer libros Titulos.
		
		String titulosTotales = "";
		
		for (int i = 0; i < titulo.length; i++) {
			
			System.out.println("Escribe el titulo del " + (i+1) + "º libro:");
				String tituloLibro = br.readLine();
				
				titulo[i] = tituloLibro;
				
				String titulosSuma = "";
				
				titulosSuma += titulo[i];
				
				titulosTotales += titulosSuma + ", ";
		}
		
		
		//Recorrer libros Autores
		
		String autoresTotales = "";
		
		for (int j = 0; j < autores.length; j++) {
			
			System.out.println("Escribe el autor del " + (j+1) + "º libro.");
				String autorLibro = br.readLine();
				
				autores[j] = autorLibro;
				
				String autoresSuma = "";
				
				autoresSuma += autores[j] + ", ";
				
				
				autoresTotales += autoresSuma;
				
		}
		
		System.out.println("Los autores de los libros seleccionados son: " + autoresTotales + " y los titulos de los libros son: " + titulosTotales);
		
	}
	
	//Apartado2.
	public static void registrarPrestamos(String [] autores, int [][] matrizPrestamos, String [] titulo) throws IOException {
			
		boolean noEncontrado = false;
		
		//Recorre el autor
		
		System.out.println("Introduce el nombre del autor:");
			String nombreAutor = br.readLine();
			
			int posicionAutores = -1;
			
		for( int i = 0; i < autores.length; i++) {
			
			if (nombreAutor.equalsIgnoreCase(autores[i])) {
				System.out.println("El autor seleccionado es: " + nombreAutor);
				
				posicionAutores = i;
				
			}
			
		}
		
		if (posicionAutores == -1) {
			System.err.println("Lo siento pero el autor seleccionado no esta en la lista.");
			noEncontrado = true;
		}
		
		//Recorre Titulos
		
		System.out.println("Introduce el nombre del titulo:");
		String nombreTitulos = br.readLine();
		
		int posicionTitulo = -1;
		
		for( int j = 0; j < titulo.length; j++) {
			
			if (nombreTitulos.equalsIgnoreCase(titulo[j])) {
				System.out.println("El titulo seleccionado es: " + nombreTitulos);
				
				posicionTitulo = j;	
			}
			
		}
		
		if (posicionTitulo == -1) {
			System.err.println("Lo siento pero el autor seleccionado no esta en la lista.");
			noEncontrado = true;
		}
		
		
		if (noEncontrado == true){
			System.err.println("Lo siento pero no se ha encontrado el libro que quiere registrar el prestamo.");
		
		}
		
		//Poner prestamos del libro en la Matriz
		
		if (posicionAutores != -1 && posicionTitulo != -1) {
			
			System.out.println("Escribe el número de veces que se ha prestado el libro " + titulo[posicionTitulo] + ", del autor " + autores[posicionAutores]);
			int numeroPrestamos = Integer.parseInt(br.readLine());
			
			while (numeroPrestamos < 0) {
				System.err.println("Lo siento pero el numero de veces no puede ser negativo. Escribe un numero correcto.");
				numeroPrestamos = Integer.parseInt(br.readLine());
				
			}
			
			matrizPrestamos[posicionAutores][posicionTitulo] = numeroPrestamos;
			
			System.out.println("Resgistro de prestamos realizado.");
		
		} 
		
		
			
		}
	
		
	//Apartado3.
	public static void mostrarTabla(String [] autores, int [][] matrizPrestamos, String [] titulo) throws IOException {
		
////////////////Tabla con titulos en las filas y autores en las columnas.
///		


		//Muestra la parte superior.
		
		System.out.print("\t\t");
			
		for(int i = 0; i < autores.length; i++) {
				System.out.print(autores[i] + "\t \t");
				
			}
		
		//Muestra la parte superior.
			
			System.out.println();
			
		for (int i = 0; i < titulo.length; i++) {
			
			System.out.print(titulo[i] + "\t \t");
			
			for (int j = 0; j < autores.length; j++) {
				
				System.out.print(matrizPrestamos[j][i] + "\t \t");	
			}
			
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
///
////////////////Tabla con titulos en las filas y autores en las columnas.

		
		
////////////////Tabla con autores en las filas y titulos en las columnas.
///		

		
		
		System.out.print("\t\t"); 

		for(int i = 0; i < titulo.length; i++) {
		    System.out.print(titulo[i] + "\t \t");
		}

		System.out.println();

		
		for (int i = 0; i < autores.length; i++) {

		    
		    System.out.print(autores[i] + "\t\t");

		    
		    for (int j = 0; j < titulo.length; j++) {
		        System.out.print(matrizPrestamos[i][j] + "\t\t");
		    }

		    System.out.println();
		}
	

///
////////////////Tabla con autores en las filas y titulos en las columnas.
			
		}
			
			
		
	//Apartado4.
	public static void bestSeller(String [] autores, int [][] matrizPrestamos, String [] titulo) throws IOException {
				
		for (int fila = 0; fila < matrizPrestamos.length; fila++) {
			
			for (int columna = 0; columna < matrizPrestamos[fila].length; columna++) {
				
				if(matrizPrestamos[fila][columna] > 35) {
					
					System.out.println("El libro " + titulo[fila] + ", del autor " + autores[columna] +  " es un Best Seller ya que se ha prestado " + matrizPrestamos[fila][columna]);
					
				}
				
			}
			
		}
		
		
			}
				
				
			
	
	//Ejercicio
public static void main(String[] args) throws IOException {
		
		String [] autores = new String [4];
		
		String [] titulo = new String [3];
		
		int [][] matrizPrestamos = new int [4][3];
		
		boolean salir = false;
		
		System.out.println("=== BIENVENIDO A [NOMBRE_APP] ===");
		
		do {
		
		//MOSTRAR MENU
		
		System.out.println("\n--- MENÚ PRINCIPAL ---");
		System.out.println("1. Rellenar arrays con titulo y autor");
		System.out.println("2. Registrar los prestamos.");
		System.out.println("3. Mostrar tabla");
		System.out.println("4. Libros Best-Seller");
		System.out.println("5. Salir");
		
		System.out.print("Elige una opción: ");
		int opcion = Integer.parseInt(br.readLine());
		
		switch (opcion) {
		
			case 1:
			System.out.println("1. Rellenar arrays con titulo y autor");
			
				rellenarLibros(autores, matrizPrestamos, titulo);
			
			break;
			
			case 2:
			System.out.println("2. Registrar los prestamos");
				
				registrarPrestamos(autores, matrizPrestamos, titulo);
				
			break;
				
			case 3:
			System.out.println("3. Tabla de Clasificación");
				
				mostrarTabla(autores, matrizPrestamos, titulo);
				
			break;
				
			case 4:
			System.out.println("4. Libros Best-Seller");
				
				bestSeller(autores, matrizPrestamos, titulo);
				
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
