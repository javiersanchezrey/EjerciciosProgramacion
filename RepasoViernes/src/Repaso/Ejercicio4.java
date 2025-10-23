package Repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Me podrías dar tus últimas 3 notas:");
	
	double nota1 = Double.parseDouble(br.readLine());
	double nota2 = Double.parseDouble(br.readLine());
	double nota3 = Double.parseDouble(br.readLine());
	
	double notaMedia = ((nota1 + nota2 + nota3)/3);
	
	
		if (notaMedia >= 5) {
			System.out.println("Tu nota media es: "+ notaMedia + " , y no tienes ninguna nota superior a un 7, lo siento pero Repites.");
		} else if (notaMedia < 5 && (nota1 >= 7 || nota2 >= 7 || nota3 >= 7)) {
			System.out.println("Tu nota media es: "+ notaMedia + " , puedes repetir algún examen para ver si apruebas.");
		} else if (notaMedia < 5 && (nota1 < 7 || nota2 < 7 || nota3 < 7)) {
			System.out.println("Tu nota media es: "+ notaMedia + " Has aprobado.");
		}
	
	}

}
