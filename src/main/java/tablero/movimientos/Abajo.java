package tablero.movimientos;

import celda.Posicion;

public class Abajo extends Movimiento{

    public Abajo(){
    }

    @Override
    public Posicion transformarPosicionPorMovimiento(Posicion posicionOrigen) {
        return posicionOrigen.abajo();
    }

}
