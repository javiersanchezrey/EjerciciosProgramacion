package Repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio9 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	System.out.println("Necesito que escriba cuál es el consumo que tiene.");
		int kilowatios = Integer.parseInt(br.readLine());
		
	System.out.println("¿Es usted un cliente de hace más de 5 años?");
		char antiguedad = br.readLine().toLowerCase().charAt(1);
		
	System.out.println("¿Tiene usted contratado tarifa nocturna?");
		char tarifa = br.readLine().toLowerCase().charAt(1);
		
		double coste = 0;
		
		if (kilowatios == 100 && antiguedad == 'S' && tarifa == 'S') {
			coste = ((kilowatios * 0.10) - (kilowatios * 0.15)) - 5;
		System.out.println("El coste de " + kilowatios + " kilowatios es de " + coste + " €,con el descuento de la tarifa nocturna y la antiguedad");
		
		} else if (kilowatios == 100) {
			coste = kilowatios * 0.10;
		System.out.println("El coste de " + kilowatios + " kilowatios es de " + coste + " €,sin tarifa nocturna, ni antiguedad");
	
	
	}

}
}