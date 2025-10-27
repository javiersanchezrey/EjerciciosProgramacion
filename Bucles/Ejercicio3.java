package EjerciciosBucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int dineroAIngresar = 0;
		int dineroEnCuenta = 0;
		
		int retiradaDinero = 0;
		
		char videojuego;
		
		boolean salir = false;
		
		System.out.println("=== BIENVENIDO A Tu Banco de Confianza ===");
		
		do {
		
			System.out.println("\n--- MENÚ PRINCIPAL ---");
			System.out.println("1. Ingresar Dinero");
			System.out.println("2. Retirar Dinero");
			System.out.println("3. Consultar Saldo Actual");
			System.out.println("4. ¿Saldo Suficiente?");
			System.out.println("5. Ahorro Mensual");
			System.out.println("6. Salir");
			System.out.print("Elige una opción: ");
		
		int opcion = Integer.parseInt(br.readLine());
		
		switch (opcion) {
		
		case 1:
		System.out.println("1. Ingresar Dinero");
		
			System.out.println("¿Cuánto dinero deseas ingresar?");
			dineroAIngresar = Integer.parseInt(br.readLine());
				dineroEnCuenta += dineroAIngresar;
			
			System.out.println("Has ingresado " + dineroAIngresar + " €. \nTu saldo actual es de: " + dineroEnCuenta + " €.");
		
		break;
		
		case 2:
		System.out.println("2. Retirar Dinero");
		
		System.out.println("Actualmente tienes " + dineroEnCuenta);
		System.out.println("Introduce la cantidad de dinero que quires retirar.");
			retiradaDinero = Integer.parseInt(br.readLine());
			
		while (retiradaDinero > dineroEnCuenta) {
			System.out.println("Lo siento no puedes retirar " + retiradaDinero + " €, porque no tienes tanto dinero en la cuenta.");
			
			System.out.println("¿Desea sacar menos dinero de su cuenta?");
				retiradaDinero = Integer.parseInt(br.readLine());
		}  
		
		if (dineroEnCuenta >= retiradaDinero) {
			System.out.println("Retirando " + retiradaDinero + " de su cuenta.");
			
		}
		
		dineroEnCuenta -= retiradaDinero;
		
		System.out.println("Tu salario actual es de: " + dineroEnCuenta + " €.");
		
		break;
		
		case 3:
		System.out.println("3. Consultar Saldo Actual");
		
		System.out.println("El saldo que tienes actualmente en la cuenta es de: " + dineroEnCuenta);
		
		break;
		
		case 4:
		System.out.println("4. ¿Saldo Suficiente?");
			
		System.out.println("Tu saldo actual es de: " + dineroEnCuenta);
		
		System.out.println("El videojuego vale 60€ ¿Te lo puedes llegar a comprar? S/N");
			videojuego = br.readLine().toLowerCase().charAt(0);
		
			if (videojuego == 's') {
				int dineroVideojuego = 60;
				
				int saldoCuenta = dineroEnCuenta - dineroVideojuego;
				
				System.out.println("Perfecto, despues de la compra del videojugo tendrás " + saldoCuenta);
			
			} else {
				System.out.println("Lo siento pero no tienes suficiente saldo en la cuenta como para comprar el videojuego.");
			
			}
		
		break;
		
		case 5:
			System.out.println("5. Ahorro Mensual");
			
			System.out.println("¿CUánto dinero quieres ahorrar mensualmente?");
				int dineroAhorro = Integer.parseInt(br.readLine());
				
				System.out.println("Y durante cuantos meses quieres ahorrar?");
				int mesesAhorro = Integer.parseInt(br.readLine());
				
				System.out.println("Vas a ahorrar " + dineroAhorro + "€, durante " + mesesAhorro + " meses.");
			
				System.out.println("--- Simulación de Ahorro ---");
				
				
				
				for (int i = 0; i < mesesAhorro; i++) {
				
					dineroEnCuenta += dineroAhorro;
					System.out.println("Para el mes " + (i+1) + " El ahorro es de " + dineroEnCuenta);
					
				}
			
			break;
		
		case 6:
			salir = true;
		System.out.println("¡Hasta luego!");
			break;
			
		default:
			
			System.out.println("Opción no válida");
			
		}
		
		}while(!salir);
	
	
		}


}


