package Repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("¿Cuál es el importe de la compra?");
			double importeCompra = Double.parseDouble(br.readLine());
			
		System.out.println("¿Eres socio? S/N");
			char socio = br.readLine().toUpperCase().charAt(0);
			
		double compra = 0;
		
	if(importeCompra < 50 && socio == 'N') {
		compra = importeCompra;
	}else if (importeCompra < 50 && socio == 'S') {
		compra = importeCompra - (importeCompra * 0.05);
	} else if (importeCompra >= 50 && importeCompra < 100 && socio == 'N') {
		compra = importeCompra - (importeCompra * 0.10);
	} else if (importeCompra >= 50 && importeCompra < 100 && socio == 'S') {
		compra = importeCompra - (importeCompra * 0.15);
	}else if (importeCompra > 100 && socio == 'N') {
		compra = importeCompra - (importeCompra * 0.15);
	}else if (importeCompra > 100 && socio == 'S') {
		compra = importeCompra - (importeCompra * 0.20);
	}
	
	System.out.println("El importe a pagar será de: " + compra);
	
	}

}
