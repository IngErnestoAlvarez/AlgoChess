package celda;

import ErroresYExcepciones.CeldaYaTieneUnidad;
import net.bytebuddy.dynamic.scaffold.inline.AbstractInliningDynamicTypeBuilder;
import unidad.Unidad;
import ErroresYExcepciones.CeldaNoTieneUnidad;

import java.util.ArrayList;
import java.util.List;

public class Celda {
    EstadoCelda estado;
    private Posicion posicion;
    private Adyacentes adyacentes;


    public Celda(){
        estado = new EstadoCeldaVacia();
        posicion = new Posicion();
        adyacentes = new Adyacentes(new ArrayList<Celda>());
    }

    public Celda(Posicion unaPosicion, Adyacentes adyacentes){
        this.estado = new EstadoCeldaVacia();
        this.posicion = unaPosicion;
        this.adyacentes = adyacentes;
    }

    public Celda(Posicion unaPosicion){
        estado = new EstadoCeldaVacia();
        this.posicion = unaPosicion;
        adyacentes = new Adyacentes(new ArrayList<Celda>());
    }

    public Celda(int x, int y){
        posicion = new Posicion(x , y);
        estado = new EstadoCeldaVacia();
        adyacentes = new Adyacentes(new ArrayList<Celda>());
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

    public Posicion verPosicion() {
        return this.posicion;
    }

    public List<Unidad> verUnidadesAdyacentes(){
        return adyacentes.verUnidadesAdyacentes();
    }

    public List<Celda> verCeldasAdyacentes(){
        return adyacentes.verCeldasAdyacentes();
    }

    public void darAdyacente(Celda celdaAAniadir){
        this.adyacentes.aniadirAdyacente(celdaAAniadir);
    }
}


