package Modelo;

import java.time.LocalDate;

public class Tarea {

	private String nombreTarea;
	private String descripcion;
	private LocalDate fecha;
	private String estado;

	
	public Tarea(String nombreTarea, String descripcion, LocalDate fecha, String estado) {
		
		super();
		this.nombreTarea = nombreTarea;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.estado = estado;

	}


	public String getNombreTarea() {
		return nombreTarea;
	}


	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
