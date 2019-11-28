package controladores;

import Alertas.AlertaFaltaColocarUnidades;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import vista.MainApp;

public class BotonCambiarAEscenaPrincipal implements EventHandler<ActionEvent> {
    private VBox seleccionados;
    private VBox unidades;
    private MainApp main;


    public BotonCambiarAEscenaPrincipal(MainApp mainApp, VBox unidades, VBox seleccionados) {
        this.main = mainApp;
        this.unidades = unidades;
        this.seleccionados = seleccionados;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(!this.unidades.getChildren().isEmpty() || !this.seleccionados.getChildren().isEmpty()){
            Alert alertaFaltanColocarUnidades = new AlertaFaltaColocarUnidades();
            alertaFaltanColocarUnidades.showAndWait();
        }else {
            try {
                main.cambiarAEscenaPrincipal();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
