package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.MainApp;

public class BotonCambiarDeEquipoCompra implements EventHandler<ActionEvent> {

    private MainApp main;

    public BotonCambiarDeEquipoCompra(MainApp main){
        this.main = main;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            main.cambiarAEscenaDeCompra2();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
