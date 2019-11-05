package estadosJinete;

import accion.Accion;
import unidades.Unidad;

public abstract class Estado {

    static Accion accion;

    public abstract Estado cambiarEstado();

    public void atacar(Unidad unidad){

        accion.interactuar(unidad);
    }
}
