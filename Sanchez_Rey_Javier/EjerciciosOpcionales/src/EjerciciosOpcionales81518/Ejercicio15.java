package EjerciciosOpcionales81518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Ejercicio15 {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	
  //Opcion1
    static void registrarEquipo(HashMap<String, Integer> equipos) throws IOException {
        System.out.print("Nombre del equipo: ");
        String nombre = br.readLine();

        if (equipos.containsKey(nombre)) {
            System.out.println("El equipo ya existe.");
        } else {
            equipos.put(nombre, 0);
            System.out.println("Equipo registrado con 0 victorias.");
        }
    }

    
  //Opcion2
    static void registrarVictoria(HashMap<String, Integer> equipos) throws IOException {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados.");
            return;
        }

        System.out.print("Nombre del equipo: ");
        String nombre = br.readLine();

        if (equipos.containsKey(nombre)) {
            equipos.put(nombre, equipos.get(nombre) + 1);
            System.out.println("Victoria registrada.");
        } else {
            System.out.println("El equipo no existe.");
        }
    }

    
  //Opcion3
    static void mostrarVictorias(HashMap<String, Integer> equipos) {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos.");
            return;
        }

        for (Entry<String, Integer> e : equipos.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue() + " victorias");
        }
    }

    
  //Opcion4
    static void mostrarEquipoGanador(HashMap<String, Integer> equipos) {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos.");
            return;
        }

        String ganador = "";
        int max = -1;

        for (Entry<String, Integer> e : equipos.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                ganador = e.getKey();
            }
        }

        System.out.println("Equipo ganador: " + ganador + " con " + max + " victorias");
    }

    
  //Opcion5
    static void comprobarExiste(HashMap<String, Integer> equipos) throws IOException {
        System.out.print("Nombre del equipo: ");
        String nombre = br.readLine();

        if (equipos.containsKey(nombre)) {
            System.out.println("El equipo existe.");
        } else {
            System.out.println("El equipo no existe.");
        }
    }

    
  //Opcion6
    static void eliminarEquipo(HashMap<String, Integer> equipos) throws IOException {
        System.out.print("Nombre del equipo: ");
        String nombre = br.readLine();

        if (equipos.remove(nombre) != null) {
            System.out.println("Equipo eliminado.");
        } else {
            System.out.println("El equipo no existe.");
        }
    }

    
  //Opcion7
    static void mostrarTotalPartidas(HashMap<String, Integer> equipos) {
        int total = 0;

        for (int v : equipos.values()) {
            total += v;
        }

        System.out.println("Total de partidas jugadas: " + total);
    }

    
  //Opcion8
    static void mostrarPorcentajes(HashMap<String, Integer> equipos) {
        int total = 0;

        for (int v : equipos.values()) {
            total += v;
        }

        if (total == 0) {
            System.out.println("No hay partidas jugadas.");
            return;
        }

        for (Entry<String, Integer> e : equipos.entrySet()) {
            double porcentaje = (e.getValue() * 100.0) / total;
            System.out.printf("%s: %.2f%%\n", e.getKey(), porcentaje);
        }
    }

    
  //Opcion9
    static void comprobarEmpate(HashMap<String, Integer> equipos) {
        if (equipos.size() < 2) {
            System.out.println("No hay suficientes equipos.");
            return;
        }

        boolean empate = false;

        for (String e1 : equipos.keySet()) {
            for (String e2 : equipos.keySet()) {
            	
                if (!e1.equals(e2) && equipos.get(e1).equals(equipos.get(e2))) {
                    empate = true;
                }
            }
        }

        System.out.println(empate ? "Hay empate." : "No hay empate.");
    }
    
    
    //Ejercicio 15    
    public static void main(String[] args) throws IOException {
        boolean salir = false;
        HashMap<String, Integer> equipos = new HashMap<>();

        do {
            System.out.println("\n--- GESTIÓN DE CALIFICACIONES ---");
            System.out.println("1. Registrar equipo");
            System.out.println("2. Registrar una victoria");
            System.out.println("3. Mostrar las victorias actuales de cada equipo");
            System.out.println("4. Mostrar el equipo ganador");
            System.out.println("5. Comprobar si un existe");
            System.out.println("6. Eliminar equipo");
            System.out.println("7. Mostrar total de partidas jugadas (total de victorias)");
            System.out.println("8. Comprobar si hay empate (dos o más con victorias iguales)");
            System.out.println("9. Salir");

            int opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
            case 1:
                registrarEquipo(equipos);
                break;
                
            case 2:
                registrarVictoria(equipos);
                break;
                
            case 3:
                mostrarVictorias(equipos);
                break;
                
            case 4:
                mostrarEquipoGanador(equipos);
                break;
                
            case 5:
                comprobarExiste(equipos);
                break;
                
            case 6:
                eliminarEquipo(equipos);
                break;
                
            case 7:
                mostrarTotalPartidas(equipos);
                break;
                
            case 8:
                mostrarPorcentajes(equipos);
                break;
                
            case 9:
                comprobarEmpate(equipos);
                break;
                
            case 10:
            	salir = true;
            	
                System.out.println("Programa finalizado.");
                break;
                
            default:
                System.out.println("Opción no válida.");
        }

        } while (!salir);
    }
    
}
