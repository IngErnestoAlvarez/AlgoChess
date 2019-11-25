package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import modelo.equipo.Equipo;
import vista.MainApp;


public class BotonConfirmarEquipoHandler implements EventHandler<ActionEvent> {

    private TextField textoEquipo1;
    private TextField textoEquipo2;
    private MainApp main;

    public BotonConfirmarEquipoHandler(TextField textoEquipo1, TextField textoEquipo2, MainApp main){
        this.textoEquipo1 = textoEquipo1;
        this.textoEquipo2 = textoEquipo2;
        this.main = main;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if((this.textoEquipo1.getText().isEmpty())||(this.textoEquipo2.getText().isEmpty())){
            return;
        }

        main.setEquipo1(new Equipo(textoEquipo1.getText(), 20));
        main.setEquipo2(new Equipo(textoEquipo2.getText(), 20));

        main.cambiarAEscenaDeCompra();
    }
}
