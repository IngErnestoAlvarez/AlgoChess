package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaTablero;

public class BotonCambiarTableroAModoAtaque implements EventHandler<ActionEvent> {
    private VistaTablero vistaTablero;
    public BotonCambiarTableroAModoAtaque(VistaTablero tablero) {
        this.vistaTablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        vistaTablero.modoAtaque();
    }
}
