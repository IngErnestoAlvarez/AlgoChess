package modelo.tablero.movimientos;

import modelo.celda.Posicion;

import java.util.HashMap;

class CalculadorDeMovimientos {

    private HashMap<Posicion, Movimiento> fabricaMovimientos;

    CalculadorDeMovimientos(Posicion posicionOrigen) {

        this.fabricaMovimientos = new HashMap<>(4,2);

        this.fabricaMovimientos.put(posicionOrigen.izquierda(), new Izquierda()); //no sirve porque
        this.fabricaMovimientos.put(posicionOrigen.derecha(), new Derecha());     //no usa .equals() para la clave
        this.fabricaMovimientos.put(posicionOrigen.arriba() , new Arriba());
        this.fabricaMovimientos.put(posicionOrigen.abajo(), new Abajo());

    }

    Movimiento crearMovimiento(Posicion posicionDestino) {
        return this.fabricaMovimientos.get(posicionDestino);
    }

}
