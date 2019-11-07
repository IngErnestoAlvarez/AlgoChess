package unidad.estadosJinete;

import unidad.accion.AtaqueMedio;

public class EstadoAtaqueMedio extends Estado{

    public EstadoAtaqueMedio() {
        accion = new AtaqueMedio(15);
    }
    @Override
    public Estado cambiarEstado() {
        return new EstadoAtaqueCercano();
    }
}
