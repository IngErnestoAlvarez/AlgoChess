package vista;

import controladores.BotonComprarUnidadHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.unidad.Unidad;

public class VistaUnidadComprar extends VBox {

    private BotonComprarUnidadHandler botonDeCompraHandler;


    public VistaUnidadComprar(Unidad unidad){
        this.getChildren().add(new VistaUnidad(unidad));

        Button botonDeCompra = new Button("Comprar " + unidad.getClass().getSimpleName());
        this.botonDeCompraHandler = new BotonComprarUnidadHandler(unidad);
        botonDeCompra.setOnAction(this.botonDeCompraHandler);

        this.getChildren().add(botonDeCompra);
    }

    public BotonComprarUnidadHandler getBotonDeCompraHandler() {
        return botonDeCompraHandler;
    }
}
