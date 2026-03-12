package Ejercicio_Examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Candidatos {

	private int idCandidato;
	
	private String nombreCandidato;
	
	private String partidoCandidato;
	
	private long numeroVotos;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	//Opcion 1.
	public void pedirDatos() throws IOException {
		
		do {
			this.idCandidato = Lecturas.leerEntero("Escribe cual es el id del candidato");
			
		}while(idRepetido(idCandidato));
		
		this.nombreCandidato = Lecturas.leerString("Escribe el nombre del Candidato");
		
		this.partidoCandidato = Lecturas.leerOpcion("Escribe el partido que representa el candidato: (Alianza Java Enterprise o Partido JavaScriptero o P.C.D o Movimiento IA First)", new String[]{"Alianza Java Enterprise", "Partido JavaScriptero", "P.C.D", "Movimiento IA First"});
		
		this.numeroVotos = Lecturas.leerEnteroMayorQue("Escribe la cantidad de votos que ha obtenido el candidato: ", 0);
	}
	
	protected static boolean idRepetido(int id) throws IOException {
		boolean enc = false;
		File archivo_candidatos = new File("candidatos.txt");

		if (archivo_candidatos.exists()) {
			FileReader fr = new FileReader(archivo_candidatos);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();

			while (linea != null && enc == false) {
				
				String[] datos = linea.split("-");
				
				int id_leido = Integer.parseInt(datos[0].trim());

				if (id == id_leido) {
					enc = true;
					System.out.println("ID Repetido");
				}

				linea = br.readLine();
			}

			br.close();
			fr.close();
		}

		return enc;
	}
	
	public void escribirFichero() {
		
			try {
				File f = new File("candidatos.txt");
				
				FileWriter fw = new FileWriter(f, true);
				
				PrintWriter pw = new PrintWriter(fw);
				
			pw.println(this.idCandidato + "-" + this.nombreCandidato + "-" + this.partidoCandidato + "-" + this.numeroVotos);
				
			pw.flush();
			pw.close();
			fw.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	//Opcion 2.
	public void splitLineaCandidatos(String linea) {
		
		String[] datos = linea.split("-");
		
		this.idCandidato = Integer.parseInt(datos[0].trim());
		this.nombreCandidato = datos[1].trim();
		this.partidoCandidato = datos[2].trim();
		this.numeroVotos = Long.parseLong(datos[3].trim());
		
	}

	public int getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}

	public String getNombreCandidato() {
		return nombreCandidato;
	}

	public void setNombreCandidato(String nombreCandidato) {
		this.nombreCandidato = nombreCandidato;
	}

	public String getPartidoCandidato() {
		return partidoCandidato;
	}

	public void setPartidoCandidato(String partidoCandidato) {
		this.partidoCandidato = partidoCandidato;
	}

	public long getNumeroVotos() {
		return numeroVotos;
	}

	public void setNumeroVotos(long numeroVotos) {
		this.numeroVotos = numeroVotos;
	}
	
	
}
