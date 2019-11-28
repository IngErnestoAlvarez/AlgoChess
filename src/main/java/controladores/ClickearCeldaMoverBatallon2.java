package controladores;

import Alertas.AlertaCeldaNoTieneUnidad;
import Alertas.AlertaMovimientoInvalido;
import Alertas.AlertaNoEsBatallon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.ErroresYExcepciones.MovimientoInvalido;
import modelo.ErroresYExcepciones.NoEsBatallon;
import modelo.ErroresYExcepciones.NoSeEncontroLaCelda;
import vista.VistaCelda;
import vista.VistaTablero;

public class ClickearCeldaMoverBatallon2 implements EventHandler<ActionEvent> {
    private VistaCelda celdaOrigen;
    private VistaCelda celdaDestino;
    private VistaTablero vistaTablero;
    public ClickearCeldaMoverBatallon2(VistaTablero vistaTablero, VistaCelda celdaOrigen, VistaCelda vistaCelda) {
        this.celdaDestino = vistaCelda;
        this.celdaOrigen = celdaOrigen;
        this.vistaTablero = vistaTablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            vistaTablero.getTablero().moverBatallon(celdaOrigen.celda.verPosicion(), celdaDestino.celda.verPosicion());
            vistaTablero.getTablero().cambiarEquipo();
        } catch (NoSeEncontroLaCelda noSeEncontroLaCelda) {
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
            Alert alerta = new AlertaCeldaNoTieneUnidad();
            alerta.showAndWait();
        } catch (MovimientoInvalido movimientoInvalido) {
            Alert alerta = new AlertaMovimientoInvalido();
            alerta.showAndWait();
        } catch (NoEsBatallon noEsBatallon) {
            Alert alerta = new AlertaNoEsBatallon();
            alerta.showAndWait();
        }
        try {
            vistaTablero.llenarCeldas();
        } catch (Exception e) {
        }
        vistaTablero.botones();

        vistaTablero.cambiarNombreEquipo();
    }
}
