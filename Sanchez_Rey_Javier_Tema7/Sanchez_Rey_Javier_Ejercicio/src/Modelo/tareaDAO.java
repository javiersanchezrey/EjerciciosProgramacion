package Modelo;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class tareaDAO {

	private ObservableList<Tarea> lista = FXCollections.observableArrayList();
	
	public ObservableList<Tarea> getLista(){	
		
		return lista;
	}
	
	
	public void añadirTarea(Tarea tareaAAñadir) {
		
		lista.add(tareaAAñadir);
	}
	
	
	public void borrarTarea(Tarea tareaBorrar) {
		
		lista.remove(tareaBorrar);
	}
	
	
	public void actualizarTarea(Tarea tarea, String nombreTarea, String descripcion, LocalDate fecha, String estado) {
		
		tarea.setNombreTarea(nombreTarea);
		tarea.setDescripcion(descripcion);
		tarea.setFecha(fecha);
		tarea.setEstado(estado);
	}
}
