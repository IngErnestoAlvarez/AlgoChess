package Alertas;

import javafx.scene.control.Alert;

public class AlertaNoEsBatallon extends Alert {

    public AlertaNoEsBatallon(){
        super(AlertType.INFORMATION);
        this.setTitle("ERROR");
        this.setHeaderText("BATALLON INVALIDO");
        this.setContentText("Para mover un batallon tiene que seleccionar la unidad del centro y la casilla a la que se moveria");
    }
}
