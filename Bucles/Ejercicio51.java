package Bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio51 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduzca el importe de la compra.");
			int importeCompra = Integer.parseInt(br.readLine());
		
		System.out.println("Introduzca el dinero entregado para pagar.");
			int dineroQueEntregamos =  Integer.parseInt(br.readLine());
		
		
			while (dineroQueEntregamos < importeCompra) {
				System.out.println("El dinero entregado no llega para pagar el importe de la compra.");
				
				System.out.println("Introduzca el dinero deseado para pagar.");
					dineroQueEntregamos =  Integer.parseInt(br.readLine());
			}
			
			int cantidadDevolver = dineroQueEntregamos - importeCompra;
			
			if (dineroQueEntregamos > importeCompra) {
				System.out.println("El dinero que has entregado supera el importe de la compra. \nTe cambio es de: " + cantidadDevolver);
				
				int cambioBilletes = 0;
				
				int num500 = 0;
				int num100 = 0;
				int num50 = 0;
				int num25 = 0;
				int num1 = 0;
				
				
				if (cantidadDevolver >= 500) {
					num500 = cantidadDevolver / 500;
						cantidadDevolver = cantidadDevolver % 500;
						
					System.out.println("El cambio serán " + num500 + " de 500 pesetas.");
				
				}
				
				if (cantidadDevolver >= 100) {
					num100 = cantidadDevolver / 100;
						cantidadDevolver = cantidadDevolver % 100;
						
					System.out.println("El cambio serán " + num100 + " de 100 pesetas.");
				} 
				
				if (cantidadDevolver >= 50) {
					num50 = cantidadDevolver / 50;
						cantidadDevolver = cantidadDevolver % 50;
					
					System.out.println("El cambio serán " + num50 + " de 50 pesetas.");
				} 
				
				if (cantidadDevolver >= 25) {
					num25 = cantidadDevolver / 25;
						cantidadDevolver = cantidadDevolver % 25;
					
					System.out.println("El cambio serán " + num25 + " de 25 pesetas.");
				}
				
				if (cantidadDevolver >= 1) {
					num1 = cantidadDevolver / 1;
						cantidadDevolver = cantidadDevolver % 1;
					
					System.out.println("El cambio serán " + num1 + " de 1 peseta.");
				}
				
			
			}
			
			if (dineroQueEntregamos == importeCompra) {
				System.out.println("El dinero entregado es el mismo que el del importe de la compra. \nTucambio es de: " + cantidadDevolver);
				
			}
	}

}
