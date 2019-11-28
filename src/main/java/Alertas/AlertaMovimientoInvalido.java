package Alertas;

import javafx.scene.control.Alert;

public class AlertaMovimientoInvalido extends Alert {

    public AlertaMovimientoInvalido(){
        super(AlertType.INFORMATION);
        this.setTitle("PRECAUCION");
        this.setHeaderText("Movimiento invalido");
        this.setContentText("Se debe a intentar mover una unidad a una celda que no es adyacente a la suya.");
    }
}
