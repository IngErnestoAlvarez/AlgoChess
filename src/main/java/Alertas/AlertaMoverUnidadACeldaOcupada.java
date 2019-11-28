package Alertas;

import javafx.scene.control.Alert;

public class AlertaMoverUnidadACeldaOcupada extends Alert {

    public AlertaMoverUnidadACeldaOcupada(){
        super(AlertType.INFORMATION);
        this.setTitle("PRECAUCION");
        this.setHeaderText("Usted no utilizo bien la funcion");
        this.setContentText("La celda de destino tiene que esta vacia. (Intente que en el segundo click selecciones una casilla adyacente y vacia.)");
    }
}
