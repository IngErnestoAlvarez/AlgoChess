package vista;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import modelo.unidad.Unidad;

public class VistaUnidadTablero extends Label {
    private Unidad unidad;
    public ImageView imagen;

    public VistaUnidadTablero(ImageView imagen, Unidad unidad){
        super();
        this.setGraphic(imagen);
        this.unidad = unidad;
        this.imagen = imagen;
        }



    public void setClickearImagen(EventHandler<MouseEvent> evento){
        this.setPickOnBounds(true);
        this.setOnMouseClicked(evento);
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setTamanio(int h, int w){
        imagen.setFitHeight(h);
        imagen.setFitWidth(w);
    }

}
