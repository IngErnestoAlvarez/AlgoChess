package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.MainApp;
import vista.VistaCelda;
import vista.VistaTablero;

public class ClickearCeldaAtaqueUnidad1 implements EventHandler<ActionEvent> {
    private VistaCelda vistaCeldaOrigen;
    private VistaTablero vistaTablero;
    private MainApp main;
    public ClickearCeldaAtaqueUnidad1(VistaTablero vistaTablero, VistaCelda vistaCelda, MainApp main) {
        this.vistaCeldaOrigen = vistaCelda;
        this.vistaTablero = vistaTablero;
        this.main = main;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.vistaTablero.modoRecibirAtaque(vistaCeldaOrigen, main);
    }
}
