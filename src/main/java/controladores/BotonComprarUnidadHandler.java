package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
            equipoNoTienePuntosSuficientes.printStackTrace();
            return;
        } catch (EquipoNoPuedeComprarMasUnidades equipoNoPuedeComprarMasUnidades) {
            equipoNoPuedeComprarMasUnidades.printStackTrace();
            return;
        }

        vistaUnidades.getChildren().add(VistaUnidad.imagenDeUnidad(unidad));
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setVistaUnidades(HBox vistaUnidades) {
        this.vistaUnidades = vistaUnidades;
    }
}
