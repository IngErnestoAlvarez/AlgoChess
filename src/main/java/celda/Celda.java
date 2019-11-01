package celda;

import Unidad.Unidad;

public class Celda {

    private boolean vacia;
    private Unidad unidad;


    public Celda(){
        vacia = true;
    }


    public boolean estaVacia() {
        return this.vacia;
    }

    public boolean estaOcupada(){
        return !this.estaVacia();
    }

    public void colocarUnidad(Unidad unidad) {
        this.unidad = unidad;
        this.vacia = false;
    }
}
