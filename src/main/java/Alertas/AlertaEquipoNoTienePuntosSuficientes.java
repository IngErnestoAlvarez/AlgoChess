package Alertas;

import javafx.scene.control.Alert;

public class AlertaEquipoNoTienePuntosSuficientes extends Alert {

    public AlertaEquipoNoTienePuntosSuficientes(){
        super(AlertType.INFORMATION);
        this.setTitle("Error");
        this.setHeaderText("PUNTOS INSUFICIENTES");
        this.setContentText("No tenes puntos suficientes para comprar esta unidad");
    }
}
