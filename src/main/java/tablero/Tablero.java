package tablero;

import ErroresYExcepciones.*;
import celda.Posicion;
import javafx.geometry.Pos;
import tablero.movimientos.Movimiento;
import unidad.Catapulta;
import unidad.Soldado;
import unidad.Unidad;
import celda.Celda;
import equipo.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Tablero {

    private List <Celda> celdas;
    private Equipo equipoDeAbajo;
    private Equipo equipoDeArriba;
    private Sector sectorDeAbajo;
    private Sector sectorDeArriba;
    private Sector sectorActual;

    public Tablero(int largo, int alto, Equipo equipoDeAbajo, Equipo equipoDeArriba) {
        this.equipoDeAbajo = equipoDeAbajo;
        this.equipoDeArriba = equipoDeArriba;

        this.sectorDeAbajo = new Sector();
        this.sectorDeArriba = new Sector();
        this.sectorActual = sectorDeAbajo;

        this.celdas = new ArrayList<Celda>();
        this.llenarTablero(largo, alto);
    }

    public void colocarUnidad(Unidad unaUnidad, Posicion posicionDeseada) throws TableroSectorInvalido, CeldaNoEstaEnElTablero, CeldaYaTieneUnidad {

        Celda miCelda = null;

        try{
            miCelda = this.buscarCeldaConPosicion(posicionDeseada);
        }catch(NoSeEncontroLaCelda excepcionCelda) {
            throw new CeldaNoEstaEnElTablero();
        }


        try {
            sectorActual.colocarUnidad(miCelda, unaUnidad);
        } catch(CeldaNoEstaEnMiSector celdaNoEstaEnElSector){
            throw new TableroSectorInvalido();
        }
    }


    public void cambiarSector(){
        if(this.sectorActual == this.sectorDeAbajo){
            this.sectorActual = this.sectorDeArriba;
        }else {
            this.sectorActual = this.sectorDeAbajo;
        }
    }

    public Unidad verUnidad(Posicion unaPosicion) throws CeldaNoEstaEnElTablero, CeldaNoTieneUnidad {
        Celda celdaIndicada = null;
        try {
            celdaIndicada = this.buscarCeldaConPosicion(unaPosicion);
        } catch (NoSeEncontroLaCelda noSeEncontroLaCelda) {
            throw new CeldaNoEstaEnElTablero();
        }

        return celdaIndicada.verUnidad();

    }

    public void moverUnidad(Posicion posicionOrigen, Posicion posicionDestino) throws NoSeEncontroLaCelda, CeldaNoTieneUnidad, CeldaYaTieneUnidad, MovimientoInvalido {
            Celda celdaOrigen = this.buscarCeldaConPosicion(posicionOrigen);
            Celda celdaDestino = this.buscarCeldaConPosicion(posicionDestino);

            if(celdaOrigen.medirDistacia(celdaDestino) != 1 || celdaOrigen.verUnidad() instanceof Catapulta) throw new MovimientoInvalido();

            if (celdaOrigen.verUnidad() instanceof Soldado && this.esBatallon(posicionOrigen)){
                Batallon elBatallon = new Batallon(celdaOrigen, this.esBatallonHorizontal(posicionOrigen), this);
                Movimiento movimientoDelBatallon = new Movimiento(posicionOrigen, posicionDestino);
                elBatallon.moverBatallon(movimientoDelBatallon, this);
                return;
            }

            Unidad unidadAMover = celdaOrigen.quitarUnidad();

            celdaDestino.colocarUnidad(unidadAMover);
    }

    private boolean esBatallon(Posicion posicionCentro){
        return (this.esBatallonVertical(posicionCentro) || this.esBatallonHorizontal(posicionCentro));
    }

    private boolean esBatallonHorizontal(Posicion posicionCentro) {
        Celda celdaDerecha = null;
        Celda celdaIzquierda = null;
        try {
            celdaIzquierda = this.buscarCeldaConPosicion(posicionCentro.izquierda());
            celdaDerecha = this.buscarCeldaConPosicion(posicionCentro.derecha());
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
            celdaArriba = this.buscarCeldaConPosicion(posicionCentro.arriba());
            celdaAbajo = this.buscarCeldaConPosicion(posicionCentro.abajo());
        } catch (NoSeEncontroLaCelda noSeEncontroLaCelda) {
            return false;
        }
        try {
            return (celdaArriba.verUnidad() instanceof Soldado && celdaAbajo.verUnidad() instanceof Soldado);
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
            return false;
        }
    }


    private void llenarTablero(int largo, int alto){

        for (int fila = 1; fila <= largo; fila++ ){

            for ( int columna = 1; columna <= alto; columna++ ){

                Celda celda = new Celda( fila , columna );

                this.celdas.add(celda);

                if( fila <= largo/2 ) this.sectorDeArriba.agregar(celda);
                else this.sectorDeAbajo.agregar(celda);

            }

        }

    }

    public Celda buscarCeldaConPosicion(Posicion laPosicion) throws NoSeEncontroLaCelda {

        Celda celdaQueQuieroEncontrar = new Celda(laPosicion);

        int indiceDeLaCelda = this.celdas.indexOf(celdaQueQuieroEncontrar);

        if (indiceDeLaCelda != -1) return this.celdas.get(indiceDeLaCelda);

        throw new NoSeEncontroLaCelda();

    }

}
