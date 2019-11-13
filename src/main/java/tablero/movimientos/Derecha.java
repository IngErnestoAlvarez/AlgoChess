package tablero.movimientos;

import celda.Posicion;

public class Derecha extends Movimiento{

    public Derecha() {
    }

    @Override
    public Posicion transformarPosicionPorMovimiento(Posicion posicionOrigen) {
        return posicionOrigen.derecha();
    }

}
