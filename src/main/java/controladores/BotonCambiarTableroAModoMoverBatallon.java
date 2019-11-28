package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaTablero;

public class BotonCambiarTableroAModoMoverBatallon implements EventHandler<ActionEvent> {

    private VistaTablero tablero;
    public BotonCambiarTableroAModoMoverBatallon(VistaTablero tablero) {

        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        tablero.modoMoverBatallon();
    }
}
