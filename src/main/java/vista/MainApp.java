package vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import modelo.unidad.Jinete;
import modelo.unidad.Soldado;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainApp extends Application {
    private Stage escenario;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setMaximized(true);

        stage.setResizable(false);

        this.escenario = stage;

        this.escenario.setTitle("AlgoChess");

        this.escenario.setScene(this.escenaTablero());

        this.escenario.show();
    }



    private Scene escenaInicial(){

        Label labelEquipo1 = new Label("Equipo1");
        labelEquipo1.setFont(Font.font("Cambria", 32));
        TextField nombreEquipo1 = new TextField("Escriba el nombre del equipo1");
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

        VBox contenedorPrincipal = new VBox(boxEquipo1, boxEquipo2, botonEnviar);
        contenedorPrincipal.setSpacing(30);
        contenedorPrincipal.setPadding(new Insets(300));

        return new Scene(contenedorPrincipal, 1200, 800);
    }


    private Scene escenaDeCompra() {

        HBox botonera = new HBox();

        HBox unidades = new HBox();

        VBox contenedorPrincipal = new VBox(new VistaCompraUnidad(), unidades, botonera);
        return new Scene(contenedorPrincipal, 1200, 800);
    }

    private Scene escenaTablero() throws Exception {

        Background fondo = new Background(new BackgroundImage(new Image(new FileInputStream("./resources/imagenes/fondo.png")),
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1200, 800, false, false, false, false)));

        GridPane tablero = new VistaTablero(new Equipo(), new Equipo());

        Label textoEntreUnidades = new Label("vs");
        textoEntreUnidades.setVisible(false);

        VBox unidades = new VBox(new VBox(), textoEntreUnidades ,new VBox());

        unidades.setSpacing(40);

        HBox contenedorPrincipal = new HBox(unidades, tablero);

        contenedorPrincipal.setBackground(fondo);
        contenedorPrincipal.setAlignment(Pos.CENTER);

        contenedorPrincipal.setSpacing(20);

        return new Scene(contenedorPrincipal, 1200, 800);
    }
}