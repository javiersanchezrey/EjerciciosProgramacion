package Ejercicio6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Ventas {

	private int idPelicula;
	
	private int entradasVendidas;
	
	private double precioTotal;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void pedirVentas() {
		
		idPelicula = Lecturas.leerEntero("Escribe el id de la pelicula");
		
		entradasVendidas = Lecturas.leerEnteroMayorQue("Escribe la cantidad de entradas que quieres", 0);
		
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public int getEntradasVendidas() {
		return entradasVendidas;
	}

	public void setEntradasVendidas(int entradasVendidas) {
		this.entradasVendidas = entradasVendidas;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public void escribirEntrada() throws IOException {
		File archivoVentas = new File("ventas.txt");
		FileWriter fw = new FileWriter(archivoVentas, true);
		PrintWriter pw = new PrintWriter(fw);

		pw.println(this.idPelicula + ";" + this.entradasVendidas + ";" + this.precioTotal);

		pw.flush();
		pw.close();
	}
	
	
	public void entradasVendidasPorPeliculas() throws IOException {
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ArrayList<Integer> entradasTotales = new ArrayList<Integer>();
		ArrayList<Double> recaudacion = new ArrayList<Double>();
		
		File ventas = new File("ventas.txt");
			FileReader fr = new FileReader(ventas);
			
			BufferedReader bf = new BufferedReader(fr);
			
			String linea = bf.readLine();
			
			while(linea != null) {
				
				String[] datos = linea.split(";");
				
					idPelicula = Integer.parseInt(datos[0]);
					entradasVendidas = Integer.parseInt(datos[1]);
					precioTotal = Double.parseDouble(datos[2]);
					
					int index = ids.indexOf(idPelicula);
					
						if(index != -1) {
							entradasTotales.set(index, entradasTotales.get(index) + entradasVendidas);
							recaudacion.set(index, recaudacion.get(index) + precioTotal);
							
						}else {
							ids.add(idPelicula);
							entradasTotales.add(entradasVendidas);
							recaudacion.add(precioTotal);
						}
						
				linea = bf.readLine();
			}
			
			bf.close();
			
			int maxEntradas = 0;
			double recaudacionTotal = 0;
			int idPeliculaMasVendida = -1;
			
			for(int i = 0; i < ids.size(); i++) {
				
				if(entradasTotales.get(i) > maxEntradas) {	
					maxEntradas = entradasTotales.get(i);
					recaudacionTotal = recaudacion.get(i);
					idPeliculaMasVendida = ids.get(i);
				}
			}
			
			System.out.println("La pelicula mas taquillera a sido: " + idPeliculaMasVendida);
			System.out.println("Ha tenido unos ingresos de: " + recaudacionTotal);
			System.out.println("Ha vendido " + maxEntradas + " entradas.");
		
	}
	
	public void mostrarListadoPorGenero() throws IOException {
			
			ArrayList<Integer> ids = new ArrayList<Integer>();
			ArrayList<String> generos = new ArrayList<String>();
			
				File peliculas = new File("peliculas.txt");
			
					FileReader fr = new FileReader(peliculas);
					
						BufferedReader bfPeliculas = new BufferedReader(fr);
						
					String linea = bfPeliculas.readLine();
			
				while(linea != null) {
					
					String[] datos = linea.split(";");
					
					ids.add(Integer.parseInt(datos[0])); 
					generos.add(datos[2]);
					
					linea = bfPeliculas.readLine();
				}
			bfPeliculas.close();
			
				ArrayList<String> generoUnico = new ArrayList<String>();
				ArrayList<Double> recaudacionTotal = new ArrayList<Double>();
		
				File ventas = new File("ventas.txt");
				
					FileReader fr2 = new FileReader(ventas);
					
						BufferedReader bfVentas = new BufferedReader(fr2);
						
						String linea2 = bfVentas.readLine();
						
					while(linea2 != null) {
						
						String[] datos = linea2.split(";");
						
						idPelicula = Integer.parseInt(datos[0]);
						
						precioTotal = Double.parseDouble(datos[2]);
						
						String genero = "";
						
						for(int i = 0; i < ids.size(); i++) {
							
							if(ids.get(i) == idPelicula) {
								
								genero = generos.get(i);
							}
						}
						
						int index = generoUnico.indexOf(genero);
						
						if(index != -1) {
							
							recaudacionTotal.set(index, recaudacionTotal.get(index) + precioTotal);
							
						}else {
							generoUnico.add(genero);
							recaudacionTotal.add(precioTotal);
						}
						
						
						linea = bfVentas.readLine();
					}
					bfVentas.close();
						
					 System.out.println("Recaudación por género:");
					    for (int i = 0; i < generoUnico.size(); i++) {
					        System.out.println(generoUnico.get(i) + ": " + recaudacionTotal.get(i) + "€");
					    }
						
		}
}
