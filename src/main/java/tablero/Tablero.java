package tablero;

import ErroresYExcepciones.*;
import unidad.Unidad;
import celda.Celda;
import equipo.Equipo;

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

    public void colocarUnidad(Unidad unaUnidad,int posicionHorizontal,int  posicionVertical) throws TableroSectorInvalido, CeldaNoEstaEnElTablero {

        Celda miCelda = null;

        try{
            miCelda = this.buscarCeldaConPosicion(posicionHorizontal, posicionVertical);
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

    public Unidad verUnidad(int posicionHorizontal, int posicionVertical) throws CeldaNoEstaEnElTablero, CeldaNoTieneUnidad {
        Celda celdaIndicada = null;
        try {
            celdaIndicada = this.buscarCeldaConPosicion(posicionHorizontal,posicionVertical);
        } catch (NoSeEncontroLaCelda noSeEncontroLaCelda) {
            throw new CeldaNoEstaEnElTablero();
        }

        return celdaIndicada.verUnidad();

    }

    public void moverUnidad(int posicionHorizantalOrigen, int posicionVerticalOrigen, int posicionHorizontalDestino, int posicionVerticalDestino) throws NoSeEncontroLaCelda, CeldaNoTieneUnidad, CeldaYaTieneUnidad {
            Celda celdaOrigen = this.buscarCeldaConPosicion(posicionHorizantalOrigen, posicionVerticalOrigen);
            Celda celdaDestino = this.buscarCeldaConPosicion(posicionHorizontalDestino, posicionVerticalDestino);

            if(celdaOrigen.estaVacia()){
                throw new CeldaNoTieneUnidad();
            }

            if(celdaDestino.estaOcupada()){
                throw new CeldaYaTieneUnidad();
            }

            Unidad unidadAMover = celdaOrigen.quitarUnidad();

            celdaDestino.colocarUnidad(unidadAMover);
    }


    private void llenarTablero(int largo,int alto){

        for (int fila = 1; fila <= largo; fila++ ){

            for ( int columna = 1; columna <= alto; columna++ ){

                Celda celda = new Celda( fila , columna );

                this.celdas.add(celda);

                if( fila <= largo/2 ) this.sectorDeArriba.agregar(celda);
                else this.sectorDeAbajo.agregar(celda);

            }

        }

    }

    private Celda buscarCeldaConPosicion(int posicionHorizontal, int posicionVertical) throws NoSeEncontroLaCelda {
        Iterator iter = this.celdas.iterator();
        Celda celdaQueQuieroEncontrar = new Celda(posicionHorizontal,posicionVertical);
        Celda celdaActual = null;
        while(iter.hasNext()){
            celdaActual = (Celda) iter.next();
            if(celdaQueQuieroEncontrar.medirDistacia(celdaActual) == 0) return celdaActual;
        }
        throw new NoSeEncontroLaCelda();
        // !!!Actuar en caso de excepcion (interfaz)
    }
}
