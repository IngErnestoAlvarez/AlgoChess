package controladores;

import Alertas.AlertaCeldaNoTieneUnidad;
import Alertas.AlertaMoverUnidadACeldaOcupada;
import Alertas.AlertaMovimientoInvalido;
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
            tablero.getTablero().cambiarEquipo();
        } catch (NoSeEncontroLaCelda noSeEncontroLaCelda) {
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
            Alert alertaNoHayUnaUnidad = new AlertaCeldaNoTieneUnidad();
            alertaNoHayUnaUnidad.showAndWait();
        } catch (CeldaYaTieneUnidad celdaYaTieneUnidad) {
            Alert alertaCeldaOcupada = new AlertaMoverUnidadACeldaOcupada();
            alertaCeldaOcupada.showAndWait();
        } catch (MovimientoInvalido movimientoInvalido) {
            Alert alertaMovimientoInvalido = new AlertaMovimientoInvalido();
            alertaMovimientoInvalido.showAndWait();
        } catch (EquipoEquivocado equipoEquivocado) {
            Alert alertaEquipoEquivocado = new AlertaUnidadNoPerteneceAlEquipoQueJuega();
            alertaEquipoEquivocado.showAndWait();
        }
        try {
            tablero.llenarCeldas();
        } catch (Exception e) {
        }
        tablero.botones();

        tablero.cambiarNombreEquipo();
    }
}
