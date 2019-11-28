package Alertas;

import javafx.scene.control.Alert;

public class AlertaFaltaColocarUnidades extends Alert {
    public AlertaFaltaColocarUnidades() {
        super(AlertType.INFORMATION);
        this.setTitle("Error");
        this.setContentText("Necesita colocar todas las unidades");
    }
}
