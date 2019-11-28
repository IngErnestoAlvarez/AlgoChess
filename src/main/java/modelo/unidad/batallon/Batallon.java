package modelo.unidad.batallon;

import modelo.ErroresYExcepciones.*;
import modelo.celda.Celda;
import modelo.celda.Posicion;
import modelo.tablero.Tablero;
import modelo.tablero.movimientos.Movimiento;
import modelo.unidad.Soldado;
import modelo.unidad.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Batallon {

    private List<Celda> batallon;
    private Tablero miTablero;

    public Batallon(Celda celdaCentro , Tablero tableroDelBatallon) throws NoSeEncontroLaCelda, NoEsBatallon, CeldaNoTieneUnidad {
        this.miTablero = tableroDelBatallon;
        this.batallon = new ArrayList<>();

        if (!(this.esBatallon(celdaCentro.verPosicion()) || !(celdaCentro.verUnidad() instanceof Soldado) )) throw new NoEsBatallon();


        Celda primerCeldaConSoldado = null;
        Celda tercerCeldaConSoldado = null;

        if (this.esBatallonHorizontal(celdaCentro.verPosicion())) {
            primerCeldaConSoldado = miTablero.buscarCeldaConPosicion(celdaCentro.verPosicion().izquierda());
            tercerCeldaConSoldado = miTablero.buscarCeldaConPosicion(celdaCentro.verPosicion().derecha());
        } else {
            primerCeldaConSoldado = miTablero.buscarCeldaConPosicion(celdaCentro.verPosicion().arriba());
            tercerCeldaConSoldado = miTablero.buscarCeldaConPosicion(celdaCentro.verPosicion().abajo());
        }

        this.batallon.add(primerCeldaConSoldado);
        this.batallon.add(celdaCentro);
        this.batallon.add(tercerCeldaConSoldado);

    }

    public void moverBatallon(Movimiento direccionDeMovimiento) throws NoSeEncontroLaCelda, CeldaNoTieneUnidad {
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
                        unaUnidad.setCelda(destino);
                    } catch (CeldaYaTieneUnidad celdaYaTieneUnidad) {}
                }

            }
        }
    }

    private boolean esBatallon(Posicion posicionCentro){
        return (this.esBatallonVertical(posicionCentro) || this.esBatallonHorizontal(posicionCentro));
    }

    private boolean esBatallonHorizontal(Posicion posicionCentro) {
        Celda celdaDerecha = null;
        Celda celdaIzquierda = null;
        try {
            celdaIzquierda = this.miTablero.buscarCeldaConPosicion(posicionCentro.izquierda());
            celdaDerecha = this.miTablero.buscarCeldaConPosicion(posicionCentro.derecha());
        } catch (NoSeEncontroLaCelda noSeEncontroLaCelda) {
            return false;
        }
        try {
            return (celdaDerecha.verUnidad() instanceof Soldado && celdaIzquierda.verUnidad() instanceof Soldado);
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
            return false;
        }
    }

    private boolean esBatallonVertical(Posicion posicionCentro) {
        Celda celdaArriba = null;
        Celda celdaAbajo = null;
        try {
            celdaArriba = this.miTablero.buscarCeldaConPosicion(posicionCentro.arriba());
            celdaAbajo = this.miTablero.buscarCeldaConPosicion(posicionCentro.abajo());
        } catch (NoSeEncontroLaCelda noSeEncontroLaCelda) {
            return false;
        }
        try {
            return (celdaArriba.verUnidad() instanceof Soldado && celdaAbajo.verUnidad() instanceof Soldado);
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
            return false;
        }
    }


}
