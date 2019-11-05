package estadosJinete;

import accion.AtaqueCercano;

public class EstadoAtaqueCercano extends Estado {

    public EstadoAtaqueCercano(){
        accion = new AtaqueCercano(5);
    }

    @Override
    public Estado cambiarEstado(){
        return new EstadoAtaqueMedio();
    }

}
