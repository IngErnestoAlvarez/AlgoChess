package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
            celdaNoTieneUnidad.printStackTrace();
        } catch (CeldaYaTieneUnidad celdaYaTieneUnidad) {
            celdaYaTieneUnidad.printStackTrace();
        } catch (MovimientoInvalido movimientoInvalido) {
            movimientoInvalido.printStackTrace();
        } catch (EquipoEquivocado equipoEquivocado) {
            equipoEquivocado.printStackTrace();
        }
        try {
            tablero.llenarCeldas();
        } catch (Exception e) {
        }
        tablero.botones();
    }
}
