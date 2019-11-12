package unidad.estadosJinete;

import unidad.accion.AtaqueCercano;

public class EstadoJineteAtaqueCercano extends EstadoJinete {

    public EstadoJineteAtaqueCercano(){
        accion = new AtaqueCercano(5);
    }

    @Override
    public EstadoJinete cambiarEstado(){
        return new EstadoJineteAtaqueMedio();
    }

}
