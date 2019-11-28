package Alertas;

import javafx.scene.control.Alert;

public class AlertaCeldaNoTieneUnidad extends Alert {
    public AlertaCeldaNoTieneUnidad() {
        super(AlertType.INFORMATION);
        this.setTitle("PRECAUCIÓN!");
        this.setHeaderText("Usted no utilizó bien la funcion.");
        this.setContentText("Tiene que haber una unidad en las casillas con la que interactua.");
    }
}
