package vista;

import controladores.*;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modelo.ErroresYExcepciones.NoSeEncontroLaCelda;
import modelo.celda.Posicion;
import modelo.equipo.Equipo;
import modelo.tablero.Tablero;

import java.util.ArrayList;
import java.util.List;

public class VistaTablero extends GridPane {

    private List<VistaCelda> vistaCeldas;
    public VBox unidadesIzquierda;
    private Equipo equipo1;
    private Equipo equipo2;
    private Tablero tablero;
    private MainApp main;
    public VistaTablero(Equipo equipo1, Equipo equipo2, Tablero tablero, VBox unidadesIzquierda, MainApp main) throws NoSeEncontroLaCelda {
        super();

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.tablero = tablero;
        this.main = main;

        this.vistaCeldas = new ArrayList<>();

        this.setHeight(1280);
        this.setWidth(720);
        this.setVgap(5);
        this.setHgap(5);

        try {
            this.llenarCeldas();
        } catch (Exception e) {
        }
    }

    public void llenarCeldas() throws NoSeEncontroLaCelda {
        int equipo;
        this.vistaCeldas.clear();
        this.getChildren().clear();
        for (int fila = 1; fila <= 20; fila++) {
            for (int col = 1; col <= 20; col++) {
                if(col > 10){
                    equipo = 1;
                }else{
                    equipo = 2;
                }
                VistaCelda celda = new VistaCelda(tablero.buscarCeldaConPosicion(new Posicion(col, fila)), equipo);
                celda.unidadesAMostrar(unidadesIzquierda);
                this.add(celda, fila, col);
                this.vistaCeldas.add(celda);
            }
        }
    }

    public void botones() {
        for (VistaCelda vistaCelda : this.vistaCeldas) {
            vistaCelda.setHandler(new BotonCeldaHandler(vistaCelda.celda));
        }
    }

    public void colocarHandlers(VBox seleccionados){
        for(Node nodos : this.getChildren()){
            VistaCelda vistaCeldaunica = (VistaCelda)nodos;
            vistaCeldaunica.setHandler(new ClickearCeldaColocarUnidad(seleccionados, tablero, vistaCeldaunica, this));
        }
    }

    public void modoMovimiento() {
        try {
            llenarCeldas();
        } catch (Exception e) {

        }
        for(VistaCelda vistaCelda : this.vistaCeldas){
            vistaCelda.setHandler(new ClickearCeldaMoverUnidad1(this, vistaCelda));
        }
    }

    public void modoRecibirUnidad(VistaCelda celdaOrigen) {
        try {
            llenarCeldas();
        } catch (Exception e) {

        }
        for (VistaCelda vistaCelda : this.vistaCeldas){
            vistaCelda.setHandler(new ClickearCeldaMoverUnidad2(this, celdaOrigen, vistaCelda));
        }
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void modoAtaque() {
        try{
            llenarCeldas();
        } catch (Exception e){}

        for(VistaCelda vistaCelda : this.vistaCeldas){
            vistaCelda.setHandler(new ClickearCeldaAtaqueUnidad1(this, vistaCelda, main));
        }
    }

    public void modoRecibirAtaque(VistaCelda vistaCeldaOrigen, MainApp main) {
        try{
            llenarCeldas();
        } catch (Exception e){}

        for (VistaCelda vistaCelda : this.vistaCeldas){
            vistaCelda.setHandler(new ClickearCeldaAtaqueUnidad2(this, vistaCeldaOrigen, vistaCelda, main));
        }
    }
    //    public VistaTablero refresh()throws Exception{
//        return new VistaTablero(equipo1, equipo2, tablero, unidadesIzquierda);
//    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }
}
