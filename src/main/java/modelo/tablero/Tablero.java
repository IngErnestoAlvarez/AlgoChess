package modelo.tablero;

import modelo.ErroresYExcepciones.*;
import modelo.celda.Posicion;
import modelo.equipo.Equipo;
import modelo.tablero.movimientos.Movimiento;
import modelo.unidad.Catapulta;
import modelo.unidad.Unidad;
import modelo.celda.Celda;
import modelo.unidad.batallon.Batallon;

import java.util.ArrayList;
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
        sectorDeAbajo.setEquipo(equipoDeAbajo);
        this.sectorDeArriba = new Sector();
        sectorDeArriba.setEquipo(equipoDeArriba);
        this.sectorActual = sectorDeAbajo;

        this.celdas = new ArrayList<Celda>();
        this.llenarTablero(largo, alto);
        this.llenarAdyacentesCeldas();
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

    public void moverBatallon(Posicion centroDelBatallon, Posicion destinoDelBatallon) throws NoSeEncontroLaCelda, CeldaNoTieneUnidad, MovimientoInvalido, NoEsBatallon {

        Celda celdaOrigen = this.buscarCeldaConPosicion(centroDelBatallon);
        Celda celdaDestino = this.buscarCeldaConPosicion(destinoDelBatallon);

        if(celdaOrigen.medirDistacia(celdaDestino) != 1 || celdaOrigen.verUnidad() instanceof Catapulta) throw new MovimientoInvalido();

        Batallon unBatallon = new Batallon(celdaOrigen,this);
        Movimiento movimientoDelBatallon = new Movimiento(centroDelBatallon,destinoDelBatallon);
        unBatallon.moverBatallon(movimientoDelBatallon);

    }

    public void interaccion(Posicion posicionOrigen, Posicion posicionDestino) throws CeldaNoTieneUnidad, NoSeEncontroLaCelda, RangoMuyLejano, RangoMuyCercano {

        Celda celdaOrigen = this.buscarCeldaConPosicion(posicionOrigen);
        Celda celdaDestino = this.buscarCeldaConPosicion(posicionDestino);

        Unidad unidadAtacante = celdaOrigen.verUnidad();
        Unidad unidadVictima = celdaDestino.verUnidad();

        double incremento = 1;

        try {
            sectorDeAbajo.encontrarCelda(celdaDestino);
            incremento = sectorDeAbajo.definirIncremento(celdaDestino);
        } catch (CeldaNoEstaEnMiSector celdaNoEstaEnMiSector) {
            incremento = sectorDeArriba.definirIncremento(celdaDestino);
        }

        unidadAtacante.interactuar(unidadVictima, posicionOrigen.medirDistancia(posicionDestino), incremento);

    }

    public void moverUnidad(Posicion posicionOrigen, Posicion posicionDestino) throws NoSeEncontroLaCelda, CeldaNoTieneUnidad, CeldaYaTieneUnidad, MovimientoInvalido {
        Celda celdaOrigen = this.buscarCeldaConPosicion(posicionOrigen);
        Celda celdaDestino = this.buscarCeldaConPosicion(posicionDestino);

        if(celdaOrigen.medirDistacia(celdaDestino) != 1 || celdaOrigen.verUnidad() instanceof Catapulta) throw new MovimientoInvalido();

        Unidad unidadAMover = celdaOrigen.quitarUnidad();

        celdaDestino.colocarUnidad(unidadAMover);
    }



    private void llenarTablero(int largo, int alto){

        for (int columna = 1; columna <= largo; columna++ ){

            for ( int fila = 1; fila <= alto; fila++ ){

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

    private void llenarAdyacentesCeldas(){

        Celda celdaIzquierda;
        Celda celdaDerecha;
        Celda celdaArriba;
        Celda celdaAbajo;

        for(Celda celdaActual : this.celdas){
            try {
                celdaIzquierda = this.buscarCeldaConPosicion(celdaActual.verPosicion().izquierda());
                celdaActual.darAdyacente(celdaIzquierda);
            } catch (NoSeEncontroLaCelda e) {}

            try {
                celdaDerecha = this.buscarCeldaConPosicion(celdaActual.verPosicion().derecha());
                celdaActual.darAdyacente(celdaDerecha);
            } catch (NoSeEncontroLaCelda e) {}

            try {
                celdaArriba = this.buscarCeldaConPosicion(celdaActual.verPosicion().arriba());
                celdaActual.darAdyacente(celdaArriba);
            } catch (NoSeEncontroLaCelda e) {}

            try {
                celdaAbajo = this.buscarCeldaConPosicion(celdaActual.verPosicion().abajo());
                celdaActual.darAdyacente(celdaAbajo);
            } catch (NoSeEncontroLaCelda e) { }
        }
    }

}
