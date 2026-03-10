package Ejercicio6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

		private static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		public static void main(String[] args) throws IOException {

				boolean salir = false;
				do {
					System.out.println("\n=== CINE ===");
					System.out.println("1. Añadir una nueva pelicula");
					System.out.println("2. Realizar una venta de entradas");
					System.out.println("3. Mostrar pelicula más vendida y recaudacion total");
					System.out.println("4. Mostrar listado por genero de Pelicula");
					System.out.println("5. Salir");
					System.out.print("Introduce una opción: ");

					int opcion = -1;
					boolean datosOK = false;
					while (!datosOK) {
						try {
							opcion = Integer.parseInt(leer.readLine());
							datosOK = true;
						} catch (IOException e) {
							System.err.println("Solo puedes introducir números");
						}
					}

					switch (opcion) {
					case 1:
						System.out.println("=== Añadir una nueva pelicula ===");
							añadirPelicula();
						break;
					case 2:
						System.out.println("=== Realizar una venta de entradas ===");
							realizarVentaEntradas();
						break;
					case 3:
						System.out.println("=== Mostrar pelicula más vendida y recaudacion total ===");
							peliculaMasVendida();
						break;
					case 4:
						System.out.println("=== Mostrar listado por genero de Pelicula ===");
							mostrarListadoPorGenero();
						break;
					case 5:
						System.out.println("Salir");
						salir = true;
						break;
					default:
						System.out.println("Opción no válida");
					}

				} while (!salir);
			}


		private static void añadirPelicula() {
			Pelicula pelicula = new Pelicula();
			
				pelicula.pedirDatos();
					pelicula.escribirFichero();
		}
		
		
		private static void realizarVentaEntradas() throws IOException {
			
			File archivoPeliculas = new File("peliculas.txt");
			
			if(archivoPeliculas.exists()) {
				
				Ventas venta = new Ventas();
					
				venta.pedirVentas();
				
				
				File archivoTemporal = new File("peliculas_temp.txt");
				
					FileWriter fw = new FileWriter(archivoTemporal, false);
					PrintWriter pw = new PrintWriter(fw);
				
					FileReader fr = new FileReader(archivoPeliculas);
						BufferedReader bf = new BufferedReader(fr);
						
						
				boolean peliculaEncontrada = false;
				
					String linea = bf.readLine();
					
				while(linea != null) {
					
					Pelicula pelicula = new Pelicula();
						
						pelicula.leerLineaPelicula(linea);
						
					if(pelicula.getId() == venta.getIdPelicula()) {
						peliculaEncontrada = true;
						
							if(pelicula.getEntradas() >= venta.getEntradasVendidas()) {
								
								int entradasActualizadas = pelicula.getEntradas() - venta.getEntradasVendidas();
								
									pelicula.setEntradas(entradasActualizadas);
									
								double precioTotal = pelicula.getPrecio() * venta.getEntradasVendidas();
								
									venta.setPrecioTotal(precioTotal);
									
									System.out.println("Compra realizada correctamente.");
										System.out.println("El precio a pagar es de: " + precioTotal);
								
							} else {
								System.err.println("Las entradas para la pelicula " + pelicula.getTitulo() +  " se han agotado.");
							}
						
						pw.println(pelicula.getId() + ";" + pelicula.getTitulo() + "," + pelicula.getGenero() + ";"
								+ pelicula.getPrecio() + ";" + pelicula.getEntradas());
					}
					
					linea = bf.readLine();
				}
				
				fw.flush();
				fw.close();
				
				pw.close();
				
				fr.close();
				
				bf.close();
				
				if (peliculaEncontrada) {
					venta.escribirEntrada();
					
					if (archivoPeliculas.delete()) {
						archivoTemporal.renameTo(archivoPeliculas);
						
					} else {
						System.out.println("Error al actualizar el archivo de películas.");
					}

				} else {
					System.out.println("No se encontró la película con ID " + venta.getIdPelicula());
				}
				
					
			}else {
				System.err.println("No se ha encontrado el fichero.");
			}
			
		}
		
		
		private static void peliculaMasVendida() throws IOException {
				
				Ventas ventas = new Ventas();
				
				ventas.entradasVendidasPorPeliculas();
		}
		
		
		private static void mostrarListadoPorGenero() throws IOException {
			
			Ventas ventas = new Ventas();
			
				ventas.mostrarListadoPorGenero();
			
		}
}
