package Ejercicio6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Pelicula {

	private int id;
	
	private String titulo;
	
	private String genero;
	
	private double precio;
	
	private int entradas;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void pedirDatos() {
			
			do {
				id = Lecturas.leerEntero("Introduce el id de la pelicula.");
				
			}while(estaRepetido(id));
			
			titulo = Lecturas.leerString("Introduce el titulo de la pelicula");
			
			genero = Lecturas.leerString("Introduce el genero de la pelicula");
			
			precio = Lecturas.leerDoubleMayorQue("Introduce el precio de las entradas de la pelicula.", 0);
			
			entradas = Lecturas.leerEnteroMayorQue("Introduce el numero de las entradas que quedan.", 0);
		
	}
	
	private boolean estaRepetido(int id) {
		
		String linea;
		
			try {
				while((linea = br.readLine()) != null) {
					
					String[] datos = linea.split(";");
						int idFichero = Integer.parseInt(datos[0]);
						
					if(idFichero == id) {
						System.out.println("El id esta repetido.");
								return true;
					}
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return false;

	}
	
	public void escribirFichero() {
		try {
			
			File f = new File("./peliculas.txt");
			
			if(f.exists()) {
				
				FileWriter fw = new FileWriter(f, true);
					PrintWriter pw = new PrintWriter(fw);
				
				pw.println(id + ";" + titulo  + ";" + genero + ";" + precio + ";" + entradas);
				
			pw.flush();
			pw.close();
			fw.close();
				
			} else {
				System.err.println("No se ha encontrado el fichero.");
			}
			
		}catch(IOException e) {
			System.err.println("Ha ocurrido un error.");
			e.printStackTrace();
		}
	}
	
	
	public void leerLineaPelicula(String linea) {
		
		String[] datos = linea.split(";");
		
		id = Integer.parseInt(datos[0]);
		
		titulo = datos[1];
		
		genero = datos[2];
		
		precio = Double.parseDouble(datos[3]);
		
		entradas = Integer.parseInt(datos[4]);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getEntradas() {
		return entradas;
	}

	public void setEntradas(int entradas) {
		this.entradas = entradas;
	}
	
}
