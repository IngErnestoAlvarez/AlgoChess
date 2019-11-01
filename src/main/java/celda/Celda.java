package celda;

import ErroresYExcepciones.CeldaYaTieneUnidad;
import Unidad.Unidad;
import ErroresYExcepciones.CeldaNoTieneUnidad;

public class Celda {

    private boolean vacia;
    private Unidad unidad;


    public Celda(){
        vacia = true;
        unidad = null;
    }

    public Celda(int x, int y){
        vacia = true;
        unidad = null;
    }

    public boolean estaVacia() {
        return this.vacia;
    }

    public boolean estaOcupada(){
        return !this.estaVacia();
    }

    public void colocarUnidad(Unidad unidad) throws CeldaYaTieneUnidad {
        if(this.estaOcupada()){
            throw new CeldaYaTieneUnidad();
        }
        this.unidad = unidad;
        this.vacia = false;
    }

    public Unidad quitarUnidad() throws CeldaNoTieneUnidad {
        if(this.estaVacia()) {
            throw new CeldaNoTieneUnidad();
        }
        Unidad unidadAux = this.unidad;
        this.unidad = null;
        this.vacia = true;
        return unidadAux;
    }

    public Unidad verUnidad() throws CeldaNoTieneUnidad{
        if(this.estaVacia()){
            throw new CeldaNoTieneUnidad();
        }

        return this.unidad;
    }
}
