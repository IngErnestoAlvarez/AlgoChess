package vista;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import modelo.unidad.Unidad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Hashtable;

public class VistaUnidad extends VBox {


    public VistaUnidad(Unidad unidad){
        super();

        Label nombre = new Label(unidad.getClass().getSimpleName());
        nombre.setFont(Font.font("Cambria", 30));

        Label vida = new Label("Vida: " + unidad.getVida());

        Label precio = new Label("Precio: " + unidad.getPrecio());


        this.setSpacing(40);
        this.getChildren().add(this.imagenDeUnidad(unidad));
        this.getChildren().add(nombre);
        this.getChildren().add(vida);
        this.getChildren().add(precio);
    }


    public static VistaUnidadTablero imagenDeUnidad(Unidad unidad){

        Hashtable<String, String> directorio = new Hashtable<>();

        directorio.put("Soldado", "./resources/imagenes/Soldado.png");
        directorio.put("Jinete", "./resources/imagenes/Soldado.png");
        directorio.put("Catapulta", "./resources/imagenes/Soldado.png");
        directorio.put("Curandero", "./resources/imagenes/Curandero.png");

        Image imagenFinal = null;
        try {
            imagenFinal = new Image(new FileInputStream(directorio.get(unidad.getClass().getSimpleName())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        ImageView imagen = new ImageView();
        imagen.setFitHeight(70);
        imagen.setFitWidth(70);
        imagen.setPreserveRatio(true);
        imagen.setImage(imagenFinal);
        VistaUnidadTablero label = new VistaUnidadTablero(imagen, unidad);


        return label;
    }



}
