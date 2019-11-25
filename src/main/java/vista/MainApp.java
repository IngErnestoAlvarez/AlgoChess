package vista;

import controladores.BotonConfirmarEquipoHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.equipo.Equipo;
import modelo.tablero.Tablero;

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

        this.escenario = stage;

        this.escenario.setTitle("AlgoChess");

        this.escenario.setScene(this.escenaInicial());

        this.escenario.show();
    }



    private Scene escenaInicial(){

        Label labelEquipo1 = new Label("Equipo1");
        labelEquipo1.setFont(Font.font("Cambria", 32));
        TextField nombreEquipo1 = new TextField();
        nombreEquipo1.setPromptText("Escriba el nombre del equipo1");
        HBox boxEquipo1 = new HBox(labelEquipo1, nombreEquipo1);
        boxEquipo1.setSpacing(15);


        Label labelEquipo2 = new Label("Equipo2");
        labelEquipo2.setFont(Font.font("Cambria", 32));
        TextField nombreEquipo2 = new TextField();
        nombreEquipo2.setPromptText("Escriba el nombre del equipo2");
        HBox boxEquipo2 = new HBox(labelEquipo2, nombreEquipo2);
        boxEquipo2.setSpacing(15);

        Button botonEnviar = new Button();
        botonEnviar.setText("Confirmar");
        botonEnviar.setOnAction(new BotonConfirmarEquipoHandler(nombreEquipo1, nombreEquipo2, this));

        VBox contenedorPrincipal = new VBox(boxEquipo1, boxEquipo2, botonEnviar);
        contenedorPrincipal.setSpacing(30);
        contenedorPrincipal.setPadding(new Insets(300));

        return new Scene(contenedorPrincipal, 1200, 800);
    }



    public void cambiarAEscenaDeCompra() {
        this.escenario.setScene(this.escenaDeCompra());
    }

    private Scene escenaDeCompra() {

        HBox botonera = new HBox();

        HBox unidades = new HBox();


        VBox contenedorPrincipal = new VBox(new VistaCompraUnidad(), unidades, botonera);
        return new Scene(contenedorPrincipal, 1200, 800);
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
}