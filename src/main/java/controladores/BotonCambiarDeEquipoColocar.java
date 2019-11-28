package controladores;

import Alertas.AlertaFaltaColocarUnidades;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import modelo.ErroresYExcepciones.NoSeEncontroLaCelda;
import modelo.tablero.Tablero;
import vista.MainApp;

public class BotonCambiarDeEquipoColocar implements EventHandler<ActionEvent> {
    private MainApp main;
    private Tablero tablero;
    private VBox unidades;
    private VBox seleccionados;

    public BotonCambiarDeEquipoColocar(MainApp main, Tablero tablero, VBox unidades, VBox seleccionados){
        this.main = main;
        this.tablero = tablero;
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
                main.cambiarAEscenaColocarUnidad2();
                this.tablero.cambiarSector();
            } catch (NoSeEncontroLaCelda noSeEncontroLaCelda) {
                noSeEncontroLaCelda.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
