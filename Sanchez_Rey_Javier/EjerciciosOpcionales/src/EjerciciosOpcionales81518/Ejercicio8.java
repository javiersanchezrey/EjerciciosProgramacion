package EjerciciosOpcionales81518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ejercicio8 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	
    // Opción 1
    public static void opcion1(ArrayList<Double> calificaciones) throws IOException {
        System.out.println("---- Añadir calificación ----");
        System.out.println("Introduce una calificación (0-10): ");
        double calificacion = Double.parseDouble(br.readLine());

        if (calificacion >= 0 && calificacion <= 10) {
            calificaciones.add(calificacion);
            System.out.println("Calificación añadida.");
            
        } else {
            System.err.println("Error: la calificación debe estar entre 0 y 10.");
        }
    }

    
    // Opción 2
    public static void opcion2(ArrayList<Double> calificaciones) throws IOException {
        System.out.println("---- Eliminar calificación por posición ----");
        opcion3(calificaciones);

        System.out.println("Introduce la posición a eliminar: ");
        int posicion = Integer.parseInt(br.readLine());

        if (posicion > 0 && posicion <= calificaciones.size()) {
            calificaciones.remove(posicion - 1);
            System.out.println("Calificación eliminada.");
        } else {
            System.err.println("Posición no válida.");
        }
    }

    
    // Opción 3
    public static void opcion3(ArrayList<Double> calificaciones) {
        System.out.println("--- Mostrar calificaciones ---");
        
        if (calificaciones.isEmpty()) {
            System.out.println("No hay calificaciones.");
            
        } else {
        	
            for (int i = 0; i < calificaciones.size(); i++) {
                System.out.println((i + 1) + ". " + calificaciones.get(i));
            }
        }
    }

    
    // Opción 4
    public static void opcion4(ArrayList<Double> calificaciones) {
        System.out.println("--- Calcular media ---");
        
        if (calificaciones.isEmpty()) {
            System.out.println("No hay calificaciones.");
            
        } else {
            double suma = 0;
            for (double c : calificaciones) {
                suma += c;
            }
            
            System.out.println("Media: " + (suma / calificaciones.size()));
        }
    }

    
    // Opción 5
    public static void opcion5(ArrayList<Double> calificaciones) {
        System.out.println("--- Calificaciones aprobadas ---");
        int aprobados = 0;

        for (double c : calificaciones) {
            if (c >= 5) {
                aprobados++;
            }
        }
        
        System.out.println("Número de aprobados: " + aprobados);
    }

    
    // Opción 6
    public static void opcion6(ArrayList<Double> calificaciones) {
        System.out.println("--- Máxima y mínima calificación ---");
        
        if (calificaciones.isEmpty()) {
            System.out.println("No hay calificaciones.");
            
        } else {
        	
            double max = calificaciones.get(0);
            double min = calificaciones.get(0);

            for (double c : calificaciones) {
                if (c > max) max = c;
                if (c < min) min = c;
            }

            System.out.println("Máxima: " + max);
            System.out.println("Mínima: " + min);
        }
    }

    
    // Opción 7
    public static void opcion7(ArrayList<Double> calificaciones) {
    	System.out.println("--- Calificaciones por encima de la media ---");
        
        if (calificaciones.isEmpty()) {
            System.out.println("No hay calificaciones.");
            
        } else {
            double suma = 0;
            for (double c : calificaciones) {
                suma += c;
            }
            double media = suma / calificaciones.size();

            int contador = 0;
            for (double c : calificaciones) {
                if (c > media) {
                    contador++;
                }
            }
            
            System.out.println("Hay " + contador + " calificaciones por encima de la media.");
        }
    }

    
    // Opción 8
    public static void opcion8(ArrayList<Double> calificaciones) throws IOException {
        System.out.println("--- Modificar calificación ---");
        opcion3(calificaciones);

        System.out.println("Introduce la posición que quieras modificar: ");
        int posicion = Integer.parseInt(br.readLine());

        if (posicion > 0 && posicion <= calificaciones.size()) {
            System.out.println("Introduce la nueva calificación: ");
            double nueva = Double.parseDouble(br.readLine());

            if (nueva >= 0 && nueva <= 10) {
                calificaciones.set(posicion - 1, nueva);
                System.out.println("La calificación ha sido modificada.");
            } else {
                System.err.println("La calificación que has seleccionado es inválida.");
            }
        } else {
            System.err.println("Posición incorrecta.");
        }
    }

    
    
    // Ejercicio 8
    public static void main(String[] args) throws IOException {
        boolean salir = false;
        ArrayList<Double> calificaciones = new ArrayList<>();

        do {
            System.out.println("\n--- GESTIÓN DE CALIFICACIONES ---");
            System.out.println("1. Añadir calificación");
            System.out.println("2. Eliminar calificación por posición");
            System.out.println("3. Mostrar calificaciones");
            System.out.println("4. Calcular media");
            System.out.println("5. Mostrar aprobados");
            System.out.println("6. Mostrar máxima y mínima");
            System.out.println("7. Contar calificaciones por encima de la media");
            System.out.println("8. Modificar calificación");
            System.out.println("9. Salir");

            int opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1: 
                	opcion1(calificaciones); 
                break;
                
                case 2: 
                	opcion2(calificaciones);
                break;
                
                case 3: 
                	opcion3(calificaciones); 
                break;
                
                case 4: 
                	opcion4(calificaciones); 
                break;
                
                case 5: 
                	opcion5(calificaciones); 
                break;
                
                case 6: 
                	opcion6(calificaciones); 
                break;
                
                case 7: 
                	opcion7(calificaciones); 
                break;
                
                case 8: 
                	opcion8(calificaciones); 
                break;
                
                case 9:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                    
                default:
                    System.err.println("Opción no válida.");
            }

        } while (!salir);
    }
}
