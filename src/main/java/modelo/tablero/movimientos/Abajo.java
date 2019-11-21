package modelo.tablero.movimientos;

import modelo.celda.Posicion;

public class Abajo extends Movimiento{

    public Abajo(){
    }

    @Override
    public Posicion transformarPosicionPorMovimiento(Posicion posicionOrigen) {
        return posicionOrigen.abajo();
    }

}
