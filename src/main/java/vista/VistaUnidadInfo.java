package vista;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import modelo.unidad.Unidad;

public class VistaUnidadInfo extends VBox {
    public VistaUnidadInfo(Unidad unidad) {
        super();

        Label nombre = new Label(unidad.getClass().getSimpleName());
        nombre.setFont(Font.font("Cambria", 30));

        Label vida = new Label("Vida: " + unidad.getVida());

        Label danio = new Label(unidad.getStringAccion());

        this.setSpacing(40);
        this.getChildren().add(VistaUnidad.imagenDeUnidad(unidad));
        this.getChildren().add(nombre);
        this.getChildren().add(vida);
        this.getChildren().add(danio);

        this.setStyle("-fx-background-color: #fffbee");

    }
}
