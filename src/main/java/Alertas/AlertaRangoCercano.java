package Alertas;

import javafx.scene.control.Alert;

public class AlertaRangoCercano extends Alert {

    public AlertaRangoCercano(){
        super(AlertType.INFORMATION);
        this.setTitle("PRECAUCION");
        this.setHeaderText("Distancia muy cercana.");
        this.setContentText("Intente atacar una unidad mas lejana!");
    }
}
