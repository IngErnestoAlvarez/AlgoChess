package tablero;

import ErroresYExcepciones.CeldaNoTieneUnidad;
import ErroresYExcepciones.CeldaYaTieneUnidad;
import ErroresYExcepciones.NoSeEncontroLaCelda;
import celda.Celda;
import celda.Posicion;
import tablero.movimientos.Movimiento;
import unidad.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Batallon {

    private List<Celda> batallon;

    public Batallon(Celda celdaCentro, boolean esHorizontal, Tablero tableroDelBatallon) throws NoSeEncontroLaCelda {

        this.batallon = new ArrayList<>();

        Celda primerCeldaConSoldado = null;
        Celda tercerCeldaConSoldado = null;

        if (esHorizontal) {
            primerCeldaConSoldado = tableroDelBatallon.buscarCeldaConPosicion(celdaCentro.verPosicion().izquierda());
            tercerCeldaConSoldado = tableroDelBatallon.buscarCeldaConPosicion(celdaCentro.verPosicion().derecha());
        } else {
            primerCeldaConSoldado = tableroDelBatallon.buscarCeldaConPosicion(celdaCentro.verPosicion().arriba());
            tercerCeldaConSoldado = tableroDelBatallon.buscarCeldaConPosicion(celdaCentro.verPosicion().abajo());
        }

        this.batallon.add(primerCeldaConSoldado);
        this.batallon.add(celdaCentro);
        this.batallon.add(tercerCeldaConSoldado);

    }

    public void moverBatallon(Movimiento direccionDeMovimiento, Tablero miTablero) throws CeldaNoTieneUnidad, NoSeEncontroLaCelda {
        List<Boolean> seMovio = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            seMovio.add(false);
        }

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (!(seMovio.get(j))) {

                    Celda origen = batallon.get(j);
                    Posicion posicionAuxiliar = direccionDeMovimiento.transformarPosicionPorMovimiento(origen.verPosicion());
                    Celda destino = miTablero.buscarCeldaConPosicion(posicionAuxiliar);
                    Unidad unaUnidad = origen.verUnidad();
                    try {
                        destino.colocarUnidad(unaUnidad);
                        seMovio.set(j, true);
                        origen.quitarUnidad();
                    } catch (CeldaYaTieneUnidad celdaYaTieneUnidad) {}

                }

            }
        }
    }


}
