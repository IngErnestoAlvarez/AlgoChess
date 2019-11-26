package controladores;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import vista.VistaUnidadTablero;

public class ClickearYCambiarDeLugarImagen implements EventHandler<MouseEvent> {

    private VistaUnidadTablero vista;
    VBox unidades;
    VBox seleccionados;

    public ClickearYCambiarDeLugarImagen(VistaUnidadTablero vista, VBox unidades, VBox seleccionados){
        this.vista = vista;
        this.unidades = unidades;
        this.seleccionados = seleccionados;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        unidades.getChildren().remove(vista);
        seleccionados.getChildren().add(vista);

    }
}
