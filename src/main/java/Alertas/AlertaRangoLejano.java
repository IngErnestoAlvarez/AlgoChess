package Alertas;

import javafx.scene.control.Alert;

public class AlertaRangoLejano extends Alert {

    public AlertaRangoLejano(){
        super(AlertType.INFORMATION);
        this.setTitle("PRECAUCION");
        this.setHeaderText("Distancia muy lejana.");
        this.setContentText("Intente atacar una unidad mas cercana!");
    }
}
