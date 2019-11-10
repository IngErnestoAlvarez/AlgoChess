package equipo;

import java.util.List;
import java.util.ArrayList;

import unidad.*;
import ErroresYExcepciones.*;


public class Equipo{

    private String nombre;
    private List<Unidad> unidades;
    private int puntos;

    public Equipo(){
        this.nombre = "";
        this.unidades = new ArrayList<Unidad>();
        this.puntos = 20;
    }

    public Equipo (String nombre, int puntos){
        this.nombre = nombre;
        this.unidades= new ArrayList<Unidad>();
        this.puntos = puntos;
    }

    public Unidad comprarUnidad(String claseUnidad) throws EquipoQuiereCrearUnidadInvalida, EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades {

        FabricaUnidad fabricaUnidad = new FabricaUnidad();
        Unidad unidadAComprar;

        unidadAComprar = fabricaUnidad.fabricar(claseUnidad);

        if(unidadAComprar.getPrecio() <= this.puntos) {
            this.unidades.add(unidadAComprar);
            this.puntos -= unidadAComprar.getPrecio();
            return unidadAComprar;
        }else{
            if (this.puntos > 0){
                throw new EquipoNoTienePuntosSuficientes();
            }else{
                throw new EquipoNoPuedeComprarMasUnidades();
            }
        }
    }

    public boolean tieneUnidades(){
        return ((this.unidades.size())!=0);
    }

    public int getCantidadUnidades(){
        return this.unidades.size();
    }

    public int getPuntaje(){
        return this.puntos;
    }

    public void eliminarUnidadesMuertas() {

        if (tieneUnidades()) {
            for (int i = 0; i < getCantidadUnidades(); i++) {
                if (unidades.get(i).getVida() <= 0) {
                    unidades.remove(unidades.get(i));
                }
            }
        }
    }

    public boolean esPerdedor(){
        return !(tieneUnidades());
    }
}

