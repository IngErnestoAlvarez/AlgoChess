package unidad.estadosJinete;

import unidad.accion.AtaqueMedio;

public class EstadoJineteAtaqueMedio extends EstadoJinete {

    public EstadoJineteAtaqueMedio() {
        accion = new AtaqueMedio(15);
    }
    @Override
    public EstadoJinete cambiarEstado() {
        return new EstadoJineteAtaqueCercano();
    }
}
