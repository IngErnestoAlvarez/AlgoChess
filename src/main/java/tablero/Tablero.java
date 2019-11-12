package tablero;

import ErroresYExcepciones.*;
import celda.Posicion;
import javafx.geometry.Pos;
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

    public void colocarUnidad(Unidad unaUnidad, Posicion posicionDeseada) throws TableroSectorInvalido, CeldaNoEstaEnElTablero {

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
        } catch (CeldaYaTieneUnidad celdaYaTieneUnidad) {
            celdaYaTieneUnidad.printStackTrace();
            // !!!Actuar en caso de excepcion (interfaz)
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
                List<Celda> batallon = crearBatallon(posicionOrigen);
                this.moverBatallon(batallon, posicionDestino);
                return;
            }

            Unidad unidadAMover = celdaOrigen.quitarUnidad();

            celdaDestino.colocarUnidad(unidadAMover);
    }

    private void moverBatallon(List<Celda> batallon, Posicion posicionDestino) throws NoSeEncontroLaCelda, CeldaNoTieneUnidad {
        List<Boolean> seMovio = new ArrayList<>();
        List<Celda> celdasDestinoOrdenadas = crearListaPosicionesDestino(batallon, posicionDestino);

        for (int i = 0; i < 3; i++) {
            seMovio.add(false);
        }

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (!(seMovio.get(j))) {

                    Celda origen = batallon.get(j);
                    Celda destino = celdasDestinoOrdenadas.get(j);
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

    private List<Celda> crearListaPosicionesDestino(List<Celda> batallon, Posicion posicionDestino) throws NoSeEncontroLaCelda {
        List<Celda> celdasDestino = new ArrayList<>();

        Celda celdaCentral = batallon.get(1);
        Posicion posicionCentral = celdaCentral.verPosicion();

        if ( posicionCentral.derecha().equals(posicionDestino) ){
            for (int i = 0; i < 3; i++){
                Celda unaCelda = batallon.get(i);
                Celda celdaDestino = buscarCeldaConPosicion(unaCelda.verPosicion().derecha());
                celdasDestino.add(celdaDestino);
            }
        } else if(posicionCentral.izquierda().equals(posicionDestino) ){
            for (int i = 0; i < 3; i++){
                Celda unaCelda = batallon.get(i);
                Celda celdaDestino = buscarCeldaConPosicion(unaCelda.verPosicion().izquierda());
                celdasDestino.add(celdaDestino);
            }
        } else if(posicionCentral.arriba().equals(posicionDestino)){
            for (int i = 0; i < 3; i++){
                Celda unaCelda = batallon.get(i);
                Celda celdaDestino = buscarCeldaConPosicion(unaCelda.verPosicion().arriba());
                celdasDestino.add(celdaDestino);
            }
        } else if( posicionCentral.abajo().equals(posicionDestino) ){
            for (int i = 0; i < 3; i++){
                Celda unaCelda = batallon.get(i);
                Celda celdaDestino = buscarCeldaConPosicion(unaCelda.verPosicion().abajo());
                celdasDestino.add(celdaDestino);
            }
        }

        return celdasDestino;

    }

    private List<Celda> crearBatallon(Posicion posicionOrigen) throws NoSeEncontroLaCelda, CeldaNoTieneUnidad {

        List<Celda> batallon = new ArrayList<>();

        Celda celdaCentro = this.buscarCeldaConPosicion(posicionOrigen);
        Celda unaCelda;
        Celda otraCelda;

        if (this.esBatallonHorizontal(posicionOrigen)){
            unaCelda = this.buscarCeldaConPosicion(posicionOrigen.derecha());
            otraCelda = this.buscarCeldaConPosicion(posicionOrigen.izquierda());
        }else{
            unaCelda = this.buscarCeldaConPosicion(posicionOrigen.arriba());
            otraCelda = this.buscarCeldaConPosicion(posicionOrigen.abajo());
        }

        batallon.add(unaCelda);
        batallon.add(celdaCentro);
        batallon.add(otraCelda);

        return batallon;
    }

    private boolean esBatallon(Posicion posicionCentro) throws CeldaNoTieneUnidad, NoSeEncontroLaCelda {
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

    private Celda buscarCeldaConPosicion(Posicion laPosicion) throws NoSeEncontroLaCelda {

        Celda celdaQueQuieroEncontrar = new Celda(laPosicion);

        int indiceDeLaCelda = this.celdas.indexOf(celdaQueQuieroEncontrar);

        if (indiceDeLaCelda != -1) return this.celdas.get(indiceDeLaCelda);

        throw new NoSeEncontroLaCelda();

    }

}
