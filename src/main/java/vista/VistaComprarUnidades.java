package vista;

import controladores.BotonComprarUnidadHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import modelo.equipo.Equipo;
import modelo.unidad.Catapulta;
import modelo.unidad.Curandero;
import modelo.unidad.Jinete;
import modelo.unidad.Soldado;

public class VistaComprarUnidades extends HBox {

    public VistaComprarUnidades(Equipo equipo, HBox vistaUnidades){
        super();

        this.setSpacing(40);

        this.getChildren().add(new VistaUnidadComprar(new Soldado()));
        this.getChildren().add(new VistaUnidadComprar(new Jinete()));
        this.getChildren().add(new VistaUnidadComprar(new Catapulta()));
        this.getChildren().add(new VistaUnidadComprar(new Curandero()));

        for(Node vista : this.getChildren()){
            VistaUnidadComprar vistaUnidad = (VistaUnidadComprar)vista;
            vistaUnidad.getBotonDeCompraHandler().setEquipo(equipo);
            vistaUnidad.getBotonDeCompraHandler().setVistaUnidades(vistaUnidades);
        }
    }

}
