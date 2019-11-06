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

    public void comprarSoldado() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades{

        if(Soldado.precio <= this.puntos) {
            Soldado soldado = new Soldado();
            this.unidades.add(soldado);
            this.puntos -= Soldado.precio;
        }
        else if(puntos > 0){
            throw new EquipoNoTienePuntosSuficientes();
        }else{
            throw new EquipoNoPuedeComprarMasUnidades();
        }
    }

    public void comprarCatapulta() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades{

        if(Catapulta.precio <= this.puntos) {
            Catapulta catapulta = new Catapulta();
            this.unidades.add(catapulta);
            this.puntos -= Catapulta.precio;
        }
        else if(puntos > 0){
            throw new EquipoNoTienePuntosSuficientes();
        }else{
            throw new EquipoNoPuedeComprarMasUnidades();
        }
    }

    public void comprarJinete() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades{

        if(Jinete.precio <= this.puntos) {
            Jinete jinete = new Jinete();
            this.unidades.add(jinete);
            this.puntos -= Jinete.precio;
        }
        else if(puntos > 0){
            throw new EquipoNoTienePuntosSuficientes();
        }else{
            throw new EquipoNoPuedeComprarMasUnidades();
        }
    }

    public void comprarCurandero() throws EquipoNoTienePuntosSuficientes, EquipoNoPuedeComprarMasUnidades{

        if(Curandero.precio <= this.puntos) {
            Curandero curandero = new Curandero();
            this.unidades.add(curandero);
            this.puntos -= Curandero.precio;
        }
        else if(puntos > 0){
            throw new EquipoNoTienePuntosSuficientes();
        }else{
            throw new EquipoNoPuedeComprarMasUnidades();
        }
    }

    public boolean tieneUnidades(){
        return ((this.unidades.size())!=0);
    }

    public int cantidadUnidades(){
        return this.unidades.size();
    }

    public int verPuntaje(){
        return this.puntos;
    }

    public Unidad devolverUnaUnidad(){
        if(tieneUnidades()){
            return unidades.get(0);
        }
        return null;
    }

    public void eliminarUnidadesMuertas() {

        if (tieneUnidades()) {
            for (int i = 0; i < cantidadUnidades(); i++) {
                if (unidades.get(i).verVida() <= 0) {
                    unidades.remove(unidades.get(i));
                }
            }
        }
    }

    public boolean esPerdedor(){
        return !(tieneUnidades());
    }
}

