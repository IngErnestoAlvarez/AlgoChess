package unidad;

import unidad.estadosJinete.*;

public class Jinete extends Unidad {

    private Estado estadoAtaque;

    public Jinete(){
        precio = 3;
        vida = 100;
        estadoAtaque = new EstadoAtaqueCercano();
    }

    public void cambiarAtaque(){
        estadoAtaque = estadoAtaque.cambiarEstado();
    }

    @Override
    public void interactuar(Unidad unidad){
        estadoAtaque.atacar(unidad);
    }
}

