package Bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio53 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		String mejorAlumno = "";
		Double mejorMedia = 0.0;
		
		for (int i = 1; i <=3; i++) {
			
			System.out.println("Escriba el nombre del alumno.");
			
			String nombreAlumno = br.readLine();
			
			System.out.println("Escriba las notas de las siguientes asignaturas del alumno. \nProgramación:");
				double nota1 = Double.parseDouble(br.readLine());
				
				while (nota1 < 0 || nota1 > 10) {
					System.out.println("La nota que has puesto es incorrecta, debe ser entre un 0 y un 10.");
						nota1 = Double.parseDouble(br.readLine());
				}
				
			System.out.println("Bases de Datos:");
				double nota2 = Double.parseDouble(br.readLine());
				
				while (nota2 < 0 || nota2 > 10) {
					System.out.println("La nota que has puesto es incorrecta, debe ser entre un 0 y un 10.");
						nota2 = Double.parseDouble(br.readLine());
				}
				
			System.out.println("Entornos de Desarrollo:");
				double nota3 = Double.parseDouble(br.readLine());
				
				while (nota3 < 0 || nota3 > 10) {
					System.out.println("La nota que has puesto es incorrecta, debe ser entre un 0 y un 10.");
						nota3 = Double.parseDouble(br.readLine());
				}
			
			double mediaAlumno = (nota1 + nota2 + nota3) / 3;
			
			System.out.println("La nota media de " + nombreAlumno + ", es de " + mediaAlumno);
			
			if (mejorMedia < mediaAlumno) {
				mejorMedia = mediaAlumno;
				mejorAlumno = nombreAlumno;
			}
			
		}
		
		System.out.println("El alumno con mayor media de la clase es: " + mejorAlumno + ", y su media es de: " + mejorMedia);
		

		
	}

}
