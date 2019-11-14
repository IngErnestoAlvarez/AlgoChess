package tablero.movimientos;

import celda.Posicion;

import java.util.HashMap;

public class CalculadorDeMovimientos {

    private HashMap fabricaMovimientos;

    public CalculadorDeMovimientos(Posicion posicionOrigen) {

        this.fabricaMovimientos = new HashMap(4,2);

        this.fabricaMovimientos.put(posicionOrigen.izquierda(), new Izquierda()); //no sirve porque
        this.fabricaMovimientos.put(posicionOrigen.derecha(), new Derecha());     //no usa .equals() para la clave
        this.fabricaMovimientos.put(posicionOrigen.arriba() , new Arriba());
        this.fabricaMovimientos.put(posicionOrigen.abajo(), new Abajo());

    }

    public Movimiento crearMovimiento(Posicion posicionDestino) {
        Movimiento miMovimiento = (Movimiento) this.fabricaMovimientos.get(posicionDestino);
        return miMovimiento;
    }

}
