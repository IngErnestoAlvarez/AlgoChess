package tablero.movimientos;

import celda.Posicion;

public class Izquierda extends Movimiento {

    public Izquierda() {}

    @Override
    public Posicion transformarPosicionPorMovimiento(Posicion posicionOrigen) {
        return posicionOrigen.izquierda();
    }

}
