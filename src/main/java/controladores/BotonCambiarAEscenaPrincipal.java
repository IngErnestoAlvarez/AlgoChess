package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.MainApp;

public class BotonCambiarAEscenaPrincipal implements EventHandler<ActionEvent> {
    private MainApp main;

    public BotonCambiarAEscenaPrincipal(MainApp mainApp) {
        this.main = mainApp;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            main.cambiarAEscenaPrincipal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
