package tablero.movimientos;

import celda.Posicion;

import java.util.HashMap;

public class CalculadorDeMovimientos {

    private HashMap fabricaMovimientos;
    private HashMap hashDeStrings;

    public CalculadorDeMovimientos(Posicion posicionOrigen) {

        this.fabricaMovimientos = new HashMap(4,2);
        this.hashDeStrings = new HashMap(4,2);

        hashDeStrings.put(posicionOrigen.arriba(),"Arriba");
        hashDeStrings.put(posicionOrigen.abajo(),"Abajo");
        hashDeStrings.put(posicionOrigen.izquierda(),"Izquierda");
        hashDeStrings.put(posicionOrigen.derecha(),"Derecha");

        this.fabricaMovimientos.put(hashDeStrings.get(posicionOrigen.izquierda()), new Izquierda());
        this.fabricaMovimientos.put(hashDeStrings.get(posicionOrigen.derecha()), new Derecha());
        this.fabricaMovimientos.put(hashDeStrings.get(posicionOrigen.arriba()) , new Arriba());
        this.fabricaMovimientos.put(hashDeStrings.get(posicionOrigen.abajo()), new Abajo());

    }

    public Movimiento crearMovimiento(Posicion posicionDestino) {
        Movimiento miMovimiento = (Movimiento) this.fabricaMovimientos.get(hashDeStrings.get(posicionDestino));
        return miMovimiento;
    }

}
