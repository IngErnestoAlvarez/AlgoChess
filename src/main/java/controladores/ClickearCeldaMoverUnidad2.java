package controladores;

import Alertas.AlertaUnidadNoPerteneceAlEquipoQueJuega;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.ErroresYExcepciones.*;
import vista.VistaCelda;
import vista.VistaTablero;

public class ClickearCeldaMoverUnidad2 implements EventHandler<ActionEvent> {
    private VistaTablero tablero;
    private VistaCelda vistaCeldaOrigen;
    private VistaCelda vistaCeldaDestino;

    public ClickearCeldaMoverUnidad2(VistaTablero tablero, VistaCelda celdaOrigen, VistaCelda celdaDestino){
        this.tablero =tablero;
        this.vistaCeldaDestino = celdaDestino;
        this.vistaCeldaOrigen = celdaOrigen;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        try {
            tablero.getTablero().moverUnidad(vistaCeldaOrigen.celda.verPosicion(), vistaCeldaDestino.celda.verPosicion());
        } catch (NoSeEncontroLaCelda noSeEncontroLaCelda) {
            tablero.getTablero().cambiarEquipo();
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
            tablero.getTablero().cambiarEquipo();
            celdaNoTieneUnidad.printStackTrace();
        } catch (CeldaYaTieneUnidad celdaYaTieneUnidad) {
            tablero.getTablero().cambiarEquipo();
            celdaYaTieneUnidad.printStackTrace();
        } catch (MovimientoInvalido movimientoInvalido) {
            tablero.getTablero().cambiarEquipo();
            movimientoInvalido.printStackTrace();
        } catch (EquipoEquivocado equipoEquivocado) {
            tablero.getTablero().cambiarEquipo();
            Alert alertaEquipoEquivocado = new AlertaUnidadNoPerteneceAlEquipoQueJuega();
            alertaEquipoEquivocado.showAndWait();
        }
        try {
            tablero.llenarCeldas();
        } catch (Exception e) {
        }
        tablero.botones();
        tablero.getTablero().cambiarEquipo();
        tablero.cambiarNombreEquipo();
    }
}
