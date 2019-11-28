package vista;

import controladores.BotonCambiarTableroAModoAtaque;
import controladores.BotonCambiarTableroAModoMovimiento;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.unidad.Unidad;

public class ContenedorPrincipal extends HBox {

    private VBox unidades;
    private VistaTablero tablero;
    private VBox controles;

    public ContenedorPrincipal(VBox unidades, VistaTablero tablero, VBox controles) {
        super(unidades, tablero, controles);
        this.unidades = unidades;
        this.tablero = tablero;
        this.controles = controles;
        this.botones();
    }

    private void botones() {
        Button botonMovimiento = new Button("Mover Unidad");
        botonMovimiento.setOnAction(new BotonCambiarTableroAModoMovimiento(tablero));
        this.controles.getChildren().add(botonMovimiento);

        Button botonAtaque = new Button("Atacar Unidad");
        botonAtaque.setOnAction(new BotonCambiarTableroAModoAtaque(tablero));
        this.controles.getChildren().add(botonAtaque);
    }

    public void agregarUnidadTop(Unidad unidad){
        this.unidades.getChildren().add(0, new VistaUnidad(unidad));
    }

    public void agregarUnidadBottom(Unidad unidad){
        this.unidades.getChildren().add(2, new VistaUnidad(unidad));
    }


}
