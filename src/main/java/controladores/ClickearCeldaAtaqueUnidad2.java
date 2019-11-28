package controladores;

import Alertas.AlertaCeldaNoTieneUnidad;
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
            if(tablero.getEquipo1().esPerdedor()){
                main.cambiarAEscenaGanador(tablero.getEquipo2());
            }
            else if(tablero.getEquipo2().esPerdedor()){
                main.cambiarAEscenaGanador(tablero.getEquipo1());
            }
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
            Alert alertaCeldaSinUnidad = new AlertaCeldaNoTieneUnidad();
            alertaCeldaSinUnidad.showAndWait();
        } catch (NoSeEncontroLaCelda noSeEncontroLaCelda){
        } catch (RangoMuyLejano rangoMuyLejano) {
        } catch (RangoMuyCercano rangoMuyCercano) {
        } catch (EquipoEquivocado equipoEquivocado) {
            equipoEquivocado.printStackTrace();
        }
        try{
            tablero.llenarCeldas();
        }catch (Exception e){}
        tablero.botones();
    }
}
