package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.MainApp;

public class BotonIniciarJuegoDeVuetla implements EventHandler<ActionEvent> {
    private MainApp main;
    public BotonIniciarJuegoDeVuetla(MainApp mainApp) {
        this.main = mainApp;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            main.cambiarAEscenaInicial();
        } catch (Exception e) {
        }
    }
}
