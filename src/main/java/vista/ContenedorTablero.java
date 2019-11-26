package vista;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContenedorTablero extends HBox {
    public ContenedorTablero(VBox unidad, GridPane tablero) {
        super();
        unidad.setAlignment(Pos.CENTER_LEFT);
        tablero.setAlignment(Pos.CENTER);
    }
}
