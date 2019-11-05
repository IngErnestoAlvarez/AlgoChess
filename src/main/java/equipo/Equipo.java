package Equipo;

import ErroresYExcepciones.EquipoNoPuedeComprarMasUnidades;
import Unidad.Unidad;
import java.util.List;
import java.util.ArrayList;
import Equipo.Equipo;
import Unidad.Soldado;
import Unidad.Catapulta;
import Unidad.Jinete;
import Unidad.Curandero;

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

    public void comprarUnidad(Unidad unidad){

        if (unidad.verPrecio() <= this.puntos){
            this.unidades.add(unidad);
            this.puntos -= unidad.verPrecio();
        }
        if(puntos > 0){
            //throw new EquipoNoTienePuntosSuficientes();
        }else{
            //throw new EquipoNoPuedeComprarMasUnidades();
        }
    }


    public void comprarSoldado(){

        Soldado soldado = new Soldado();

        if(soldado.verPrecio() <= this.puntos) {
            this.unidades.add(soldado);
            this.puntos -= soldado.verPrecio();
        }
        if(puntos > 0){
            //throw new EquipoNoTienePuntosSuficientes();
        }else{
            //throw new EquipoNoPuedeComprarMasUnidades();
        }
    }

    public void comprarCatapulta(){

        Catapulta catapulta = new Catapulta();

        if(catapulta.verPrecio() <= this.puntos) {
            this.unidades.add(catapulta);
            this.puntos -= catapulta.verPrecio();
        }
        if(puntos > 0){
            //throw new EquipoNoTienePuntosSuficientes();
        }else{
            //throw new EquipoNoPuedeComprarMasUnidades();
        }
    }

    public void comprarJinete(){

        Jinete jinete = new Jinete();

        if(jinete.verPrecio() <= this.puntos) {
            this.unidades.add(jinete);
            this.puntos -= jinete.verPrecio();
        }
        if(puntos > 0){
            //throw new EquipoNoTienePuntosSuficientes();
        }else{
            //throw new EquipoNoPuedeComprarMasUnidades();
        }
    }

    public void comprarCurandero(){

        Curandero curandero = new Curandero();

        if(curandero.verPrecio() <= this.puntos) {
            this.unidades.add(curandero);
            this.puntos -= curandero.verPrecio();
        }
        else if(puntos > 0){
            //throw new EquipoNoTienePuntosSuficientes();
        }else{
            //throw new EquipoNoPuedeComprarMasUnidades();
        }
    }

    public boolean tieneUnidades(){
        return (this.unidades.size()!=0);
    }

    public int cantidadUnidades(){
        return this.unidades.size();
    }

    public int verPuntaje(){
        return this.puntos;
    }
}

