package Repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio6 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Me podrías decir cuál es tu nota de acceso?");
	double nota = Double.parseDouble(br.readLine());
	
		System.out.println("¿Eres Familia Numerosa?");
	char familiaNumerosa = br.readLine().toLowerCase().charAt(0);
	
		if (nota > 9 && nota < 10) {
			System.out.println("La matricula es gratutita.");
			
		} else if (nota >7 && nota < 8.99 && familiaNumerosa == 's'){
			System.out.println("Como era Familia Numerosa la matricula se te queda en 200€");
			
		} else if (nota >7 && nota < 8.99) {
			System.out.println("La matricula será de 300 €");
			
		} else if (nota >5 && nota < 6.99 && familiaNumerosa == 's')   {
			System.out.println("Como era Familia Numerosa la matricula se te queda en 400€");
			
		} else if (nota > 5 && nota < 6.99)  {
			System.out.println("La matricula será de 600 €");
			
		} else if (nota < 5) {
			System.out.println("Lo siento pero no puedes matricularte.");
		}
		
		
	}

}
