package unidad;

import estadosJinete.*;

public class Jinete extends Unidad {

    public static int precio = 3;
    private Estado estadoAtaque;

    public Jinete(){
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

