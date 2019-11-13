package tablero.movimientos;

import celda.Posicion;

public class Movimiento {

    private Movimiento unMovimiento;
    private CalculadorDeMovimientos calculador;

    public Movimiento(){
    }

    public Movimiento (Posicion posicionOrigen, Posicion posicionDestino){
        this.calculador = new CalculadorDeMovimientos(posicionOrigen);
        this.unMovimiento = calculador.crearMovimiento(posicionDestino);
    }

    public Posicion transformarPosicionPorMovimiento(Posicion posicionOrigen){
        return this.unMovimiento.transformarPosicionPorMovimiento(posicionOrigen);
    }
}
