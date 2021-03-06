package vista;

import controladores.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.ErroresYExcepciones.NoSeEncontroLaCelda;
import modelo.equipo.Equipo;
import modelo.tablero.Tablero;
import modelo.unidad.Unidad;

import java.io.FileInputStream;

public class MainApp extends Application {
    private Stage escenario;
    private Equipo equipo1;
    private Equipo equipo2;
    private Tablero tablero;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setMaximized(true);

        stage.setResizable(true);

        this.escenario = stage;

        this.escenario.setTitle("AlgoChess");

        this.escenario.setScene(this.escenaInicial());

        this.escenario.show();
    }



    private Scene escenaInicial() throws Exception{

        Image fondoImagen = new Image(new FileInputStream("./resources/imagenes/fondoantes.png"));

        Background fondo = new Background(new BackgroundImage(fondoImagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(50, 50, false, false, false, false)));

        Label titulo = new Label("AlgoChess");
        titulo.setFont(Font.font("Glamor", 72));


        Label labelEquipo1 = new Label("Equipo 1");
        labelEquipo1.setFont(Font.font("Cambria", 32));
        TextField nombreEquipo1 = new TextField();
        nombreEquipo1.setPromptText("Nombre");
        HBox boxEquipo1 = new HBox(labelEquipo1, nombreEquipo1);
        boxEquipo1.setSpacing(15);


        Label labelEquipo2 = new Label("Equipo 2");
        labelEquipo2.setFont(Font.font("Cambria", 32));
        TextField nombreEquipo2 = new TextField();
        nombreEquipo2.setPromptText("Nombre");
        HBox boxEquipo2 = new HBox(labelEquipo2, nombreEquipo2);
        boxEquipo2.setSpacing(15);

        Button botonEnviar = new Button();
        botonEnviar.setText("Play");
        botonEnviar.setOnAction(new BotonConfirmarEquipoHandler(nombreEquipo1, nombreEquipo2, this));

        VBox contenedorPrincipal = new VBox(titulo, boxEquipo1, boxEquipo2, botonEnviar);
        contenedorPrincipal.setSpacing(30);
        contenedorPrincipal.setBackground(fondo);
        contenedorPrincipal.setPadding(new Insets(300));

        return new Scene(contenedorPrincipal, 1920, 1080);
    }



    public void cambiarAEscenaDeCompra() throws Exception {
        this.escenario.setScene(this.escenaDeCompra1());
    }

    private Scene escenaDeCompra1() throws Exception{

        Image fondoImagen = new Image(new FileInputStream("./resources/imagenes/fondoantes.png"));

        Background fondo = new Background(new BackgroundImage(fondoImagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(50, 50, false, false, false, false)));

        Label nombreEquipo = new Label("Equipo: " + equipo1.getNombre());
        Label puntosResantes = new Label("Puntos restantes: " + equipo1.getPuntaje());
        Button botonDeTerminar = new Button("TerminarCompra");
        botonDeTerminar.setOnAction(new BotonCambiarDeEquipoCompra(this));

        HBox botonera = new HBox(nombreEquipo, puntosResantes, botonDeTerminar);
        botonera.setSpacing(50);

        HBox unidades = new HBox();

        VBox contenedorPrincipal = new VBox(new VistaComprarUnidades(this.equipo1, unidades, puntosResantes), botonera, unidades);
        contenedorPrincipal.setSpacing(30);
        contenedorPrincipal.setBackground(fondo);
        return new Scene(contenedorPrincipal, 1920, 1080);
    }


    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void cambiarAEscenaDeCompra2() throws Exception {
        this.escenario.setScene(this.escenaDeCompra2());
    }

    private Scene escenaDeCompra2() throws Exception{

        Image fondoImagen = new Image(new FileInputStream("./resources/imagenes/fondoantes.png"));

        Background fondo = new Background(new BackgroundImage(fondoImagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(50, 50, false, false, false, false)));

        Label nombreEquipo = new Label("Equipo: " + equipo2.getNombre());
        Label puntosResantes = new Label("Puntos restantes: " + equipo2.getPuntaje());
        Button botonDeTerminar = new Button("TerminarCompra");
        botonDeTerminar.setOnAction(new BotonPasarAColocarUnidad(this));

        HBox botonera = new HBox(nombreEquipo, puntosResantes, botonDeTerminar);
        botonera.setSpacing(50);

        HBox unidades = new HBox();

        VBox contenedorPrincipal = new VBox(new VistaComprarUnidades(this.equipo2, unidades, puntosResantes), botonera, unidades);
        contenedorPrincipal.setSpacing(30);
        contenedorPrincipal.setBackground(fondo);
        return new Scene(contenedorPrincipal, 1920, 1080);
    }
    public void cambiarAEscenaColocarUnidad1() throws Exception {
        this.escenario.setScene(this.escenaColocarUnidad1());
    }

    private Scene escenaColocarUnidad1() throws Exception {

        Image fondoImagen = new Image(new FileInputStream("./resources/imagenes/fondoantes.png"));

        Background fondo = new Background(new BackgroundImage(fondoImagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(50, 50, false, false, false, false)));

        VistaTablero tablero = new VistaTablero(this.equipo1, this.equipo2, this.getTablero(), null, this);


        VBox unidades = new VBox();
        Label nombreUnidades = new Label("UNIDADES");
        nombreUnidades.setFont(Font.font("Cambria", 25));

        VBox unidadesCompleta = new VBox(nombreUnidades, unidades);
        unidadesCompleta.setSpacing(20);

        for(Unidad unidad : equipo1.getUnidades()){
            unidades.getChildren().add(VistaUnidad.imagenDeUnidad(unidad));
        }

        VBox seleccionados = new VBox();
        Label nombreSeleccionados = new Label("SELECCIONADAS");
        nombreSeleccionados.setFont(Font.font("Cambria", 25));

        VBox seleccionadosCompleta = new VBox(nombreSeleccionados, seleccionados);
        seleccionadosCompleta.setSpacing(20);

        for(Node nodo : unidades.getChildren()){
            VistaUnidadTablero vistaPrueba = (VistaUnidadTablero) nodo;
            vistaPrueba.setClickearImagen(new ClickearYCambiarDeLugarImagen(vistaPrueba, unidades, seleccionados));
        }


        tablero.colocarHandlers(seleccionados);

        Button botonCambioDeEquipo = new Button("Confirmar");
        botonCambioDeEquipo.setOnAction(new BotonCambiarDeEquipoColocar(this, this.tablero, unidades, seleccionados));

        unidadesCompleta.getChildren().add(botonCambioDeEquipo);




        HBox contenedorPrincipal = new HBox(tablero, unidadesCompleta, seleccionadosCompleta);
        contenedorPrincipal.setSpacing(30);
        contenedorPrincipal.setBackground(fondo);

        return new Scene(contenedorPrincipal, 1920, 1080);
    }
    private Scene escenaColocarUnidad2() throws Exception {

        Image fondoImagen = new Image(new FileInputStream("./resources/imagenes/fondoantes.png"));

        Background fondo = new Background(new BackgroundImage(fondoImagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(50, 50, false, false, false, false)));

        VistaTablero tablero = new VistaTablero(this.equipo1, this.equipo2, this.getTablero(), null, this);

        VBox unidades = new VBox();
        Label nombreUnidades = new Label("UNIDADES");
        nombreUnidades.setFont(Font.font("Cambria", 25));

        VBox unidadesCompleta = new VBox(nombreUnidades, unidades);
        unidadesCompleta.setSpacing(20);

        for(Unidad unidad : equipo2.getUnidades()){
            unidades.getChildren().add(VistaUnidad.imagenDeUnidad(unidad));
        }

        VBox seleccionados = new VBox();
        Label nombreSeleccionados = new Label("SELECCIONADAS");
        nombreSeleccionados.setFont(Font.font("Cambria", 25));

        VBox seleccionadosCompleta = new VBox(nombreSeleccionados, seleccionados);
        seleccionadosCompleta.setSpacing(20);

        for(Node nodo : unidades.getChildren()){
            VistaUnidadTablero vistaPrueba = (VistaUnidadTablero) nodo;
            vistaPrueba.setClickearImagen(new ClickearYCambiarDeLugarImagen(vistaPrueba, unidades, seleccionados));
        }




        for(Node nodos : tablero.getChildren()){
            VistaCelda vistaCeldaunica = (VistaCelda)nodos;
            vistaCeldaunica.setHandler(new ClickearCeldaColocarUnidad(seleccionados, this.getTablero(), vistaCeldaunica, tablero));
        }
        Button botonCambioDeEquipo = new Button("Confirmar");
        botonCambioDeEquipo.setOnAction(new BotonCambiarAEscenaPrincipal(this, unidades, seleccionados));
        unidadesCompleta.getChildren().add(botonCambioDeEquipo);


        HBox contenedorPrincipal = new HBox(tablero, unidadesCompleta, seleccionadosCompleta);
        contenedorPrincipal.setSpacing(30);
        contenedorPrincipal.setBackground(fondo);

        return new Scene(contenedorPrincipal, 1920, 1080);
    }

    public void cambiarAEscenaPrincipal() throws Exception {
        this.escenario.setScene(this.escenaTablero());
    }

    private Scene escenaTablero() throws Exception {

        Image fondoImagen = new Image(new FileInputStream("./resources/imagenes/fondo.png"));

        Background fondo = new Background(new BackgroundImage(fondoImagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(80, 80, false, false, false, false)));


        VBox unidades = new VBox();

        VistaTablero tablero = new VistaTablero(this.equipo1, this.equipo2, this.tablero, unidades, this);
        tablero.botones();


        unidades.setSpacing(40);

        VBox controles = new VBox();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(unidades, tablero, controles);

        contenedorPrincipal.setBackground(fondo);
        contenedorPrincipal.setAlignment(Pos.CENTER);

        contenedorPrincipal.setSpacing(20);

        return new Scene(contenedorPrincipal, 1920, 1080);
    }

    public void cambiarAEscenaColocarUnidad2() throws Exception {
        this.escenario.setScene(this.escenaColocarUnidad2());
    }

    public void cambiarAEscenaGanador(Equipo equipo2) {
        this.escenario.setScene(this.escenaGanador(equipo2));
    }

    private Scene escenaGanador(Equipo equipo2) {
        VBox contenedorPrincipal = new VBox();

        Label ganador = new Label("GANADOR: " + equipo2.getNombre().toUpperCase());
        ganador.setFont(Font.font("Cambria", 100));

        Button botonJugarDeNuevo = new Button("Jugar de Nuevo");
        botonJugarDeNuevo.setOnAction(new BotonIniciarJuegoDeVuetla(this));

        contenedorPrincipal.getChildren().add(ganador);
        contenedorPrincipal.getChildren().add(botonJugarDeNuevo);


        return new Scene(contenedorPrincipal, 1920, 1080);
    }

    public void cambiarAEscenaInicial() throws Exception{
        this.escenario.setScene(escenaInicial());
    }
}