package RepasoEjercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Operadores {

	public static void main(String[] args) throws IOException {
		//EJERCICIO 5.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("Introduce tu peso: ");
				String pesoIMC =br.readLine();
		
				int peso = Integer.parseInt(pesoIMC);
		
		System.out.println("Introduce tu Altura: ");
				String alturaIMC = br.readLine();
				
				double altura = Double.parseDouble(alturaIMC);
			
		double IMC = peso / (altura*2);
		
		System.out.println("El Indice de Masa Corporal es: " + IMC);
		
		
		
		//EJERCICIO 6.
				System.out.println();
		
				
			System.out.println("Elige un radio para el circulo: ");
				String radioElección = br.readLine();
		double radio1 = Double.parseDouble(radioElección);
				
		double área = Math.PI * (radio1*radio1);
		
		double circunferencia = 2 * Math.PI * radio1;

		System.out.println("El Área del circulo es: " + área + " y la circunferencía será: " + circunferencia);
		
		
		//EJERCICIO 7.
				System.out.println();
		
		System.out.println("Elige un radio para formar el área y volumen de un cilindro.");
				
			String CilindroRadio = br.readLine();
				double radioCilindro = Double.parseDouble(CilindroRadio);
				
				System.out.println("Elige una Altura para formar el área y volumen de un cilindro.");

			String Cilindroaltura = br.readLine();
				double alturaCilindro = Double.parseDouble(Cilindroaltura);
 
				double volumen = Math.PI * radioCilindro * radioCilindro * alturaCilindro;
					double areaCilindro = 2 * Math.PI * radioCilindro * alturaCilindro;
		
		System.out.println("El volumen de cilindro será : " + volumen + " y el área será: " + areaCilindro);
		
		
		//EJERCICIO 8.
			System.out.println();
			
		System.out.println("¿Cual es tu peso?");
		
		
		
			String pesoLibras = br.readLine();
				double Libras = Double.parseDouble(pesoLibras);
				
				double pesoFinal = Libras * 0.4535;
				
				System.out.println("Tu peso en libras es " + pesoFinal);
				
				
		//EJERCICIO 9.				NO RESUELTO PREGUNTAR EN CLASE
				
				
			String numeroMinutos = br.readLine();
				int minutos = Integer.parseInt(numeroMinutos);
			
			String numeroAños = br.readLine();
				int Años = Integer.parseInt(numeroAños);				
			
			String numeroDias = br.readLine();
				int Dias = Integer.parseInt(numeroDias);
			
			String minutosEnAno1 = br.readLine();
				int minutosEnAno = 60 * 24 * 365;
				
				
				Años =(minutos / minutosEnAno);
				
				
				//NO RESUELTO PREGUNTAR EN CLASE.
		
		//EJERCICIO 10.
				System.out.println();
				
		System.out.println("¿Me puedes decir una distancia en Kilometros?");
		
			String kilometros = br.readLine();
				double metros = Double.parseDouble(kilometros);
				
				double resultadoMetros = metros * 1000;
				
				
					double centimetros = Double.parseDouble(kilometros);
				
					double resultadoCentimetros = centimetros * 100000;
				
				
						double millas = Double.parseDouble(kilometros);
				
						double resultadoMillas = millas / 0.621371;
				
			
			System.out.println("La distancia indicada son " + resultadoMetros + " metros, y también son  " + resultadoCentimetros + " y también son " + resultadoMillas + " millas.");
		
		
			
		//EJERCICIO 11.
			System.out.println();
			
		System.out.println("Necesito que selecciones 2 numeros, los que mas te gusten.");
		
			String numero1 = br.readLine();
				double num1 = Double.parseDouble(numero1);
				
			String numero2 = br.readLine();
				double num2 = Double.parseDouble(numero2);
				
				
			double suma = (num1 + num2);
				double resta = (num1 - num2);
					double multiplicacion = (num1 * num2);
						double division = (num1 / num2);

			System.out.println("Se van a realizar operaciones con los números 						seleccionados,"+ num1 +" " + num2 + "La suma de estos números dá: " + suma + 			"/n La resta: " + resta + "/n La Multiplicación " + multiplicacion + "/n La 				división da: " + division);
		
		
		
		
		
		
		
		
				
		
	}

}
