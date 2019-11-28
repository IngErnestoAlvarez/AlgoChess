package Alertas;

import javafx.scene.control.Alert;

public class AlertaUnidadNoPerteneceAlEquipoQueJuega extends Alert {
    public AlertaUnidadNoPerteneceAlEquipoQueJuega() {
        super(AlertType.INFORMATION);
        this.setTitle("PRECAUCIÓN");
        this.setHeaderText("Usted no utilizó bien la funcion.");
        this.setContentText("Tiene que utilizar una unidad que pertenezca a tu equipo.");
    }
}
