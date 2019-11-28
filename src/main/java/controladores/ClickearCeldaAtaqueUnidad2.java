package controladores;

import Alertas.AlertaCeldaNoTieneUnidad;
import Alertas.AlertaRangoCercano;
import Alertas.AlertaRangoLejano;
import Alertas.AlertaUnidadNoPerteneceAlEquipoQueJuega;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.ErroresYExcepciones.*;
import vista.MainApp;
import vista.VistaCelda;
import vista.VistaTablero;

public class ClickearCeldaAtaqueUnidad2 implements EventHandler<ActionEvent> {
    private VistaTablero tablero;
    private VistaCelda vistaCeldaOrigen;
    private VistaCelda vistaCeldaDestino;
    private MainApp main;
    public ClickearCeldaAtaqueUnidad2(VistaTablero vistaTablero, VistaCelda vistaCeldaOrigen, VistaCelda vistaCelda, MainApp main) {
        this.tablero = vistaTablero;
        this.vistaCeldaDestino = vistaCelda;
        this.vistaCeldaOrigen = vistaCeldaOrigen;
        this.main = main;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            tablero.getTablero().interaccion(vistaCeldaOrigen.celda.verPosicion(), vistaCeldaDestino.celda.verPosicion());
            tablero.getTablero().cambiarEquipo();
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
            Alert alertaCeldaSinUnidad = new AlertaCeldaNoTieneUnidad();
            alertaCeldaSinUnidad.showAndWait();
        } catch (NoSeEncontroLaCelda noSeEncontroLaCelda){
        } catch (RangoMuyLejano rangoMuyLejano) {
            Alert alertaRangoLejano = new AlertaRangoLejano();
            alertaRangoLejano.showAndWait();
        } catch (RangoMuyCercano rangoMuyCercano) {
            Alert alertaRangoCercano = new AlertaRangoCercano();
            alertaRangoCercano.showAndWait();
        } catch (EquipoEquivocado equipoEquivocado) {
            Alert alertaEquipoEquivocado = new AlertaUnidadNoPerteneceAlEquipoQueJuega();
            alertaEquipoEquivocado.showAndWait();
        }
        if(tablero.getEquipo1().esPerdedor()){
            main.cambiarAEscenaGanador(tablero.getEquipo2());
        }
        else if(tablero.getEquipo2().esPerdedor()){
            main.cambiarAEscenaGanador(tablero.getEquipo1());
        }
        try{
            tablero.llenarCeldas();
        }catch (Exception e){}
        tablero.botones();
        tablero.cambiarNombreEquipo();
    }
}
