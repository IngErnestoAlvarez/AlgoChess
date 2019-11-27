package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.celda.Celda;
import modelo.tablero.Tablero;
import vista.VistaCelda;
import vista.VistaTablero;

public class ClickearCeldaMoverUnidad1 implements EventHandler<ActionEvent> {
    private VistaCelda vistaCeldaOrigen;
    private VistaTablero vistaTablero;
    public ClickearCeldaMoverUnidad1(VistaTablero vistaTablero, VistaCelda vistaCelda){
        this.vistaCeldaOrigen = vistaCelda;
        this.vistaTablero = vistaTablero;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        vistaTablero.modoRecibirUnidad(vistaCeldaOrigen);
    }
}
