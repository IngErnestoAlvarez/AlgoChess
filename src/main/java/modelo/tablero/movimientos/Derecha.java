package modelo.tablero.movimientos;

import modelo.celda.Posicion;

public class Derecha extends Movimiento{

    public Derecha() {
    }

    @Override
    public Posicion transformarPosicionPorMovimiento(Posicion posicionOrigen) {
        return posicionOrigen.derecha();
    }

}
