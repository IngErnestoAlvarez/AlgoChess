package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaTablero;

public class BotonCambiarTableroAModoMovimiento implements EventHandler<ActionEvent> {

    private VistaTablero vistaTablero;

    public BotonCambiarTableroAModoMovimiento(VistaTablero vistaTablero){
        this.vistaTablero = vistaTablero;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        vistaTablero.modoMovimiento();
    }
}
