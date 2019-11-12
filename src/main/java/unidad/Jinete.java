package unidad;

import ErroresYExcepciones.CeldaNoEstaEnRango;
import unidad.estadosJinete.*;

public class Jinete extends Unidad {

    private EstadoJinete estadoJineteAtaque;

    public Jinete(){
        precio = 3;
        vida = 100;
        estadoJineteAtaque = new EstadoJineteAtaqueCercano();

    }

    public void cambiarAtaque(){
        estadoJineteAtaque = estadoJineteAtaque.cambiarEstado();
    }

    @Override
    public void interactuar(Unidad unidad, int distancia) throws CeldaNoEstaEnRango {
        estadoJineteAtaque.atacar(unidad, distancia);
    }
}

