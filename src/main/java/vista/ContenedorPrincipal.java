package vista;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.unidad.Unidad;

public class ContenedorPrincipal extends HBox {

    private VBox unidades;
    private VistaTablero tablero;

    public ContenedorPrincipal(VBox unidades, VistaTablero tablero) {
        super(unidades, tablero);
        this.unidades = unidades;
        this.tablero = tablero;
    }

    public void agregarUnidadTop(Unidad unidad){
        this.unidades.getChildren().add(0, new VistaUnidad(unidad));
    }

    public void agregarUnidadBottom(Unidad unidad){
        this.unidades.getChildren().add(2, new VistaUnidad(unidad));
    }
}
