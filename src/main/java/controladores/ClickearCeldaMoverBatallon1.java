package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaCelda;
import vista.VistaTablero;

public class ClickearCeldaMoverBatallon1 implements EventHandler<ActionEvent> {
    private VistaTablero vistaTablero;
    private VistaCelda vistaCelda;

    public ClickearCeldaMoverBatallon1(VistaTablero vistaTablero, VistaCelda vistaCelda) {
        this.vistaCelda = vistaCelda;
        this.vistaTablero = vistaTablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        vistaTablero.modoRecibirBatallon(vistaCelda);
    }
}
