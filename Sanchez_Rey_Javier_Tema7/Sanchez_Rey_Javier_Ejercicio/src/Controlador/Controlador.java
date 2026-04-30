package Controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Modelo.Tarea;
import Modelo.tareaDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controlador {

	
	//Columnas Tabla
	@FXML
	private TableColumn<Tarea, String> colNombre;
	
	@FXML
	private TableColumn<Tarea, String> colDescripcion;
	
	@FXML
	private TableColumn<Tarea, String> colFecha;
	
	@FXML
	private TableColumn<Tarea, String> colEstado;
	
	//Tabla Completa
	@FXML
	private TableView<Tarea> tablaTareas;
	
	//Respuestas
	@FXML
	private TextField respuestaNombre;
	
	@FXML
	private TextField respuestaDescripcion;
	
	@FXML
	private TextField respuestaFecha;
	
	@FXML
	private TextField respuestaEstado;
	
	@FXML
	private Label mensajesError;

	@FXML
	private Label apartadoTareasPendientes;

	@FXML
	private Label apartadoTareasCompletadasSemana;

	@FXML
	private Label lblPorcentaje;
	
	
	private tareaDAO TareaDAO = new tareaDAO();

	
	@FXML
	public void initialize() {
		colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreTarea"));
		colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

		tablaTareas.setItems(TareaDAO.getLista());

		tablaTareas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tarea>() {
			@Override
			public void changed(ObservableValue<? extends Tarea> observable, Tarea anterior, Tarea seleccionado) {
				if (seleccionado != null) {
					respuestaNombre.setText(seleccionado.getNombreTarea());
					respuestaDescripcion.setText(seleccionado.getDescripcion());
					respuestaFecha.setText(String.valueOf(seleccionado.getFecha()));
					respuestaEstado.setText(String.valueOf(seleccionado.getEstado()));
				}
			}
		});
	}
	
	
	@FXML
	public void añadirTarea() {
		
		try {
			
	        String nombreTarea = respuestaNombre.getText();
	        String descripcion = respuestaDescripcion.getText();
	        
	        if (respuestaNombre.getText().isEmpty() || respuestaFecha.getText().isEmpty()) {
	            mensajesError.setText("Error: El nombre y la fecha son obligatorios.");
	            return;
	            
	        }
	        
	        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        		LocalDate fecha = LocalDate.parse(respuestaFecha.getText(), formatter);
	        
	        	String estado = respuestaEstado.getText();
	        	
	        	 if (!respuestaEstado.getText().equalsIgnoreCase("Pendiente") && !respuestaEstado.getText().equalsIgnoreCase("Completado")) {
	        		mensajesError.setText("Error: Hay algún fallo en el Estado");
	 	            return;
	 	            
	 	        }
	        
	        	Tarea nueva = new Tarea(nombreTarea, descripcion, fecha, estado);
	       
	        TareaDAO.añadirTarea(nueva);
	        limpiarFormulario();
	        
	    } catch (Exception e) {
	        mensajesError.setText("Error: Formato de Fecha incorrecto.");
	    }
	}
	
	@FXML
	public void borrarTarea() {
		
		Tarea seleccionado = tablaTareas.getSelectionModel().getSelectedItem();

		if (seleccionado != null) {
			TareaDAO.borrarTarea(seleccionado);
		}
	}
	
	@FXML
	public void modificarTarea() {
		Tarea seleccionado = tablaTareas.getSelectionModel().getSelectedItem();

		if (seleccionado == null) {
			return;
		}

		String nombreTarea = respuestaNombre.getText();
		
		String descripcion = respuestaDescripcion.getText();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fecha = LocalDate.parse(respuestaFecha.getText(), formatter);
			
		String estado = respuestaEstado.getText();
		
		
		TareaDAO.actualizarTarea(seleccionado, nombreTarea, descripcion, fecha, estado);

		tablaTareas.refresh();
		
		limpiarFormulario();
	}

	private void limpiarFormulario() {
		respuestaNombre.clear();
		respuestaDescripcion.clear();
		respuestaFecha.clear();
		respuestaEstado.clear();
	}
		
}
