package controladores;

import Alertas.AlertaEquipoNoTienePuntosSuficientes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modelo.ErroresYExcepciones.EquipoNoPuedeComprarMasUnidades;
import modelo.ErroresYExcepciones.EquipoNoTienePuntosSuficientes;
import modelo.ErroresYExcepciones.EquipoQuiereCrearUnidadInvalida;
import modelo.equipo.Equipo;
import modelo.unidad.Unidad;
import vista.VistaUnidad;


public class BotonComprarUnidadHandler implements EventHandler<ActionEvent> {

    private Equipo equipo;
    private Unidad unidad;
    private HBox vistaUnidades;
    private Label puntosRestantes;

    public BotonComprarUnidadHandler(Unidad unidad){

        this.unidad = unidad;
    }
    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            equipo.comprarUnidad(unidad.getClass().getSimpleName().toUpperCase());
        } catch (EquipoQuiereCrearUnidadInvalida equipoQuiereCrearUnidadInvalida) {
            equipoQuiereCrearUnidadInvalida.printStackTrace();
            return;
        } catch (EquipoNoTienePuntosSuficientes equipoNoTienePuntosSuficientes) {
            Alert alertaFaltanPuntos = new AlertaEquipoNoTienePuntosSuficientes();
            alertaFaltanPuntos.showAndWait();
            return;
        } catch (EquipoNoPuedeComprarMasUnidades equipoNoPuedeComprarMasUnidades) {
            Alert alertaFaltanPuntos = new AlertaEquipoNoTienePuntosSuficientes();
            alertaFaltanPuntos.showAndWait();
            return;
        }

        vistaUnidades.getChildren().add(VistaUnidad.imagenDeUnidad(unidad));
        this.puntosRestantes.setText("Puntos restantes: " + this.equipo.getPuntaje());
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setVistaUnidades(HBox vistaUnidades) {
        this.vistaUnidades = vistaUnidades;
    }

    public void setPuntosRestantes(Label puntosRestantes) {
        this.puntosRestantes = puntosRestantes;
    }
}
