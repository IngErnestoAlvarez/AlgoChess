package celda;

import ErroresYExcepciones.CeldaYaTieneUnidad;
import unidad.Unidad;
import ErroresYExcepciones.CeldaNoTieneUnidad;

public class Celda {
    EstadoCelda estado;
    private Posicion posicion;


    public Celda(){
        estado = new EstadoCeldaVacia();
        posicion = new Posicion();
    }

    public Celda(int x, int y){
        posicion = new Posicion(x , y);
        estado = new EstadoCeldaVacia();
    }

    public void colocarUnidad(Unidad unidad) throws CeldaYaTieneUnidad {
        estado.colocarUnidad(this, unidad);
    }

    public Unidad quitarUnidad() throws CeldaNoTieneUnidad {
        return estado.quitarUnidad(this);
    }

    public Unidad verUnidad() throws CeldaNoTieneUnidad{
        return estado.verUnidad();
    }

    public int medirDistacia(Celda celdaAComparar) {
        return this.posicion.medirDistancia(celdaAComparar.verPosicion());
    }

    @Override
    public boolean equals(Object celdaAComparar) {
        Celda unaCelda = (Celda) celdaAComparar;
        return this.medirDistacia(unaCelda) == 0;
    }

    private Posicion verPosicion() {
        return this.posicion;
    }

}


