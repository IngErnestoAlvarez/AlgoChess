package tablero.movimientos;

import celda.Posicion;

public class Arriba extends Movimiento{

    public Arriba() {
    }

    @Override
    public Posicion transformarPosicionPorMovimiento(Posicion posicionOrigen) {
        return posicionOrigen.arriba();
    }

}
