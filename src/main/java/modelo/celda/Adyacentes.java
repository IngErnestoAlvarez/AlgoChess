package modelo.celda;

import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.unidad.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Adyacentes {
    List<Celda> celdas;

    public Adyacentes(List<Celda> adyacentes){
        this.celdas = adyacentes;
    }

    List<Celda> verCeldasAdyacentes(){
        return celdas;
    }

    public List<Unidad> verUnidadesAdyacentes(){
        List<Unidad> unidades = new ArrayList<Unidad>();

        for(Celda celda : celdas){
            try{
                unidades.add(celda.verUnidad());
            } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {}
        }
        return unidades;
    }

    void aniadirAdyacente(Celda celda) {
        celdas.add(celda);
    }
}
