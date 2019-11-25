package vista;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import modelo.equipo.Equipo;
import modelo.unidad.Catapulta;
import modelo.unidad.Curandero;
import modelo.unidad.Jinete;
import modelo.unidad.Soldado;

public class VistaCompraUnidad extends HBox {

    public VistaCompraUnidad(Equipo equipo, HBox vistaUnidades){
        super();

        this.setSpacing(40);

        this.getChildren().add(new VistaUnidad(new Soldado()));
        this.getChildren().add(new VistaUnidad(new Jinete()));
        this.getChildren().add(new VistaUnidad(new Catapulta()));
        this.getChildren().add(new VistaUnidad(new Curandero()));

        for(Node vista : this.getChildren()){
            VistaUnidad vistaUnidad = (VistaUnidad)vista;
            vistaUnidad.getBotonDeCompraHandler().setEquipo(equipo);
            vistaUnidad.getBotonDeCompraHandler().setVistaUnidades(vistaUnidades);
        }
    }

}
