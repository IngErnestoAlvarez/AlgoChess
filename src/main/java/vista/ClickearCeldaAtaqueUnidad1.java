package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClickearCeldaAtaqueUnidad1 implements EventHandler<ActionEvent> {
    private VistaCelda vistaCeldaOrigen;
    private VistaTablero vistaTablero;
    public ClickearCeldaAtaqueUnidad1(VistaTablero vistaTablero, VistaCelda vistaCelda) {
        this.vistaCeldaOrigen = vistaCelda;
        this.vistaTablero = vistaTablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.vistaTablero.modoRecibirAtaque(vistaCeldaOrigen);
    }
}
