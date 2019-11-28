package controladores;

import Alertas.AlertaCeldaNoTieneUnidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.ErroresYExcepciones.NoSeEncontroLaCelda;
import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;
import vista.VistaCelda;
import vista.VistaTablero;

public class ClickearCeldaAtaqueUnidad2 implements EventHandler<ActionEvent> {
    private VistaTablero tablero;
    private VistaCelda vistaCeldaOrigen;
    private VistaCelda vistaCeldaDestino;
    public ClickearCeldaAtaqueUnidad2(VistaTablero vistaTablero, VistaCelda vistaCeldaOrigen, VistaCelda vistaCelda) {
        this.tablero = vistaTablero;
        this.vistaCeldaDestino = vistaCelda;
        this.vistaCeldaOrigen = vistaCeldaOrigen;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            tablero.getTablero().interaccion(vistaCeldaOrigen.celda.verPosicion(), vistaCeldaDestino.celda.verPosicion());
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
            Alert alertaCeldaSinUnidad = new AlertaCeldaNoTieneUnidad();
            alertaCeldaSinUnidad.showAndWait();
        } catch (NoSeEncontroLaCelda noSeEncontroLaCelda){
        } catch (RangoMuyLejano rangoMuyLejano) {
        } catch (RangoMuyCercano rangoMuyCercano) {
        }
        try{
            tablero.llenarCeldas();
        }catch (Exception e){}
        tablero.botones();
    }
}
