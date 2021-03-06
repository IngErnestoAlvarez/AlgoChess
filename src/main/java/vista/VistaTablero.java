package vista;

import controladores.*;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import modelo.ErroresYExcepciones.NoSeEncontroLaCelda;
import modelo.celda.Posicion;
import modelo.equipo.Equipo;
import modelo.tablero.Tablero;

import java.util.ArrayList;
import java.util.List;

public class VistaTablero extends GridPane {

    private List<VistaCelda> vistaCeldas;
    public VBox unidad;
    private Equipo equipo1;
    private Equipo equipo2;
    private Tablero tablero;
    private MainApp main;
    private Label equipoQueJuega;
    public VistaTablero(Equipo equipo1, Equipo equipo2, Tablero tablero, VBox unidad, MainApp main) throws NoSeEncontroLaCelda {
        super();

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.tablero = tablero;
        this.main = main;
        this.unidad = unidad;
        equipoQueJuega = new Label("El equipo que juega es: " + equipo1.getNombre());
        equipoQueJuega.setFont(Font.font("Cambria", 30));
        equipoQueJuega.setStyle("-fx-background-color:POWDERBLUE");

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
        for (int fila = 1; fila <= tablero.alto; fila++) {
            for (int col = 1; col <= tablero.largo; col++) {
                if(col > tablero.largo / 2){
                    equipo = 1;
                }else{
                    equipo = 2;
                }
                VistaCelda celda = new VistaCelda(tablero.buscarCeldaConPosicion(new Posicion(col, fila)), equipo);
                this.add(celda, fila, col);
                this.vistaCeldas.add(celda);
            }
        }
    }

    public void botones() {
        for (VistaCelda vistaCelda : this.vistaCeldas) {
            vistaCelda.setHandler(new BotonCeldaHandler(vistaCelda.celda, this.unidad));
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

    public Label equipoQueJuega(){
        return this.equipoQueJuega;
    }

    public void cambiarNombreEquipo(){
        equipoQueJuega.setText("El equipo que juega es: " + tablero.equipoQueJuega().getNombre());
    }

    public void modoMoverBatallon() {
        try{
            llenarCeldas();
        }catch (Exception e){}
        for (VistaCelda vistaCelda : this.vistaCeldas){
            vistaCelda.setHandler(new ClickearCeldaMoverBatallon1(this, vistaCelda));
        }

    }
    public void modoRecibirBatallon(VistaCelda celdaOrigen){
        try{
            llenarCeldas();
        }catch(Exception e){}

        for (VistaCelda vistaCelda : this.vistaCeldas) {
            vistaCelda.setHandler(new ClickearCeldaMoverBatallon2(this, celdaOrigen, vistaCelda));

        }
    }
}
