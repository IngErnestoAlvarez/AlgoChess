package vista;

import javafx.scene.control.Button;
import modelo.celda.Celda;
import modelo.equipo.Equipo;

public class VistaCelda extends Button {

    public VistaCelda(Celda celda, int equipo){
        super();

        this.setPrefHeight(50);
        this.setPrefWidth(40);

        if(equipo == 2) {
            this.setStyle("-fx-background-color: #6c6eb3");
        }
        else
            this.setStyle("-fx-background-color: #b35051");
    }
}
