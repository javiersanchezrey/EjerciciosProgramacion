package Bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio54 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int codigoProducto = 0;
		int cantidadProducto = 0;
		double precio = 0;
		double precioTotal = 0;
		
		System.out.println("Escribe el código del producto.");
		codigoProducto = Integer.parseInt(br.readLine());

		while (codigoProducto != 0 ) {
			System.out.println("Escribe la cantidad que quieres del producto.");
			cantidadProducto = Integer.parseInt(br.readLine());
		System.out.println("Escribe el precio del producto.");
			precio = Double.parseDouble(br.readLine());
			
			System.out.println("El código del producto seleccionado es: " + codigoProducto + "\nLa cantidad del producto es: " + cantidadProducto + "\nEl precio del producto es: " + precio);
			
			double subTotal = precio * cantidadProducto;
				precioTotal += subTotal;
				
			System.out.println("Escribe el código del siguiente producto.");
			codigoProducto = Integer.parseInt(br.readLine());
		}
		
		System.out.println("Has terminado la compra. \nEl total que debes de pagar es " + precioTotal);
		
	}

}
