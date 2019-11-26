package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.ErroresYExcepciones.NoSeEncontroLaCelda;
import modelo.tablero.Tablero;
import vista.MainApp;

public class BotonPasarAColocarUnidad implements EventHandler<ActionEvent> {

    private MainApp main;

    public BotonPasarAColocarUnidad(MainApp mainApp) {
        this.main = mainApp;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Tablero tablero = new Tablero(20, 20, main.getEquipo1(), main.getEquipo2());
        main.setTablero(tablero);
        try {
            main.cambiarAEscenaColocarUnidad1();
        } catch (NoSeEncontroLaCelda noSeEncontroLaCelda) {
            noSeEncontroLaCelda.printStackTrace();
        }
    }
}
