package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.ErroresYExcepciones.NoSeEncontroLaCelda;
import modelo.tablero.Tablero;
import vista.MainApp;

public class BotonCambiarDeEquipoColocar implements EventHandler<ActionEvent> {
    private MainApp main;
    private Tablero tablero;

    public BotonCambiarDeEquipoColocar(MainApp main, Tablero tablero){
        this.main = main;
        this.tablero = tablero;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            main.cambiarAEscenaColocarUnidad2();
            this.tablero.cambiarSector();
        } catch (NoSeEncontroLaCelda noSeEncontroLaCelda) {
            noSeEncontroLaCelda.printStackTrace();
        }
    }
}
