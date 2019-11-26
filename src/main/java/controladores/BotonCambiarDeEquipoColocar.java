package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.ErroresYExcepciones.NoSeEncontroLaCelda;
import vista.MainApp;

public class BotonCambiarDeEquipoColocar implements EventHandler<ActionEvent> {
    private MainApp main;

    public BotonCambiarDeEquipoColocar(MainApp main){
        this.main = main;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            main.cambiarAEscenaColocarUnidad2();
        } catch (NoSeEncontroLaCelda noSeEncontroLaCelda) {
            noSeEncontroLaCelda.printStackTrace();
        }
    }
}
