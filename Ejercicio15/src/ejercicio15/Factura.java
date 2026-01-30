package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factura {

	private int id;
	
	private String cliente;
	
	private String[] conceptos = new String[3];
	
	private Double[] importes = new Double[3];
	
	private int numConceptos;
	
	private final double IVA = 0.21;
	
	private static int contadorId = 1;
	
	//------------------------------------------//
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void añadirConcepto(Factura[] facturas, int pos) {
		
		boolean datosOK = false;
		
		if(numConceptos <= conceptos.length) {
			
			do {
				try {	
						System.out.println("Añade el concepto que quieras:");
							conceptos[numConceptos] = br.readLine();
						
						System.out.println("Añade el importe del concepto: " + conceptos[numConceptos]);
							importes[numConceptos] = Double.parseDouble(br.readLine());
					
				} catch (NumberFormatException | IOException e) {
					
					e.getStackTrace();
				}
					
					numConceptos++;
				
			}while(datosOK != true);	
		}
		
	}
	
	
	public void añadirNombreCliente(Factura[] facturas, int pos) throws IOException {
		
		try {
			
			if(numConceptos <= conceptos.length) {
				
				System.out.println("Escribe le nombre del cliente al que va dirigida la factura:");
				cliente = br.readLine();
				
			} else {
				System.out.println("El array ya esta completo.");
			}
			
			this.id = contadorId;
			contadorId++;
			
			System.out.println("El id de la factura es " + this.id);
			
			System.out.println("El nombre del cliente es " + cliente + " y su ID es " + this.id);
			
			
		} catch(IOException e) {
			e.getStackTrace();
			
		}	
		
	}


	public void verDesgloseFactura() {
		
		System.out.println("El desglose de la factura es del cliente " + cliente);
		
			for(int i = 0; i < numConceptos; i++) {
				
				System.out.println("El nombre del concepto es: " + conceptos[i] + " y el precio es: " + importes[i]);
			}
			
		System.out.println("El subtototal de las facturas del cliente " + cliente + " es de: " + calcularSubtotal());
		System.out.println("El IVA de esta factura es de: " + calcularIVA());
		System.out.println("El total de la factura es de: " + calcularTotalFinal());
		
	}
	
	
	public double calcularSubtotal() {
		
		double subtotalFactura = 0;
		
		for (int i = 0; i< numConceptos; i++) {
			
			subtotalFactura += importes[i];
			
		}
		
		return subtotalFactura;
	}
	
	
	public double facturaMasAlta() {
		
		double subtotalFactura = 0;
		
		for (int i = 0; i< importes.length; i++) {
			
			subtotalFactura += importes[i];
			
		}

			double IVAFactura = subtotalFactura * IVA;
		
		double totalFactura = subtotalFactura + IVAFactura;
		
			double facturaMasAlta = 0;
			
			for(double i = 0; i < numConceptos; i++) {
				
				if(importes[(int) totalFactura] > facturaMasAlta) {
					
					importes[(int) totalFactura] = facturaMasAlta;
				}
			}
			
			return facturaMasAlta;
	}
	
	
	//----------------- Getters -------------------------//
	
	private double calcularIVA() {
		
		return calcularSubtotal() * IVA;
	}
	
	
	public double calcularTotalFinal() {
		
			return calcularSubtotal() + calcularIVA();
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return conceptos[numConceptos];
	}
	
	
	
	
}
